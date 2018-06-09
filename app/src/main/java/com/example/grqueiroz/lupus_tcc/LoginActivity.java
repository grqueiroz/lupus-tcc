package com.example.grqueiroz.lupus_tcc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Arrays;
import java.util.Collections;

public class LoginActivity extends AppCompatActivity {
    private String selected_user;
    private DbHandler db;
    private FirebaseAnalytics mFirebaseAnalytics;
    private Boolean confirmRemoval = false;
    private Button remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login);
        Button signin = findViewById(R.id.signin);
        remove = findViewById(R.id.remove);

        LinearLayout loginContainer = findViewById(R.id.login_container);

        Spinner spinner = findViewById(R.id.spinner_users);

        db = new DbHandler(LoginActivity.this);

        String[] spinnerLists = db.getAllUsers();

        if (spinnerLists == null || spinnerLists.length == 0) {
            loginContainer.setVisibility(View.GONE);
        }

        Arrays.sort(spinnerLists);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(LoginActivity.this,android.R.layout.simple_spinner_item, spinnerLists);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_user = parent.getItemAtPosition(position).toString();

                if (confirmRemoval) {
                    remove.setText(R.string.hint_remove);
                    confirmRemoval = false;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected_user == null) {
                    Toast.makeText(LoginActivity.this,"Nenhum usuário selecionado.",Toast.LENGTH_SHORT).show();
                } else {
                    User user = db.getUserByName(selected_user);
                    db.userLogin(user);

                    mFirebaseAnalytics.setUserId(user.getShaid());
                    mFirebaseAnalytics.setUserProperty("idade", user.getAgeGroup());
                    mFirebaseAnalytics.setUserProperty("gênero", user.getGender());
                    mFirebaseAnalytics.setUserProperty("tipo", user.getType());

                    Toast.makeText(LoginActivity.this,"Bem vindo(a), " + selected_user + "!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    db.close();
                    finish();
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!confirmRemoval) {
                    remove.setText(R.string.hint_confirmRemoval);
                    confirmRemoval = true;

                    Toast.makeText(LoginActivity.this,"Toque novamente para remover " + selected_user,Toast.LENGTH_SHORT).show();
                } else {
                    db.removeUser(selected_user);

                    remove.setText(R.string.hint_remove);
                    confirmRemoval = false;

                    db.close();
                    Toast.makeText(LoginActivity.this, selected_user + " removido(a) com sucesso",Toast.LENGTH_SHORT).show();

                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
                db.close();
                finish();
            }
        });
    }

}
