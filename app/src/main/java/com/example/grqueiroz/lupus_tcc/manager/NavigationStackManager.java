package com.example.grqueiroz.lupus_tcc.manager;

import android.app.FragmentManager;

import java.util.ArrayList;

/**
 * Created by gabriel-queiroz on 20/03/18.
 */

public class NavigationStackManager {

    private static ArrayList<String> navigationSessionStack = new ArrayList<>();

    public static void stackSession(String originSessionId){
        navigationSessionStack.add(originSessionId);
    }

    public static Boolean isStackEmpty(){
        return navigationSessionStack.isEmpty();
    }

    public static String getPresentSession(){
        try {
            return navigationSessionStack.get(navigationSessionStack.size() - 1);
        } catch (IndexOutOfBoundsException e){
            return "";
        }
    }

    public static String getPreviousSession(){
        try {
            return navigationSessionStack.get(navigationSessionStack.size() - 2);
        } catch (IndexOutOfBoundsException e){
            return "";
        }
    }

    public static void popPresentSession(){
        try {
            navigationSessionStack.remove(navigationSessionStack.size() - 1);
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
