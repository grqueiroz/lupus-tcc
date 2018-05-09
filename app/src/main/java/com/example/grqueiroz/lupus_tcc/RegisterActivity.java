package com.example.grqueiroz.lupus_tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

class RegisterActivity extends Activity {

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

        name_user=(EditText)findViewById(R.id.name);

        gender_radio_group = (RadioGroup) findViewById(R.id.gender_radio_group);
        int radioButtonID = gender_radio_group.getCheckedRadioButtonId();
       // radioButton = (RadioButton);
        gender_radio_group.findViewById(radioButtonID);
        final String selectedgender = (String) radioButton.getText();

        type_radio_group = (RadioGroup) findViewById(R.id.type_radio_group);
        radioButtonID = type_radio_group.getCheckedRadioButtonId();
        //radioButton2 = (RadioButton);
        type_radio_group.findViewById(radioButtonID);
        final String selectedtype = (String) radioButton2.getText();

        age_user=(EditText)findViewById(R.id.age);


        register=(Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_user.getText().toString();
                int id= checkUser(new User(name, "", "", "",null ));
                if(id==-1)
                {
                    db=new DbHandler(RegisterActivity.this);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    db.addUser(new User(name_user.getText().toString(), selectedgender, selectedtype, age_user.getText().toString(), date));
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Nome já utilizado. Por favor escolha outro.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        db=new DbHandler(RegisterActivity.this);
//inserting our users
        db.addUser(new User("Gabriele", "", "", "", null));
        db.addUser(new User("Gabriel", "", "", "", null));
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
