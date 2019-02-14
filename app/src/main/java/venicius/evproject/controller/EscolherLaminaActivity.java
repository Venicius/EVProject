package venicius.evproject.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        final Intent intentMain = new Intent(this, MainActivity.class);

        btnFacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences(
                        "venicius.evp.PREFERENCE_FILE_KEY",
                        Context.MODE_PRIVATE);

                //salvando configurações
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("sequencias",1);
                editor.apply();

                startActivity(intentMain);
            }
        });

        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences(
                        "venicius.evp.PREFERENCE_FILE_KEY",
                        Context.MODE_PRIVATE);

                //salvando configurações
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("sequencias",2);
                editor.apply();

                startActivity(intentMain);
            }
        });

        btnDificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences(
                        "venicius.evp.PREFERENCE_FILE_KEY",
                        Context.MODE_PRIVATE);

                //salvando configurações
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("sequencias",3);
                editor.apply();

                startActivity(intentMain);
            }
        });



    }
}
