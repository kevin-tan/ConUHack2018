package com.startup.constants;

public enum WeekdayId {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday");

    private final String weekday;

    WeekdayId(String weekday) {
        this.weekday = weekday;
    }

    public String getWeekday() {
        return weekday;
    }
}
