package com.startup.form;

import com.startup.constants.WeekdayId;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static com.windows.constants.FrameConstants.FORM_WINDOW_HEIGHT;
import static com.windows.constants.FrameConstants.FORM_WINDOW_WIDTH;

public class TimeForm extends JPanel {

    public TimeForm() {
        setSize(FORM_WINDOW_WIDTH, FORM_WINDOW_HEIGHT);
        setLayout(new MigLayout(new LC().wrapAfter(2).insets("5").gridGap("35", "15")));
        setBackground(Color.BLACK);
        setVisible(true);

        addTextboxes();
    }

    private void addTextboxes() {
        for (WeekdayId weekdayId : WeekdayId.values()) {
            JLabel weekdayLabel = new JLabel(weekdayId.getWeekday() + ": ");
            weekdayLabel.setForeground(Color.WHITE);
            add(weekdayLabel);
        }
    }

}
