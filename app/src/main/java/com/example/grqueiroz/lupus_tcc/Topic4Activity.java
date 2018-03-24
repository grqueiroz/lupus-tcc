package com.example.grqueiroz.lupus_tcc;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Topic4Activity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic4);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        fragmentManager = getFragmentManager();

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.subtopic1);
        Button button2 = (Button) findViewById(R.id.subtopic2);

        final NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                TextView textView = (TextView) findViewById(R.id.textView);
                Intent intent = new Intent();
                switch (menuItem.getItemId()){
                    case(R.id.o_que_e):
                        intent.setClass(Topic4Activity.this, Topic1Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.o_que_causa):
                        intent.setClass(Topic4Activity.this, Topic2Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_e_diagnosticado):
                        intent.setClass(Topic4Activity.this, Topic3Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_afeta_corpo):
                        break;
                    case(R.id.como_vou_melhorar):
                        intent.setClass(Topic4Activity.this, Topic5Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_sera_dia_a_dia):
                        intent.setClass(Topic4Activity.this, Topic6Activity.class);
                        startActivity(intent);
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

        View fragmentContainer = findViewById(R.id.fragment_container4);
        fragmentContainer.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Topic4Activity.this.onClick(view, R.layout.card_riscos_orgaos);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Topic4Activity.this.onClick(view, R.layout.card_fadiga);
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

    public void onClick(View view, int layout) {
        final View fragmentContainer = findViewById(R.id.fragment_container4);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CardFragment cardFragment = new CardFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("layout", layout);

        cardFragment.setArguments(bundle);

        fragmentTransaction.addToBackStack("card");
        fragmentTransaction.add(R.id.fragment_container4, cardFragment);
        fragmentTransaction.commit();

        View scrollView = findViewById(R.id.topic4_content);
        scrollView.setVisibility(View.GONE);

        fragmentContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
        else super.onBackPressed();
    }
}
