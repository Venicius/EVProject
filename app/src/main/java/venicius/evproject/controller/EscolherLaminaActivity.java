package venicius.evproject.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import venicius.evproject.R;

public class EscolherLaminaActivity extends AppCompatActivity {

    Button btnFacil;
    Button btnMedia;
    Button btnDificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_lamina);

        btnFacil = (Button) findViewById(R.id.btnFacil);
        btnMedia = (Button) findViewById(R.id.btnMedia);
        btnDificil = (Button) findViewById(R.id.btnDificil);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final Intent intentMain = new Intent(this, MainActivity.class);

        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setTitle("Definir Lâmina Fácil?");

                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        SharedPreferences sharedPref = getSharedPreferences(
                                "venicius.evp.PREFERENCE_FILE_KEY",
                                Context.MODE_PRIVATE);

                        //salvando configurações
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("sequencias",1);
                        editor.apply();
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Aplicativo pronto para iniciar!", Toast.LENGTH_LONG);
                        toast2.show();
                        startActivity(intentMain);

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setTitle("Definir Lâmina Média?");

                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        SharedPreferences sharedPref = getSharedPreferences(
                                "venicius.evp.PREFERENCE_FILE_KEY",
                                Context.MODE_PRIVATE);

                        //salvando configurações
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("sequencias",2);
                        editor.apply();
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Aplicativo pronto para iniciar!", Toast.LENGTH_LONG);
                        toast2.show();
                        startActivity(intentMain);

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btnDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder.setTitle("Definir Lâmina Difícil?");

                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        SharedPreferences sharedPref = getSharedPreferences(
                                "venicius.evp.PREFERENCE_FILE_KEY",
                                Context.MODE_PRIVATE);

                        //salvando configurações
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("sequencias",3);
                        editor.apply();
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Aplicativo pronto para iniciar!", Toast.LENGTH_LONG);
                        toast2.show();
                        startActivity(intentMain);

                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });



    }
}
