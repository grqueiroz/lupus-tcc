package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Topic1Activity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic1);

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
                switch (menuItem.getItemId()){
                    case(R.id.o_que_e):
                        break;
                    case(R.id.o_que_causa):
                        textView.setText(R.string.o_que_causa_lupus);
                        break;
                    case(R.id.como_e_diagnosticado):
                        textView.setText(R.string.como_e_diagnosticado);
                        break;
                    case(R.id.como_afeta_corpo):
                        textView.setText(R.string.como_afeta_corpo);
                        break;
                    case(R.id.como_vou_melhorar):
                        textView.setText(R.string.como_vou_melhorar);
                        break;
                    case(R.id.como_sera_dia_a_dia):
                        textView.setText(R.string.como_sera_dia_a_dia);
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
