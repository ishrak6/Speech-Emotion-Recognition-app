package com.example.ycfelix.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar mainToolbar;
    private String current_user_id;
    private BottomNavigationView mainBottomNav;
    private DrawerLayout mainDrawer;
    private ActionBarDrawerToggle mainToggle;
    private NavigationView mainNav;

    FrameLayout frameLayout;
    private TextView drawerName;
    private CircleImageView drawerImage;


    private HashMap<String, String> user;
    private String name, email, photo, mobile,username;

    HomeFragment homeFragment;
    MessageFragment messageFragment;


    //Other Variables
    private Animation topAnimation, bottomAnimation, startAnimation, endAnimation;
    private SharedPreferences onBoardingPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(10.0f);
        mainDrawer=findViewById(R.id.main_activity);
        mainNav = findViewById(R.id.main_nav);
        mainNav.setNavigationItemSelectedListener(this);
        frameLayout=findViewById(R.id.main_container);
        mainToggle = new ActionBarDrawerToggle(this,mainDrawer,toolbar,R.string.open,R.string.close);
        mainDrawer.addDrawerListener(mainToggle);
        mainToggle.setDrawerIndicatorEnabled(true);
        mainToggle.syncState();
        //mainNav.setAnimation(topAnimation);
        /////
        homeFragment=new HomeFragment();
        messageFragment=new MessageFragment();

        mainBottomNav = findViewById(R.id.mainBottomNav);
        //mainBottomNav.setAnimation(bottomAnimation);
        mainBottomNav.setOnNavigationItemSelectedListener(selectlistner);
        initializeFragment();
        mainBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        flag=1;
                        replaceFragment(homeFragment);

                        return true;

                    case R.id.navigation_chat:
                        flag=2;
                        replaceFragment(messageFragment);

                        return true;






                    default:
                        return false;
                }
            }
        });
    }
    int flag=1;
    private BottomNavigationView.OnNavigationItemSelectedListener selectlistner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.bottom_home:
                            HomeFragment fragment2 = new HomeFragment();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.content, fragment2, "");
                            ft2.commit();
                            break;



                    }
                    return false;
                }
            };
    private void replaceFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (fragment == homeFragment){
            fragmentTransaction.hide(messageFragment);

            // fragmentTransaction.hide(historyFragment);

        } else if (fragment == messageFragment){

            fragmentTransaction.hide(homeFragment);

            //   fragmentTransaction.hide(historyFragment);

        }

    }




    public void initializeFragment(){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,homeFragment);
        fragmentTransaction.add(R.id.main_container,messageFragment);


        // fragmentTransaction.add(R.id.main_container,historyFragment);


        fragmentTransaction.hide(messageFragment);



        fragmentTransaction.commit();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case R.id.workhis:
                startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                break;


            case R.id.addNote:
                Toast.makeText(this, "You are now in home", Toast.LENGTH_SHORT).show();

                break;





        }

        return false;
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Exit")
                .setCancelable(false)
                .setMessage("Are you want to exit")
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finishAffinity();
            }
        }).create();
        builder.show();



    }
}