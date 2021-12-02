package com.Wilson.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class SignUP extends AppCompatActivity {
    public EditText user, pass, confPass;
    public Button login;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.signup);

            user = (EditText) findViewById(R.id.usuario);
            pass = (EditText) findViewById(R.id.contraseña);
            confPass = (EditText) findViewById(R.id.confirmarPass);
            login = (Button) findViewById(R.id.logear);

        }

        /*public void onClick(View v){
        Intent intent = new Intent(SignUP.this, LoginActivity.class);
        startActivity(intent);
       } */

        public void logear(View v){
            String valor1 = pass.getText().toString();
            String valor2 = confPass.getText().toString();
            String userOtro = user.getText().toString();

            if(valor1.equals(valor2)){

                Intent intent = new Intent(SignUP.this, LoginActivity.class);
                intent.putExtra("usuario", userOtro);
                intent.putExtra("contraseña", valor2);
                startActivity(intent);

            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "Contraseñas no coinciden.", Toast.LENGTH_LONG);
                toast.show();
            }

        }




}
