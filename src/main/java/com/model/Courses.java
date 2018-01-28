package com.model;

public class Courses {
    private final String courseName;
    private final Time startTime;

    public Courses(String courseName, Time startTime) {
        this.courseName = courseName;
        this.startTime = startTime;
    }

    public Courses() {
        this.courseName = "";
        this.startTime = new Time(0, 0, 0);
    }

    public String getCourseName() {
        return courseName;
    }

    public Time getStartTime() {
        return startTime;
    }
}
