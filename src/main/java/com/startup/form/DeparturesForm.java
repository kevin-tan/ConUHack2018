package com.startup.form;

import com.startup.constants.WeekdayId;
import com.startup.data.DataRepository;
import com.startup.model.Courses;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.startup.data.DataConstants.NUM_OF_DEPARTURES;
import static com.windows.constants.FrameConstants.INFO_WINDOW_HEIGHT;
import static com.windows.constants.FrameConstants.INFO_WINDOW_WIDTH;

public class DeparturesForm extends JPanel {

    private JComboBox[] numOfDepartures = new JComboBox[5];

    public DeparturesForm() {
        setSize(INFO_WINDOW_WIDTH, INFO_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5")));
        setBackground(Color.BLACK);
        setVisible(true);

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener((actionEvent) -> registerData());

        addComboBoxes();
        add(submitButton);
    }

    private void addComboBoxes() {
        int index = 0;
        for (WeekdayId weekdayId : WeekdayId.values()) {
            JLabel weekdayLabel = new JLabel(weekdayId.getWeekday() + ": ");
            weekdayLabel.setForeground(Color.WHITE);
            add(weekdayLabel);
            numOfDepartures[index] = new JComboBox<>(NUM_OF_DEPARTURES);
            add(numOfDepartures[index]);
            index++;
        }
    }

    private void registerData() {
        int index = 0;
        for (WeekdayId weekdayId : WeekdayId.values()) {
            List<Courses> courses = new ArrayList<>();
            int numberOfDepartures = (int) numOfDepartures[index].getSelectedItem();
            for (int i = 0; i < numberOfDepartures; i++) {
                courses.add(new Courses());
            }
            DataRepository.getDataRepository().put(weekdayId, courses);
            index++;
        }
    }
}
