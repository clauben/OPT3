package controller;

import java.util.ArrayList;

public class ArrayKeeper {
    private static ArrayList<PersonalData> Data = new ArrayList<>();
    private static int currentUser;

    public void SignUpData(String[] data){
        PersonalData personalData = new PersonalData(data);
        Data.add(personalData);
        currentUser++;
    }

    public void setCurrentUser(int currentUser){
        ArrayKeeper.currentUser = currentUser;
    }

    public static int getCurrentUser() {
        return currentUser;
    }

    public static ArrayList<PersonalData> getData(){
        return Data;
    }

    public static PersonalData getPersonalData(int user) {
        return Data.get(user);
    }
}
