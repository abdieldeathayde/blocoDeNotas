package com.example.mynotesxi.controller;

import android.content.Context;

import com.example.mynotesxi.model.Nota;
import com.example.mynotesxi.model.NotaDao;

import java.util.ArrayList;

public class NotaController {

    NotaDao mNotaDao;

    public NotaController(Context context) {
        //this.mNotaDao = mNotaDao;
        mNotaDao = new NotaDao(context);
    }



    public void cadastrarNota(Nota nota){
        mNotaDao.insertNota(nota);
    }
    public void  updateNota(Nota mNota){
        mNotaDao.updateNota(mNota);

    }
    public void deleteNota(Nota mNota){
        mNotaDao.deleteNota(mNota);


    }
    public ArrayList<Nota> getAllNote(){
        return mNotaDao.getAllNotes();
    }

    public ArrayList<String> getAllTitlesNotes(){
        ArrayList<String> stringArrayListTitulos = new ArrayList<String>();
        for (Nota n: getAllNote()){
            stringArrayListTitulos.add(n.getTitulo());
        }
        return stringArrayListTitulos;
    }


    public Nota getNota(int id){
        return mNotaDao.getNota(id);
    }


}
