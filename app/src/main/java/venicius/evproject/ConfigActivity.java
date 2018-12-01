package venicius.evproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfigActivity extends AppCompatActivity {

    Button btnEditarSq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        btnEditarSq = (Button) findViewById(R.id.btnEditarSequencia);

        final Intent intentEditar = new Intent(this, EditarSequenciaActivity.class);

        btnEditarSq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEditar);
            }
        });

    }
}
