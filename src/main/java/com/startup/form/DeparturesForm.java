package com.startup.form;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.awt.*;

import static com.windows.constants.FrameConstants.INFO_WINDOW_WIDTH;
import static com.windows.constants.FrameConstants.INFO_WINDOW_HEIGHT;

public class DeparturesForm extends JPanel {

    public DeparturesForm() {
        setSize(INFO_WINDOW_WIDTH, INFO_WINDOW_HEIGHT);
        setLayout(new MigLayout("insets 5"));
        setBackground(Color.GREEN);
        setVisible(true);
    }
}
