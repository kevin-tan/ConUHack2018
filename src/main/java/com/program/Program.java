package com.program;

import com.program.window.ClockThread;
import com.program.window.ProgramWindow;
import com.startup.constants.WeekdayId;
import com.data.DataRepository;
import com.startup.model.Courses;
import com.windows.constants.FrameConstants;

import java.util.List;
import java.util.Map;

public class Program {

    private final ProgramWindow programWindow;
    private final Thread dateThread;
    private final Map<WeekdayId, List<Courses>> dataRepo;

    public Program() {
        programWindow = new ProgramWindow("", FrameConstants.INFO_WINDOW_WIDTH, FrameConstants.INFO_WINDOW_HEIGHT);
        dateThread = new ClockThread(programWindow);
        dataRepo = DataRepository.getDataRepository();
    }

    public void start() {
        programWindow.setVisible(true);
        dateThread.start();
    }

    public void stop() throws InterruptedException {
        dateThread.join();
        programWindow.setVisible(false);
    }
}
