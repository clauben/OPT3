package controller;

import javafx.stage.Stage;
import model.HomeScreen;
import model.Main;
import model.ShopScreen;

public class GoToScreens {
    private static GoToScreens instance;
    private GoToScreens(){
    }
    public static GoToScreens getInstance() {
        if(instance == null){
            instance = new GoToScreens();
        }
        return instance;
    }

    public void goShopScreen(Stage stage){
        ShopScreen shopscreen = new ShopScreen();
        try {
            shopscreen.start(stage);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
