package com.startup.window;

import com.windows.template.Window;

import javax.swing.*;

public class StartupWindow extends Window{

    public StartupWindow(String title, int length, int width) {
        super(title, length, width);
        configure();
    }

    @Override
    protected void configure(JPanel...jPanels) {

    }
}
