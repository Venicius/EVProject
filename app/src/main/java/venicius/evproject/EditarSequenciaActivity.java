package venicius.evproject;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.datatype.Duration;

public class EditarSequenciaActivity extends AppCompatActivity {

    TextView numImagem;
    private ArrayList<FundoItem> mFundosList;
    private ArrayList<FundoItem> mCentrosList;
    private ArrayList<FundoItem> mSonsList;
    private FundoAdapter mAdapterFundos;
    private FundoAdapter mAdapterCentros;
    private FundoAdapter mAdapterSons;
    String clickedItemFundoNameFundo;
    String clickedItemFundoNameCentro;
    String clickedItemFundoNameSom;
    Button adicionar;

    SequenciaDbHelper mDbHelper;
    SQLiteDatabase db;
    ContentValues values;

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

        spinnerFundos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FundoItem clickedItem = (FundoItem) parent.getItemAtPosition(position);
                clickedItemFundoNameFundo = clickedItem.getFundoName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCentros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FundoItem clickedItem = (FundoItem) parent.getItemAtPosition(position);
                clickedItemFundoNameCentro = clickedItem.getFundoName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerSons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FundoItem clickedItem = (FundoItem) parent.getItemAtPosition(position);
                clickedItemFundoNameSom = clickedItem.getFundoName();
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


            }
        });

    }

    private void initListFundos() {
        mFundosList = new ArrayList<>();
        mFundosList.add(new FundoItem("fundo_alvo", R.drawable.fundo_alvo));
        mFundosList.add(new FundoItem("fundo_alvoazul_amarelo", R.drawable.fundo_alvoazul_amarelo));
        mFundosList.add(new FundoItem("fundo_alvovermelho_verde", R.drawable.fundo_alvovermelho_verde));
        mFundosList.add(new FundoItem("fundo_alvoxadrez", R.drawable.fundo_alvoxadrez));
    }

    private void initListCentros() {
        mCentrosList = new ArrayList<>();
        mCentrosList.add(new FundoItem("centro_boneco", R.drawable.centro_boneco));
        mCentrosList.add(new FundoItem("centro_cao", R.drawable.centro_cao));
        mCentrosList.add(new FundoItem("centro_cavalo", R.drawable.centro_cavalo));
        mCentrosList.add(new FundoItem("centro_galinho", R.drawable.centro_galinho));
    }

    private void initListSons() {
        mSonsList = new ArrayList<>();
        mSonsList.add(new FundoItem("som_cao", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_cavalo", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_galinho", R.drawable.ic_son));
        mSonsList.add(new FundoItem("som_padrao", R.drawable.ic_son));
    }


}
