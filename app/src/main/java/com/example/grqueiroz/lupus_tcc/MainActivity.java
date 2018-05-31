package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.grqueiroz.lupus_tcc.manager.NavigationStackManager;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private DbHandler db;
    private User loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbHandler(MainActivity.this);
        loggedUser = db.getLoggedUser();
        if(loggedUser == null){
            navigateToLogin();
            return;
        }

        //disparando evento da home
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle params = new Bundle();
        params.putString("user_id", loggedUser.getShaid());
        params.putString("user_age", loggedUser.getAge());
        mFirebaseAnalytics.logEvent("View_Home", params);

        Bundle bundle = getIntent().getExtras();

        if(bundle == null || bundle.getString("topicId") == null){
            navigateToCloud();
        } else {
            navigate(bundle.getString("topicId"));
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        Menu menu = mNavigationView.getMenu();
        MenuItem logout = menu.findItem(R.id.logout);
        logout.setTitle("Olá, " + loggedUser.getName() + "! - " + logout.getTitle() + "?");
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                switch (menuItem.getItemId()){
                    case(R.id.nuvem_palavras):
                        navigateToCloud();
                        break;
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
                    case(R.id.logout):
                        db.userLogout();
                        navigateToLogin();
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

    }

    public void navigateToCloud(){
        Bundle bundle = new Bundle();
        bundle.putString("loggedUser", loggedUser.getName());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(MainActivity.this, CloudActivity.class);
        startActivity(intent);
        finish();
    }

    public void navigateToLogin(){
        NavigationStackManager.clearStack();
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
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
        else {
            navigateToCloud();
        }
    }
}
