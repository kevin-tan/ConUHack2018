package com.startup.form;

import com.data.DataRepository;
import com.program.Program;
import com.startup.constants.WeekdayId;
import com.utils.DateTimeUtils;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import org.joda.time.DateTime;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.windows.constants.FrameConstants.FORM_WINDOW_HEIGHT;
import static com.windows.constants.FrameConstants.FORM_WINDOW_WIDTH;

class TimeForm extends JPanel {

    private Map<WeekdayId, List<JTextField>> textFieldRepo = new HashMap<>();

    TimeForm() {
        setSize(FORM_WINDOW_WIDTH, FORM_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5").gridGap("35", "15")));
        setBackground(Color.BLACK);
        setVisible(true);

        JButton submitButton = new JButton("Submit");
        submitButton.setForeground(Color.BLUE);
        Program program = new Program();
        submitButton.addActionListener((actionEvent) -> {
            registerTimeData();
            SwingUtilities.getWindowAncestor(this).setVisible(false);
            program.start();
        });

        addTextFields();
        add(submitButton);
    }

    private void addTextFields() {
        for (WeekdayId weekdayId : WeekdayId.values()) {
            JLabel weekdayLabel = new JLabel(weekdayId.getWeekday() + ": ");
            weekdayLabel.setForeground(Color.WHITE);

            ArrayList<JTextField> list = new ArrayList<>();
            int numberOfTimes = DataRepository.getNumberOfTimes(weekdayId);

            switch (numberOfTimes) {
                case 0:
                    break;
                case 1:
                    add(weekdayLabel);
                    addTextField("", list);
                    break;
                default:
                    add(weekdayLabel);
                    addTextField("", list);
                    for (int i = 1; i < numberOfTimes; i++) {
                        addTextField("span 2, align right", list);
                    }
            }

            textFieldRepo.put(weekdayId, list);
        }
    }

    private void registerTimeData() {
        for (WeekdayId weekdayId : WeekdayId.values()) {
            for (int i = 0; i < textFieldRepo.get(weekdayId).size(); i++) {
                DateTime time = getTimeObject(textFieldRepo.get(weekdayId).get(i).getText());
                DataRepository.getDataRepository().get(weekdayId).get(i).setStartTime(time);
            }
        }
    }

    private void addTextField(String constraints, ArrayList<JTextField> list) {
        JTextField jTextField = new JTextField(10);
        add(jTextField, constraints);
        list.add(jTextField);
    }

    //TODO need to parse the input to return a time object
    private DateTime getTimeObject(String timeInput) {
        String[] hoursMinutes = timeInput.split(":", 2);
        int hours = Integer.parseInt(hoursMinutes[0]);
        int minutes = Integer.parseInt(hoursMinutes[1]);

        if (hours > 0 && hours <= 24 && minutes >= 0 && minutes < 60) {
            return new DateTime(DateTimeUtils.dateTime().getYear(), DateTimeUtils.dateTime().getMonthOfYear(),
                    DateTimeUtils.dateTime().getDayOfMonth(), hours, minutes);
        } else {
            return new DateTime(DateTimeUtils.dateTime().getYear(),DateTimeUtils.dateTime().getMonthOfYear(),
                    DateTimeUtils.dateTime().getDayOfMonth(),0,0);
        }
    }

}
