package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PessoaDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public PessoaDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirPessoa(Pessoa pessoa) {
        ContentValues valores = new ContentValues();
        valores.put("nome", pessoa.getNome());
        valores.put("email", pessoa.getEmail());
        valores.put("dataNascimento", pessoa.getDataNascimento());
        return banco.insert("pessoa", null, valores);
    }

    public ArrayList<Pessoa> listarPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Cursor cursor = banco.query("pessoa", new String[]{"id", "nome", "email", "dataNascimento"},
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(cursor.getLong(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setEmail(cursor.getString(2));
            pessoa.setDataNascimento(cursor.getString(3));
            pessoas.add(pessoa);
        }
        cursor.close();
        return pessoas;
    }

    public int atualizarPessoa(Pessoa pessoa) {
        ContentValues valores = new ContentValues();
        valores.put("nome", pessoa.getNome());
        valores.put("email", pessoa.getEmail());
        valores.put("dataNascimento", pessoa.getDataNascimento());

        return banco.update("pessoa", valores, "id = ?", new String[]{String.valueOf(pessoa.getId())});
    }

    public void apagarPessoa(long id) {
        banco.delete("pessoa", "id = ?", new String[]{String.valueOf(id)});
    }

    public Pessoa buscarPessoaPorId(long id) {
        Cursor cursor = banco.query("pessoa", new String[]{"id", "nome", "email", "dataNascimento"},
                "id = ?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(cursor.getLong(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setEmail(cursor.getString(2));
            pessoa.setDataNascimento(cursor.getString(3));
            cursor.close();
            return pessoa;
        }
        return null;
    }

}
