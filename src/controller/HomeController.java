package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    Stage window;
    GoToScreens goToScreens = GoToScreens.getInstance();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button backButton;

    @FXML
    void back(ActionEvent event) {
        backButton.setOnAction(E->{
            Stage stage = new Stage();
            goToScreens.goShopScreen(stage);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
