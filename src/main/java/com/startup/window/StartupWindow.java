package com.startup.window;

import com.startup.form.InitialForm;
import com.windows.template.Window;

import javax.swing.*;

public class StartupWindow extends Window {


    public StartupWindow(String title, int width, int height) {
        super(title, width, height);
        configure(new InitialForm());
    }

    @Override
    protected void configure(JPanel... jPanels) {
        //TODO StartupWindow has no layout
        for (JPanel jPanel : jPanels) {
            add(jPanel);
        }
    }
}
