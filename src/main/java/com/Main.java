package com;


import com.alee.laf.WebLookAndFeel;
import com.data.DataConstants;
import com.startup.StartupForm;

import javax.swing.*;
import java.io.File;

public class Main {


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        StartupForm startupForm = new StartupForm();
        startupForm.startStartupForm();
        File file = new File(DataConstants.FILE_DATA);
//        if(!file.exists()){
//            startupForm.startStartupForm();
//        }

    }
}
