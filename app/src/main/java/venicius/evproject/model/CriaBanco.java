package venicius.evproject.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class CriaBanco extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "sequencia";
    public static final String ID = "_id";
    public static final String FUNDO = "fundo";
    public static final String CENTRO = "centro";
    public static final String SOM = "som";
    public static final int VERSAO = 1;

    public CriaBanco(@Nullable Context context) {

        super(context, NOME_BANCO, null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA +"("
                + ID + " integer primary key autoincrement,"
                + FUNDO + " text,"
                + CENTRO + " text,"
                + SOM + " text"
                +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }


}
