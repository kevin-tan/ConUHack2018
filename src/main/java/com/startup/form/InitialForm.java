package com.startup.form;

import javax.swing.*;
import java.awt.*;

import static com.windows.constants.FrameConstants.FORM_WINDOW_HEIGHT;
import static com.windows.constants.FrameConstants.FORM_WINDOW_WIDTH;

public class InitialForm extends JPanel {

    private JComboBox[] numOfDepartures = new JComboBox[7];

    public InitialForm() {
        setSize(FORM_WINDOW_WIDTH, FORM_WINDOW_HEIGHT);
        setLayout(null);
        setOpaque(false);
        setVisible(true);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(new Dimension(getWidth(), getHeight()));

        DeparturesForm departuresForm = new DeparturesForm(numOfDepartures);
        JButton submitButton = new JButton("Submit");
        submitButton.setForeground(Color.BLUE);

        submitButton.addActionListener((actionEvent) -> {
            departuresForm.registerData(numOfDepartures);
            departuresForm.setVisible(false);
            layeredPane.add(new TimeForm());
        });

        departuresForm.add(submitButton);

        layeredPane.add(departuresForm);
        add(layeredPane);
    }

}
