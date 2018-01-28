package com.startup.form;

import com.data.DataRepository;
import com.model.Courses;
import com.startup.constants.WeekdayId;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.data.DataConstants.NUM_OF_DEPARTURES;
import static com.windows.constants.FrameConstants.FORM_WINDOW_HEIGHT;
import static com.windows.constants.FrameConstants.FORM_WINDOW_WIDTH;

//TODO UI needs big overhaul
public class DeparturesForm extends JPanel {

    private JComboBox[] numOfDepartures = new JComboBox[5];

    public DeparturesForm() {
        setSize(FORM_WINDOW_WIDTH, FORM_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5").gridGap("35", "15")));
        setBackground(Color.BLACK);
        setVisible(true);

        JButton submitButton = new JButton("Submit");
        submitButton.setForeground(Color.BLUE);

        submitButton.addActionListener((actionEvent) -> {
            registerData();
            setVisible(false);
        });

        JLabel label = new JLabel("Enter number of departures for each day of the week");
        label.setForeground(Color.CYAN);
        add(label, "span 2");

        addComboBoxes();
        //add(submitButton, "gapleft 30, span 2");
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
