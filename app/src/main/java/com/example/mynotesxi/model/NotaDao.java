package com.example.mynotesxi.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {

    SQLiteDatabase sqLiteDatabase;

    public NotaDao(Context context) {
        sqLiteDatabase = context.openOrCreateDatabase("bd", Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS nota ( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo varchar, " +
                "txt varchar)");
    }



    public Nota insertNota(Nota nota){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("txt", nota.getTxt());
        nota.setId((int)sqLiteDatabase.insert("nota", null, contentValues));
        return nota;
    }
    public Nota updateNota (Nota nota){
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("txt", nota.getTxt());
        sqLiteDatabase.update("nota", contentValues, "id=?", new String[] {Integer.toString(nota.getId())});
        return nota;
    }
    public boolean deleteNota (Nota nota){
        sqLiteDatabase.delete("nota", "id=?", new String[] {Integer.toString(nota.getId())});
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
    @SuppressLint("Range")
    public Nota getNota(int id){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM nota WHERE id="+id, null);
        cursor.moveToFirst();
        return new Nota(cursor.getInt(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("titulo")),
                cursor.getString(cursor.getColumnIndex("txt")));
    }

}
