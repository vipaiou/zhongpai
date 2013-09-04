package com.supertool.dspui.controller.zhongpai;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.model.Material;
import com.supertool.dspui.service.SettingService;
import com.supertool.dspui.service.zhongpai.ProjectService;
import com.supertool.dspui.util.HttpFileUpload;
import com.supertool.dspui.util.ImageUtil;
import com.supertool.dspui.util.MD5;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.material.FLVMetaData;
import com.supertool.dspui.util.material.swf.SWFHeader;
import com.supertool.dspui.vo.ResultVO;
import com.supertool.dspui.vo.SettingVO;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private ProjectService projectService;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/upload")
	public void upload(@RequestParam("Filedata") MultipartFile upload,
			HttpServletResponse resp, HttpServletRequest req, @RequestParam Map<String, Object> map)
			throws IOException {
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;  
	        CommonsMultipartFile file1 = (CommonsMultipartFile) multipartRequest.getFile("Filedata");
	        
		String userAgent = req.getHeader("User-Agent").toUpperCase();
		if (userAgent.contains("MSIE")) {
			resp.setCharacterEncoding("gbk");
		} else {
			resp.setCharacterEncoding("utf8");
		}
		Writer writer = resp.getWriter();
		ResultVO vo = new ResultVO();

		// 物料大小
		// 文件后缀
		if (!upload.isEmpty()) {
			String fileName = StringUtil.trimSRN(upload.getOriginalFilename());
			try {
				long size = upload.getSize();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String tmppath = Config.getDatasourceFilePath() + fileName;
				File tmpfile = new File(tmppath);
				if(!tmpfile.exists()){
					upload.transferTo(tmpfile);
				}
				String tmp = System.getProperty("java.io.tmpdir");
				
				String largeName = "project-large-" + MD5.getFileMD5String(tmpfile) + "."+ ext;
			    String largepath = Config.getDatasourceFilePath() + largeName;
			    String largeTmpPath = tmp + largeName;
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 570, 422);
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 422, 570);
			    ImageUtil.scale3(tmppath, largeTmpPath, 422, 570, true);
			    //ImageUtil.cut3(largeTmpPath, largepath, 422, 570);
			    File bf = new File(largeTmpPath);
				ImageUtil.cutting(bf, largeName, Config.getDatasourceFilePath(), 0, 0, 570, 422);
			    //File largefile = new File(largepath);
				//upload.transferTo(largefile);
				
				String mediumName = "project-medium-" + MD5.getFileMD5String(tmpfile) + "."+ ext;
			    String mediumpath = Config.getDatasourceFilePath() + mediumName;
			    String mediumTmpPath = tmp + mediumName;
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 165, 223);
			    ImageUtil.scale3(tmppath, mediumTmpPath, 165, 223, true);//.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 223, 165);
			    File mf = new File(mediumTmpPath);
				ImageUtil.cutting(mf, mediumName, Config.getDatasourceFilePath(), 0, 0, 223, 165);
				//this.saveFileFromInputStream(upload.getInputStream(), path);
				//processImage(path);
					// return ;
				projectService.updateImage(map.get("projectId"), MD5.getFileMD5String(tmpfile) + "." + ext);
				String imagehost = Config.getImageHost();
//				vo.setResultCode(Constant.RESULT_SUCCESS);
//				vo.setMessage(imagehost + mediumName);
				writer.write(imagehost + mediumName + "?" + new Date().getTime());
				return;

			} catch (ValidationException e) {
				logger.error(e.getMessage());
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage(e.getMessage());
				// return vo;
				writer.write(JSONObject.fromObject(vo).toString());
				return;
			} catch (Exception e) {
				logger.error(e.getMessage());
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage(e.getMessage());
				// return vo;
				writer.write(JSONObject.fromObject(vo).toString());
				return;
			}
		}
		// return vo;
		writer.write(JSONObject.fromObject(vo).toString());
		return;

	}
	
}
