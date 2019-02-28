package venicius.evproject.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import venicius.evproject.model.*;

import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import venicius.evproject.R;
import venicius.evproject.model.BancoController;
import venicius.evproject.model.CriaBanco;

public class AnimationActivity extends AppCompatActivity {
    private View mContentView;
    private ImageView imgCentral;
    private MediaPlayer mp;

    int flagSeq;
    Boolean flagAudio = true;

    Handler mHandler = new Handler();

    ArrayList<Integer> arrayListCentros = new ArrayList<Integer>();

    ArrayList<Integer> arrayListFundos = new ArrayList<Integer>();

    ArrayList<Integer> arrayListSons = new ArrayList<Integer>();

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
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        intentMain = new Intent(this,MainActivity.class);
        mContentView = findViewById(R.id.fullscreen_content2);
        imgCentral = (ImageView) findViewById(R.id.imageView);

        SharedPreferences sharedPref = this.getSharedPreferences(
                "venicius.evp.PREFERENCE_FILE_KEY",
                Context.MODE_PRIVATE);

        flagSeq = sharedPref.getInt("sequencias", 0);

        if(flagSeq==0){ //Padrao

            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_preto);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_alvovermelho_verde);
            arrayListFundos.add(R.drawable.fundo_alvoazul_amarelo);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvoxadrez);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_azulescuro);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_caracol);
            arrayListFundos.add(R.drawable.fundo_lilas);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_cinza);

            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_galinho);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_boneco);
            arrayListCentros.add(R.drawable.centro_panda);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz2);
            arrayListCentros.add(R.drawable.centro_macaco);
            arrayListCentros.add(R.drawable.centro_tigre);
            arrayListCentros.add(R.drawable.centro_pintinho);
            arrayListCentros.add(R.drawable.centro_cavalo);
            arrayListCentros.add(R.drawable.centro_rostovermelho);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz3);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_sapo);
            arrayListCentros.add(R.drawable.centro_girafa);
            arrayListCentros.add(R.drawable.centro_caracolvermelho);
            arrayListCentros.add(R.drawable.centro_garoto1);
            arrayListCentros.add(R.drawable.centro_garoto2);
            arrayListCentros.add(R.drawable.centro_rostoverde);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_lagarta);
            arrayListCentros.add(R.drawable.centro_guaxinin);
            arrayListCentros.add(R.drawable.centro_porco);
            arrayListCentros.add(R.drawable.centro_cao);
            arrayListCentros.add(R.drawable.centro_garoto3);
            arrayListCentros.add(R.drawable.centro_pinguin);
            arrayListCentros.add(R.drawable.centro_menina1);

            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_galinho);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_panda);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_macaco);
            arrayListSons.add(R.raw.som_tigre);
            arrayListSons.add(R.raw.som_pintinho);
            arrayListSons.add(R.raw.som_cavalo);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_sapo);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_guaxinin);
            arrayListSons.add(R.raw.som_porco);
            arrayListSons.add(R.raw.som_cao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);

            mHandler.postDelayed(mRunNovaImagem, 00000);
    } else if (flagSeq==1){//Fácil

            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvovermelho_verde);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_branco);
            arrayListFundos.add(R.drawable.fundo_alvoazul_amarelo);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_alvopontudo);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_branco);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_branco);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_branco);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_branco);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_verdelimao);


            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_rostopreto1);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_pintinho);
            arrayListCentros.add(R.drawable.centro_alvopreto);
            arrayListCentros.add(R.drawable.centro_caracolamarelo);
            arrayListCentros.add(R.drawable.centro_rostopreto2);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_rostoverde);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz2);
            arrayListCentros.add(R.drawable.centro_boneco);
            arrayListCentros.add(R.drawable.centro_rostopreto2);
            arrayListCentros.add(R.drawable.centro_alvopreto);
            arrayListCentros.add(R.drawable.centro_rostopreto1);
            arrayListCentros.add(R.drawable.centro_alvopreto);
            arrayListCentros.add(R.drawable.centro_rostopreto2);
            arrayListCentros.add(R.drawable.centro_alvopreto);
            arrayListCentros.add(R.drawable.centro_rostobranco);
            arrayListCentros.add(R.drawable.centro_caracolvermelho);
            arrayListCentros.add(R.drawable.fundo_alvopontudo);
            arrayListCentros.add(R.drawable.centro_rostopreto2);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz3);
            arrayListCentros.add(R.drawable.centro_rostoverde2);
            arrayListCentros.add(R.drawable.centro_circuloxadrez);
            arrayListCentros.add(R.drawable.centro_boneco);
            arrayListCentros.add(R.drawable.centro_rostopreto1);
            arrayListCentros.add(R.drawable.centro_alvopreto);

            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_pintinho);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);

            mHandler.postDelayed(mRunNovaImagem, 00000);

        } else if (flagSeq==2){//Média

            arrayListFundos.add(R.drawable.fundo_preto);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_alvovermelho_verde);
            arrayListFundos.add(R.drawable.fundo_lilas);
            arrayListFundos.add(R.drawable.fundo_caracol);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_branco);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_amarelo);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_alvopontudo);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_xadrezamarelopreto);


            arrayListCentros.add(R.drawable.centro_galinho);
            arrayListCentros.add(R.drawable.centro_porcoroxo);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz2);
            arrayListCentros.add(R.drawable.centro_cavalo);
            arrayListCentros.add(R.drawable.centro_caracolamarelo);
            arrayListCentros.add(R.drawable.centro_macaco);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_ratoverde);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_boneco);
            arrayListCentros.add(R.drawable.centro_girafa);
            arrayListCentros.add(R.drawable.centro_rostoamarelofeliz2);
            arrayListCentros.add(R.drawable.centro_elefante);
            arrayListCentros.add(R.drawable.centro_boneco);
            arrayListCentros.add(R.drawable.centro_panda2);
            arrayListCentros.add(R.drawable.centro_alvopreto);
            arrayListCentros.add(R.drawable.centro_circuloxadrez);
            arrayListCentros.add(R.drawable.centro_rostoverde2);
            arrayListCentros.add(R.drawable.centro_macaco);
            arrayListCentros.add(R.drawable.centro_panda2);
            arrayListCentros.add(R.drawable.centro_cavalo);
            arrayListCentros.add(R.drawable.centro_pintinho);
            arrayListCentros.add(R.drawable.centro_caracolvermelho);
            arrayListCentros.add(R.drawable.centro_girafa);
            arrayListCentros.add(R.drawable.centro_alvopreto);
            arrayListCentros.add(R.drawable.centro_rostoverde2);
            arrayListCentros.add(R.drawable.fundo_alvopontudo);
            arrayListCentros.add(R.drawable.centro_elefante);
            arrayListCentros.add(R.drawable.centro_porcoroxo);
            arrayListCentros.add(R.drawable.centro_passaroazul);



            arrayListSons.add(R.raw.som_galinho);
            arrayListSons.add(R.raw.som_porco);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_cavalo);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_macaco);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_elefante);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_panda);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_macaco);
            arrayListSons.add(R.raw.som_panda);
            arrayListSons.add(R.raw.som_cavalo);
            arrayListSons.add(R.raw.som_pintinho);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_elefante);
            arrayListSons.add(R.raw.som_porco);
            arrayListSons.add(R.raw.som_passaro);

            mHandler.postDelayed(mRunNovaImagem, 00000);

        } else if (flagSeq==3){//difícil
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvoxadrez);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_xadrezamarelopreto);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_lilas);
            arrayListFundos.add(R.drawable.fundo_xadrezverdepreto);
            arrayListFundos.add(R.drawable.fundo_marron);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_azulescuro);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_xadrezamarelopreto);
            arrayListFundos.add(R.drawable.fundo_verdemusgo);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_azulclaro);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
           arrayListFundos.add(R.drawable.fundo_preto);
            arrayListFundos.add(R.drawable.fundo_azulmarinho);
            arrayListFundos.add(R.drawable.fundo_xadrezvermelhopreto);
            arrayListFundos.add(R.drawable.fundo_vinho);
            arrayListFundos.add(R.drawable.fundo_xadrez);
            arrayListFundos.add(R.drawable.fundo_verdelimao);
            arrayListFundos.add(R.drawable.fundo_azul);
            arrayListFundos.add(R.drawable.fundo_alvo);
            arrayListFundos.add(R.drawable.fundo_vermelho);
            arrayListFundos.add(R.drawable.fundo_amarelo);


            arrayListCentros.add(R.drawable.centro_panda);
            arrayListCentros.add(R.drawable.centro_sapo);
            arrayListCentros.add(R.drawable.centro_guaxinin);
            arrayListCentros.add(R.drawable.centro_transparente);
            arrayListCentros.add(R.drawable.centro_tigre);
            arrayListCentros.add(R.drawable.centro_passaroazul);
            arrayListCentros.add(R.drawable.centro_elefante);
            arrayListCentros.add(R.drawable.centro_garoto1);
            arrayListCentros.add(R.drawable.centro_girafa);
            arrayListCentros.add(R.drawable.centro_lagarta);
            arrayListCentros.add(R.drawable.centro_meninaruiva);
            arrayListCentros.add(R.drawable.centro_passaroazul);
            arrayListCentros.add(R.drawable.centro_cavalo);
            arrayListCentros.add(R.drawable.centro_garoto2);
            arrayListCentros.add(R.drawable.centro_tigre);
            arrayListCentros.add(R.drawable.centro_elefante);
            arrayListCentros.add(R.drawable.centro_coelhoroxo);
            arrayListCentros.add(R.drawable.centro_sapo);
            arrayListCentros.add(R.drawable.centro_avobigode);
            arrayListCentros.add(R.drawable.centro_panda2);
            arrayListCentros.add(R.drawable.centro_galinho);
            arrayListCentros.add(R.drawable.centro_vaca);
            arrayListCentros.add(R.drawable.centro_lagarta);
            arrayListCentros.add(R.drawable.centro_vovo);
            arrayListCentros.add(R.drawable.centro_bebe);
            arrayListCentros.add(R.drawable.centro_pinguin);
            arrayListCentros.add(R.drawable.centro_boneco);
            arrayListCentros.add(R.drawable.centro_coruja);
            arrayListCentros.add(R.drawable.centro_rostoverde2);
            arrayListCentros.add(R.drawable.centro_alvopreto);



            arrayListSons.add(R.raw.som_panda);
            arrayListSons.add(R.raw.som_sapo);
            arrayListSons.add(R.raw.som_guaxinin);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_tigre);
            arrayListSons.add(R.raw.som_passaro);
            arrayListSons.add(R.raw.som_elefante);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_passaro);
            arrayListSons.add(R.raw.som_cavalo);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_tigre);
            arrayListSons.add(R.raw.som_elefante);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_sapo);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_panda);
            arrayListSons.add(R.raw.som_galinho);
            arrayListSons.add(R.raw.som_vaca);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_padrao);
            arrayListSons.add(R.raw.som_bebe);
            arrayListSons.add(R.raw.som_pintinho);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_coruja);
            arrayListSons.add(R.raw.som_rostinhoamarelofeliz);
            arrayListSons.add(R.raw.som_padrao);

            mHandler.postDelayed(mRunNovaImagem, 00000);
        } else if (flagSeq==4) {

            final BancoController crud = new BancoController(getBaseContext());
            Cursor cursor;
            cursor = crud.carregaDados();
            cursor.moveToFirst();
           // Toast toast = Toast.makeText(this, cursor.getInt(cursor.getColumnIndexOrThrow(CriaBanco.FUNDO)),Toast.LENGTH_LONG);
            //toast.show();
            boolean flagCursor=true;
            while (flagCursor){

                if (cursor.isLast()){
                    flagCursor = false;
                }
                arrayListFundos.add(cursor.getInt(cursor.getColumnIndexOrThrow(CriaBanco.FUNDO)));
                arrayListCentros.add(cursor.getInt(cursor.getColumnIndexOrThrow(CriaBanco.CENTRO)));
                arrayListSons.add(cursor.getInt(cursor.getColumnIndexOrThrow(CriaBanco.SOM)));
                // arrayListSons.add(cursor.getColumnIndexOrThrow(CriaBanco.SOM));
                cursor.moveToNext();
            }

            mHandler.postDelayed(mRunNovaImagem, 00000);

        }

    }

    private Runnable mRunNovaImagem = new Runnable () {
        @Override
        public void run() {
            if (cont < arrayListFundos.size()){
                imgCentral.setImageResource(arrayListCentros.get(cont));
                //imgFundo.setImageResource(arrayListFundos.get(cont));
                mContentView.setBackgroundResource(arrayListFundos.get(cont));
                imgCentral.setAnimation(null);
                mContentView.setAnimation(null);
               //imgFundo.setAnimation(null);
                if(flagAudio){
                    mp = MediaPlayer.create(AnimationActivity.this, arrayListSons.get(cont));
                }
                mContentView.setClickable(false);
                mHandler.postDelayed(mRunInicial, 3000);
                startTimer();
            } else {
                Calendar calendar = new GregorianCalendar();
                final BancoControllerDatas crud2 = new BancoControllerDatas(getBaseContext());

                String resultado;

                Date dt = new Date();
                resultado = crud2.insereData(dt,1);

                //Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Toast toast = Toast.makeText(getApplicationContext(), "FIM",Toast.LENGTH_LONG);
                toast.show();

                SharedPreferences sharedPref = getSharedPreferences(
                        "venicius.evp.PREFERENCE_FILE_KEY",
                        Context.MODE_PRIVATE);

                //salvando configurações
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("banco",true);
                editor.apply();

                startActivity(intentMain);
            }
        }
    };

    //animação da imagem, ao tocar ou ao fim do tempo

    private void animarImagem(){
        Animation animZoomIn;
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);

        if(arrayListCentros.get(cont) == R.drawable.centro_transparente){
            mContentView.startAnimation(animZoomIn);
        } else {
            imgCentral.startAnimation(animZoomIn);
        }
        if(mp!=null) {
            mp.start();
        }
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
        super.onStop();
        cont=0;
        this.finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        cont=0;
        this.finish();
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        cont = 0;
        mp.stop();
        flagAudio=false;
        this.finish();


    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        cont = 0;
        mp.stop();
        flagAudio=false;
        this.finish();

    }

}


