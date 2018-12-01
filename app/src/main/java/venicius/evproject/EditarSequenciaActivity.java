package venicius.evproject;

import android.app.ProgressDialog;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_sequencia);

        initListFundos();
        initListCentros();
        initListSons();

        Spinner spinnerFundos = findViewById(R.id.spinnerFundos);
        Spinner spinnerCentros = findViewById(R.id.spinnerCentros);
        Spinner spinnerSons = findViewById(R.id.spinnerSons);

        mAdapterFundos = new FundoAdapter(this, mFundosList);
        spinnerFundos.setAdapter(mAdapterFundos);
        mAdapterCentros = new FundoAdapter(this, mCentrosList);
        spinnerCentros.setAdapter(mAdapterCentros);
        mAdapterSons = new FundoAdapter(this, mSonsList);
        spinnerSons.setAdapter(mAdapterSons);

    }

    private void initListFundos() {
        mFundosList = new ArrayList<>();
        mFundosList.add(new FundoItem("India", R.drawable.fundo_alvo));
        mFundosList.add(new FundoItem("China", R.drawable.fundo_alvoazul_amarelo));
        mFundosList.add(new FundoItem("USA", R.drawable.fundo_alvovermelho_verde));
        mFundosList.add(new FundoItem("Germany", R.drawable.fundo_alvoxadrez));
    }

    private void initListCentros() {
        mCentrosList = new ArrayList<>();
        mCentrosList.add(new FundoItem("India", R.drawable.fundo_alvo));
        mCentrosList.add(new FundoItem("China", R.drawable.fundo_alvoazul_amarelo));
        mCentrosList.add(new FundoItem("USA", R.drawable.fundo_alvovermelho_verde));
        mCentrosList.add(new FundoItem("Germany", R.drawable.fundo_alvoxadrez));
    }

    private void initListSons() {
        mSonsList = new ArrayList<>();
        mSonsList.add(new FundoItem("India", R.drawable.ic_son));
        mSonsList.add(new FundoItem("China", R.drawable.ic_son));
        mSonsList.add(new FundoItem("USA", R.drawable.ic_son));
        mSonsList.add(new FundoItem("Germany", R.drawable.ic_son));
    }



}
