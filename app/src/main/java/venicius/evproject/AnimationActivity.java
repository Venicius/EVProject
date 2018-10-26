package venicius.evproject;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        this.getSupportActionBar().hide();
        hideSystemUI();
        mContentView = findViewById(R.id.fullscreen_content2);


        for(int i=0; i<3; i++) {
            mHandler.postDelayed(mRunInicial, 3000);
            mHandler.postDelayed(mRunGeral, 12000);
        }


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

   //exeução depois de alguns segundos
    private Runnable mRun = new Runnable () {
        @Override
        public void run() {
            ImageView imgFundo = (ImageView) findViewById(R.id.imageView3);
            imgFundo.setImageResource(R.drawable.logo);
        }
    };

    private Runnable mRunInicial = new Runnable () {
        @Override
        public void run() {
            mContentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //toggle();
                    Animation animZoom;
                    ImageView imgCentral;

                    animZoom = AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.zoom_in);

                    imgCentral = (ImageView) findViewById(R.id.imageView);

                    imgCentral.startAnimation(animZoom);
                    //depois dos 3 segundos de animação, + 3 de espera até passar o proximo slide
                    mHandler.postDelayed(mRun, 6000);

                }
            });
        }
    };

    private Runnable mRunGeral = new Runnable () {
        @Override
        public void run() {
            ImageView imgFundo = (ImageView) findViewById(R.id.imageView3);
            imgFundo.setImageResource(R.drawable.logo);
        }
    };

    Handler mHandler = new Handler();

}
