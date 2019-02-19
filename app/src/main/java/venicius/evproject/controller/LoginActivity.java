package venicius.evproject.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import venicius.evproject.R;

public class LoginActivity extends AppCompatActivity {

    String evpSenha;
    Button btnLogin;
    EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();

        evpSenha="evp";

        btnLogin = (Button) findViewById(R.id.btnEntrar);

        editTextSenha = (EditText) findViewById(R.id.edtSenha);

        final Intent intentConfig = new Intent(this, ConfigActivity.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (!editTextSenha.getText().toString().equals(evpSenha)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Senha incorreta!",Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    startActivity(intentConfig);
                }
            }
        });

    }


}
