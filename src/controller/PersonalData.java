package controller;

public class PersonalData {
    private String username, name, password;

    public PersonalData(){
        ArrayKeeper.getData().add(this);
    }

    public PersonalData(String[] data){
        this.username = data[0];
        this.name = data[1];
        this.password = data[2];
        ArrayKeeper.getData().add(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
