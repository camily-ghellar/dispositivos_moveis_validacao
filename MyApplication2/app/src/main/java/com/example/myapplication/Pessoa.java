package com.example.myapplication;

import android.graphics.Bitmap;

public class Pessoa {

    private long id;
    private String nome;
    private String email;
    private String dataNascimento;
    private byte[] fotoBitmap;


    public byte[] getFotoBitmap() {
        return fotoBitmap;
    }

    public void setFotoBitmap(byte[] fotoBitmap) {
        this.fotoBitmap = fotoBitmap;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}