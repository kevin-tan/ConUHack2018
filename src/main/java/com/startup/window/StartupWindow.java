package com.startup.window;

import com.startup.form.DeparturesForm;
import com.startup.form.TimeForm;
import com.windows.template.Window;

import javax.swing.*;
import java.awt.*;

public class StartupWindow extends Window {


    public StartupWindow(String title, int width, int height) {
        super(title, width, height);
        configure(new DeparturesForm(), new TimeForm());
    }

    @Override
    protected void configure(JPanel... jPanels) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(new Dimension(getWidth(), getHeight()));
        for (JPanel jPanel : jPanels) {
            //TODO StartupWindow has no layout
            layeredPane.add(jPanel);
        }
        add(layeredPane);
    }
}
