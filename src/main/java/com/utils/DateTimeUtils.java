package com.utils;

import com.startup.constants.WeekdayId;
import org.joda.time.DateTime;

import static com.startup.constants.WeekdayId.*;

public class DateTimeUtils {

    private static DateTime dateTime;

    static{
        dateTime = new DateTime();
    }

    public static WeekdayId getEnum(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            case 7:
                return SUNDAY;
            default:
                return null;
        }
    }

    public static DateTime dateTime(){
        return dateTime;
    }
}
