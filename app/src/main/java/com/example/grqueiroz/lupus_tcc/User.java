package com.example.grqueiroz.lupus_tcc;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created by Gabriele on 18/03/2018.
 */

public class User {
    //variables
    String name, user_type, gender, aux,  shaid, age;

    //Parameter constructor containing id and email
    public User(String name, String gender, String user_type, String age, Date date)
    {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date);
        aux = (((name.concat(gender)).concat(user_type)).concat(age)).concat(s);
        try{ this.shaid = StringEncryption.SHA1(aux);
        }
            catch (Exception e){e.printStackTrace();}
        this.gender=gender;
        this.age=age;
        this.user_type=user_type;
        this.name=name;
    }
    //getting id
    public String getShaid() {
        return shaid;
    }
    //setting id
    public void setShaid(String id) {
        this.shaid = id;
    }
    //getters
    public String getName() {
        return name;
    }
    public String getType() {
        return user_type;
    }
    public String getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    //setting name
    public void setName(String name) {
        this.name = name;
    }
}
