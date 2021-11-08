package com.Wilson.first;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Sheila
 * Trabajando en mejora de la animación
 *
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        OpenApp(true);

        ImageView imagen = findViewById(R.id.corona);


        Animation rotate = AnimationUtils.loadAnimation(this,R.anim.anim);
        imagen.startAnimation(rotate);
    }

    public void splash (View v){
        Intent intent = new Intent(Splash.this, LoginActivity.class);
        startActivity(intent);

    }
    public void OpenApp (boolean abierto){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                startActivity(intent);
            }
        },2000);

    }
}