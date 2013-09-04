package com.supertool.dspui.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionHolder;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supertool.dspui.util.JSONUtils;
import com.supertool.dspui.util.TalkWithCarbon;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.PagedResultVO;
import com.supertool.dspui.vo.ResultVO;
import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.dao.mybatis.AdvertiserMapper;
import com.supertool.dspui.framework.carboninterface.CarbonInterface;
import com.supertool.dspui.model.Advertiser;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.param.SelectSQLParam;

@Service
public class AdvertiserService {

	@Autowired
	private AdvertiserMapper advertiserMapper;

	private static Logger logger = Logger.getLogger(AdvertiserService.class);
	
	public List<Advertiser> getPagedAdvertisers(SelectSQLParam m){
		
		return this.advertiserMapper.getAllAdvertisers(m);
	}

	public Page<Advertiser> getPagedAdvertiserList(PageParam param) {
		int pgsize = param.getPageSize() < 1 ? 20 : param.getPageSize();
		int start = (param.getCurrentPage() -1 )*param.getPageSize(); 
		String key = "";
		boolean isNumber = false;
		if(param.getSearchValue() != null ){
			key = param.getSearchValue().trim();
			if(!key.isEmpty()){
				if(StringUtils.isNumeric(key)){
					isNumber = true;
				}else{
					key = key.replace("_", "\\_").replace("%", "\\%");
				}
			}
		}
		SelectSQLParam sqlParam = new SelectSQLParam(null, start, param.getPageSize(), param.getOrderName(), param.getOrderValue(), param.getSearchName(), key, isNumber);
		List<Advertiser> list = this.advertiserMapper.getPagedAdvertiserList(sqlParam, UserContext.getDspId());
		int totalCount = advertiserMapper.getTotalCount(sqlParam, UserContext.getDspId());
		int totalPage = totalCount % pgsize == 0 ? totalCount / pgsize : totalCount / pgsize + 1;
		Page<Advertiser> pagedResultVO = new Page<Advertiser>();
		pagedResultVO.setRows(list);
		pagedResultVO.setPageNo(param.getCurrentPage());
		pagedResultVO.setPageSize(pgsize);
		pagedResultVO.setTotalRecords(totalCount);
		pagedResultVO.setTotalPages(totalPage);
		return pagedResultVO;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ResultVO create(Advertiser advertiser) {
		advertiser.setParent("");
		advertiser.setCreateTime(new Date());
		advertiser.setDeleteTime(new Date());
		advertiser.setIsAgency((byte)0);
		advertiser.setIsDeleted((byte)0);
		advertiser.setUpdateTime(new Date());
		advertiser.setDspId(UserContext.getDspId());
		advertiser.setDescription(advertiser.getDescription() == null ? "" : advertiser.getDescription().trim());
		advertiser.setName(advertiser.getName() == null ? "" : advertiser.getName().trim());
		int nums = advertiserMapper.create(advertiser);
		ResultVO resultVO = new ResultVO();
		if(nums > 0 && advertiser.getId() > 0){
			Map <String,Object> map  = new HashMap<String,Object>();
			map.put("dspId", UserContext.getDspId());
			map.put("agency", false);
			map.put("name", advertiser.getName());
			map.put("parent", "");
			map.put("desc", advertiser.getDescription());
			String body = JSONUtils.mapToJsonString(map);
			String url = Config.getCarbonHost() + "/advertiser/add";
			JSONObject result = CarbonInterface.requestCarbon(url, body);
			try{
				if(result == null){
					logger.error("carbon创建广告主失败，未知异常");
					throw new RuntimeException("carbon创建广告主失败，未知异常");
				}
				if(!"1".equals(result.getString("resultCode"))){
					logger.error("carbon创建广告主失败，状态号："+result.getString("resultCode") + "，" + result.getString("message"));
					throw new RuntimeException("carbon创建广告主失败，异常:" + result.getString("message"));
				}
				JSONObject json = result.getJSONObject("result");
				if(json != null){
					if(200 == json.getInt("statusCode")){
						advertiser.setCarbonId(json.getInt("id"));
						advertiserMapper.updateCarbonId(advertiser);
						resultVO.setResultCode(0);
						resultVO.setMessage("成功");
						resultVO.getMap().put("id", advertiser.getId());
					}else{
						throw new RuntimeException("carbon创建广告主失败，异常:" +json.getInt("statusCode") + json.getString("message"));
					}
				}else{
					throw new RuntimeException("carbon创建广告主失败，未知异常");
				}
			}catch (Exception e) {
				throw new RuntimeException("carbon创建广告主失败，未知异常");
			}
		}
		return resultVO;
	}

	public Advertiser view(Integer id) {
		return advertiserMapper.getAdvertiserById(id);
	}

	public boolean check(Advertiser advertiser) {
		List<Advertiser> list;
		String name = advertiser.getName() == null ? "":advertiser.getName().trim();
		Integer id = advertiser.getId();
		if(advertiser.getId() > 0){
			list = advertiserMapper.checkByNameAndId(name, id, UserContext.getDspId());
		}else{
			list = advertiserMapper.checkByName(name, UserContext.getDspId());
		}
		if(list != null && list.size() > 0){
			return false;
		}
		return true;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ResultVO edit(Advertiser advertiser) {
		int nums = advertiserMapper.edit(advertiser);
		ResultVO resultVO = new ResultVO();
		if(nums > 0){
			Map <String,Object> map  = new HashMap<String,Object>();
			map.put("id", advertiser.getCarbonId());
			map.put("dspId", UserContext.getDspId());
			map.put("agency", false);
			map.put("name", advertiser.getName()==null? "" : advertiser.getName().trim());
			map.put("parent", "");
			map.put("desc", advertiser.getDescription()==null? "" : advertiser.getDescription().trim());
			String body = JSONUtils.mapToJsonString(map);
			String url = Config.getCarbonHost() + "/advertiser/update";
			JSONObject result = CarbonInterface.requestCarbon(url, body);
			try {
				if(result == null){
					logger.error("carbon修改广告主失败，未知异常");
					throw new RuntimeException("carbon修改广告主失败，未知异常");
				}
				if(!"1".equals(result.getString("resultCode"))){
					logger.error("carbon修改广告主失败，状态号："+result.getString("resultCode") + "，" + result.getString("message"));
					throw new RuntimeException("carbon修改广告主失败，异常:" + result.getString("message"));
				}
				JSONObject json = result.getJSONObject("result");
				if(json != null){
					if(200 == json.getInt("statusCode")){
						resultVO.setResultCode(0);
						resultVO.setMessage("成功");
					}else{
						throw new RuntimeException("carbon修改广告主失败，异常:" +json.getString("statusCode") + json.getString("message"));
					}
				}else{
					resultVO.setResultCode(-1);
					resultVO.setMessage("未知异常");
				}
				resultVO.getMap().put("id", advertiser.getId());
			} catch (Exception e) {
				System.out.println(result.toString());
				throw new RuntimeException("修改广告主失败，处理结果异常" );
			}
		}
		return resultVO;
	}

	@Transactional(rollbackFor = Exception.class)
	public ResultVO delete(Integer id, Integer carbonId) {
		ResultVO vo = new ResultVO();
		try{
			this.advertiserMapper.deleteAdvertiserById(id);
			TalkWithCarbon talkWithCarbon = new TalkWithCarbon();
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("dspId", UserContext.getDspId());
			params.put("id", carbonId);
			String url = Config.getCarbonHost()+"/advertiser/delete";
			JSONObject jObject = talkWithCarbon.getCarbonVOJson(params, url);
			int statusCode = jObject.getInt("statusCode");
			if(HttpStatus.SC_OK == statusCode){
				vo.setMessage("操作成功");
				vo.setResultCode(Constant.RESULT_SUCCESS);
			}else{
				String message = jObject.getString("message");
				throw new RuntimeException(message);
			}
		}catch (Exception e){
			throw new RuntimeException(e.getMessage());
		}
		return vo;
	}
}
