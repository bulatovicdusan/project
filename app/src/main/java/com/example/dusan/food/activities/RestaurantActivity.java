package com.example.dusan.food.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dusan.food.Fragments.TabFragment;
import com.example.dusan.food.Fragments.TabFragment2;
import com.example.dusan.food.R;

/**
 * Created by wubon on 1/10/2017.
 */
public class RestaurantActivity extends AppCompatActivity {

        DrawerLayout mDrawerLayout;
        NavigationView mNavigationView;
        FragmentManager mFragmentManager;
        FragmentTransaction mFragmentTransaction;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.restaurant_layout);




            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
            mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

            /**
             * Lets inflate the very first fragment
             * Here , we are inflating the TabFragment as the first Fragment
             */

            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.containerView, new TabFragment2()).commit();
            /**
             * Setup click events on the Navigation View Items.
             */

            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    mDrawerLayout.closeDrawers();


                    if (menuItem.getItemId() == R.id.nav_item_inbox) {
                        FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                        xfragmentTransaction.replace(R.id.containerView, new TabFragment2()).commit();
                    }

                    return false;
                }

            });

            /**
             * Setup Drawer Toggle of the Toolbar
             */

            android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if(actionBar != null) {
                actionBar.setIcon(R.drawable.ic_action_logo);
            }

            ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                    R.string.app_name);

            mDrawerLayout.setDrawerListener(mDrawerToggle);

            mDrawerToggle.syncState();

        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Intent i = new Intent(getApplicationContext(), Preferences.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }





}