package com.supertool.dspui.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateTimeFormatString = "yyyy-MM-dd hh:mm:ss";
	public static String dateFormatString = "yyyy-MM-dd";
	
	
	
	public static String getDateTimeFormatString() {
		return dateTimeFormatString;
	}

	public static void setDateTimeFormatString(String dateTimeFormatString) {
		DateUtil.dateTimeFormatString = dateTimeFormatString;
	}

	public static String getDateFormatString() {
		return dateFormatString;
	}

	public static void setDateFormatString(String dateFormatString) {
		DateUtil.dateFormatString = dateFormatString;
	}

	/**
	 * 解析 1970-01-01 08:00:00 形式字符串表示的日期
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date getYMDHMSDate(String dateString) {
		return getDate(dateString, dateTimeFormatString);
	}

	/**
	 * 解析指定形式字符串表示的日期
	 * @param dateString
	 * @param formatString
	 * @return
	 */
	public static Date getDate(String formatString, String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date getNowDate(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(sdf.format(now));
		} catch (ParseException e) {
			
			return null;
		}
	}
	public static String getNowDateTimeStr(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return sdf.format(now);
		
	}

	public static Date getDefaultDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse("1970-01-01 08:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public static Date getDefalutDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse("1970-01-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
    public static Date getMax(Date a, Date b) {
        if (null == a && null == b) {
            return null;
        }
        if (null == a) {
            return b;
        } 
        if (null == b) {
            return a;
        }
        return a.after(b) ? a : b;
    }
    public static Date formatDateTime(Date d){
    	SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormatString);
    	String dateStr =  sdf.format(d);
    	
    	Date date;
		try {
			date = sdf.parse(dateStr.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	return date;
    }
    public static void main(String[] args) {
    	System.out.println(System.getProperty("java.io.tmpdir"));
    }

}