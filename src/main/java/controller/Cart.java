package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Cart extends CartBuilder {

    public List<Product> cartItems = new ArrayList<>();
    public ObservableList<String> productString2 = FXCollections.observableArrayList(cartItems.toString());

    public void addProductToCartByPID(int pid) {
        Product product = getProductByProductID(pid);
        addToCart(product);
    }
    public List<Product> getProduct() {
        return cartItems;
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

    public void addToCart(Product product) {
        cartItems.add(product);
        productString2.add(product.toString());
    }

    public void removeProduct(int pid) {
        Product prod = getProductByProductID(pid);
        cartItems.remove(prod);
    }

}