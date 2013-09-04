package com.supertool.dspui.taglib;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;

public class Format {

    /**
     * 日期格式化
     * @param date
     * @return
     */
    public static String toDate(Date date) {
        if (null == date) {
            return "";
        }
        return JodaFormats.Date.print(new DateTime(date));
    }

    /**
     * 时间格式化，精确到分钟。格式为：`yyyy-MM-dd HH:mm`
     * @param date
     * @return
     */
    public static String toMinute(Date date) {
        if (null == date) {
            return "";
        }
        return JodaFormats.Minute.print(new DateTime(date));
    }

    public static String toHourMinute(Date date) {
        return JodaFormats.HourMinute.print(new DateTime(date));
    }

    public static String endOfDay(Date date) {
        return JodaFormats.Minute.print(new DateTime(Times.endOfDay(date)));
    }

    public static String number(double n) {
        NumberFormat f = NumberFormat.getNumberInstance(Locale.SIMPLIFIED_CHINESE);
        f.setMinimumFractionDigits(2);
        f.setMaximumFractionDigits(2);
        return f.format(n);
    }

    public static String integer(double n) {
        NumberFormat f = NumberFormat.getNumberInstance(Locale.SIMPLIFIED_CHINESE);
        f.setMinimumFractionDigits(0);
        f.setMaximumFractionDigits(0);
        return f.format(n);
    }

    public static String cleanNumber(double n) {
        NumberFormat f = NumberFormat.getNumberInstance(Locale.SIMPLIFIED_CHINESE);
        f.setMinimumFractionDigits(2);
        f.setMaximumFractionDigits(2);
        f.setGroupingUsed(false);
        return f.format(n);
    }

    public static String cpm(double n) {
        NumberFormat f = NumberFormat.getCurrencyInstance(Locale.SIMPLIFIED_CHINESE);
        return f.format(n) + "/CPM" ;
    }

    public static String percent(double n) {
        NumberFormat f = NumberFormat.getPercentInstance(Locale.SIMPLIFIED_CHINESE);
        f.setMaximumFractionDigits(3);
        f.setMinimumFractionDigits(3);
        return f.format(n);
    }

    public static void main(String[] args) {
        System.out.println(cpm(123));
    }
}
