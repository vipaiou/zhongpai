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
import com.supertool.dspui.context.UserContext;
import com.supertool.dspui.model.Material;
import com.supertool.dspui.service.SettingService;
import com.supertool.dspui.service.zhongpai.ProjectService;
import com.supertool.dspui.service.zhongpai.UserService;
import com.supertool.dspui.util.HttpFileUpload;
import com.supertool.dspui.util.ImageUtil;
import com.supertool.dspui.util.MD5;
import com.supertool.dspui.util.StringUtil;
import com.supertool.dspui.util.material.FLVMetaData;
import com.supertool.dspui.util.material.swf.SWFHeader;
import com.supertool.dspui.vo.ResultVO;
import com.supertool.dspui.vo.SettingVO;

@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private SettingService settingService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/upload4Cover")
	public void upload4Cover(@RequestParam("Filedata") MultipartFile upload,
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
	@RequestMapping(value = {"/uploadavatar"})
	public void upload4Avatar(@RequestParam("Filedata") MultipartFile upload,
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
				
				String largeName = "avatar-large-" + MD5.getFileMD5String(tmpfile) + "."+ ext;
			    String largepath = Config.getDatasourceFilePath() + largeName;
			    String largeTmpPath = tmp + largeName;
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 570, 422);
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 422, 570);
			    ImageUtil.scale3(tmppath, largeTmpPath, 220, 220, true);
			    //ImageUtil.cut3(largeTmpPath, largepath, 422, 570);
			    File bf = new File(largeTmpPath);
				ImageUtil.cutting(bf, largeName, Config.getDatasourceFilePath(), 0, 0, 220, 220);
			    //File largefile = new File(largepath);
				//upload.transferTo(largefile);
				
				String mediumName = "avatar-medium-" + MD5.getFileMD5String(tmpfile) + "."+ ext;
			    String mediumpath = Config.getDatasourceFilePath() + mediumName;
			    String mediumTmpPath = tmp + mediumName;
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 165, 223);
			    ImageUtil.scale3(tmppath, mediumTmpPath, 80, 80, true);//.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 223, 165);
			    File mf = new File(mediumTmpPath);
				ImageUtil.cutting(mf, mediumName, Config.getDatasourceFilePath(), 0, 0, 80, 80);
				//this.saveFileFromInputStream(upload.getInputStream(), path);
				//processImage(path);
					// return ;

				String smallName = "avatar-small-" + MD5.getFileMD5String(tmpfile) + "."+ ext;
			    String smallpath = Config.getDatasourceFilePath() + smallName;
			    String smallTmpPath = tmp + smallName;
			    //ImageUtil.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 165, 223);
			    ImageUtil.scale3(tmppath, smallTmpPath, 40, 40, true);//.smartCut(tmpfile, largeName, Config.getDatasourceFilePath(), 223, 165);
			    File sf = new File(smallTmpPath);
				ImageUtil.cutting(sf, smallName, Config.getDatasourceFilePath(), 0, 0, 40, 40);
				
				userService.updateAvatar(map.get("userid"), MD5.getFileMD5String(tmpfile) + "." + ext);
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
				//projectService.updateImage(map.get("projectId"), MD5.getFileMD5String(tmpfile) + "." + ext);
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
	
	@RequestMapping(value = "/upload1")
	public void upload1(@RequestParam("file") MultipartFile upload,
			HttpServletResponse resp, HttpServletRequest req)
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

		JSONObject jsonObject = null;
		File file = null;
		// 物料大小
		long size = 0;
		// 文件后缀
		String ext = "";
		Material material = null;
		if (!upload.isEmpty()) {
			String fileName = StringUtil.trimSRN(upload.getOriginalFilename());
			material = new Material();
			material.setName(fileName);
			try {
				size = upload.getSize();

				ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String newName = UUID.randomUUID().toString() + "." + ext;
				String path = System.getProperty("java.io.tmpdir") + newName;
				this.saveFileFromInputStream(upload.getInputStream(), path);
				file = new File(path);
				size = file.length();
				Map<String, Object> fileInfo = getFileInfo(file, path, ext,
						material, size);
				int resultCode = Integer.valueOf(fileInfo.get("resultCode")
						.toString());
				if (Constant.RESULT_SUCCESS == resultCode) {
					material = (Material) fileInfo.get("material");
				} else {
					vo.setResultCode(resultCode);
					vo.setMessage(fileInfo.get("message").toString());
					// return vo;
					writer.write(JSONObject.fromObject(vo).toString());
					return;
				}

				/*
				 * this.isTooLarge(material, size); this.isWrongFormat(material,
				 * ext); this.isWrongSize(material, file);
				 */
				HttpFileUpload httpFileUpload = new HttpFileUpload();
				jsonObject = httpFileUpload.upload(Config.getImageHost()
						+ "/material/upload", file, null);

			} catch (ValidationException e) {
				if (null != file) {
					file.delete();
				}
				logger.error(e.getMessage());
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage(e.getMessage());
				// return vo;
				writer.write(JSONObject.fromObject(vo).toString());
				return;
			} catch (Exception e) {
				if (null != file) {
					file.delete();
				}
				logger.error(e.getMessage());
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage(e.getMessage());
				// return vo;
				writer.write(JSONObject.fromObject(vo).toString());
				return;
			}
			if (null != jsonObject) {
				int statusCode = jsonObject.getInt("statusCode");
				if (HttpStatus.SC_OK == statusCode) {
					vo.setResultCode(Constant.RESULT_SUCCESS);
					vo.setMessage("上传成功!");
					Map<String, Object> map = new HashMap<String, Object>();
					material.setPreviewUrl(jsonObject.getString("url"));
					map.put("material", material);
					vo.setMap(map);
				} else {
					file.delete();
					vo.setResultCode(Constant.RESULT_FAIL);
					vo.setMessage(jsonObject.getString("message"));
				}

			} else {
				file.delete();
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage("调用carbon失败!");
			}
		}
		// return vo;
		//writer.write(JSONObject.fromObject(vo).toString());
		return;

	}

	@RequestMapping(value = "/remote")
	public void remote(@RequestParam("remote") String remote,
			HttpServletResponse resp, HttpServletRequest req)
			throws IOException {
		String userAgent = req.getHeader("User-Agent").toUpperCase();
		if (userAgent.contains("MSIE")) {
			resp.setCharacterEncoding("gbk");
		} else {
			resp.setCharacterEncoding("utf8");
		}
		Writer writer = resp.getWriter();
		ResultVO vo = new ResultVO();
		JSONObject jsonObject = null;
		File file = null;
		// 物料大小
		long size = 0;
		// 视频类时长

		// 文件后缀
		String ext = "";
		Material material = null;

		DefaultHttpClient dc = new DefaultHttpClient();
		HttpGet get = new HttpGet(remote);
		try {
			HttpParams params = dc.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 5000);
			HttpConnectionParams.setSoTimeout(params, 5000);
			HttpResponse response = dc.execute(get);
			if (response.getStatusLine().getStatusCode() == 404) {
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage("未找到该地址");
				writer.write(JSONObject.fromObject(vo).toString());
				return;
			}

			ext = StringUtil.trimSRN(remote).substring(
					StringUtil.trimSRN(remote).lastIndexOf(".") + 1);
			String fileName = UUID.randomUUID().toString() + "." + ext;
			String path = System.getProperty("java.io.tmpdir") + fileName;
			this.saveFileFromInputStream(response.getEntity().getContent(),
					path);
			file = new File(path);
			size = file.length();
			material = new Material();
			material.setName(fileName);
			Map<String, Object> fileInfo = getFileInfo(file, path, ext,
					material, size);
			int resultCode = Integer.valueOf(fileInfo.get("resultCode")
					.toString());
			if (Constant.RESULT_SUCCESS == resultCode) {
				material = (Material) fileInfo.get("material");
			} else {
				vo.setResultCode(resultCode);
				vo.setMessage(fileInfo.get("message").toString());
				writer.write(JSONObject.fromObject(vo).toString());
				return;
			}

			/*
			 * this.isTooLarge(material, size); this.isWrongFormat(material,
			 * ext); this.isWrongSize(material, file);
			 */
			HttpFileUpload httpFileUpload = new HttpFileUpload();
			jsonObject = httpFileUpload.upload(Config.getImageHost()
					+ "/material/upload", file, null);

		} catch (ValidationException e) {
			if (null != file) {
				file.delete();
			}

			logger.error(e.getMessage());
			vo.setResultCode(Constant.RESULT_FAIL);
			vo.setMessage("地址错误，请重新输入！");
			writer.write(JSONObject.fromObject(vo).toString());
			return;
		} catch (Exception e) {
			if (null != file) {
				file.delete();
			}
			logger.error(e.getMessage());
			vo.setResultCode(Constant.RESULT_FAIL);
			vo.setMessage("地址错误，请重新输入！");
			writer.write(JSONObject.fromObject(vo).toString());
			return;
		}
		if (null != jsonObject) {
			int statusCode = jsonObject.getInt("statusCode");
			if (HttpStatus.SC_OK == statusCode) {

				Map<String, Object> map = new HashMap<String, Object>();
				material.setPreviewUrl(jsonObject.getString("url"));
				map.put("material", material);
				if (jsonObject.getString("url").length() > 1000) {
					vo.setResultCode(Constant.RESULT_FAIL);
					vo.setMessage("物料服务器返回的地址过长！");
					writer.write(JSONObject.fromObject(vo).toString());
					return;
				}
				vo.setResultCode(Constant.RESULT_SUCCESS);
				vo.setMessage("上传成功!");
				vo.setMap(map);
			} else {
				file.delete();
				vo.setResultCode(Constant.RESULT_FAIL);
				vo.setMessage(jsonObject.getString("message"));
			}

		} else {
			file.delete();
			vo.setResultCode(Constant.RESULT_FAIL);
			vo.setMessage("调用carbon失败!");
		}

		writer.write(JSONObject.fromObject(vo).toString());
		return;
	}
	
	private void processImage(String path){

		String dim = ImageUtil.getImageDim(path);
	}

	private Map<String, Object> getFileInfo(File file, String path, String ext,
			Material material, long size) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		path = StringUtil.trimSRN(path);
		SettingVO settingVO = settingService.getSettingVO();

		if (ext.equalsIgnoreCase("gif") || ext.equalsIgnoreCase("bmp")
				|| ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("jpeg")
				|| ext.equalsIgnoreCase("png")) {
			if (null != settingVO && size > settingVO.getImgsize() * 1024) {
				map.put("message", "物料超大!此物料文件最大请勿超过" + settingVO.getImgsize()
						+ "K");
				map.put("resultCode", Constant.RESULT_FAIL);
				return map;
			}
			material.setType("P");
			String dim = ImageUtil.getImageDim(path);
			String[] dims = dim.split("::");
			if (dims != null && dims.length > 0) {
				int width = Integer.valueOf(dims[0]);
				int height = Integer.valueOf(dims[1]);
				material.setWidth(width);
				material.setHeight(height);
			}

		} else if (ext.equalsIgnoreCase("flv")) {
			if (null != settingVO && size > settingVO.getFlvsize() * 1024) {
				map.put("message", "物料超大!此物料文件最大请勿超过" + settingVO.getFlvsize()
						+ "K");
				map.put("resultCode", Constant.RESULT_FAIL);
				return map;
			}
			material.setType("F");
			FLVMetaData flv = new FLVMetaData(path, false);
			String du = flv.getDuration();
			String[] durs = du.split(":");
			Integer[] hms = new Integer[durs.length];
			Integer duration = 0;
			for (int i = 0; i < durs.length; i++) {
				hms[i] = Integer.parseInt(durs[i]);
			}
			if (3 == hms.length) {
				duration = hms[0] * 3600 + hms[1] * 60 + hms[2];
			} else if (2 == hms.length) {
				duration = hms[0] * 60 + hms[1];
			}
			int width = (int) flv.getWidth();
			int height = (int) flv.getHeight();

			material.setWidth(width);
			material.setHeight(height);
			material.setDuration(duration);

		} else if (ext.equalsIgnoreCase("swf")) {
			if (null != settingVO && size > settingVO.getSwfsize() * 1024) {
				map.put("message", "物料超大!此物料文件最大请勿超过" + settingVO.getSwfsize()
						+ "K");
				map.put("resultCode", Constant.RESULT_FAIL);
				return map;
			}
			material.setType("S");
			SWFHeader swf = new SWFHeader(path);
			Integer frameRate = swf.getFrameRate();
			Integer frameCount = swf.getFrameCount();
			Integer duration = 0;
			if (1 != frameCount && frameRate > 0) {
				duration = frameCount / frameRate;
			}
			int width = swf.getWidth();
			int height = swf.getHeight();
			material.setWidth(width);
			material.setHeight(height);
			material.setDuration(duration);

		} else {
			map.put("message", "地址错误，请重新输入");
			map.put("resultCode", Constant.RESULT_FAIL);
			return map;
		}
		material.setFileSize(size);
		if (size < 1024) {
			material.setFileSizeStr(size + "B");
		} else if (size < 1024 * 1024) {
			double k = size * 1.0 / (1024);
			material.setFileSizeStr(String.format("%.1f", k) + "K");
		} else {
			double m = size * 1.0 / (1024 * 1024);
			material.setFileSizeStr(String.format("%.1f", m) + "M");
		}
		map.put("material", material);
		map.put("resultCode", Constant.RESULT_SUCCESS);
		return map;
	}

	private void saveFileFromInputStream(InputStream stream, String path)
			throws IOException {
		FileOutputStream fs = new FileOutputStream(path);
		byte[] buffer = new byte[1024 * 1024];
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}

}
