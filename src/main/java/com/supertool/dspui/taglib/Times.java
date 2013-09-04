package com.supertool.dspui.taglib;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * TODO: 彻底解决时区问题
 *
 */
public class Times {

    public static DateTime datetime(Date d) {
        return new DateTime(d);
    }

    /**
     * 一天的开始
     */
    public static Date startOfDay(Date d) {
        return datetime(d).millisOfDay().withMinimumValue().toDate();
    }

    /**
     * 一天的结束
     */
    public static Date endOfDay(Date d) {
        return datetime(d).millisOfDay().withMaximumValue().toDate();
    }

    public static Date endOfDay(DateTime dt) {
        return dt.millisOfDay().withMaximumValue().toDate();
    }

    public static Date parseDateOrTime(String text) {
        try {
            return JodaFormats.Time.parseDateTime(text).toDate();
        } catch (Exception e) {
            try {
                return JodaFormats.Date.parseDateTime(text).toDate();
            } catch (Exception e1) {
                return null;
            }
        }
    }

    public static Date parseISO(String text) {
        return JodaFormats.ISO.parseDateTime(text).toDate();
    }

    public static Date parse(String text) {
        return JodaFormats.Time.parseDateTime(text).toDate();
    }

    public static Date parseMinute(String text) {
        return JodaFormats.Minute.parseDateTime(text).toDate();
    }

    public static Date create(int y, int m, int d, int h, int mm, int s) {
        return new DateTime(y, m, d, h, mm, s).toDate();
    }

    public static Date create(int y, int m, int d, int h, int mm, int s, int sss) {
        return new DateTime(y, m, d, h, mm, s, sss).toDate();
    }

    /**
     * 加法，单位是Hour
     * 
     * @param d
     * @param n
     * @return
     */
    public static Date plusHours(Date d, int n) {
        return datetime(d).plusHours(n).toDate();
    }

    /**
     * 剑法，单位是Hour
     * 
     * @author zhaopuming
     * @param d
     * @param n
     * @return
     */
    public static Date minusHours(Date d, int n) {
        return datetime(d).minusHours(n).toDate();
    }

    /**
     * 小时的开始
     */
    public static Date startOfHour(Date d) {
        return datetime(d).hourOfDay().roundFloorCopy().toDate();
    }

    /**
     * 小时的结束
     * 
     * @note 精确到millis（实现方法: startOfNextHour - 1ms）
     * @author zhaopuming
     * @param d
     * @return
     */
    public static Date endOfHour(Date d) {
        return datetime(d).hourOfDay().roundCeilingCopy().minusMillis(1).toDate();
    }

    /**
     * toString，格式是 "yyyy-MM-dd HH:mm:ss"
     * 
     * @author zhaopuming
     * @param d
     * @return
     */
    public static String toString(Date d) {
        return datetime(d).toString(Patterns.Time);
    }

    public static String toString(Date d, String pattern) {
        return datetime(d).toString(pattern);
    }

    public static String toHourMinuteString(Date d) {
        return datetime(d).toString(Patterns.HourMinute);
    }

    public static String toMinuteString(Date d) {
        return datetime(d).toString(Patterns.Minute);
    }

    /**
     * 
     * toString 格式是ISO格式"yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
     * 
     * @see Patterns ISO
     * @param d
     * @return
     */
    public static String toISOString(Date d) {
        return datetime(d).toString();
    }

    public static String toISOSecondString(Date d) {
        return datetime(d).toString(JodaFormats.ISOSecond);
    }

    public static void main(String[] args) {
        Date d = parse("2011-01-02 01:02:03");
        Date d1 = parseISO("2011-01-02T01:02:03.333+08:00");
        System.out.println(d);
        System.out.println(toString(d1));
        System.out.println(toHourMinuteString(d1));
    }
}
