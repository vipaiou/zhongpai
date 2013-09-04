package com.supertool.dspui.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.supertool.dspui.config.Config;
import com.supertool.dspui.constant.Constant;
import com.supertool.dspui.util.chinese.ZHConverter;



public class StringUtil {
    static Logger logger = Logger.getLogger(StringUtil.class.getName());

    /**
     * 文件名称转换函数。去除空格、Tab、斜线、反斜线
     * 
     * @param str
     *            文件名称
     * @return 转换后的文件名称
     */
    public static String fileNameEncode(String str) {
        str = str.replace(" ", "_");// replace space
        str = str.replace("	", "_");// replace tab
        str = str.replace("/", "_");// replace /
        str = str.replace("\\", "_");// replace \
        return str;
    }

    public static String xmlEncode(String str) {
        str = str.replace("<", "stmzdyh");
        str = str.replace(">", "stmzxyh");
        return str;
    }

    public static Date replaceDateNull(Date date) {
        if (date == null) {
            return new Date();
        }
        return date;
    }

    public static int replaceIntegerNull(Integer integer, Integer newInteger) {
        if (integer == null) {
            return newInteger;
        } else
            return integer;
    }

    public static int replaceIntegerNull(Integer integer) {
        if (integer == null) {
            return 0;
        } else
            return integer.intValue();
    }

    public static String replaceStringNull(String str) {
        if (str == null) {
            return "";
        } else
            return str;
    }

    public static String replaceStringNull(String str, String fill) {
        if (str == null) {
            return fill;
        } else
            return str;
    }

    public static Vector<String> splitString(String str) {
        // 把str以SPLITER分割，分别取出，写入vector，返回该vector。
        return new Vector<String>();
    }

    public static String tagFilter(String content) {
        content = content.replaceAll("<", "&lt");
        content = content.replaceAll(">", "&gt");
        return content;
    }

    public static String tagRetrieve(String content) {
        content = content.replaceAll("&lt", "<");
        content = content.replaceAll("&gt", ">");
        return content;
    }

    public static String xmlEscape(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (s == null) {
            return null;
        }
        int j = s.length();
        for (int i = 0; i < j; i++) {
            char c = s.charAt(i);
            switch (c) {
            case '\'':
                stringBuilder.append("&apos;");
                break;
            case '\"':
                stringBuilder.append("&quot;");
                break;
            case '>':
                stringBuilder.append("&gt;");
                break;
            case '<':
                stringBuilder.append("&lt;");
                break;
            case '&':
                stringBuilder.append("&amp;");
                break;
            default:
                stringBuilder.append(c);
            }
        }
        return new String(stringBuilder);
    }

    public static String jqGridHtmEncode(String s) {
        s = "<![CDATA[" + s + "]]>";
        return s;
    }

    public static String htmEncode(String s) {
        StringBuffer stringbuffer = new StringBuffer();
        int j = s.length();
        for (int i = 0; i < j; i++) {
            char c = s.charAt(i);
            switch (c) {
            case 39:
                stringbuffer.append("&apos;");
                break;
            case 60:
                stringbuffer.append("&lt;");
                break;
            case 62:
                stringbuffer.append("&gt;");
                break;
            case 38:
                stringbuffer.append("&amp;");
                break;
            case 34:
                stringbuffer.append("&quot;");
                break;
            case 169:
                stringbuffer.append("&copy;");
                break;
            case 174:
                stringbuffer.append("&reg;");
                break;
            case 165:
                stringbuffer.append("&yen;");
                break;
            case 8364:
                stringbuffer.append("&euro;");
                break;
            case 8482:
                stringbuffer.append("&#153;");
                break;
            /*
             * case 13: if (i < j - 1 && s.charAt(i + 1) == 10) { stringbuffer.append("<br>"); i++; } break;
             */
            /*
             * case 32: if (i < j - 1 && s.charAt(i + 1) == ' ') { stringbuffer.append(" &nbsp;"); i++; break; }
             */
            case 13:
                stringbuffer.append("<br>");
                break;
            case 32:
                stringbuffer.append("&nbsp;");
                break;
            default:
                stringbuffer.append(c);
                break;
            }
        }
        return new String(stringbuffer.toString());
    }

    public static String decimalInttoBase64(int input) {
        String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String my64mediaId = "";
        int r = 0;
        char c = 0;
        int spotsPlanId2 = input;
        if (spotsPlanId2 == 0) {
            my64mediaId = "+";
        } else {
            while (spotsPlanId2 > 0) {
                r = spotsPlanId2 % 64;
                c = b64.charAt(r);
                my64mediaId = c + my64mediaId;
                spotsPlanId2 = spotsPlanId2 / 64;
            }
        }
        return my64mediaId;
    }

    public static int base64toDecimalInt(String base64) {
        String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char indexChar = 0;
        int index = 0;
        int power = 0;
        int total = 0;

        if (base64 != null) {
            for (int i = 0; i < base64.length(); i++) {
                indexChar = base64.charAt(i);
                index = b64.indexOf(indexChar);
                power = base64.length() - i - 1;
                total += index * Math.pow(64, power);
            }
        }
        return total;
    }

    public static String base64toDecimalStr(String base64) {
        String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char indexChar = 0;
        int index = 0;
        int power = 0;
        int total = 0;

        if (base64 != null) {
            for (int i = 0; i < base64.length(); i++) {
                indexChar = base64.charAt(i);
                index = b64.indexOf(indexChar);
                power = base64.length() - i - 1;
                total += index * Math.pow(64, power);
            }
        }
        return String.valueOf(total);
    }

    /**
     * 截去改字符串首尾的空格,回车和换行字符
     * 
     * @param str
     * @return
     */
    public static String trimSRN(String str) {
        if (str == null) {
            return "";
        } else {
            str = str.trim();

            if (str.endsWith("\r\n") || str.endsWith("\n\r"))
                str = str.substring(0, str.length() - 2);
            else if (str.endsWith("\r") || str.endsWith("\n"))
                str = str.substring(0, str.length() - 1);

            if (str.startsWith("\r\n") || str.startsWith("\n\r"))
                str = str.substring(2, str.length());
            else if (str.startsWith("\r") || str.startsWith("\n"))
                str = str.substring(1, str.length());

            return str;
        }
    }

    public static String trimQuotedString(String str) {
        if (str == null) {
            return "";
        } else {
            if (str.startsWith("\"") || str.startsWith("\'")) {
                str = str.substring(1, str.length());
            }

            if (str.endsWith("\"") || str.endsWith("\'")) {
                str = str.substring(0, str.length() - 1);
            }
            return str;
        }
    }

    /**
     * 去掉首尾任意字符串
     * 
     * @param str
     * @return
     */
    public static String trim(String str, String trimStr) {
        return str.replaceAll("^" + trimStr + "+|" + trimStr + "+$", "");
    }

    public static String toBase64(int input) {
        String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String my64mediaId = "";
        int r = 0;
        char c = 0;
        int spotsPlanId2 = input;
        if (spotsPlanId2 == 0) {
            my64mediaId = "+";
        } else {
            while (spotsPlanId2 > 0) {
                r = spotsPlanId2 % 64;
                c = b64.charAt(r);
                my64mediaId = c + my64mediaId;
                spotsPlanId2 = spotsPlanId2 / 64;
            }
        }
        return my64mediaId;
    }

    /**
     * 判断s字符串是不是数字格式 ,当s为null时不是数字
     * 
     * @return
     */
    public static boolean isNumber(String s) {
        if (s != null) {
            Pattern numberPattern = null;
            if (numberPattern == null)
                numberPattern = Pattern.compile("[\\+-]?[0-9]+");
            return numberPattern.matcher(s).matches();
        } else {
            return false;
        }
    }

	public static Integer getNumber(Object obj) {
		Integer num = null;
		if (obj != null && obj instanceof String) {
			String str = obj.toString().trim();
			if (isNumber(str)) {
				num = Integer.parseInt(str);
			}
		}
		return num;
	}
    /**
     * 获取某一个月有多天的函数
     * 
     * @param year
     * @param month
     * @return
     */
    public static int getDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getCurrentYear() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);// 获取年份
        return year;
    }

    /**
     * 与myDecode配对的编码。转换:,@$|\\'"
     * 
     * @param str
     *            字符串
     * @return 转换后的字符串
     */
    public static String myEncode(String str) {
        str = str.replace(":", "mzzxcv");
        str = str.replace(",", "mzzxdh");
        str = str.replace("@", "mzzxat");
        str = str.replace("$", "mzzxdl");
        str = str.replace("|", "mzzxsx");
        str = str.replace("\\", "mzzxfxx");
        str = str.replace("'", "mzzxdyh");
        str = str.replace("\"", "mzzxsyh");
        return str;
    }

    /**
     * 与myEncode配对的解码函数。恢复被转码的:,@$|\\'"
     * 
     * @param str
     *            字符串
     * @return 转换后的字符串
     */
    public static String myDecode(String str) {
        str = str.replace("mzzxsyh", "\"");
        str = str.replace("mzzxdyh", "'");
        str = str.replace("mzzxfxx", "\\");
        str = str.replace("mzzxsx", "|");
        str = str.replace("mzzxdl", "$");
        str = str.replace("mzzxat", "@");
        str = str.replace("mzzxdh", ",");
        str = str.replace("mzzxcv", ":");
        return str;
    }

    /**
     * csv文件内容转换函数。将双引号变成两个双引号
     * 
     * @param str
     *            csv文件内容
     * @return 转换后的内容
     */
    public static String csvEncode(String str) {
        str = str.replace("\"", "\"\"");
        return str;
    }

    public static String javaScriptEscape(String input) {
        if (input == null) {
            return input;
        }
        StringBuffer filtered = new StringBuffer(input.length());
        char prevChar = '\u0000';
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c == '"') {
                filtered.append("\\\"");
            } else if (c == '\'') {
                filtered.append("\\'");
            } else if (c == '\\') {
                filtered.append("\\\\");
            } else if (c == '\t') {
                filtered.append("\\t");
            } else if (c == '\n') {
                if (prevChar != '\r') {
                    filtered.append("\\n");
                }
            } else if (c == '\r') {
                filtered.append("\\n");
            } else if (c == '\f') {
                filtered.append("\\f");
            } else if (c == '/') {
                filtered.append("\\/");
            } else {
                filtered.append(c);
            }
            prevChar = c;
        }
        return filtered.toString();
    }

    /*
     * 通过已经存在的最近的订单号生成一个新的订单号
     */
    public static String getOrderNumber(String latestOrderNumber) {
        Integer index;
        String orderNumber;
        if (latestOrderNumber != null && latestOrderNumber.length() > 9) {
            index = Integer.valueOf(latestOrderNumber.substring(8));
            index++;
        } else {
            index = 1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("000");
        String formatIndex = df.format(index);
        orderNumber = sdf.format(new Date()) + formatIndex;
        return orderNumber;
    }
  
    /**
     * 此方法用来将对象列表转划为jqGrid可用的xml字符串
	 * 
	 * @param dataList xml数据源
	 * @param entityClass 实体类型
	 * @param pageNo 当前第几页
	 * @param total 总页数
	 * @param records 总记录数 
	 * @param attributes 表格中需要显示的属性列表（不包括 extra拼凑属性)
	 * @param extras 表格中需要显示的属性拼凑属性
	 * @return
	 */
    public static <K> String buildTableXMLData(List<K> dataList,Class<K> entityClass,int pageNo, int total, int records,
           List<String>attributes,List<List<Object>>extras) {
        if (dataList == null || dataList.size() <= 0 || attributes == null || attributes.size() <= 0) {
           //System.out.println("dataList="+dataList); 
        	return "<?xml version='1.0' encoding='utf-8'?><rows><page>" + pageNo + "</page><total>" + total
                    + "</total>" + "<records>" + records + "</records></rows>";
        }
        Class<K> cls = entityClass;
        List<String> methodStrings = new LinkedList<String>();
        List<Method>methods= new LinkedList<Method>();
        for (int i = 0; i < attributes.size(); i++) {
        	String methodString = "get" + attributes.get(i).toString().substring(0, 1).toUpperCase() + attributes.get(i).toString().substring(1);
        	methodStrings.add(methodString);
        	try {
        		 	methods.add(cls.getMethod(methodStrings.get(i).toString()));
        	 } catch (NoSuchMethodException e) {
                 logger.debug(new Date() + ": " + e.getMessage());
                 e.printStackTrace();
                 methods.set(i, null);
             }
        }
        StringBuilder tableDataXML = new StringBuilder();
        tableDataXML.append("<?xml version='1.0' encoding='utf-8'?>");
        tableDataXML.append("<rows>");
        tableDataXML.append("<page>" + pageNo + "</page>");
        tableDataXML.append("<total>" + total + "</total>");
        tableDataXML.append("<records>" + records + "</records>");
        Object attribute;
   
        int i = 0;
        
        for (; i < dataList.size(); i++) {
        	tableDataXML.append("<row >"); 
        	String value="数据构造出错";
        	//构造固有属性
        	for (int j = 0; j < methods.size(); j++) {
        		try{
        				attribute = methods.get(j).invoke(dataList.get(i), new Object[] {});
        				value=StringUtil.jqGridHtmEncode(attribute != null ? attribute.toString() : "");	 
        		} catch (IllegalAccessException e) {
                       logger.debug(new Date() + ": " + e.getMessage());
                        e.printStackTrace();
                        // return "";
                } catch (InvocationTargetException e) {
                        logger.debug(new Date() + ": " + e.getMessage());
                        e.printStackTrace();
                }
        		tableDataXML.append("<cell>"+value+"</cell>");
        	}

        	//添加拼凑属性列
            if(null!=extras&&extras.size()>0){
            	for(int ii=0;ii<extras.size();ii++){
		             tableDataXML.append("<cell>");
		             tableDataXML.append(StringUtil.jqGridHtmEncode(extras.get(ii).get(i)!= null ? extras.get(ii).get(i).toString() : ""));	
		             tableDataXML.append("</cell>");
	            }
            }
           tableDataXML.append("</row>");   
        }
        tableDataXML.append("</rows>");
       //System.out.println(tableDataXML.toString());
        return tableDataXML.toString();
    }
    
    
    public static String dateToFormatString(String formatStr, Date time) {
        String rs = "";
        if (formatStr == null || "".equals(formatStr)) {
            formatStr = "yyyy-MM-dd HH:mm:ss:SSS";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            rs = sdf.format(time);
        } catch (Exception e) {
            logger.debug(new Date() + ": " + e.getMessage());
            e.printStackTrace();
            return "";
        }
        return rs;
    }
    
    public static Date formatStringToDate(String date,String ...formatStr){
        SimpleDateFormat sdf;
        try {
            if (formatStr == null || formatStr.length <= 0) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            } else {
                sdf = new SimpleDateFormat(formatStr[0]);
            }
            return sdf.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String staticDecrypt(String str) {
        if (str == null) {
            return "";
        }
        String retStr = new DesEncrypter(Config.getImageHost()).decrypt(str);
        return retStr != null ? retStr : "";
    }

    public static boolean isExpired(Date endTime) {
        return endTime.before(new Date());
    }

    public static Date parseDate(String str) {
        Date rs = new Date();
        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            rs = dateformat.parse(str);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        return rs;
    }

    public static int numberOfChar(String str, String c) {
        int n = 0;
        int i = str.indexOf(c);
        while (i != -1) {
            n++;
            i = str.indexOf(c, i + 1);
        }
        return n;
    }

    public static boolean mkdirs(String filePath) {
        File dirFile = null;
        try {
            dirFile = new File(filePath);
            if (!dirFile.exists() && !dirFile.isDirectory()) {
                return dirFile.mkdirs();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean compareString(String str1,String str2){
 		String simpleName = ZHConverter.convert(str2, ZHConverter.SIMPLIFIED);
		String traditionName = ZHConverter.convert(str2,ZHConverter.TRADITIONAL);
		if (str2.length() == 2) {// name长度为2时，对可能存在的简繁体中文混合处理
			String[] portfolios = ZHConverter.getPortfolioString(str2);
			if (str1.equalsIgnoreCase(portfolios[0]) || str1.equalsIgnoreCase(portfolios[1])) {
				return true;
			}
		}
		if (str1.equalsIgnoreCase(str2) || str1.equalsIgnoreCase(simpleName)|| str1.equalsIgnoreCase(traditionName)) {
			return true;
		}
		return false;
	}
    
	public static boolean isBlank(String str) {
		if (null != str && !"".equals(str.trim())) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
    
    public static Boolean isPositiveInteger(String s){
        Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        return pattern.matcher(s).matches();
    }
    
    public static Boolean isNonNegativeIntegerInteger(String s){
        Pattern pattern = Pattern.compile("^\\d+$");
        return pattern.matcher(s).matches();
    }

    /**
     * 将 string编码为base64字符串
     * @param str
     * @return
     */
    public static String encodeToBase64(String str){
    	byte[] b = str.getBytes();
    	Base64 base64 = new Base64();
    	return new String(base64.encode(b));
    }

    /**
     * 将 base64字符串解码为string
     * @param base64String
     * @return
     */
    public static String decodeBase64ToString(String base64String){
    	if(base64String == null){
    		return "";
    	}
    	byte[] b = Base64.decodeBase64(base64String);
    	return new String(b);
    }
    
	public static void main(String[] args) {
		System.out.println(decodeBase64ToString("c3VjY2Vzc2Z1bA=="));
	}
}
