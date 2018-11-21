package venicius.evproject;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class AnimationActivity extends AppCompatActivity {
    private View mContentView;
    private ImageView imgCentral;
    private ImageView imgFundo;

    Handler mHandler = new Handler();

    int arrayCentral[] = {R.drawable.cavalo};
    int arrayFundos[] = {R.drawable.alvo_preto_branco};

    int cont=0;

    private static final long START_TIME_IN_MILLIS = 12000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        this.getSupportActionBar().hide();
        hideSystemUI();

        mContentView = findViewById(R.id.fullscreen_content2);
        imgCentral = (ImageView) findViewById(R.id.imageView);
        imgFundo = (ImageView) findViewById(R.id.imageView3);

        iniciarSequencia();

    }

    private void iniciarSequencia(){
        imgCentral.setImageResource(arrayCentral[cont]);
        imgFundo.setImageResource(arrayFundos[cont]);
        mHandler.postDelayed(mRunInicial, 3000);
        startTimer();
    }


    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                resetTimer();
                Toast toast = Toast.makeText(getApplicationContext(), "Finish",Toast.LENGTH_LONG);
                toast.show();
                iniciarSequencia();

            }
        }.start();

        mTimerRunning = true;

    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;

    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;

    }

      private Runnable mRunInicial = new Runnable () {
        @Override
        public void run() {

            //toque na imagem
            mContentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //toggle();
                    Animation animZoom;
                    animZoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                    imgCentral.startAnimation(animZoom);
                    //depois dos 3 segundos de animação, + 3 de espera até passar o proximo slide
                   pauseTimer();
                   resetTimer();
                   iniciarSequencia();

                }
            });//tocou na imagem
            //mHandler.postDelayed(mRun, 12000);
        }
    };

    //troca de imagens
    private Runnable mRun = new Runnable () {
        @Override
        public void run() {
            cont = cont++;
            imgFundo.setImageResource(arrayFundos[cont]);
        }
    };

   /* private Runnable mRunGeral = new Runnable () {
        @Override
        public void run() {
            ImageView imgFundo = (ImageView) findViewById(R.id.imageView3);
            imgFundo.setImageResource(R.drawable.logo);
        }
    };*/




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

}
