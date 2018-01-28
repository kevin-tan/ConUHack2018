package com.utils;

import javax.swing.*;

public class JLabelFactory {
    public static JLabel createJLabel(String label){
        JLabel jLabel = new JLabel(label);
        jLabel.setSize(10,10);
        return jLabel;
    }
}
