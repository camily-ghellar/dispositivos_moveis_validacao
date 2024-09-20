package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EditarPessoa extends AppCompatActivity {

    private EditText nome, email, dataNascimento;
    private PessoaDAO dao;
    private long idPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pessoa);

        nome = findViewById(R.id.name);
        email = findViewById(R.id.email);
        dataNascimento = findViewById(R.id.birthDate);

        dao = new PessoaDAO(this);
        idPessoa = getIntent().getLongExtra("id", -1);

        carregarDados(idPessoa);
    }

    private void carregarDados(long id) {
        Pessoa pessoa = dao.buscarPessoaPorId(id);
        if (pessoa != null) {
            nome.setText(pessoa.getNome());
            email.setText(pessoa.getEmail());
            dataNascimento.setText(pessoa.getDataNascimento());
        }
    }

    public void editarPessoa(View view) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(idPessoa);
        pessoa.setNome(nome.getText().toString());
        pessoa.setEmail(email.getText().toString());
        pessoa.setDataNascimento(dataNascimento.getText().toString());


        dao.atualizarPessoa(pessoa);
        Toast.makeText(this, "Pessoa editada com sucesso!", Toast.LENGTH_LONG).show();
        finish();
    }

}
