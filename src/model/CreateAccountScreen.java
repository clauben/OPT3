package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountScreen extends Application {
    Scene createAccountScreen;

    @Override
    public void start(Stage stage) throws Exception {
        fin(stage);
    }

    public void fin(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
        createAccountScreen = new Scene(root);
        stage.setTitle("Create Account");
        stage.setScene(createAccountScreen);
        stage.show();
    }
}
