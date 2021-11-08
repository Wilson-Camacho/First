package com.Wilson.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity{
    public Button entrar;
    public EditText user, pass;
    String userPrueba = "hola";
    String passPrueba = "123";
    public TextView resultado;

    public boolean ValidarLogin(){
        boolean mentira = false;

        if ((user.getText().toString().equals(userPrueba)) && (pass.getText().toString().equals(passPrueba)) ){
            mentira = true;
        }

        return mentira;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        user = (EditText) findViewById(R.id.usuario);
        pass = (EditText) findViewById(R.id.pass);
        resultado = (TextView) findViewById(R.id.resultado);

        ImageView mGirl = findViewById(R.id.girl);
        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mGirl)
        ;


    }



    public void Abierto(View v){
        if(ValidarLogin()){
            Intent intent = new Intent(LoginActivity.this, SignUP.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else {
            resultado.setText(String.valueOf("No"));
        }

    }

    public void alMain(View v){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }



}

