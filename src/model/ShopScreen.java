package model;

import controller.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShopScreen extends Application {
    Scene ShopScreen;
    Products products = new Products();
    Cart cart = new Cart();
    int buttonNumber = 0;
    Pane pane = new Pane();
    GoToScreens goToScreens = GoToScreens.getInstance();
    ButtonSettings buttonSettings = ButtonSettings.getInstance();
    Label welcomeLabel = new Label("Welkom op de Orderpagina");
    Label productenLabel = new Label("Lifefitness producten");
    ListView<String> ListView = new ListView<>();

    Button btnBack = new Button("Back");
    Button kiesbtn = new Button("Voeg toe aan Cart");
    Button veranderbtn = new Button("Ga naar Cart");
    Button deletebtn = new Button("Delete product");

    TextField tfPid = new TextField();
    TextField tfName = new TextField();
    TextField tfPrice = new TextField();
    TextField tfStock = new TextField();


    @Override
    public void start(Stage stage) throws Exception{
        relocateTextFields();
        makeListView();
        makeLabels();
        makeButtons(stage);
        pane.getChildren().addAll(welcomeLabel, kiesbtn, veranderbtn, productenLabel,ListView, tfPid, tfName, tfPrice, tfStock);
        fin(stage);
        pane.setStyle("-fx-background-color:#bedefa");
        tfNumbers(tfPid);
        tfNumbers(tfPrice);
        tfNumbers(tfStock);
    }

    public void relocateTextFields() {
        tfPid.relocate(530, 220);
        tfName.relocate(530, 250);
        tfPrice.relocate(530, 280);
        tfStock.relocate(530, 310);
    }

    public void tfNumbers(TextField textField){
        textField.textProperty().addListener((new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*"))
                {
                textField.setText(s.replaceAll("[^\\d]", ""));
                }
            }
        }));
    }


    public void addProduct() {
        Object productData[] = {tfPid.getText(), tfName.getText(), tfPrice.getText(), tfStock.getText()};
        Product product = new Product(productData);
        cart.addToCart(product);
        cart.printCartItems();
        System.out.println(cart.productString2);
        clear();
    }

    public void veranderButton(Stage stage){
        makeMenuButton(veranderbtn);
        veranderbtn.setOnMouseClicked(E -> {
            goToScreens.goCartScreen(stage);
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
            addProduct();
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
        ListView.relocate(145, 190);
        ListView.setPrefHeight(200);
        ListView.setPrefWidth(373);
        ListView.setItems(cart.productString2);
    }
    public void makeLabels(){
        makeAppointmentLabel();
        makeStartLabel();
        makeInputLabels();
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
            button.relocate(530, 365);
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

    public void makeInputLabels() {
        Label lblpid = new Label("Product ID");
        Label lblname = new Label("Naam");
        Label lblprice = new Label("Prijs");
        Label lblstock = new Label("aantal");
        lblpid.relocate(680, 225);
        lblname.relocate(680, 255);
        lblprice.relocate(680, 285);
        lblstock.relocate(680, 315);
        pane.getChildren().addAll(lblname, lblpid, lblprice, lblstock );
    }

    public void clear(){
        tfName.setText("");
        tfPid.setText("");
        tfPrice.setText("");
        tfStock.setText("");
    }

    public void buttonNumber(){
        buttonNumber++;
    }
    public void fin(Stage stage){
        ShopScreen = new Scene(pane,800,600);
        stage.setTitle("Shop");
        stage.setScene(ShopScreen);
        stage.show();
    }
}