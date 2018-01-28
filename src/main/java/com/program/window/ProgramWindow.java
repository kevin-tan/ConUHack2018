package com.program.window;

import com.data.DataRepository;
import com.google.maps.errors.ApiException;
import com.program.window.menu.MenuBar;
import com.program.window.menu.MenuItems;
import com.request.dimension.DimensionMatrixRequest;
import com.windows.template.Window;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProgramWindow extends Window {

    private final JMenuBar jMenuBar;
    private final DimensionMatrixRequest dimensionMatrixRequest;

    public ProgramWindow(String title, int width, int height) {
        super(title, width, height);
        jMenuBar = new JMenuBar();
        dimensionMatrixRequest = new DimensionMatrixRequest(DataRepository.getUser());
        configure();
    }

    @Override
    protected void configure(JPanel... jPanels) {
        //File menu items
        JMenuItem exit = new JMenuItem(MenuItems.EXIT.toString());
        exit.addActionListener(actionListener -> System.exit(0));
        //TODO add functionality
        JMenuItem editCourse = new JMenuItem(MenuItems.EDIT_COURSES.toString());
        jMenuBar.add(createJMenu(MenuBar.FILE, editCourse, exit));

        //Edit menu items
        //TODO add functionality
        JMenuItem editAddress = new JMenuItem(MenuItems.EDIT_ADDRESS.toString());
        jMenuBar.add(createJMenu(MenuBar.EDIT, editAddress));

        add(jMenuBar, BorderLayout.NORTH);

        //Adding Google's Api for DimensionMatrix
        JLabel jLabel = null;
        try {
             jLabel = new JLabel(dimensionMatrixRequest.getTripDuration().humanReadable);
             jLabel.setSize(50,50);
        } catch (InterruptedException | ApiException | IOException e) {
            e.printStackTrace();
        }
        add(jLabel, BorderLayout.CENTER);
    }

    private JMenu createJMenu(MenuBar menuBar, JMenuItem... jMenuItems) {
        JMenu menu = new JMenu(menuBar.toString());
        for (JMenuItem items : jMenuItems)
            menu.add(items);
        return menu;
    }
}
