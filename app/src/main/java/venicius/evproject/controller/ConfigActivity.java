package venicius.evproject.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import venicius.evproject.R;

public class ConfigActivity extends AppCompatActivity {

    Button btnEditarSq;
    Button btnSeqPadrao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        btnEditarSq = (Button) findViewById(R.id.btnEditarSequencia);
        btnSeqPadrao = (Button) findViewById(R.id.btnSeqPadrao);

        final Intent intentEditar = new Intent(this, EditarSequenciaActivity.class);
        final Intent intentMain = new Intent(this, MainActivity.class);

        btnEditarSq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEditar);
            }
        });

        btnSeqPadrao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getSharedPreferences(
                        "venicius.evp.PREFERENCE_FILE_KEY",
                        Context.MODE_PRIVATE);

                //salvando configurações
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("sequencia",false);
                editor.apply();

                startActivity(intentMain);
            }
        });




    }
}
