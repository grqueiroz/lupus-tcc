package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.grqueiroz.lupus_tcc.entity.Session;
import com.example.grqueiroz.lupus_tcc.entity.TitleContent;
import com.example.grqueiroz.lupus_tcc.manager.NavigationStackManager;
import com.example.grqueiroz.lupus_tcc.manager.UserManager;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private DbHandler db;
    private User loggedUser;
    private FirebaseAnalytics mFirebaseAnalytics;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        initAnalytics();
        sendAnalyticsScreenView();

        setContentView(R.layout.activity_main);

        db = new DbHandler(MainActivity.this);

        if (UserManager.getLoggedUser() == null){
            UserManager.setLoggedUser(db.getLoggedUser());
        }

        loggedUser = UserManager.getLoggedUser();
        db.close();

        if(loggedUser == null){
            navigateToLogin();
            return;
        }

        setFirebaseUserProperties();

        Bundle bundle = getIntent().getExtras();

        if(bundle == null || bundle.getString("topicId") == null){
            navigateToCloud();
        } else {
            if (!"video".equals(NavigationStackManager.getPresentSession())) {
                navigate(bundle.getString("topicId"));
            }
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView mNavigationView = findViewById(R.id.nav_menu);
        Menu menu = mNavigationView.getMenu();
        MenuItem logout = menu.findItem(R.id.logout);

        String firstName = loggedUser.getName().split(" ")[0];

        logout.setTitle("Olá, " + firstName + "! - " + logout.getTitle() + "?");
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                switch (menuItem.getItemId()){
                    case (R.id.nuvem_palavras):
                        navigateToCloud();
                        break;
                    case (R.id.o_que_e):
                        navigate("topic1");
                        break;
                    case (R.id.o_que_causa):
                        navigate("topic2");
                        break;
                    case (R.id.como_e_diagnosticado):
                        navigate("topic3");
                        break;
                    case (R.id.como_afeta_corpo):
                        navigate("topic4");
                        break;
                    case (R.id.como_vou_melhorar):
                        navigate("topic5");
                        break;
                    case (R.id.como_sera_dia_a_dia):
                        navigate("topic6");
                        break;
                    case (R.id.logout):
                        db.userLogout();
                        navigateToLogin();
                        break;
                    case (R.id.about):
                        navigate("about");
                        break;
                }
                mDrawerLayout.closeDrawer(mNavigationView, true);
                return true;
            }
        });

    }

    private void setFirebaseUserProperties() {
        mFirebaseAnalytics.setUserId(loggedUser.getShaid());
        mFirebaseAnalytics.setUserProperty("idade", loggedUser.getAgeGroup());
        mFirebaseAnalytics.setUserProperty("gênero", loggedUser.getGender());
        mFirebaseAnalytics.setUserProperty("tipo", loggedUser.getType());
    }

    public void navigateToCloud(){
        Intent intent = new Intent();
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
            NavigationStackManager.removeVideoEntries();

            sendEvents(topicId);
            NavigationStackManager.stackSession(topicId);

            TopicFragment fragment = TopicFragment.newInstance(topicId);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private void navigateBack(String topicId){
        sendEvents(topicId);

        TopicFragment fragment = TopicFragment.newInstance(topicId);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public String getTopicNameById(String topicId) {
        Session session = Repository.getSession(topicId);
        TitleContent title = (TitleContent) session.getContentList().get(0);
        return getResources().getString(title.getTextId());
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
        NavigationStackManager.removeVideoEntries();

        NavigationStackManager.popPresentSession();
        if (!NavigationStackManager.isStackEmpty()) {
            navigateBack(NavigationStackManager.getPresentSession());
        }
        else {
            navigateToCloud();
        }
    }

    private void initAnalytics() {
        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    public void sendAnalyticsScreenView() {
        mTracker.setScreenName("Atividade Principal");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }


    private void sendEvents(String topicId) {
        Bundle params = new Bundle();
        params.putString("topic_name", getTopicNameById(topicId));
        mFirebaseAnalytics.logEvent("View_Topic", params);

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(getTopicNameById(topicId))
                .setAction(loggedUser.getGender())
                .setLabel(loggedUser.getType())
                .setValue(Long.valueOf(loggedUser.getAge()))
                .build());
    }
}
