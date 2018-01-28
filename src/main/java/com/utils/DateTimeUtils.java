package com.utils;

import org.joda.time.DateTime;

public class DateTimeUtils {

    private static DateTime dateTime;

    static{
        dateTime = new DateTime();
    }

    public static DateTime dateTime(){
        return dateTime;
    }
}
