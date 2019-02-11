package venicius.evproject.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;


public class CriaBancoDatas extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "bancodatas.db";
       public static final String TABELADATAS = "datas";
    public static final String ID = "_id";

    public static final String DIA = "data";
    public static final String FEITO = "feito";

    public static final int VERSAO = 1;

    public CriaBancoDatas(@Nullable Context context) {
        super(context, NOME_BANCO, null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqldatas = "CREATE TABLE " + TABELADATAS +"("
                + ID + " integer primary key autoincrement,"
                + DIA + " string,"
                + FEITO + " integer"
                +")";

        db.execSQL(sqldatas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELADATAS);
        onCreate(db);
    }


}
