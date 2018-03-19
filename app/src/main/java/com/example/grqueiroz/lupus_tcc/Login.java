package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    EditText email_user;
    Button login;
    Button signin;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_user=(EditText)findViewById(R.id.email);
        login=(Button)findViewById(R.id.login);
        signin=(Button)findViewById(R.id.signin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =email_user.getText().toString();
                int id= checkUser(new User(email));
                if(id==-1)
                {
                    Toast.makeText(Login.this,"Usuário inexistente.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this,"Bem vindo(a)!",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setClass(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email_user.getText().toString();
                int id= checkUser(new User(email));
                if(id==-1)
                {
                    db=new DbHandler(Login.this);
                    db.addUser(new User(email));
                }
                else
                {
                    Toast.makeText(Login.this,"Usuário já cadastrado. Faça login",Toast.LENGTH_SHORT).show();
                }
            }
        });
        db=new DbHandler(Login.this);
//inserting our users
        db.addUser(new User("gabi.andrade.fernandes@gmail.com"));
        db.addUser(new User("grqueiroz3@gmail.com"));
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
