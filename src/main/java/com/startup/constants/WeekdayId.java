package com.startup.constants;

public enum WeekdayId {
    MONDAY("Monday", 1),
    TUESDAY("Tuesday", 2),
    WEDNESDAY("Wednesday", 3),
    THURSDAY("Thursday", 4),
    FRIDAY("Friday", 5);

    private final String weekday;
    private final int dayOfWeek;

    WeekdayId(String weekday, int dayOfWeek) {
        this.weekday = weekday;
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfWeek(){
        return dayOfWeek;
    }

    public String getWeekday() {
        return weekday;
    }
}
