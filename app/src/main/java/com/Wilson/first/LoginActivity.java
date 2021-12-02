package com.Wilson.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity{
    public EditText user, pass;
    String userPrueba = "hola";
    String passPrueba = "123";


    public boolean ValidarLogin(){
        boolean mentira = false;

        if(user.getText().toString().equals(getIntent().getStringExtra("usuario")) && pass.getText().toString().equals(getIntent().getStringExtra("contraseña")) ){
            mentira = true;
        }

        /*if ((user.getText().toString().equals(userPrueba)) && (pass.getText().toString().equals(passPrueba)) ){
            mentira = true;
        }
*/
        return mentira;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);

        user = (EditText) findViewById(R.id.usuario);
        pass = (EditText) findViewById(R.id.pass);

        ImageView mGirl = findViewById(R.id.girl);
        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .into(mGirl)
        ;

    }


    public void Abierto(View v){

        if(ValidarLogin()){

            Intent intent = new Intent(LoginActivity.this, Bienvenida.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "Usuario no existe o incorrecto", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void alMain(View v){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void alLogeo(View v){
        Intent intent = new Intent(LoginActivity.this, SignUP.class);
        startActivity(intent);
    }



}

