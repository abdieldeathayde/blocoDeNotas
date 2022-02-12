package com.example.mynotesxi.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    public NotaDao(Context context) {
        sqLiteDatabase = context.openOrCreateDatabase("bd", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nota ( id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "titulo varchar, " +
                "txt varchar)");
    }

    SQLiteDatabase sqLiteDatabase;

    public Nota insertNota(Nota nota){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("txt", nota.getTxt());
        nota.setId((int)sqLiteDatabase.insert("nota", null, contentValues));
        return nota;
    }
    public Nota updateNota (Nota nota){
        return new Nota("a", "a");
    }
    public boolean deleteNota (Nota nota){
        return true;
    }
    @SuppressLint("Range")
    public ArrayList<Nota> getAllNotes(){
        ArrayList<Nota> notaArrayList = new ArrayList<Nota>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM nota", null);
        cursor.moveToFirst();

        do{

            notaArrayList.add(new Nota(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("titulo")),
                    cursor.getString(cursor.getColumnIndex("txt"))));
        } while(cursor.moveToNext());
        return notaArrayList;
    }
    public Nota getNota(int id){
        return new Nota("a", "a");
    }

}
