package model;

import controller.ArrayKeeper;
import controller.GoToScreens;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreen extends Application {
    Scene homeScene;
    Pane home = new Pane();

    @Override
    public void start(Stage stage) throws Exception {
        fin(stage);
    }

    public void fin(Stage stage) throws IOException {
        homeScene = new Scene(home);
        stage.setTitle("Homescreen");
        stage.setScene(homeScene);
        stage.show();
    }
}
