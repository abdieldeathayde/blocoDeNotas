package com.example.mynotesxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotesxi.controller.NotaController;
import com.example.mynotesxi.model.Nota;

public class ExibirActivity extends AppCompatActivity {
    NotaController mNotaControler;
    Nota mNota;
    EditText edTitulo, edTxt;
    Button btnSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        mNotaControler = new NotaController(getApplicationContext());
        mNota = mNotaControler.getNota(getIntent().getExtras().getInt("id"));
        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener();
    }
    @Override
    protected void onStart(){
        super.onStart();
        edTitulo.setText(mNota.getTitulo());
        edTxt.setText(mNota.getTxt());
    }

}