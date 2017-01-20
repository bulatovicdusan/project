package com.example.dusan.food.activities;

import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.service.notification.NotificationListenerService;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dusan.food.Fragments.TabFragment2;
import com.example.dusan.food.R;

import org.w3c.dom.Text;

import java.io.File;

/**
 * Created by wubon on 1/18/2017.
 */
public class MealActivity extends AppCompatActivity implements View.OnClickListener{


    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private Button button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_info_layout);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);


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


        TextView mealName = (TextView) findViewById(R.id.nazivJela);
        mealName.setText(getIntent().getStringExtra("name"));
        TextView mealDesc = (TextView) findViewById(R.id.opisJela);
        mealDesc.setText(getIntent().getStringExtra("descr"));
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(getIntent().getStringExtra("price") + " din");
        ImageView imageView = (ImageView) findViewById(R.id.slikameal);
        String photo = getIntent().getStringExtra("img");
        File imgFile = new File(photo);
        Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(bitmap);

        button = (Button) findViewById(R.id.buybutton);
        button.setOnClickListener(this);





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


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Processing order ...", Toast.LENGTH_LONG).show();
        final Toast tag = Toast.makeText(getBaseContext(), getIntent().getStringExtra("name"),Toast.LENGTH_SHORT);

        tag.show();

        new CountDownTimer(9000, 1000)
        {

            public void onTick(long millisUntilFinished) {tag.show();}
            public void onFinish() {tag.show();}

        }.start();
        Toast.makeText(this,"Order completed !",Toast.LENGTH_SHORT).show();
    }
}
