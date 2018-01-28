package com.windows.template;


import javax.swing.*;

public abstract class Window extends JFrame {

    private int width;
    private int height;

    public Window(String title, int width, int height) {
        super(title);
        this.width = width;
        this.height = height;
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected abstract void configure(JPanel... jPanels);

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
