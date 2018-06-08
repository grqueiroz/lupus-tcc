package com.example.grqueiroz.lupus_tcc;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gabriele on 18/03/2018.
 */

public class User {
    //variables
    private String name, type, gender, shaString,  shaid, age;

    public User(){
        super();
    };

    //Parameter constructor containing id and email
    public User(String name, String gender, String type, String age, Date date)
    {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(date);
        shaString = (((name.concat(gender)).concat(type)).concat(age)).concat(formattedDate);
        try {
            this.shaid = StringEncryption.SHA1(shaString);
        } catch (Exception e){e.printStackTrace();}
        this.gender = gender;
        this.age = age;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getShaString() {
        return shaString;
    }

    public void setShaString(String shaString) {
        this.shaString = shaString;
    }

    public String getShaid() {
        return shaid;
    }

    public void setShaid(String shaid) {
        this.shaid = shaid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeGroup() {
        Integer ageInt = Integer.parseInt(age);

        if (ageInt <= 11) {
            return "0-11";
        }
        if (ageInt <= 17) {
            return "12-17";
        }
        if (ageInt <= 24) {
            return "18-24";
        }
        if (ageInt <= 29) {
            return "25-39";
        }
        if (ageInt <= 59) {
            return "40-59";
        }
        return "60+";
    }
}
