package com.ltrsoft.userpoliceapp.activities;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ltrsoft.userpoliceapp.R;

public class SpashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent main_activity_intent = new Intent(SpashScreen.this, MainActivity.class);
                    startActivity(main_activity_intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
}
