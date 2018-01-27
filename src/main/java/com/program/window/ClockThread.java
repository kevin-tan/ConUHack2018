package com.program.window;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread extends Thread{

    private boolean isRunning;
    private final ProgramWindow programWindow;

    public ClockThread(ProgramWindow programWindow){
        this.programWindow = programWindow;
    }

    @Override
    public void run(){
        while(programWindow.isVisible()){
            try {
                programWindow.setTitle(getDateAndTime());
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getDateAndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currrentDate = new Date();
        return simpleDateFormat.format(currrentDate);
    }

}
