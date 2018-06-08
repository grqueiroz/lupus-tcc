package com.example.grqueiroz.lupus_tcc.manager;

import com.example.grqueiroz.lupus_tcc.User;

public class UserManager {

    private static User loggedUser;

    public static void setLoggedUser(User loggedUser){
        UserManager.loggedUser = loggedUser;
    }

    public static User getLoggedUser() {
        return UserManager.loggedUser;
    }

    public static void userLogout(){
        UserManager.loggedUser = null;
    }
}
