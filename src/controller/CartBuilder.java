package controller;

import java.util.List;

public abstract class CartBuilder {

    public abstract void addProductToCartByPID(int pid);
    public abstract List<Product> getProduct();
    public abstract void addToCart(Product product);
    public abstract void removeProduct(int pid);


}
