package com.aayat.bankingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class splash_screenActivity extends Activity {

    LinearLayout created;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        logo = findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }, 3000);
    }
}

