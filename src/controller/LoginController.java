package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    Label error = new Label();
    CheckUser checkUser = new CheckUser();
    AnchorPane pane;


    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField usernameTF;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button registerbutton;

    @FXML
    void register(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(getClass().getResource("/view/CreateAccount.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void login(ActionEvent event) throws IOException {

        if(checkUser.dataCheck(usernameTF.getText(), passwordTF.getText())) {
            pane = FXMLLoader.load(getClass().getResource("/view/HomeScreen.fxml"));
            rootPane.getChildren().setAll(pane);
        } else {
            clear();
            error.setText("Sorry, try again");
            error.relocate(100,350);
            rootPane.getChildren().add(error);
        }
    }

    public void clear(){
        rootPane.getChildren().remove(error);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
