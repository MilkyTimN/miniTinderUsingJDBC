package kg.megaco.miniTinder.services.crud;

import kg.megaco.miniTinder.MiniTinderApplication;
import kg.megaco.miniTinder.models.Users;

public class Checking {

//    private Users signedInUser = null;
//
//    public Users getSignedInUser(){
//        return signedInUser;
//    }
//    public void setSignedInUserNull(){
//        signedInUser = null;
//    }


    public Boolean checkForUniqueLogin(Users user) {
        return user.getLogin() == null;
    }
    public Boolean checkForUsersLoginAndPassword(Users user,String login, String password) {
        try {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                MiniTinderApplication.setMainUsers(user);
                return true;
            } else {
                return false;
            }
        }catch (NullPointerException e){
            return false;
        }

    }
}
