package com.example.grqueiroz.lupus_tcc;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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

        Button button = (Button) findViewById(R.id.subtopic1);

        final NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                Intent intent = new Intent();
                switch (menuItem.getItemId()){
                    case(R.id.o_que_e):
                        break;
                    case(R.id.o_que_causa):
                        intent.setClass(Topic1Activity.this, Topic2Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_e_diagnosticado):
                        intent.setClass(Topic1Activity.this, Topic3Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_afeta_corpo):
                        intent.setClass(Topic1Activity.this, Topic4Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_vou_melhorar):
                        intent.setClass(Topic1Activity.this, Topic5Activity.class);
                        startActivity(intent);
                        break;
                    case(R.id.como_sera_dia_a_dia):
                        intent.setClass(Topic1Activity.this, Topic6Activity.class);
                        startActivity(intent);
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

        LinearLayout fragmentContainer = (LinearLayout) findViewById(R.id.fragment_container);
        fragmentContainer.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View fragmentContainer = findViewById(R.id.fragment_container);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CardFragment cardFragment = new CardFragment();

                Bundle bundle = new Bundle();
                bundle.putInt("layout", R.layout.card_riscos_orgaos);

                cardFragment.setArguments(bundle);

                fragmentTransaction.add(R.id.fragment_container, cardFragment);
                fragmentTransaction.commit();

                View scrollView = findViewById(R.id.topic1_content);
                scrollView.setVisibility(View.GONE);

                fragmentContainer.setVisibility(View.VISIBLE);

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
