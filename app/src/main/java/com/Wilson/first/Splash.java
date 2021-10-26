package com.Wilson.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
    }

    public void splash (View v){
        Intent intent = new Intent(Splash.this, LoginActivity.class);
        startActivity(intent);
    }
}