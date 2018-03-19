package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                TextView textView = (TextView) findViewById(R.id.textView);
                Intent intent = new Intent();
                switch (menuItem.getItemId()){
                    case(R.id.o_que_e):
                        intent.setClass(MainActivity.this, Topic1Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.o_que_causa):
                        intent.setClass(MainActivity.this, Topic2Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_e_diagnosticado):
                        intent.setClass(MainActivity.this, Topic3Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_afeta_corpo):
                        intent.setClass(MainActivity.this, Topic4Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_vou_melhorar):
                        intent.setClass(MainActivity.this, Topic5Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_sera_dia_a_dia):
                        intent.setClass(MainActivity.this, Topic6Activity.class);
                        startActivity(intent);
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Login.class);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
