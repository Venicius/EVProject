package venicius.evproject.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import venicius.evproject.R;
import venicius.evproject.model.BancoController;
import venicius.evproject.view.FundoAdapter;
import venicius.evproject.view.FundoItem;

public class EditarSequenciaActivity extends AppCompatActivity {

    TextView numImagem;
    private ArrayList<FundoItem> mFundosList;
    private ArrayList<FundoItem> mCentrosList;
    private ArrayList<FundoItem> mSonsList;
    private FundoAdapter mAdapterFundos;
    private FundoAdapter mAdapterCentros;
    private FundoAdapter mAdapterSons;
    int clickedItemFundoNameFundo;
    int clickedItemFundoNameCentro;
    int clickedItemFundoNameSom;
    Button adicionar;
    Button finalizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_sequencia);

        numImagem = (TextView) findViewById(R.id.numeroImagem);
        initListFundos();
        initListCentros();
        initListSons();

        final Spinner spinnerFundos = (Spinner) findViewById(R.id.spinnerFundos);
        Spinner spinnerCentros = (Spinner) findViewById(R.id.spinnerCentros);
        Spinner spinnerSons = (Spinner) findViewById(R.id.spinnerSons);

        mAdapterFundos = new FundoAdapter(this, mFundosList);
        spinnerFundos.setAdapter(mAdapterFundos);
        mAdapterCentros = new FundoAdapter(this, mCentrosList);
        spinnerCentros.setAdapter(mAdapterCentros);
        mAdapterSons = new FundoAdapter(this, mSonsList);
        spinnerSons.setAdapter(mAdapterSons);

        final BancoController crud = new BancoController(getBaseContext());
        crud.deletaLinhas();

        spinnerFundos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FundoItem clickedItem = (FundoItem) parent.getItemAtPosition(position);
                clickedItemFundoNameFundo = clickedItem.getFlagImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCentros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FundoItem clickedItem = (FundoItem) parent.getItemAtPosition(position);
                clickedItemFundoNameCentro = clickedItem.getFlagImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FundoItem clickedItem = (FundoItem) parent.getItemAtPosition(position);
                clickedItemFundoNameSom = clickedItem.getFlagImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adicionar = (Button) findViewById(R.id.btnAdicionar);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Imagem " + numImagem.getText() +" adicionada!",Toast.LENGTH_SHORT);
                toast.show();
               int i= Integer.valueOf(numImagem.getText().toString());
               i=i+1;
                numImagem.setText(String.valueOf(i));
                String resultado;
                resultado = crud.insereDado(clickedItemFundoNameFundo,clickedItemFundoNameCentro,clickedItemFundoNameSom);

               // Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }
        });

        finalizar = (Button) findViewById(R.id.btnFinalizarSequencia);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  SharedPreferences sharedPref = getSharedPreferences(
                        "venicius.evp.PREFERENCE_FILE_KEY",
                        Context.MODE_PRIVATE);

                //salvando configurações
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("sequencia",true);
                editor.apply(); */



             }
        });




    }

    private void initListFundos() {
        mFundosList = new ArrayList<>();
        mFundosList.add(new FundoItem("fundo_alvo", R.drawable.icone_fundo_alvo));
        mFundosList.add(new FundoItem("fundo_amarelo", R.drawable.icone_fundo_amarelo));
        mFundosList.add(new FundoItem("fundo_vermelho", R.drawable.icone_fundo_vermelho));
        mFundosList.add(new FundoItem("fundo_xadrez", R.drawable.icone_fundo_xadrez));
        mFundosList.add(new FundoItem("fundo_azul", R.drawable.icone_fundo_azul));
        mFundosList.add(new FundoItem("fundo_verdelimao", R.drawable.icone_fundo_verdelimao));
    }

    private void initListCentros() {
        mCentrosList = new ArrayList<>();
        mCentrosList.add(new FundoItem("centro_boneco", R.drawable.centro_boneco));
        mCentrosList.add(new FundoItem("centro_cao", R.drawable.centro_cao));
        mCentrosList.add(new FundoItem("centro_cavalo", R.drawable.centro_cavalo));
        mCentrosList.add(new FundoItem("centro_galinho", R.drawable.centro_galinho));
        mCentrosList.add(new FundoItem("centro_rostoamarelofeliz", R.drawable.centro_rostoamarelofeliz));
        mCentrosList.add(new FundoItem("centro_panda", R.drawable.centro_panda));
        mCentrosList.add(new FundoItem("centro_rostoamarelofeliz2", R.drawable.centro_rostoamarelofeliz2));
        mCentrosList.add(new FundoItem("centro_macaco", R.drawable.centro_macaco));
        mCentrosList.add(new FundoItem("centro_tigre", R.drawable.centro_tigre));
        mCentrosList.add(new FundoItem("centro_pintinho", R.drawable.centro_pintinho));
        mCentrosList.add(new FundoItem("centro_rostovermelho", R.drawable.centro_rostovermelho));
        mCentrosList.add(new FundoItem("centro_rostoamarelofeliz3", R.drawable.centro_rostoamarelofeliz3));
        mCentrosList.add(new FundoItem("centro_sapo", R.drawable.centro_sapo));
        mCentrosList.add(new FundoItem("centro_girafa", R.drawable.centro_girafa));
        mCentrosList.add(new FundoItem("centro_caracolvermelho", R.drawable.centro_caracolvermelho));
        mCentrosList.add(new FundoItem("centro_garoto1", R.drawable.centro_garoto1));
        mCentrosList.add(new FundoItem("centro_garoto2", R.drawable.centro_garoto2));
        mCentrosList.add(new FundoItem("centro_guaxinin", R.drawable.centro_guaxinin));
        mCentrosList.add(new FundoItem("centro_rostoverde", R.drawable.centro_rostoverde));
        mCentrosList.add(new FundoItem("centro_lagarta", R.drawable.centro_lagarta));
        mCentrosList.add(new FundoItem("centro_porco", R.drawable.centro_porco));
        mCentrosList.add(new FundoItem("centro_cao", R.drawable.centro_cao));
        mCentrosList.add(new FundoItem("centro_garoto3", R.drawable.centro_garoto3));
        mCentrosList.add(new FundoItem("centro_pinguin", R.drawable.centro_pinguin));
        mCentrosList.add(new FundoItem("centro_menina1", R.drawable.centro_menina1));
    }

    private void initListSons() {
        mSonsList = new ArrayList<>();
        mSonsList.add(new FundoItem("som_padrao", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_cao", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_cavalo", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_galinho", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_rostinhoamarelofeliz", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_panda", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_macaco", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_tigre", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_pintinho", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_sapo", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_guaxinin", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_porco", R.drawable.ic_son));
    }


}
