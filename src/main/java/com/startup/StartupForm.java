package com.startup;

import com.startup.window.StartupWindow;
import com.windows.constants.FrameConstants;

public class StartupForm {

    private final StartupWindow startupWindow;

    public StartupForm() {
        startupWindow = new StartupWindow("Setup - 1",
                FrameConstants.FORM_WINDOW_WIDTH, FrameConstants.FORM_WINDOW_HEIGHT);
    }

    public void startStartupForm(){
        startupWindow.setVisible(true);
    }

    public void stopStartupForm(){
        startupWindow.setVisible(false);
    }

    public boolean isActive(){
        return startupWindow.isActive();
    }

}
