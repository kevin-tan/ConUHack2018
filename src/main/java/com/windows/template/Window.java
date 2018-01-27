package com.windows.template;


import javax.swing.*;

public abstract class Window extends JFrame{

    public Window(String title, int length, int width){
        super(title);
        setSize(length,width);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected abstract void configure(JPanel... jPanels);
}
