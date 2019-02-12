package venicius.evproject.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BancoControllerDatas {

    private SQLiteDatabase db;
    private CriaBancoDatas banco;

    public BancoControllerDatas(Context context){
        banco = new CriaBancoDatas(context);
    }

    public String insereData(Date dia, int feito){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        valores.put("data", dateFormat.format(dia));
        db.insert(CriaBancoDatas.TABELADATAS, null, valores);

        resultado = db.insert(CriaBancoDatas.TABELADATAS, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.DIA,banco.FEITO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELADATAS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void deletaLinhas(){
        db = banco.getReadableDatabase();
        db.delete(CriaBancoDatas.TABELADATAS,null,null);
        db.close();

    }



}
