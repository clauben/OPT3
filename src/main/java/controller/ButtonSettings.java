package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonSettings {
    private static ButtonSettings instance;
    private ButtonSettings(){
    }
    public static ButtonSettings getInstance(){
        if(instance==null) {
            instance=new ButtonSettings();
        }
        return instance;
    }
    public static void onMouse(Button button) {
        button.setOnMouseEntered(mouseEvent -> {
            button.setScaleX(1.2);
            button.setScaleY(1.2);

        });
        button.setOnMouseExited(mouseEvent -> {
            button.setScaleX(1);
            button.setScaleY(1);

        });
    }
    public static void setButtonLayout(Button button){
        button.setPrefHeight(100);
        button.setPrefWidth(100);
    }
}

