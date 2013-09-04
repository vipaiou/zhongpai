package com.supertool.dspui.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.DatasourceMapper;
import com.supertool.dspui.exception.CarbonBadResponseException;
import com.supertool.dspui.model.Datasource;
import com.supertool.dspui.param.form.DatasourceForm;
import com.supertool.dspui.param.form.DatasourcePageForm;
import com.supertool.dspui.util.HttpFileUpload;
import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.util.Utils;
import com.supertool.dspui.vo.Page;

@Service
public class DatasourceService {

	private static Logger logger = Logger.getLogger(DatasourceService.class);

	@Autowired
	DatasourceMapper datasourceMapper;

	public Page<Datasource> list(DatasourcePageForm form) {
		int pageSize = form.getPageSize();
		int pageNo = form.getPageNo();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ownerDspId", UserContext.getDspId());
		params.put("orderName", form.getOrderBy());
		params.put("orderValue", form.getOrder());
		params.put("startRow", pageSize * (pageNo - 1));
		params.put("limitRows", pageSize);
		String type = form.getType();
		if (null != type && !"ALL".equals(type)) {
			params.put("type", type);
		}
		String searchStr = form.getSearchStr();
		if (null != searchStr && !"".equals(searchStr)) {
			if (StringUtil.isNumber(searchStr)) {
				params.put("searchStr", searchStr);
			} else {
				params.put("name", searchStr);
			}
		}
		List<Datasource> datasourceList = datasourceMapper
				.getPagedDatasources(params);
		int totalRecords = datasourceMapper.getDatasourcesCount(params);
		Page<Datasource> page = new Page<Datasource>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalRecords(totalRecords);
		page.setTotalPages(Utils.getTotalPage(totalRecords, pageSize));
		page.setRows(datasourceList);
		return page;
	}

	@Transactional
	public Integer add(DatasourceForm form) throws IOException {
		Integer dspId = UserContext.getDspId();
		Map<String, Object> datasourceParams = new HashMap<String, Object>();
		datasourceParams.put("dspId", dspId);
		datasourceParams.put("name", form.getName().trim());
		datasourceParams.put("type", form.getType());
		datasourceParams.put("allowedDspIds", dspId);

		String datasourceAddUrl = Config.getCarbonHost()
				+ Constant.DATASOURCE_ADD_URL;
		JSONObject datasourceAddResponse = new TalkWithCarbon()
				.getCarbonVOJson(datasourceParams, datasourceAddUrl);
		if (null == datasourceAddResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + datasourceAddUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(datasourceParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int datasourceStatusCode = (Integer) datasourceAddResponse
				.get("statusCode");
		String datasourceMessage = (String) datasourceAddResponse
				.get("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != datasourceStatusCode) {
			logger.error("[Carbon] " + datasourceStatusCode + " "
					+ datasourceMessage + "\nurl: " + datasourceAddUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(datasourceParams));
			throw new CarbonBadResponseException(datasourceMessage);
		}
		int datasourceCarbonId = (Integer) datasourceAddResponse.get("id");
		Datasource datasource = new Datasource();
		datasource.setCarbonId(datasourceCarbonId);
		datasource.setOwnerDspId(dspId);
		datasource.setName(form.getName().trim());
		datasource.setType(form.getType());
		datasource.setKeySeperator("");
		datasource.setValueSeperator("");
		datasource.setRemark(form.getRemark() == null ? "" : form.getRemark()
				.trim());
		datasourceMapper.add(datasource);

		MultipartFile file = form.getFile();
		if (null != file && !file.isEmpty()) {
			uploadFile(file, datasourceCarbonId);
		}
		return datasource.getId();
	}

	@Transactional
	public void delete(Integer id) {
		Datasource datasource = datasourceMapper.getById(id);
		Integer dspId = UserContext.getDspId();
		Map<String, Object> datasourceParams = new HashMap<String, Object>();
		datasourceParams.put("dspId", dspId);
		datasourceParams.put("id", datasource.getCarbonId());
		String datasourceDeleteUrl = Config.getCarbonHost()
				+ Constant.DATASOURCE_DELETE_URL;
		JSONObject datasourceDeleteResponse = new TalkWithCarbon()
				.getCarbonVOJson(datasourceParams, datasourceDeleteUrl);
		if (null == datasourceDeleteResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + datasourceDeleteUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(datasourceParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int datasourceStatusCode = (Integer) datasourceDeleteResponse
				.get("statusCode");
		String datasourceMessage = (String) datasourceDeleteResponse
				.get("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != datasourceStatusCode) {
			logger.error("[Carbon] " + datasourceStatusCode + " "
					+ datasourceMessage + "\nurl: " + datasourceDeleteUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(datasourceParams));
			throw new CarbonBadResponseException(datasourceMessage);
		}
		datasourceMapper.deleteById(id);
	}

	public boolean checkName(String name) {
		Datasource datasource = datasourceMapper.getByName(name);
		return null == datasource;
	}

	public Datasource getByCarbonId(Integer id) {
		return datasourceMapper.getByCarbonId(id);
	}

	@Transactional
	public String update(DatasourceForm form) throws IOException {
		Datasource oldDatasource = datasourceMapper.getById(form.getId());
		Map<String, Object> datasourceParams = new HashMap<String, Object>();
		datasourceParams.put("dspId", UserContext.getDspId());
		datasourceParams.put("id", oldDatasource.getCarbonId());
		datasourceParams.put("name", oldDatasource.getName());
		datasourceParams.put("type", form.getType());

		String datasourceUpdateUrl = Config.getCarbonHost()
				+ Constant.DATASOURCE_UPDATE_URL;
		JSONObject datasourceUpdateResponse = new TalkWithCarbon()
				.getCarbonVOJson(datasourceParams, datasourceUpdateUrl);
		if (null == datasourceUpdateResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + datasourceUpdateUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(datasourceParams));
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int datasourceStatusCode = (Integer) datasourceUpdateResponse
				.get("statusCode");
		String datasourceMessage = (String) datasourceUpdateResponse
				.get("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != datasourceStatusCode) {
			logger.error("[Carbon] " + datasourceStatusCode + " "
					+ datasourceMessage + "\nurl: " + datasourceUpdateUrl
					+ "\nparam: " + JSONUtils.mapToJsonString(datasourceParams));
			throw new CarbonBadResponseException(datasourceMessage);
		}
		Datasource datasource = new Datasource();
		datasource.setId(form.getId());
		datasource.setType(form.getType());
		datasource.setRemark(form.getRemark() == null ? "" : form.getRemark()
				.trim());
		datasourceMapper.update(datasource);

		MultipartFile file = form.getFile();
		if (null != file && !file.isEmpty()) {
			uploadFile(file, oldDatasource.getCarbonId());
		}
		return null;
	}

	private void uploadFile(MultipartFile file, Integer carbonId)
			throws IOException {
		Map<String, Object> datasourceUploadParams = new HashMap<String, Object>();
		datasourceUploadParams.put("dspId", UserContext.getDspId());
		datasourceUploadParams.put("id", carbonId);
		File targetFile = new File(Config.getDatasourceFilePath()
				+ UserContext.getLoginUserId() + "-"
				+ System.currentTimeMillis() + "-" + file.getOriginalFilename());
		file.transferTo(targetFile);
		String datasourceUploadUrl = Config.getCarbonHost()
				+ Constant.DATASOURCE_UPLOAD_URL;
		HttpFileUpload httpFileUpload = new HttpFileUpload();
		JSONObject datasourceUploadResponse = httpFileUpload.upload(
				datasourceUploadUrl, targetFile, datasourceUploadParams);
		if (null == datasourceUploadResponse) {
			logger.error("[Carbon] Carbon连接失败 \nurl: " + datasourceUploadUrl
					+ "\nparam: "
					+ JSONUtils.mapToJsonString(datasourceUploadParams));
			targetFile.delete();
			throw new CarbonBadResponseException("Carbon连接失败");
		}
		int uploadStatusCode = (Integer) datasourceUploadResponse
				.get("statusCode");
		String uploadMessage = (String) datasourceUploadResponse.get("message");
		if (Constant.CARBON_STATUS_CODE_SUCCESS != uploadStatusCode) {
			logger.error("[Carbon] " + uploadStatusCode + " " + uploadMessage
					+ "\nurl: " + datasourceUploadUrl + "\nparam: "
					+ JSONUtils.mapToJsonString(datasourceUploadParams));
			targetFile.delete();
			throw new CarbonBadResponseException(uploadMessage);
		}
		targetFile.delete();
	}

	public Datasource getById(Integer id) {
		return datasourceMapper.getById(id);
	}

}
