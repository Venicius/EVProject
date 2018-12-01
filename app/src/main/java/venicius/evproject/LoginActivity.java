package venicius.evproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    String evpUser;
    String evpSenha;
    Button btnLogin;
    EditText editTextUser;
    EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();

        evpUser="evp";
        evpSenha="1234";

        btnLogin = (Button) findViewById(R.id.btnEntrar);
        editTextUser = (EditText) findViewById(R.id.edtUser);
        editTextSenha = (EditText) findViewById(R.id.edtSenha);

        final Intent intentConfig = new Intent(this, ConfigActivity.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextUser.getText().toString().equals(evpUser)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Usuário incorreto!",Toast.LENGTH_SHORT);
                    toast.show();
                } else if (!editTextSenha.getText().toString().equals(evpSenha)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Senha incorreta!",Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    startActivity(intentConfig);
                }
            }
        });

    }


}
