package venicius.evproject;

import android.provider.BaseColumns;

public class SequenciaContract {


    private SequenciaContract() {}
    public static class SequenciaEntry implements BaseColumns {
        public static final String TABLE_NAME = "sequencia";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_FUNDO = "nomeImagemFundo";
        public static final String COLUMN_NAME_CENTRO = "nomeImagemCentro";
        public static final String COLUMN_NAME_SOM = "nomeImagemFundo";

    }
}
