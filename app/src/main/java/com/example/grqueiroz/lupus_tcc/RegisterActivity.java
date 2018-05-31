package com.example.grqueiroz.lupus_tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gabriele on 31/03/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText name_user;
    RadioGroup gender_radio_group;
    RadioGroup type_radio_group;
    EditText age_user;
    Button register;
    DbHandler db;
    RadioButton radioButton2, radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name_user = findViewById(R.id.name);

        gender_radio_group = findViewById(R.id.gender_radio_group);
        int radioButtonID = gender_radio_group.getCheckedRadioButtonId();
        radioButton = gender_radio_group.findViewById(radioButtonID);
        final String selectedgender = (String) radioButton.getText();

        type_radio_group = findViewById(R.id.type_radio_group);
        radioButtonID = type_radio_group.getCheckedRadioButtonId();
        radioButton2 = type_radio_group.findViewById(radioButtonID);
        final String selectedtype = (String) radioButton2.getText();

        age_user = findViewById(R.id.age);


        register = findViewById(R.id.register);

        db=new DbHandler(RegisterActivity.this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_user.getText().toString();
                int id = checkUser(name);
                if(id==-1) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    User user = new User(name_user.getText().toString(), selectedgender, selectedtype, age_user.getText().toString(), date);
                    db.addUser(user);
                    db.userLogin(user);
                    Toast.makeText(RegisterActivity.this,"Bem-vindo(a), " + user.getName() + "!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(RegisterActivity.this,"Nome já utilizado. Por favor escolha outro.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public int checkUser(String name) {
        return db.checkUser(name);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
