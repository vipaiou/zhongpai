package com.supertool.dspui.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.supertool.dspui.model.Algorithm;
import com.supertool.dspui.model.Campaign;
import com.supertool.dspui.param.GridParam;
import com.supertool.dspui.param.PageParam;
import com.supertool.dspui.service.AlgorithmService;
import com.supertool.dspui.service.CampaignService;
import com.supertool.dspui.service.RtbRuleService;
import com.supertool.dspui.vo.AlgorithmVO;
import com.supertool.dspui.vo.Page;
import com.supertool.dspui.vo.PagedResultVO;
import com.supertool.dspui.vo.ResultVO;

@Controller
public class AlgorithmController {

	@Autowired
	private AlgorithmService algorithmService;
	
	@Autowired CampaignService campaignService;
	
	@Autowired
	private RtbRuleService rtbRuleService;
	
	@RequestMapping(value={"/algorithm/index"})
	public String index(Integer campaignId, Model model){
		Campaign campaign = campaignService.getCampaignById(campaignId);
		model.addAttribute("c", campaign);
		return "/algorithm/index";
	}
	
	@RequestMapping(value={"/algorithm/list"})
	public @ResponseBody Page<AlgorithmVO> list(@ModelAttribute("pageParam") GridParam pageParam,@RequestParam Map<String, String> map){
		 
		Page<AlgorithmVO> pagedResultVO = this.algorithmService.getPagedAlgorithmList(pageParam, Integer.parseInt(map.get("campaignId")));
		
		return pagedResultVO;
	}

	@RequestMapping(value={"/algorithm/listall"})
	public @ResponseBody Page<AlgorithmVO> listAll(@ModelAttribute("pageParam") GridParam pageParam,@RequestParam Map<String, String> map){
		 
		Page<AlgorithmVO> pagedResultVO = this.algorithmService.getPagedAlgorithmListAll(pageParam);
		
		return pagedResultVO;
	}

	@RequestMapping(value={"/algorithm/select"})
	public String select(@RequestParam Map<String, String> map){
		return "/algorithm/select";
	}

	@RequestMapping(value={"/algorithm/view"})
	public String view(@RequestParam("id") Integer id, Model model){
		Algorithm algorithm = algorithmService.view(id);
		Campaign campaign = campaignService.getCampaignById(algorithm.getCampaignId());
		model.addAttribute(algorithm);
		model.addAttribute(campaign);
		return "/algorithm/view";
	}
	
	@RequestMapping(value={"/algorithm/edit"})
	public String edit(@RequestParam("id") Integer id, Model model){
		Algorithm algorithm = algorithmService.view(id);
		Campaign campaign = campaignService.getCampaignById(algorithm.getCampaignId());
		int rtbCount = rtbRuleService.getCountByAlgorithmId(id);
		model.addAttribute(algorithm);
		model.addAttribute(campaign);
		model.addAttribute("rtbCount", rtbCount);
		return "/algorithm/edit";
	}

	@RequestMapping(value={"/algorithm/create"})
	public String create(@RequestParam("campaignId") Integer id, Model model){
		Campaign campaign = campaignService.getCampaignById(id);
		model.addAttribute("c",campaign);
		return "/algorithm/create";
	}
	
	@RequestMapping(value={"/algorithm/docreate"})
	public @ResponseBody ResultVO create(@ModelAttribute("algorithm") Algorithm algorithm, @RequestParam Map<String, String> map){
		System.out.println(AopUtils.isAopProxy(algorithmService));
		System.out.println(AopUtils.isCglibProxy(algorithmService));
		System.out.println(AopUtils.isJdkDynamicProxy(algorithmService));
		return algorithmService.create(algorithm);
	}

	@RequestMapping(value={"/algorithm/doedit"})
	public @ResponseBody ResultVO edit(@ModelAttribute("algorithm") Algorithm algorithm, @RequestParam Map<String, String> map){
		return algorithmService.edit(algorithm);
	}

	@RequestMapping(value={"/algorithm/getbyid"})
	public @ResponseBody ResultVO getById(@RequestParam("id") Integer id, @RequestParam Map<String, String> map){
		ResultVO resultVO = new ResultVO();
		if(id == null || id < 1){
			resultVO.setResultCode(0);
			resultVO.setMessage("参数id错误");
			return resultVO;
		}
		try{
			Algorithm algorithm = algorithmService.view(id);
			if(algorithm != null && algorithm.getScript() != null){
				resultVO.setResultCode(1);
				resultVO.setMessage("读取成功");
				resultVO.getMap().put("script", algorithm.getScript());
				return resultVO;
			}else{
				resultVO.setResultCode(0);
				resultVO.setMessage("未获取到算法");
				return resultVO;
			}
		}catch (Exception e) {
			resultVO.setResultCode(0);
			resultVO.setMessage("查询数据异常");
			return resultVO;
		}
	}

	@RequestMapping(value={"/algorithm/check"})
	public @ResponseBody boolean check(@ModelAttribute("algorithm") Algorithm algorithm, @RequestParam Map<String, String> map){
		return algorithmService.check(algorithm);
	}

	@RequestMapping(value={"/algorithm/test","/algorithm/","/algorithm"})
	public String test(@ModelAttribute("algorithm") Algorithm algorithm, @RequestParam Map<String, String> map){
		return "/algorithm/test";
	}
	
	@RequestMapping(value={"/algorithm/dotest"})
	public @ResponseBody ResultVO dotest(@RequestParam Map<String, String> map){
		ResultVO resultVO = algorithmService.test(map);
		return resultVO;
	}
	
	/**
	 * 编译
	 * @param map
	 * @return
	 */
	@RequestMapping(value={"/algorithm/compile"})
	public @ResponseBody boolean compile(@RequestParam Map<String, String> map){
		boolean b = algorithmService.compile(map);
		return b;
	}
	
	@RequestMapping(value={"/algorithm/delete"})
	public @ResponseBody ResultVO delete(@ModelAttribute("algorithm") Algorithm algorithm, @RequestParam Map<String, String> map){
		return algorithmService.delete(algorithm);
	}
	
	@RequestMapping(value={"/algorithm/upload"})
	public void upload(@RequestParam("file") MultipartFile multipartFile, HttpServletResponse resp,
            HttpServletRequest req) throws IOException{
		String userAgent = req.getHeader("User-Agent").toUpperCase();
        if (userAgent.contains("MSIE")) {
            resp.setCharacterEncoding("gbk");
        } else {
            resp.setCharacterEncoding("utf8");
        }
	 	Writer writer = resp.getWriter();
		ResultVO resultVO = new ResultVO();
		if (multipartFile == null) {
			resultVO.setResultCode(-1);
			resultVO.setMessage("上传的文件为null");
      	  	writer.write(JSONObject.fromObject(resultVO).toString());
			return ;
		}
		 if(multipartFile.getSize()>65535){
				resultVO.setResultCode(-1);
				resultVO.setMessage("文件大小超过64K限制");
          	  	writer.write(JSONObject.fromObject(resultVO).toString());
				return ;
		 }
		String filename = multipartFile.getOriginalFilename();
		int lastindex = filename.lastIndexOf(".");
		if(lastindex == -1){
			resultVO.setResultCode(-3);
			resultVO.setMessage("文件缺少扩展名");
      	  	writer.write(JSONObject.fromObject(resultVO).toString());
			return ;
		}
		String ext=filename.substring(lastindex,filename.length());
		
		System.out.println(multipartFile.getContentType());
		if(!(".txt".equalsIgnoreCase(ext) && "text/plain".equalsIgnoreCase(multipartFile.getContentType())) && !(".lua".equalsIgnoreCase(ext) && "application/octet-stream".equalsIgnoreCase(multipartFile.getContentType()))){
			resultVO.setResultCode(-2);
			resultVO.setMessage("文件非txt、lua文件");
      	  	writer.write(JSONObject.fromObject(resultVO).toString());
			return ;
		}
		InputStream inputStream;
		StringBuilder builder = new StringBuilder();
		try {
			inputStream = multipartFile.getInputStream();
			byte[] b = new byte[1024];
			int i = inputStream.read(b);
			while (i != -1) {
				builder = builder.append(new String(b, 0, i));
				i = inputStream.read(b);
			}
			resultVO.setResultCode(1);
			resultVO.setMessage("文件读取成功");
			resultVO.getMap().put("content", builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
			resultVO.setResultCode(0);
			resultVO.setMessage("文件读取失败");
		}
  	  	writer.write(JSONObject.fromObject(resultVO).toString());
		return ;
	}

	public static void main(String[] args) {
		try{ 
		    FileInputStream fis = new FileInputStream(new File("D://51job_丁娟(77801205).doc"));
		   WordExtractor ex = new WordExtractor(fis);
		  String text2003 = ex.getText();
		  System.out.println("word的内容信息"+text2003);
		  } catch (Exception e) {
		   e.printStackTrace();
		   System.out.println("解析word有错！");
		  }
	}
}
