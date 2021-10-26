package com.Wilson.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View; // Se añade esta vista.
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        ImageView mGirl = findViewById(R.id.girl);
        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mGirl)
        ;
    }

    public void Abierto(View v){
        Intent intent = new Intent(LoginActivity.this, SignUP.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void alMain(View v){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }



}

