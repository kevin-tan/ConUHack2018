package com.utils;

public class StringUtils {
    public static String appendStrings(String...strings){
        StringBuilder stringBuilder = new StringBuilder();
        for(String string : strings)
            stringBuilder.append(string + " ");
        return stringBuilder.toString();
    }
}
