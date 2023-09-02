package com.example.quiz_vingadores;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView txParabens, txResultado;
    Button btReiniciar;

    String nome;

    int ponto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txParabens = findViewById(R.id.txtParabens);
        txResultado = findViewById(R.id.txtResultado);
        btReiniciar = findViewById(R.id.btnReiniciar);

        Intent abrirResultado = getIntent();
        Bundle valor = abrirResultado.getExtras();

        ponto = valor.getInt("ponto");
        nome = valor.getString("nome");

        if (ponto > 10) {
            ponto = 10;
        }

        txParabens.setText("Parabéns " + nome + "!");
        txResultado.setText(String.valueOf(ponto) + " Perguntas");

        btReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirMain = new Intent(Resultado.this, MainActivity.class);
                startActivity(abrirMain);
            }
        });

    }
    public void onBackPressed(){
        Intent abrirMain = new Intent(Resultado.this, MainActivity.class);
        startActivity(abrirMain);
    }
}