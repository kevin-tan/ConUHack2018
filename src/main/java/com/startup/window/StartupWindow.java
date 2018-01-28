package com.startup.window;

import com.program.Program;
import com.startup.form.InitialForm;
import com.windows.template.Window;

import javax.swing.*;

public class StartupWindow extends Window {


    public StartupWindow(String title, int width, int height) {
        super(title, width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        configure(new InitialForm(new Program()));
    }

    @Override
    protected void configure(JPanel... jPanels) {
        //TODO StartupWindow has no layout
        for (JPanel jPanel : jPanels) {
            add(jPanel);
        }
    }
}
