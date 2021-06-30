package model;

import controller.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    ComboBox<String> productBox = new ComboBox<>();

    Button btnBack = new Button("Back");
    Button kiesbtn = new Button("Voeg toe aan Cart");
    Button veranderbtn = new Button("Verzend Order");
    Button deletebtn = new Button("Delete product");
    Label verzonden = new Label();

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
        pane.getChildren().addAll(welcomeLabel, kiesbtn, veranderbtn,productBox, productenLabel,ListView, tfPid, tfName, tfPrice, tfStock);
        fin(stage);
        pane.setStyle("-fx-background-color:#bedefa");
        tfNumbers(tfPid);
        tfNumbers(tfPrice);
        tfNumbers(tfStock);
    }

    public void makeAppointmentComboBox(){
        productBox.relocate(100, 200);
        fillComboBox(productBox);
    }
    public void fillComboBox(ComboBox combobox){
        for(int i = 0; i< products.productString.size(); i++){
            combobox.getItems().add(products.getProducts().toString());
        }
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
        makeMenuButtons(veranderbtn);
        veranderbtn.setOnMouseClicked(E -> {
            clear();
            verzonden.setText("Uw order is verzonden! Sluit het scherm om een nieuwe order aan te maken.");
            verzonden.relocate(140,550);
            pane.getChildren().add(verzonden);
        });
    }
    public void makeButtons(Stage stage){
        makeBackButton(stage);
        kiesButton(stage);
        veranderButton(stage);
        makeDeleteButton(stage);
    }
    public void makeBackButton(Stage stage){
        btnBack.relocate(11,566);
        buttonSettings.onMouse(btnBack);
        btnBack.setOnAction(E->{
        });
    }
    public void kiesButton(Stage stage){
        makeMenuButtons(kiesbtn);
        kiesbtn.setOnAction(E-> {
            addProduct();
        });
    }
    public void makeDeleteButton(Stage stage){
        makeMenuButtons(deletebtn);
        deletebtn.setOnAction(E-> {

        });
    }
    public void makeListView(){
        makeNewListView();
    }
    public void makeNewListView(){
        ListView.relocate(145, 190);
        ListView.setPrefHeight(200);
        ListView.setPrefWidth(373);
        ListView.setItems(cart.productString2);
    }
    public void makeLabels(){
        makeScreenLabel();
        makeStartLabel();
        makeInputLabels();
    }
    public void makeStartLabel(){
        welcomeLabel.setFont(Font.font("Arial", 30));
        welcomeLabel.relocate(225,100);
    }
    public void makeScreenLabel(){
        productenLabel.setFont(Font.font("Arial", 20));
        productenLabel.relocate(335, 150);
        productenLabel.setStyle("-fx-underline: true");
    }
    public void makeMenuButtons(Button button){
        setButtonPosition(button, buttonNumber);
        setButtonLayout(button);
    }

    public void setButtonLayout(Button button){
        button.setPrefWidth(151);
        button.setPrefHeight(101);
    }
    public void setButtonPosition(Button button, int buttonNumber){
        if(buttonNumber == 0){
            button.relocate(530, 365);
        }
        else if(buttonNumber == 1){
            button.relocate(225, 426);
        }
        else if(buttonNumber == 2){
            button.relocate(225, 451);
        }
        else{
            button.relocate(450, 401);
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
        pane.getChildren().remove(verzonden);
    }

    public void buttonNumber(){
        buttonNumber++;
    }
    public void fin(Stage stage){
        ShopScreen = new Scene(pane,800,600);
        stage.setTitle("Order Applicatie");
        stage.setScene(ShopScreen);
        stage.show();
    }
}