package venicius.evproject;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        Button buttonPlay = (Button)findViewById(R.id.btnPlay);
        final Intent intentPlay = new Intent(this, AnimationActivity.class);

        FloatingActionButton fabConfig = (FloatingActionButton) findViewById(R.id.fabConfig);
        final Intent intentConfig = new Intent(this, LoginActivity.class);

        fabConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentConfig);
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentPlay);
            }
        });


    }
}
