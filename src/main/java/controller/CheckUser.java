package controller;

public class CheckUser {
    public boolean usercheck = false;
    ArrayKeeper arraykeeper = new ArrayKeeper();
    public boolean dataCheck(String password, String username){
        boolean ret = false;
        int s = 0;
        var x = ArrayKeeper.getData();
        for(int i = 0;i<ArrayKeeper.getData().size();i++){
            if(ArrayKeeper.getData().get(i).getUsername().equals(username)){
                if(ArrayKeeper.getData().get(i).getPassword().equals(password)){
                    ret = true;
                }
            }
        }
        return ret;
    }

    public void users() {
        if (!usercheck) {
            String[] adminData = {"admin", "admin", "admin"};
            arraykeeper.SignUpData(adminData);
            PersonalData admin = new PersonalData(adminData);
            admin.setUserName("admin");
            admin.setPassword("admin");
        }
    }
}
