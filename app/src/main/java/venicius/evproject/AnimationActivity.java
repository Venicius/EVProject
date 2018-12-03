package venicius.evproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.MediaPlayer;
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

import java.util.ArrayList;

import venicius.evproject.model.BancoController;
import venicius.evproject.model.CriaBanco;

public class AnimationActivity extends AppCompatActivity {
    private View mContentView;
    private ImageView imgCentral;
    private ImageView imgFundo;
    private MediaPlayer mp;

    Boolean flagSeq;

    Handler mHandler = new Handler();

    ArrayList<Integer> arrayListCentros = new ArrayList<Integer>();

    int arrayCentral[] = {R.drawable.centro_sino,R.drawable.centro_galinho,R.drawable.centro_rostoamarelofeliz, R.drawable.centro_sino,R.drawable.centro_sino,R.drawable.centro_sino,R.drawable.centro_boneco,R.drawable.centro_panda,R.drawable.centro_rostoamarelofeliz2,R.drawable.centro_macaco,R.drawable.centro_tigre,R.drawable.centro_pintinho,R.drawable.centro_cavalo,R.drawable.centro_rostovermelho,R.drawable.centro_rostoamarelofeliz3,R.drawable.centro_sino,R.drawable.centro_sapo,R.drawable.centro_girafa,R.drawable.centro_caracolvermelho,R.drawable.centro_garoto1,R.drawable.centro_garoto2,R.drawable.centro_rostoverde,R.drawable.centro_sino,R.drawable.centro_lagarta,R.drawable.centro_guaxinin,R.drawable.centro_porco,R.drawable.centro_cao,R.drawable.centro_garoto3,R.drawable.centro_pinguin,R.drawable.centro_menina1};


    int arrayFundos[] = {R.drawable.fundo_alvo,R.drawable.fundo_preto,R.drawable.fundo_azul,R.drawable.fundo_xadrez,R.drawable.fundo_alvovermelho_verde, R.drawable.fundo_alvoazul_amarelo,R.drawable.fundo_verdelimao,R.drawable.fundo_vermelho,R.drawable.fundo_azul,R.drawable.fundo_xadrez,R.drawable.fundo_verdelimao,R.drawable.fundo_azul,R.drawable.fundo_alvo,R.drawable.fundo_verdelimao,R.drawable.fundo_azul,R.drawable.fundo_alvoxadrez,R.drawable.fundo_alvo,R.drawable.fundo_xadrez,R.drawable.fundo_amarelo,R.drawable.fundo_vermelho,R.drawable.fundo_azulescuro,R.drawable.fundo_vermelho,R.drawable.fundo_caracol,R.drawable.fundo_lilas,R.drawable.fundo_azul,R.drawable.fundo_alvo,R.drawable.fundo_xadrez,R.drawable.fundo_amarelo,R.drawable.fundo_verdelimao,R.drawable.fundo_cinza};

    int arraySons[] = {R.raw.som_padrao,R.raw.som_galinho,R.raw.som_rostinhoamarelofeliz,R.raw.som_padrao,R.raw.som_padrao,R.raw.som_padrao,R.raw.som_rostinhoamarelofeliz,R.raw.som_panda,R.raw.som_rostinhoamarelofeliz,R.raw.som_macaco,R.raw.som_tigre,R.raw.som_pintinho,R.raw.som_cavalo,R.raw.som_rostinhoamarelofeliz,R.raw.som_rostinhoamarelofeliz,R.raw.som_padrao,R.raw.som_sapo,R.raw.som_padrao,R.raw.som_padrao,R.raw.som_rostinhoamarelofeliz,R.raw.som_rostinhoamarelofeliz,R.raw.som_rostinhoamarelofeliz,R.raw.som_padrao,R.raw.som_padrao,R.raw.som_guaxinin,R.raw.som_porco,R.raw.som_cao,R.raw.som_rostinhoamarelofeliz,R.raw.som_padrao,R.raw.som_rostinhoamarelofeliz};

    int cont=0;

    private static final long START_TIME_IN_MILLIS = 15000;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    Intent intentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        this.getSupportActionBar().hide();
        hideSystemUI();

        SharedPreferences sharedPref = this.getSharedPreferences(
                "venicius.evp.PREFERENCE_FILE_KEY",
                Context.MODE_PRIVATE);


        flagSeq = sharedPref.getBoolean("sequencia", false);

        if(!flagSeq){
            arrayListCentros.add(R.drawable.centro_sino);
            arrayListCentros.add(R.drawable.centro_galinho);

        }

      /*  final BancoController crud = new BancoController(getBaseContext());
        Cursor cursor;

        cursor = crud.carregaDados();
        cursor.moveToFirst();


        Toast toast = Toast.makeText(getApplicationContext(), cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.FUNDO)),Toast.LENGTH_LONG);
        toast.show();*/

        intentMain = new Intent(this, MainActivity.class);
        mContentView = findViewById(R.id.fullscreen_content2);
        imgCentral = (ImageView) findViewById(R.id.imageView);
        imgFundo = (ImageView) findViewById(R.id.imageView3);
        mHandler.postDelayed(mRunNovaImagem, 00000);

    }

    private Runnable mRunNovaImagem = new Runnable () {
        @Override
        public void run() {
            if (cont < arrayCentral.length){
                imgCentral.setImageResource(arrayCentral[cont]);
                imgFundo.setImageResource(arrayFundos[cont]);
                imgCentral.setAnimation(null);
                mp = MediaPlayer.create(AnimationActivity.this, arraySons[cont]);
                mContentView.setClickable(false);
                mHandler.postDelayed(mRunInicial, 3000);
                startTimer();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "FIM",Toast.LENGTH_LONG);
                toast.show();
                startActivity(intentMain);
            }
        }
    };

    //animação da imagem, ao tocar ou ao fim do tempo
    private void animarImagem(){
        Animation animZoomIn;
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        imgCentral.startAnimation(animZoomIn);
        mp.start();
        pauseTimer();
        resetTimer();
        cont++;
        //depois dos 3 segundos de animação, + 3 de espera até passar o proximo slide
        mHandler.postDelayed(mRunNovaImagem, 6000);
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
                animarImagem();
            }
        }.start();
        mTimerRunning = true;
    }

    //esperando o clique na figura
      private Runnable mRunInicial = new Runnable () {
        @Override
        public void run() {

            //toque na imagem
            mContentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContentView.setClickable(false);
                    animarImagem();
                }
                });//tocou na imagem
        }
    };

    //funções para pausar e zerar o contador
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
    }

    //Aqui para baixo configurções de tela cheia
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

    @Override
    protected void onStop() {
        mp.stop();
        super.onStop();
    }

    @Override
    protected void onPause() {
        mp.stop();
        super.onPause();

    }
}


