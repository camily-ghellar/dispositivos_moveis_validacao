package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MeuAdapter extends ArrayAdapter<Pessoa> {

    private PessoaDAO dao;

    public MeuAdapter(@NonNull Context context, ArrayList<Pessoa> pessoas) {
        super(context, 0, pessoas);
        dao = new PessoaDAO(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pessoa_celula, parent, false);
        }

        final Pessoa pessoa = getItem(position);
        TextView nome = convertView.findViewById(R.id.nome);
        TextView email = convertView.findViewById(R.id.email);
        Button excluir = convertView.findViewById(R.id.excluir);
        Button editar = convertView.findViewById(R.id.editar);

        nome.setText(pessoa.getNome());
        email.setText(pessoa.getEmail());

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.apagarPessoa(pessoa.getId());
                remove(pessoa);
                notifyDataSetChanged();
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditarPessoa.class);
                intent.putExtra("id", pessoa.getId());
                getContext().startActivity(intent);
            }
        });


        return convertView;
    }
}
