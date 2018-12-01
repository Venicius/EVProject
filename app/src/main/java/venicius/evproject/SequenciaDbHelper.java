package venicius.evproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SequenciaDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_POSTS =
            "CREATE TABLE " + SequenciaContract.SequenciaEntry.TABLE_NAME + " (" +
                    SequenciaContract.SequenciaEntry._ID + " INTEGER PRIMARY KEY," +
                    SequenciaContract.SequenciaEntry.COLUMN_NAME_ID + TEXT_TYPE + COMMA_SEP +
                    SequenciaContract.SequenciaEntry.COLUMN_NAME_FUNDO + TEXT_TYPE + COMMA_SEP +
                    SequenciaContract.SequenciaEntry.COLUMN_NAME_CENTRO + TEXT_TYPE + COMMA_SEP +
                    SequenciaContract.SequenciaEntry.COLUMN_NAME_SOM + TEXT_TYPE + " )";

    private static final String SQL_DELETE_POSTS =
            "DROP TABLE IF EXISTS " + SequenciaContract.SequenciaEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sequencias.db";

    public SequenciaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_POSTS);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_POSTS);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
