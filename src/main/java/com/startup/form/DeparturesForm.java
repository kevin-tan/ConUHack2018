package com.startup.form;

import com.startup.constants.WeekdayId;
import com.data.DataRepository;
import com.startup.model.Courses;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.windows.constants.FrameConstants.INFO_WINDOW_WIDTH;
import static com.windows.constants.FrameConstants.INFO_WINDOW_HEIGHT;

public class DeparturesForm extends JPanel {

    private JTextArea[] jTextAreas = new JTextArea[5];


    public DeparturesForm() {
        setSize(INFO_WINDOW_WIDTH, INFO_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5")));
        setBackground(Color.BLACK);
        setVisible(true);

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener((actionEvent) -> registerData());

        addTextboxes();
        add(submitButton);
    }

    private void addTextboxes() {
        int index = 0;
        for (WeekdayId weekdayId : WeekdayId.values()) {
            JLabel weekdayLabel = new JLabel(weekdayId.getWeekday() + ": ");
            weekdayLabel.setForeground(Color.WHITE);
            add(weekdayLabel);
            jTextAreas[index] = new JTextArea(1, 10);
            add(jTextAreas[index]);
            index++;
        }
    }

    private void registerData() {
        int index = 0;
        for (WeekdayId weekdayId : WeekdayId.values()) {
            List<Courses> courses = new ArrayList<>();
            //TODO what about invalid input? (wrong type)
            int numberOfDepartures = Integer.parseInt(jTextAreas[index].getText());
            for (int i = 0; i < numberOfDepartures; i++) {
                courses.add(new Courses());
            }
            DataRepository.getDataRepository().put(weekdayId, courses);
            index++;
        }
    }
}
