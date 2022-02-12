package com.example.mynotesxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotesxi.controller.NotaController;
import com.example.mynotesxi.model.Nota;

public class CadastrarActivity extends AppCompatActivity {

    EditText edTitulo, edTxt;
    Nota mNote;
    NotaController mNoteController;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        btnCadastrar = findViewById(R.id.btnSalvar);
        mNoteController = new NotaController(getApplicationContext());
        mNote = new Nota(edTitulo.getText().toString(), edTxt.getText().toString());
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastraNota();
            }
        });
    }


    private void cadastraNota() {
        mNote.setTitulo(edTitulo.getText().toString());
        mNote.setTxt(edTxt.getText().toString());
        mNoteController.cadastrarNota(mNote);
    }
}