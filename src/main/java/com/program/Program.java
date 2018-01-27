package com.program;

import com.program.window.ProgramWindow;
import com.startup.constants.WeekdayId;
import com.startup.data.DataRepository;
import com.startup.model.Courses;
import com.windows.constants.FrameConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Program {

    private final ProgramWindow programWindow;
    private final Thread dateThread;
    private final Map<WeekdayId, List<Courses>> dataRepo;

    public Program() {
        programWindow = new ProgramWindow("", FrameConstants.INFO_WINDOW_WIDTH, FrameConstants.INFO_WINDOW_HEIGHT);
        dateThread = new Thread(timeDateThread(programWindow));
        dataRepo = DataRepository.getDataRepository();
    }

    public void start(){
        programWindow.setVisible(true);
        dateThread.start();
    }

    public void stop() throws InterruptedException {
        dateThread.join();
        programWindow.setVisible(false);
    }

    private Runnable timeDateThread(final ProgramWindow programWindow){
        return () -> {
            while(programWindow.isVisible()){
                programWindow.setTitle(getDateAndTime());
            }
        };
    }

    private String getDateAndTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currrentDate = new Date();
        return simpleDateFormat.format(currrentDate);
    }
}
