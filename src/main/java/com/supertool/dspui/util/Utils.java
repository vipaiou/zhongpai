package com.supertool.dspui.util;



import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;



public class Utils {
	private static Pattern numberPattern = null;
	private static DocumentBuilder db = null;
	private static Pattern fileNameEscapePattern = null;
	private static Pattern cssPattern =  null;
	
	/**
	 * 判断s字符串是不是数字格式
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {
		if (numberPattern == null) 
			numberPattern = Pattern.compile("[\\+-]?[0-9]+");
		return numberPattern.matcher(s).matches();
	}
	
	/**
	 * 将list中int[index]整数全部加在一起
	 * @param list
	 * @param index
	 * @return
	 */
	public static int sumListArray(List<int[]> list, int index) {
		int sum = 0;
		Iterator<int[]> iter = list.iterator();
		while (iter.hasNext()) {
			int[] x = iter.next();
			sum += x[index];
		}
		return sum;
	}

	/**
	 * 创建一个w3c DOM文档
	 * @return
	 */
	public static Document createNewDocument() {
		if (db == null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
				return null;
			}
		}
		return db.newDocument();
	}
	
	/**
	 * 将DOM文档转化为XML字符串
	 * @param doc DOM文档
	 * @return XML字符串
	 */
	public static String convertDomToXML(Document doc) {
		TransformerFactory  tf = TransformerFactory.newInstance();
		Transformer t;
		try {
			t = tf.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DOMSource source = new DOMSource(doc);
		t.setOutputProperty(OutputKeys.ENCODING, "GBK");
		
		try {
			t.transform(source, new StreamResult(baos));
		} catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}

		try {
			return baos.toString("ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return baos.toString();
		}
	}
	
	public static int indexOf(Integer[] array, int x) {
		if (array == null)
			return -1;
		
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == x)
				return i;
		}
		
		return -1;
	}
	
	/**
	 * 获取某一个月有多天的函数
	 * @param year
	 * @param month
	 * @return
	 */
	public static synchronized int getDayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 根据year和month推算出该月的第一天和最后一天的Date变量
	 * @param year
	 * @param month
	 * @return 返回一个Date数组:
	 * 			Date[0] = startTime
	 * 			Date[1] = endTime
	 */
	public static Date[] getTimeRange(int year, int month) {
		year -= 1900;
		month--;
		Date startTime = new Date(year, month, 1);
		Date endTime = new Date(year, month, Utils.getDayOfMonth(year, month));

		Date[] timeRange = new Date[2];
		timeRange[0] = startTime;
		timeRange[1] = endTime;
		
		return timeRange;
	}
	
	/**
	 * 根据指定的Date变量换算出年,从公元纪年开始
	 * @param d
	 * @return
	 */
	public static int getYear(Date d) {
		return d.getYear() + 1900;
	}
	
	/**
	 * 根据指定的Date变量换算出月，从1开始
	 * @param d
	 * @return
	 */
	public static int getMonth(Date d) {
		return d.getMonth() + 1;
	}
	
	/**
	 * a <- a - ^b。把在a不在b的元素从a中除去
	 * @param a 若a为null, 不执行任何操作
	 * @param b 若b为null, 则清空a的所有元素
	 */
	public static void minusNot(List<Date> a, List<Date> b) {
		if (a == null || a.size() == 0) 
			return;
		
		if (b == null || b.size() == 0) {
			a.clear();
			return;
		}
		
		HashSet<Date> bSet = new HashSet<Date>(b);
		Iterator<Date> aIter = a.iterator();
		LinkedList<Date> diff = new LinkedList<Date>();
		while (aIter.hasNext()) {
			Date i = aIter.next();
			if (!bSet.contains(i))
				diff.add(i);
		}
		Iterator<Date> diffIter = diff.iterator();
		while (diffIter.hasNext()) {
			a.remove(diffIter.next());
		}
	}

	/**
	 * 将fileName转为非空格的GBK编码的字符串
	 * @param fileName
	 * @return
	 */
	public static String encodeFileName(String fileName) {
		if (fileNameEscapePattern == null)
			fileNameEscapePattern = Pattern.compile("\\s");
		Matcher m = fileNameEscapePattern.matcher(fileName);
		String s = m.replaceAll("_");
		try {
			return new String(s.getBytes("GBK"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}
	
	public static int sumArray(int[] a) {
		int t = 0;
		for (int i = 0; i < a.length; ++i) 
			t += a[i];
		return t;
	}
	
	public static boolean isExist(Integer id,Integer[] ids){
		for(int i=0;i<ids.length;i++){
			if(id==ids[i]){
				return true;
			}			
		}
		return false;
		
	}
	
	/**
	 * 将逗号隔开的数字组成的字符串转为int数组
	 * @param s 逗号隔开的数字组成的字符串
	 * @return int数组
	 */
	public static int[] convertCommaSeperatedStrToIntArray(String s) {
		if (cssPattern == null) {
			cssPattern = Pattern.compile("[0-9]+(,[0-9]+)*");
		}
		if (s == null || !cssPattern.matcher(s).matches())
			return null;
		
		String[] ss = s.split(",");
		int[] r = new int[ss.length];
		for (int i = 0; i < ss.length; ++i) {
			r[i] = Integer.parseInt(ss[i]);
		}
		
		return r;
	}
	
	public static Date replaceDateNull(Date date){
		if(date==null){
			return new Date();
		}
		return date;
	}
	
	public static int replaceIntegerNull(Integer integer){
		if(integer==null){
			return 0;
		}
		else
			return integer.intValue();
	}
	
	public static String replaceStringNull(String str){
		if(str==null){
			return "";
		}
		else
			return str;
	}
	public static String replaceStringNull(String str,String fill){
		if(str==null){
			return fill;
		}
		else
			return str;
	}
	
	/**
	 * 截去改字符串首尾的空格,回车和换行字符
	 * @param str
	 * @return
	 */
	public static String trimSRN(String str){
		if(str==null){
			return "";
		}	else {
			str = str.trim();
			
			if(str.endsWith("\r\n") || str.endsWith("\n\r"))
				str = str.substring(0, str.length()-2);
			else if(str.endsWith("\r") || str.endsWith("\n"))
				str = str.substring(0, str.length()-1);
			
			if(str.startsWith("\r\n") || str.startsWith("\n\r"))
				str = str.substring(2, str.length());
			else if(str.startsWith("\r") || str.startsWith("\n"))
				str = str.substring(1, str.length());
			
			return str;
		}
	}
	
	public static String trimQuotedString(String str){
		if(str==null){
			return "";
		}else {
			if(str.startsWith("\"") || str.startsWith("\'")) {
				str = str.substring(1, str.length());
			}
			
			if(str.endsWith("\"") || str.endsWith("\'")) {
				str = str.substring(0, str.length()-1);
			}
				return str;
		}
	}
	
	public static String decimalInttoBase64(int input)
	{
		String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String my64mediaId = "";
		int r = 0;
		char c = 0;
		int 	spotsPlanId2=input;
		if(spotsPlanId2==0){
			my64mediaId ="+";
		}else{
			while (spotsPlanId2 > 0) {
				r = spotsPlanId2 % 64;
				c = b64.charAt(r);
				my64mediaId = c + my64mediaId;
				spotsPlanId2 = spotsPlanId2/ 64;
            }
        }
		return my64mediaId;
	}
	
	public static int base64toDecimalInt(String base64)
	{
		String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		char indexChar = 0;
		int index = 0;
		int power = 0;
		int total = 0;
				
		if (base64 != null){
			for (int i = 0; i < base64.length(); i++){
				indexChar = base64.charAt(i);
				index = b64.indexOf(indexChar);
				power = base64.length() - i - 1;
				total += index*Math.pow(64, power);
			}
		}
		return total;
	}
	
	public static String base64toDecimalStr(String base64)
	{
		String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		char indexChar = 0;
		int index = 0;
		int power = 0;
		int total = 0;
				
		if (base64 != null){
			for (int i = 0; i < base64.length(); i++){
				indexChar = base64.charAt(i);
				index = b64.indexOf(indexChar);
				power = base64.length() - i - 1;
				total += index*Math.pow(64, power);
			}
		}
		return String.valueOf(total);
	}
	
	public static String convertIntArrayToCommaSeperatedStr(int[] array) {
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < array.length; ++i) {
			if (i > 0)
				buf.append(',');
			buf.append(array[i]);
		}
		
		return buf.toString();
	}

	public static String xmlEncode(String str){
		str=str.replace("<", "stmzdyh");
		str=str.replace(">", "stmzxyh");
		return str;
	}
	public static String[] getTimeRange(String begin,String end){
		int beginYear = Integer.parseInt(begin.substring(0, 4));
		int endYear = Integer.parseInt(end.substring(0, 4));
		int beginMonth = Integer.parseInt(begin.substring(begin.indexOf("-") + 1, begin.indexOf("-") + 3));
		int endMonth = Integer.parseInt(end.substring(end.indexOf("-") + 1,end.indexOf("-") + 3));
		String[] yearMonths = null;
		if (endYear == beginYear) {
			yearMonths = new String[endMonth - beginMonth + 1];
			for (int i = 0; i < (endMonth - beginMonth + 1); i++) {
				int month = beginMonth + i;
				String monthStr = "" + month;
				if (month < 10) {
					monthStr = "0" + month;
				}
				yearMonths[i] = beginYear + "-" + monthStr;
			}
		} else if (endYear > beginYear) {
			int monthNums = 0;
			monthNums = 12 - beginMonth + (endYear - beginYear - 1) * 12+ endMonth+1;
			yearMonths = new String[monthNums];
			for (int i = 0; i < (monthNums); i++) {
				int month =  (beginMonth + i % 12) % 13;
				String monthStr = "" + month;
				if (month < 10) {
					monthStr = "0" + month;
				}
				yearMonths[i] = beginYear + i / 12 + "-"+ monthStr;
			}
		}
		return yearMonths;
	}
	public static String[] getDateRangeByDateList(List<Date> availableDates){
		TreeSet<String> set=new TreeSet<String>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		if(availableDates!=null){
			for(int m=0;m<availableDates.size();m++){
				String temp=sdf.format(availableDates.get(m));			
			  set.add(temp);
			}		
		}
			String[] dateStr=new String[set.size()];
			Iterator it=set.iterator();
			for(int n=0;n<set.size();n++){
				dateStr[n]=it.next().toString();
			}
			return dateStr;
	}
	public static Map<Integer,Integer[]>   getCategoryAdpResultMap(List<Object[]> categoryAdpResult){
		Map<Integer,Integer[]> categoryAdpResultMap=new HashMap<Integer,Integer[]>();
		if(categoryAdpResult!=null){
			for(int j=0;j<categoryAdpResult.size();j++){
				int id=0;
				if(categoryAdpResult.get(j)[1]!=null){
					id=Integer.parseInt(categoryAdpResult.get(j)[1].toString());
				}
				Integer[] count=new Integer[2];
				if(categoryAdpResult.get(j)[2]!=null){
					count[0]=Integer.parseInt(categoryAdpResult.get(j)[2].toString());
				}
				if(categoryAdpResult.get(j)[3]!=null){
					count[1]=Integer.parseInt(categoryAdpResult.get(j)[3].toString());
				}			
				categoryAdpResultMap.put(id, count);
			}
		}
		return categoryAdpResultMap;
	}
	public static Map<Integer,Integer[]>   getAdpAllCategoryMap(List<Object[]> adpAllCategoriesResult){
		Map<Integer,Integer[]> adpAllCateMap=new HashMap<Integer,Integer[]>();
		if(adpAllCategoriesResult!=null){
			for(int j=0;j<adpAllCategoriesResult.size();j++){
				int id=0;
				if(adpAllCategoriesResult.get(j)[0]!=null){
					id=Integer.parseInt(adpAllCategoriesResult.get(j)[0].toString());
				}
				Integer[] count=new Integer[2];
				if(adpAllCategoriesResult.get(j)[1]!=null){
					count[0]=Integer.parseInt(adpAllCategoriesResult.get(j)[1].toString());
				}
				if(adpAllCategoriesResult.get(j)[2]!=null){
					count[1]=Integer.parseInt(adpAllCategoriesResult.get(j)[2].toString()); 
				}
				
				adpAllCateMap.put(id, count);
			}
		}
		return adpAllCateMap;
	}
	public static int getDays(Date date){
		Calendar calendar =  Calendar.getInstance();
		calendar.set(Calendar.YEAR, date.getYear());
		calendar.set(Calendar.MONTH, date.getMonth());
		int totalDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int days = totalDay - date.getDate();
		return days;
	}
	/*
	 * 通过总记录数跟pagesize求总页数
	 */
	public static Integer getTotalPage(Integer total,Integer pageSize){
		if(total==null||total==0||pageSize==0){
			return 0;
		}
		Integer totalPage = 0;
		if(total % pageSize==0){
			totalPage = total/pageSize;
		}else{
			totalPage = total/pageSize +1;
		}
		//System.out.println("totalPage="+totalPage);
		return totalPage;
	}
	public static String randomColor(){
		Random rand = new Random();
		int red = rand.nextInt(256);
		int blue = rand.nextInt(256);
		int green = rand.nextInt(256);

		java.awt.Color color = new java.awt.Color(red,green,blue);
		String rStr = "#"+String.valueOf(Integer.toHexString(color.getRed()));
		rStr += String.valueOf(Integer.toHexString(color.getGreen()));
		rStr += String.valueOf(Integer.toHexString(color.getBlue()));
		return rStr;
	}
	public static Field getFieldInFamily(Class cls,String field){
		do{
			Field[] fields = cls.getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				if(fields[i].getName().equals(field)){
					return fields[i];
				}
			}
		}while(!(cls = cls.getSuperclass()).equals(Object.class));
		return null;
	}
	public static String ListToStr(List<Integer> ids){
		if(null ==ids || ids.size() == 0){
			return null;
		}
		StringBuffer s = new StringBuffer("");
		for(int id :ids){
			s.append(String.valueOf(id)+",");
		}
		String idsStr =s.substring(0, s.length()-1);
		return idsStr;
	}
}
