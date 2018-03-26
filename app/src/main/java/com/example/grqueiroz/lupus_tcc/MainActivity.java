package com.example.grqueiroz.lupus_tcc;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

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
                switch (menuItem.getItemId()){
                    case(R.id.o_que_e):
                        navigate("topic1");
                        break;
                    case(R.id.o_que_causa):
                        navigate("topic2");
                        break;
                    case(R.id.como_e_diagnosticado):
                        navigate("topic3");
                        break;
                    case(R.id.como_afeta_corpo):
                        navigate("topic4");
                        break;
                    case(R.id.como_vou_melhorar):
                        navigate("topic5");
                        break;
                    case(R.id.como_sera_dia_a_dia):
                        navigate("topic6");
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

    }

    public void navigate(String topicId) {
        TopicFragment fragment = TopicFragment.newInstance(topicId);
        NavigationStackManager.stackSession(topicId);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private void navigateBack(String topicId){
        TopicFragment fragment = TopicFragment.newInstance(topicId);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        NavigationStackManager.popPresentSession();
        if (!NavigationStackManager.isStackEmpty()) {
            navigateBack(NavigationStackManager.getPresentSession());
        }
        else super.onBackPressed();
    }
}
