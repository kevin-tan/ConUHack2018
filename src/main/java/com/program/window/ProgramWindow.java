package com.program.window;

import com.program.window.menu.MenuBar;
import com.program.window.menu.MenuItems;
import com.windows.template.Window;

import javax.swing.*;
import java.awt.*;

public class ProgramWindow extends Window {

    private final JMenuBar jMenuBar;

    public ProgramWindow(String title, int width, int height) {
        super(title, width, height);
        jMenuBar = new JMenuBar();
        configure();
    }

    @Override
    protected void configure(JPanel... jPanels) {
        //File menu items
        JMenuItem exit = new JMenuItem(MenuItems.EXIT.toString());
        exit.addActionListener(acitionListener -> System.exit(0));
        //TODO add functionality
        JMenuItem editCourse = new JMenuItem(MenuItems.EDIT_COURSES.toString());
        jMenuBar.add(createJMenu(MenuBar.FILE, editCourse, exit));

        //Edit menu items
        //TODO add functionality
        JMenuItem editAddress = new JMenuItem(MenuItems.EDIT_ADDRESS.toString());
        jMenuBar.add(createJMenu(MenuBar.EDIT, editAddress));
        add(jMenuBar, BorderLayout.NORTH);
    }

    private JMenu createJMenu(MenuBar menuBar, JMenuItem... jMenuItems) {
        JMenu menu = new JMenu(menuBar.toString());
        for (JMenuItem items : jMenuItems)
            menu.add(items);
        return menu;
    }
}
