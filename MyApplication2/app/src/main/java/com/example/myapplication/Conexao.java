package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bancoSQL.db";
    private static final int VERSAO_BANCO = 6;
    public static final String TABELA_PESSOA = "pessoa";

    public Conexao(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABELA_PESSOA + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, email TEXT, dataNascimento TEXT, foto BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PESSOA);
        onCreate(db);
    }
}
