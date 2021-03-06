package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AccountController {
    AnchorPane pane;
    Label ErrorMessage = new Label();
    Label gelukt = new Label();
    ArrayKeeper arraykeeper = new ArrayKeeper();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button submitbutton;

    @FXML
    private Button backbutton;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordtTF;

    @FXML
    private PasswordField passwordConfigTF;

    @FXML
    void back(ActionEvent event) throws IOException {
        pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/LoginScreen.fxml")));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    void submit(ActionEvent event) {
        String[] data = {usernameTF.getText(),nameTF.getText(),passwordtTF.getText()};
        signUp(data, passwordConfigTF.getText());

    }

    public void signUp(String[] signUpData, String passwordconfigtf){
        if((!(signUpData[2].equals("")))&&(!(signUpData[0].equals("")))) {
            if (signUpData[2].equals(passwordconfigtf)) {
                arraykeeper.SignUpData(signUpData);
                clear();
                gelukt.setText("Uw account is aangemaakt!");
                gelukt.relocate(100,350);
                rootPane.getChildren().add(gelukt);
            }
        }else {
            clear();
            ErrorMessage.setText("Velden zijn leeg!");
            ErrorMessage.relocate(100,350);
            rootPane.getChildren().add(ErrorMessage);
        }
    }

    public void clear(){
        rootPane.getChildren().remove(ErrorMessage);
        rootPane.getChildren().remove(gelukt);
    }

}