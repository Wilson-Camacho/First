package com.Wilson.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public SwipeRefreshLayout swipe;
    public WebView sitioWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView presionado =  (TextView) findViewById(R.id.textPress);
        registerForContextMenu(presionado);


        swipe = (SwipeRefreshLayout) findViewById(R.id.refresh);

        swipe.setOnRefreshListener(nOnRefresListener);

        sitioWeb = (WebView) findViewById(R.id.sitioWeb);

        sitioWeb.getSettings().setBuiltInZoomControls(true);
        sitioWeb.loadUrl("https://thiscatdoesnotexist.com/");


    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Ventana");
        builder.setMessage("¿Donde vas?");

        builder.setCancelable(false);

        builder.setPositiveButton("Signup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, SignUP.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No hacer nada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Otro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.it1) {
            final ConstraintLayout lay = findViewById(R.id.myMainActivityConstraint);
            Snackbar snackbar = Snackbar
                    .make(lay, "Infecting", Snackbar.LENGTH_LONG);
            snackbar.show();
        }

        if (id == R.id.it2){
            final ConstraintLayout lay = findViewById(R.id.myMainActivityConstraint);
            Snackbar snackbar = Snackbar
                    .make(lay, "Fixing", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        if (id == R.id.it4) {
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);

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
    protected SwipeRefreshLayout.OnRefreshListener nOnRefresListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(MainActivity.this, "Recargando", Toast.LENGTH_LONG);


            sitioWeb.reload();
            swipe.setRefreshing(false);
            toast.show();
        }
    };




}