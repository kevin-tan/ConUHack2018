package com.program;

import com.program.window.thread.ClockThread;
import com.program.window.ProgramWindow;
import com.startup.constants.WeekdayId;
import com.data.DataRepository;
import com.model.Courses;
import com.utils.DateTimeUtils;
import com.windows.constants.FrameConstants;

import java.util.List;
import java.util.Map;

public class Program {

    private final ProgramWindow programWindow;
    private final Thread timeThread;
    private final Map<WeekdayId, List<Courses>> dataRepo;

    public Program() {
        programWindow = new ProgramWindow("", FrameConstants.INFO_WINDOW_WIDTH, FrameConstants.INFO_WINDOW_HEIGHT);
        timeThread = new ClockThread(programWindow);
        dataRepo = DataRepository.getDataRepository();
    }

    public void start() {
        programWindow.addData();
        programWindow.setVisible(true);
        if (!dataRepo.get(DateTimeUtils.getEnum(DateTimeUtils.dateTime().getDayOfWeek())).isEmpty())
            programWindow.startDirectionRequestThread();
        programWindow.startDateThread();
        timeThread.start();
    }

    public void stop() throws InterruptedException {
        timeThread.join();
        programWindow.stopDateThread();
        programWindow.stopDirectionRequestThread();
        programWindow.setVisible(false);
    }
}
