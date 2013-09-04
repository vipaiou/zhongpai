package com.supertool.dspui.taglib;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class Patterns {

    public static final String Date = "yyyy-MM-dd";
    public static final String Time = "yyyy-MM-dd HH:mm:ss";
    public static final String Minute = "yyyy-MM-dd HH:mm";
    public static final String ISO = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
    public static final String ISOSecond = "yyyy-MM-dd'T'HH:mm:ssZZ";
    public static final String HourMinute = "HH:mm";

    public static void main(String[] args) {
        System.out.println(new DateTime(new Date()).toString(ISO));
        System.out.println(new SimpleDateFormat(ISO).format(new Date()));
    }
}
