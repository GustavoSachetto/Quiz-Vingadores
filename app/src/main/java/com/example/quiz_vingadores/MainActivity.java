package com.example.quiz_vingadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btJogar, btInstrucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btJogar = findViewById(R.id.btnJogar);
        btInstrucao = findViewById(R.id.btnInstrucao);

        btJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirIniciarQuiz = new Intent(MainActivity.this, IniciarQuiz.class);
                startActivity(abrirIniciarQuiz);
            }
        });

        btInstrucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirInstrucoes = new Intent(MainActivity.this, Instrucoes.class);
                startActivity(abrirInstrucoes);
            }
        });
    }
    public void onBackPressed() {
        finishAffinity();
    }
}