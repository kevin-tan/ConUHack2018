package com;


import com.data.DataConstants;
import com.program.Program;
import com.startup.StartupForm;

import java.io.File;

public class Main {



    public static void main(String[] args) {
        StartupForm startupForm = new StartupForm();
        File file = new File(DataConstants.FILE_DATA);
//        if(!file.exists()){
//            startupForm.startStartupForm();
//        }
        Program program = new Program();
        program.start();
    }
}
