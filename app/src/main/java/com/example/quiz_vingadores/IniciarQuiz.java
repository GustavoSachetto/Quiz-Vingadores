package com.example.quiz_vingadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IniciarQuiz extends AppCompatActivity {

    EditText edNome;
    Button btIniciar;
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_quiz);

        edNome = findViewById(R.id.edtNome);
        btIniciar = findViewById(R.id.btnIniciar);

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edNome.getText().toString().isEmpty()) {
                    edNome.setError("Nome obrigatório!");
                    edNome.requestFocus();
                } else {
                    nome = edNome.getText().toString();
                    Intent abrirPergunta1 = new Intent(IniciarQuiz.this, Pergunta1.class);
                    abrirPergunta1.putExtra("nome", nome);
                    startActivity(abrirPergunta1);
                }
            }
        });
    }
}