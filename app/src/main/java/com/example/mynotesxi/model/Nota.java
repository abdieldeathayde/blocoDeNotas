package com.example.mynotesxi.model;

public class Nota {

    int id;
    String titulo, txt;

    public Nota(int id, String titulo, String txt) {
        this.id = id;
        this.titulo = titulo;
        this.txt = txt;
    }

    public Nota(String titulo, String txt) {
        this.titulo = titulo;
        this.txt = txt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }



}
