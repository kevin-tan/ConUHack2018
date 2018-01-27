package com.startup.model;

public class Courses {
    private final String courseName;
    private final Time time;

    public Courses(String courseName, Time time){
        this.courseName = courseName;
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public Time getTime() {
        return time;
    }
}
