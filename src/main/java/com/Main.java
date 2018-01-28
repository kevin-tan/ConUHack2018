package com;


import com.data.DataConstants;
import com.startup.StartupForm;

import java.io.File;

public class Main {



    public static void main(String[] args) {
        StartupForm startupForm = new StartupForm();
        startupForm.startStartupForm();
        File file = new File(DataConstants.FILE_DATA);
//        if(!file.exists()){
//            startupForm.startStartupForm();
//        }

    }
}
