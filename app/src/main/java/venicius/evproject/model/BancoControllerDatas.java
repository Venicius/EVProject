package venicius.evproject.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoControllerDatas {

    private SQLiteDatabase db;
    private CriaBancoDatas banco;

    public BancoControllerDatas(Context context){
        banco = new CriaBancoDatas(context);
    }

    public String insereData(String dia, int feito){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.DIA, dia);
        valores.put(CriaBanco.FEITO, feito);

        resultado = db.insert(CriaBanco.TABELADATAS, null, valores);
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
