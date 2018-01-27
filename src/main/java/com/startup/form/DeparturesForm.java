package com.startup.form;

import com.startup.constants.WeekdayId;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.windows.constants.FrameConstants.INFO_WINDOW_WIDTH;
import static com.windows.constants.FrameConstants.INFO_WINDOW_HEIGHT;

public class DeparturesForm extends JPanel {

    private JButton submitButton;


    public DeparturesForm() {
        setSize(INFO_WINDOW_WIDTH, INFO_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5")));
        setBackground(Color.BLACK);
        setVisible(true);

        submitButton = new JButton("Submit");

        submitButton.addActionListener((actionEvent) -> System.out.println("button pressed"));

        addTextboxes();
        add(submitButton);
    }

    private void addTextboxes() {
        for (WeekdayId weekdayId : WeekdayId.values()) {
            JLabel weekdayLabel = new JLabel(weekdayId.getWeekday() + ": ");
            weekdayLabel.setForeground(Color.WHITE);
            add(weekdayLabel);
            JTextArea jTextArea = new JTextArea(1, 10);
            add(jTextArea);
        }
    }

    private void registerData() {

    }
}
