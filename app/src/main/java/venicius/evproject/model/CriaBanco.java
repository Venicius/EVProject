package venicius.evproject.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;


public class CriaBanco extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "sequencia";
    public static final String TABELADATAS = "datas";
    public static final String ID = "_id";
    public static final String FUNDO = "fundo";
    public static final String CENTRO = "centro";
    public static final String SOM = "som";
    public static final String DIA = "data";
    public static final String FEITO = "feito";
    public static final String ID2 = "_id2";
    public static final int VERSAO = 1;

    public CriaBanco(@Nullable Context context) {
        super(context, NOME_BANCO, null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA +"("
                + ID + " integer primary key autoincrement,"
                + FUNDO + " integer,"
                + CENTRO + " integer,"
                + SOM + " integer"
                +")";

        String sqldatas = "CREATE TABLE " + TABELADATAS +"("
                + ID2 + " integer primary key autoincrement,"
                + DIA + " integer,"
                + FEITO + " integer"
                +")";

       db.execSQL(sql);
        db.execSQL(sqldatas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }


}
