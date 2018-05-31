package com.example.grqueiroz.lupus_tcc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.adroitandroid.chipcloud.ChipCloud;
import com.adroitandroid.chipcloud.ChipListener;
import com.example.grqueiroz.lupus_tcc.manager.NavigationStackManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CloudActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud);

        db = new DbHandler(CloudActivity.this);

        final ChipCloud chipCloud = findViewById(R.id.chip_cloud);

        List<String> tagList = Arrays.asList(getResources().getStringArray(R.array.tags));
        Collections.shuffle(tagList);
        final String[] tags = tagList.toArray(new String[tagList.size()]);

        new ChipCloud.Configure()
                .chipCloud(chipCloud)
                .labels(tags)
                .chipListener(new ChipListener() {
                    @Override
                    public void chipSelected(int index) {
                        navigate(Repository.tagTopicMap.get(tags[index]));
                    }
                    @Override
                    public void chipDeselected(int index) {
                        //...
                    }
                })
                .build();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        Menu menu = mNavigationView.getMenu();
        MenuItem logout = menu.findItem(R.id.logout);

        Bundle bundle = getIntent().getExtras();
        String loggedUserName = null;
        if (bundle != null) {
            loggedUserName = bundle.getString("loggedUser");
        }
        logout.setTitle("Olá, " + loggedUserName + "! - " + logout.getTitle() + "?");

        TextView greetings = findViewById(R.id.greetings);
        greetings.setText(String.format("%s %s%s", getResources().getString(R.string.cloud_greeting_1), loggedUserName, getResources().getString(R.string.cloud_greeting_2)));

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                switch (menuItem.getItemId()){
                    case(R.id.nuvem_palavras):
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

    public void navigate(String topicId){
        Bundle bundle = new Bundle();
        bundle.putString("topicId", topicId);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(CloudActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void navigateToLogin(){
        NavigationStackManager.clearStack();
        Intent intent = new Intent();
        intent.setClass(CloudActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
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
        if (!NavigationStackManager.isStackEmpty()) {
            navigate(NavigationStackManager.getPresentSession());
            NavigationStackManager.popPresentSession();
        }
        else {
            super.onBackPressed();
        }
    }
}
