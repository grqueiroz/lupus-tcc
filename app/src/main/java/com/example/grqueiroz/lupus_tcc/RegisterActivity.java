package com.example.grqueiroz.lupus_tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gabriele on 31/03/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText name_user;
    private RadioGroup gender_radio_group;
    private RadioGroup type_radio_group;
    private EditText age_user;
    private DbHandler db;
    private String selectedGender, selectedType;
    private RadioButton radioButton2, radioButton;
    private TextView terms;
    private LinearLayout formsContent;
    private LinearLayout agreementContent;
    private Boolean showingTerms = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name_user = findViewById(R.id.name);
        gender_radio_group = findViewById(R.id.gender_radio_group);
        type_radio_group = findViewById(R.id.type_radio_group);
        age_user = findViewById(R.id.age);

        Button register = findViewById(R.id.register);

        db = new DbHandler(RegisterActivity.this);

        terms = findViewById(R.id.terms);
        formsContent = findViewById(R.id.register_form);
        agreementContent = findViewById(R.id.agreement_content);

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showingTerms = true;
                agreementContent.setVisibility(View.VISIBLE);
                formsContent.setVisibility(View.GONE);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox agreement = findViewById(R.id.checkbox_agreement);

                if (!agreement.isChecked()){
                    Toast.makeText(RegisterActivity.this,"Por favor, leia e aceite os termos e condições antes de continuar",Toast.LENGTH_SHORT).show();
                    return;
                }

                int radioButtonID = gender_radio_group.getCheckedRadioButtonId();
                radioButton = gender_radio_group.findViewById(radioButtonID);
                selectedGender = (String) radioButton.getText();

                radioButtonID = type_radio_group.getCheckedRadioButtonId();
                radioButton2 = type_radio_group.findViewById(radioButtonID);
                selectedType = (String) radioButton2.getText();

                String name = name_user.getText().toString();
                String age = age_user.getText().toString();

                if (areParametersValid(name, age)){
                    registerUser();
                }
            }
        });
    }

    private void registerUser() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        User user = new User(name_user.getText().toString(), selectedGender, selectedType, age_user.getText().toString(), date);
        db.addUser(user);
        db.userLogin(user);
        db.close();
        Toast.makeText(RegisterActivity.this,"Bem-vindo(a), " + user.getName() + "!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public int checkUser(String name) {
        return db.checkUser(name);
    }

    @Override
    public void onBackPressed() {
        if (showingTerms) {
            showingTerms = false;
            agreementContent.setVisibility(View.GONE);
            formsContent.setVisibility(View.VISIBLE);
        } else {
            Intent intent = new Intent();
            intent.setClass(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            db.close();
            finish();
        }
    }

    public Boolean areParametersValid(String name, String age){
        return isValidName(name) && isValidAge(age);
    }

    public Boolean isValidAge(String age){
        if (!TextUtils.isEmpty(age.trim())) {
            return true;
        }

        Toast.makeText(RegisterActivity.this,"Por favor, digite uma idade válida.",Toast.LENGTH_SHORT).show();
        return false;
    }

    public Boolean isValidName(String name){
        if (!TextUtils.isEmpty(name.trim())) {
            return isUniqueName(name);
        }

        Toast.makeText(RegisterActivity.this,"Por favor, digite um nome válido.",Toast.LENGTH_SHORT).show();
        return false;
    }

    public Boolean isUniqueName(String name){
        int id = checkUser(name);
        if (id == -1){
            return true;
        }
        Toast.makeText(RegisterActivity.this,"Nome já utilizado. Por favor escolha outro.",Toast.LENGTH_SHORT).show();
        return false;
    }
}
