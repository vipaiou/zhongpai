package com.supertool.dspui.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
* 视频工具类
* @author sunlightcs
* 2011-4-6
* http://hi.juziku.com/sunlightcs/
*/
public class VideoUtil {

	
	public static String getVideoHtml(String url) {
		String html = "";
		html = "<embed width=\"590\" height=\"472\" align=\"middle\" type=\"application/x-shockwave-flash\" allowscriptaccess=\"always\" quality=\"high\" allowfullscreen=\"true\" src=\"";
		String swf = "";
		try {
			swf = getSwf(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		html += swf;
		html += "\" wmode=\"opaque\">";
		System.out.println(html);
		return html;
	}
	

	private static String getSwf(String url)throws Exception {
		/*String url = "http://v.youku.com/v_show/id_XNTk3Njk3MjQw.html";
		url = "http://v.ku6.com/show/0tzMHvnVIcshAXDV.html";//未通过
		url = "http://www.tudou.com/listplay/8H8UlHvxik4/1ewbY8NoZbc.html";//未通过,405
		url = "http://v.6.cn/video/16065616.html";//未通过
		url = "http://www.56.com/u98/v_OTU0NzQyNzk.html";//通过
*/		Document doc = getURLContent(url);
		String swf = "";
		if(url.indexOf("v.youku.com")!=-1){
			try {
				swf = getElementAttrById(doc, "link2", "value");
			} catch (Exception e) {
				swf = null;
			}
		}else if(url.indexOf("tudou.com")!=-1){
			try {
				String content = doc.html();
				int beginLocal = content.indexOf("<script>document.domain");
				int endLocal = content.indexOf("</script>");
				content = content.substring(beginLocal, endLocal);
				
				/**
				 * 获取视频地址
				 */	
				String flash = getScriptVarByName("iid_code", content);
				swf = "http://www.tudou.com/v/" + flash + "/v.swf";
			} catch (Exception e) {
				swf = null;
			}
		}else if(url.indexOf("v.ku6.com")!=-1){
			try {
//				Element flashEt = doc.getElementById("outSideSwfCode");
//				swf = flashEt.attr("value");

				String content = doc.html();
				int beginLocal = content.indexOf("<input class=\"text_A\" readonly=\"\" title=\"点击右侧复制按钮直接复制内容\" value=\"\"");
				int endLocal = content.indexOf("\"><span class=\"flash\">");
				swf = content.substring(beginLocal, endLocal);
			} catch (Exception e) {
				swf = null;
			}
		}else if(url.indexOf("6.cn")!=-1){
			try {
				Element flashEt = doc.getElementById("video-share-code");
				doc = Jsoup.parse(flashEt.attr("value"));  
				swf = doc.select("embed").attr("src");
			} catch (Exception e) {
				swf = null;
			}
		}else if(url.indexOf("56.com")!=-1){
			try {
				swf = "http://player.56.com" + url.substring(url.lastIndexOf("/"), url.lastIndexOf(".html")) + ".swf";
			} catch (Exception e) {
				swf = null;
			}
		}
		return swf;
	}
	
	
	/**
	 * 根据HTML的ID键及属于名，获取属于值
	 * @param id  HTML的ID键
	 * @param attrName  属于名
	 * @return  返回属性值
	 */
	private static String getElementAttrById(Document doc, String id, String attrName)throws Exception{
		Element et = doc.getElementById(id);
		String attrValue = et.attr(attrName);
		
		return attrValue;
	}
	
	
	/**
	* 获取script某个变量的值
	* @param name  变量名称
	* @return   返回获取的值 
	*/
	private static String getScriptVarByName(String name, String content){
		String script = content;
		
		int begin = script.indexOf(name);
		
		script = script.substring(begin+name.length()+2);
		
		int end = script.indexOf(",");
		
		script = script.substring(0,end);
		
		String result=script.replaceAll("'", "");
		result = result.trim();
		
		return result;
	}
	
	/**
	 * 获取网页的内容
	 */
	private static Document getURLContent(String url) throws Exception{
		Document doc = Jsoup.connect(url)
		  .data("query", "Java")
		  .userAgent("Mozilla")
		  .cookie("auth", "token")
		  .timeout(6000)
		  .post();
		return doc;
	}
	
	
	public static void main(String[] args) {
		//String url = "http://v.youku.com/v_show/id_XMjU0MjI2NzY0.html";
		//String url = "http://www.tudou.com/programs/view/pVploWOtCQM/";
		//String url = "http://v.ku6.com/special/show_4024167/9t7p64bisV2A31Hz.html";
		//String url = "http://v.ku6.com/show/BpP5LeyVwvikbT1F.html";
		//String url = "http://6.cn/watch/14757577.html";
		String url = "http://v.youku.com/v_show/id_XNTk3Njk3MjQw.html";
		url = "http://v.ku6.com/show/0tzMHvnVIcshAXDV.html";//未通过
//		url = "http://www.tudou.com/listplay/8H8UlHvxik4/1ewbY8NoZbc.html";//未通过,405
//		url = "http://v.6.cn/video/16065616.html";//未通过
//		url = "http://www.56.com/u98/v_OTU0NzQyNzk.html";//通过
		String htmlCode = getVideoHtml(url);
		/*Video video = getVideoInfo(url);
		System.out.println("视频缩略图："+video.getPic());
		System.out.println("视频地址："+video.getFlash());
		System.out.println("视频时长："+video.getTime());*/
	}

}