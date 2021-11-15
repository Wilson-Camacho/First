package com.Wilson.first;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView presionado =  (TextView) findViewById(R.id.textPress);
        registerForContextMenu(presionado);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        //getMenuInflater().inflate(R.menu.menu_context, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }


    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                /*
                Toast toast = Toast.makeText(this, "item copied", Toast.LENGTH_LONG);
                toast.show();
                */

                final ConstraintLayout lay = findViewById(R.id.myMainActivityConstraint);
                Snackbar snackbar = Snackbar
                        .make(lay, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG);

                /*OPCIONAL, PARA PODER QUITAR EL SNACKBAR
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(lay, "Action is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                 */
                snackbar.show();

                return true;

            case R.id.item2:
                Toast toast2 = (Toast) Toast.makeText(getApplicationContext(), "going context se", Toast.LENGTH_LONG);
                toast2.show();

                return true;

            default:
                return super.onContextItemSelected(item);
        }





    }
}