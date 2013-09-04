package com.supertool.dspui.taglib;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaFormats {

    public static final DateTimeFormatter Date = ISODateTimeFormat.date();
    public static final DateTimeFormatter Time = DateTimeFormat.forPattern(Patterns.Time);
    public static final DateTimeFormatter Minute = DateTimeFormat.forPattern(Patterns.Minute);
    public static final DateTimeFormatter ISO = ISODateTimeFormat.dateTimeParser();
    public static final DateTimeFormatter ISOSecond = ISODateTimeFormat.dateTimeNoMillis();
    public static final DateTimeFormatter HourMinute = DateTimeFormat.forPattern(Patterns.HourMinute);

    public static void main(String[] args) {
        System.out.println(Date.parseDateTime("2011-01-02"));
        System.out.println(Date.print(new DateTime()));
        System.out.println(ISOSecond.print(new DateTime()));
    }
}
