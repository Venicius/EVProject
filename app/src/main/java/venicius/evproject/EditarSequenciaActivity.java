package venicius.evproject;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditarSequenciaActivity extends AppCompatActivity {

    private ArrayList<FundoItem> mFundosList;
    private ArrayList<FundoItem> mCentrosList;
    private ArrayList<FundoItem> mSonsList;
    private FundoAdapter mAdapterFundos;
    private FundoAdapter mAdapterCentros;
    private FundoAdapter mAdapterSons;
    String clickedItemFundoName;
    Button adicionar;

    SequenciaDbHelper mDbHelper;
    SQLiteDatabase db;
    ContentValues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_sequencia);

        mDbHelper = new SequenciaDbHelper(this);
        db = mDbHelper.getWritableDatabase();
        values = new ContentValues();



        initListFundos();
        initListCentros();
        initListSons();

        final Spinner spinnerFundos = findViewById(R.id.spinnerFundos);
        Spinner spinnerCentros = findViewById(R.id.spinnerCentros);
        Spinner spinnerSons = findViewById(R.id.spinnerSons);

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
                clickedItemFundoName = clickedItem.getFundoName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adicionar = (Button) findViewById(R.id.btnAdicionar);
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                values.put(SequenciaContract.SequenciaEntry.COLUMN_NAME_FUNDO, "");
                values.put(SequenciaContract.SequenciaEntry.COLUMN_NAME_CENTRO, "");
                values.put(SequenciaContract.SequenciaEntry.COLUMN_NAME_SOM, "");

                long newRowId = db.insert(SequenciaContract.SequenciaEntry.TABLE_NAME, null, values);

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
