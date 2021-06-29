package model;

import controller.GoToScreens;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Scene loginScene;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        fin(window);
    }

    public void fin(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        loginScene = new Scene(root);
        stage.setTitle("Loginscreen");
        stage.setScene(loginScene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
