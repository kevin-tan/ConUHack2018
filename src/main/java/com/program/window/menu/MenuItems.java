package com.program.window.menu;

public enum MenuItems {
    EDIT_COURSES("Edit courses"),
    EDIT_ADDRESS("Edit address"),
    EXIT("Exit");

    private String item;
    MenuItems(String item){
        this.item = item;
    }

    @Override
    public String toString(){
        return item;
    }
}
