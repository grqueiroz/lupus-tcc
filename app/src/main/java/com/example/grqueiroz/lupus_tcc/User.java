package com.example.grqueiroz.lupus_tcc;

/**
 * Created by Gabriele on 18/03/2018.
 */

public class User {
    //variables
    int id;
    String email;
    // Constructor with just one parameter
    public User(String email)
    {
        this.email=email;
    }
    //Parameter constructor containing id and email
    public User(int id,String email)
    {
        this.id=id;
        this.email=email;
    }
    //getting id
    public int getId() {
        return id;
    }
    //setting id
    public void setId(int id) {
        this.id = id;
    }
    //getting name
    public String getEmail() {
        return email;
    }
    //setting name
    public void setEmail(String name) {
        this.email = email;
    }
}
