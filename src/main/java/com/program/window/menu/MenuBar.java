package com.program.window.menu;

public enum MenuBar {
    FILE("File"),
    EDIT("Edit");

    private String menubar;
    MenuBar(String menubar){
        this.menubar = menubar;
    }

    @Override
    public String toString(){
        return menubar;
    }
}
