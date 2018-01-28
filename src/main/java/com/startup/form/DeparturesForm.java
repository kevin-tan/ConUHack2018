package com.startup.form;

import com.data.DataRepository;
import com.model.Courses;
import com.startup.constants.WeekdayId;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static com.data.DataConstants.NUM_OF_DEPARTURES;
import static com.windows.constants.FrameConstants.FORM_WINDOW_HEIGHT;
import static com.windows.constants.FrameConstants.FORM_WINDOW_WIDTH;

//TODO UI needs big overhaul
class DeparturesForm extends JPanel {

    DeparturesForm(JComboBox[] numOfDepartures) {
        setSize(FORM_WINDOW_WIDTH, FORM_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5").gridGap("35", "15")));
        setBackground(Color.BLACK);
        setVisible(true);

        JLabel label = new JLabel("Enter number of departures for each day of the week");
        label.setForeground(Color.CYAN);
        add(label, "span 2");

        addComboBoxes(numOfDepartures);
    }

    //TODO drop down list is quite large
    private void addComboBoxes(JComboBox[] numOfDepartures) {
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

    void registerData(JComboBox[] numOfDepartures) {
        int index = 0;
        for (WeekdayId weekdayId : WeekdayId.values()) {
            List<Courses> courses = new LinkedList<>();
            int numberOfDepartures = (int) numOfDepartures[index].getSelectedItem();
            for (int i = 0; i < numberOfDepartures; i++) {
                courses.add(new Courses());
            }
            DataRepository.getDataRepository().put(weekdayId, courses);
            index++;
        }
    }
}
