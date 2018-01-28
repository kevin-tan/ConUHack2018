package com.model;

import com.utils.DateTimeUtils;
import org.joda.time.DateTime;

public class Courses {
    private String courseName;
    private DateTime startTime;

    public Courses(String courseName, DateTime startTime) {
        this.courseName = courseName;
        this.startTime = startTime;
    }

    public Courses() {
        this.courseName = "";
        this.startTime = new DateTime(DateTimeUtils.dateTime().getYear(),DateTimeUtils.dateTime().getMonthOfYear(),
                DateTimeUtils.dateTime().getDayOfMonth(),0,0);
    }

    public String getCourseName() {
        return courseName;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }
}
