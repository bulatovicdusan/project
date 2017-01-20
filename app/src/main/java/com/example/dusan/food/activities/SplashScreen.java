package com.example.dusan.food.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.dusan.food.R;

/**
 * Created by wubon on 1/10/2017.
 */
public class SplashScreen extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        img = (ImageView) findViewById(R.id.splashimg);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMainScreen = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startMainScreen);
            }
        });

        Thread myThread = new Thread() {





            public void run() {
                try {
                    sleep(2000);

                    Intent startMainScreen = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(startMainScreen);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }


}
