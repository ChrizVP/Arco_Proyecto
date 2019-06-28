package com.example.intefaz_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class splash_screen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();

        Thread timer = new Thread() {
            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(splash_screen.this, Divice_BT.class);
                    startActivity(intent);
                }


            }

        };
        timer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
