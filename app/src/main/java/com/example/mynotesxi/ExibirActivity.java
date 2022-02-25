package com.example.mynotesxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotesxi.controller.NotaController;
import com.example.mynotesxi.model.Nota;

public class ExibirActivity extends AppCompatActivity {
    NotaController mNotaController;
    Nota mNota;
    EditText edTitulo, edTxt;
    Button btnSalvar, btnExcluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        mNotaController = new NotaController(getApplicationContext());
        mNota = mNotaController.getNota(getIntent().getExtras().getInt("id"));
        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirNota();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                salvar();
            }
        });
    }

    private void excluirNota() {
        mNotaController.deleteNota(mNota);
    }

    private void salvar() {
        mNota.setTitulo(edTitulo.getText().toString());
        mNota.setTxt(edTitulo.getText().toString());
        mNotaController.updateNota(mNota);
    }

    @Override
    protected void onStart(){
        super.onStart();
        edTitulo.setText(mNota.getTitulo());
        edTxt.setText(mNota.getTxt());
    }

}