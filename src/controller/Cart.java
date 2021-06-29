package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    public ObservableList<String> productString2 = FXCollections.observableArrayList(cartItems.toString());

    public void addProductToCartByPID(int pid) {
        Product product = getProductByProductID(pid);
        addToCart(product);
    }

    private Product getProductByProductID(int pid) {
        Product product = null;
        List<Product> products = new Products().getProducts();
        for (Product prod: products) {
            if (prod.getPid() == pid) {
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToCart(Product product) {
        cartItems.add(product);
    }

    public void removeProductByPID(int pid) {
        Product prod = getProductByProductID(pid);
        cartItems.remove(prod);
    }

    void printCartItems() {
        for (Product prod: cartItems) {
            System.out.println(prod.getName());
            productString2.add(getProductByProductID(prod.getPid()).toString());
        }
    }

}