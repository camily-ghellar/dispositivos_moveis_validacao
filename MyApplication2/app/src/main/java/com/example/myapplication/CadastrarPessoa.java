package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CadastrarPessoa extends AppCompatActivity {

    private EditText nome, email, dataNascimento;
    private PessoaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pessoa);

        nome = findViewById(R.id.name);
        email = findViewById(R.id.email);
        dataNascimento = findViewById(R.id.birthDate);

        dao = new PessoaDAO(this);

        findViewById(R.id.cadastrarPessoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarPessoa();
            }
        });
    }

    private void cadastrarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome.getText().toString());
        pessoa.setEmail(email.getText().toString());
        pessoa.setDataNascimento(dataNascimento.getText().toString());

        dao.inserirPessoa(pessoa);
        Toast.makeText(this, "Pessoa cadastrada com sucesso!", Toast.LENGTH_LONG).show();
        finish();
    }

}
