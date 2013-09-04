package com.supertool.dspui.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.supertool.dspui.exception.BasicException;

public class Common {

	public Common() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date stringToUtilDate(String strdate)
	{
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(strdate.trim());
		} catch (ParseException e) {
			
			throw new BasicException("日期转换异常:"+e.getMessage(),e);
		}
	}
	public java.sql.Date utilDateToSqlDate(Date date){
		return new java.sql.Date(date.getTime());
	}
	public static Common getInstance(){
		return new Common();
	}
}
