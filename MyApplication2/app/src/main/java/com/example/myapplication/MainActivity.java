package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaPessoas;
    private PessoaDAO dao;
    private ArrayList<Pessoa> pessoas;
    private MeuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        dao = new PessoaDAO(this);
        pessoas = dao.listarPessoas();

        listaPessoas = findViewById(R.id.listaPessoas);

        adapter = new MeuAdapter(this, pessoas);
        listaPessoas.setAdapter(adapter);

        Button cadastrarPessoa = findViewById(R.id.cadastrarPessoa);
        cadastrarPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastrarPessoa.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        pessoas.clear();
        pessoas.addAll(dao.listarPessoas());
        adapter.notifyDataSetChanged();
    }
}