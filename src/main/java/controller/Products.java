package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class Products {
    private final List<Product> products = new ArrayList<>();
    public ObservableList<String> productString = FXCollections.observableArrayList(products.toString());


    public Products () {
        this.initStoreItems();
    }


    public List<Product> getProducts() {
        return products;
    }

    public void initStoreItems() {
        String [] productNames = {"Hometrainer", "Crosstrainer", "Roeitrainer", "Loopband", "Spinningbike", "Squatrek"};
        Double [] productPrice = {299.00d, 155.00d, 448.00d, 178.00d, 625.00d, 559.00d};
        Integer [] stock = {10, 6, 10, 2, 7, 22};


        for (int i=0; i < productNames.length; i++) {
            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i]));
            productString.add(getProducts().get(i).toString());
        }
    }
}