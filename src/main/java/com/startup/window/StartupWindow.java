package com.startup.window;

import com.startup.form.DeparturesForm;
import com.windows.template.Window;

import javax.swing.*;

public class StartupWindow extends Window {

    public StartupWindow(String title, int width, int height) {
        super(title, width, height);
        configure(new DeparturesForm());
    }

    @Override
    protected void configure(JPanel... jPanels) {
        for (JPanel jPanel : jPanels) {
            //TODO StartupWindow has no layout
            add(jPanel);
        }
    }
}
