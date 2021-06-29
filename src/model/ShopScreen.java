package model;

import controller.ArrayKeeper;
import controller.ButtonSettings;
import controller.GoToScreens;
import controller.Products;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShopScreen extends Application {
    Scene ShopScreen;
    Products products = new Products();
    int buttonNumber = 0;
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    Label welcomeLabel = new Label("Welkom op de Orderpagina");
    Label productenLabel = new Label("Mijn producten");
    ListView<String> ListView = new ListView<>();

    Button btnBack = new Button("Back");
    Button kiesbtn = new Button("Kies een product");
    Button veranderbtn = new Button("Verander Product");
    Button deletebtn = new Button("Delete product");

    @Override
    public void start(Stage stage) throws Exception{
        makeListView();
        makeLabels();
        makeButtons(stage);
        pane.getChildren().addAll(welcomeLabel, btnBack, kiesbtn, veranderbtn, productenLabel,ListView);
        fin(stage);
        pane.setStyle("-fx-background-color:#F0F8FF");

    }


    public void veranderButton(Stage stage){
        makeMenuButton(veranderbtn);
        veranderbtn.setOnMouseClicked(E -> {
            goToScreens.goShopScreen(stage);
        });
    }
    public void makeButtons(Stage stage){
        makeBackButton(stage);
        kiesButton(stage);
        veranderButton(stage);
        makeDeleteButton(stage);
    }
    public void makeBackButton(Stage stage){
        btnBack.relocate(10,565);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E->{
        });
    }
    public void kiesButton(Stage stage){
        makeMenuButton(kiesbtn);
        kiesbtn.setOnAction(E-> {
        });
    }
    public void makeDeleteButton(Stage stage){
        makeMenuButton(deletebtn);
        deletebtn.setOnAction(E-> {

        });
    }
    public void makeListView(){
        makeAppointmentListView();
    }
    public void makeAppointmentListView(){
        ListView.relocate(225, 190);
        ListView.setPrefHeight(200);
        ListView.setPrefWidth(373);
        ListView.setItems(products.productString);
    }
    public void makeLabels(){
        makeAppointmentLabel();
        makeStartLabel();
    }
    public void makeStartLabel(){
        welcomeLabel.setFont(Font.font("Arial", 30));
        welcomeLabel.relocate(225,100);
    }
    public void makeAppointmentLabel(){
        productenLabel.setFont(Font.font("Arial", 20));
        productenLabel.relocate(335, 150);
        productenLabel.setStyle("-fx-underline: true");
    }
    public void makeMenuButton(Button button){
        setButtonPosition(button, buttonNumber);
        setButtonLayout(button);
    }

    public void setButtonScaleChange(Button button, Double scale){
        button.setScaleX(scale);
        button.setScaleY(scale);
    }

    public void setButtonLayout(Button button){
        button.setPrefWidth(150);
        button.setPrefHeight(100);
    }

    public void setButtonPosition(Button button, int buttonNumber){
        if(buttonNumber == 0){
            button.relocate(450, 425);
        }
        else if(buttonNumber == 1){
            button.relocate(225, 425);
        }
        else if(buttonNumber == 2){
            button.relocate(225, 450);
        }
        else{
            button.relocate(450, 400);
        }
        buttonNumber();
    }

    public void buttonNumber(){
        buttonNumber++;
    }
    public void fin(Stage stage){
        ShopScreen = new Scene(pane,800,600);
        stage.setTitle("Medical Section");
        stage.setScene(ShopScreen);
        stage.show();
    }
}