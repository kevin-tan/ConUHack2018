package com.program.window.thread;

import com.model.Courses;
import com.program.window.ProgramWindow;
import com.startup.constants.WeekdayId;
import com.utils.DateTimeUtils;
import org.joda.time.format.DateTimeFormat;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class DateThread extends Thread {

    private Map<WeekdayId, List<Courses>> map;
    private JLabel date;
    private ProgramWindow programWindow;

    public DateThread(Map<WeekdayId, List<Courses>> map, ProgramWindow programWindow, JLabel date) {
        this.map = map;
        this.date = date;
        this.programWindow = programWindow;
    }

    @Override
    public void run() {
        while(programWindow.isVisible()){
            date.setText(DateTimeUtils.dateTime().toString(DateTimeFormat.mediumDate()));
            try {
                sleep(600000); //TODO change to sleep for 1 day
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
