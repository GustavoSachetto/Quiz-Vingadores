package com.example.quiz_vingadores;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pergunta5 extends AppCompatActivity {

    TextView txNome;
    Button btProxima;
    RadioGroup rgPergunta;
    String nome;
    int ponto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta5);

        txNome = findViewById(R.id.txtNome);
        btProxima = findViewById(R.id.btnProxima5);
        rgPergunta = findViewById(R.id.rgpPergunta5);

        Intent abrirPergunta5 = getIntent();
        Bundle valor = abrirPergunta5.getExtras();
        nome = valor.getString("nome");
        ponto = valor.getInt("ponto");
        txNome.setText(nome);

        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolha;
                escolha = rgPergunta.getCheckedRadioButtonId();

                if (escolha == R.id.rbtC5) {
                    ponto = ponto + 1;
                }

                AlertDialog.Builder resposta = new AlertDialog.Builder(Pergunta5.this);
                resposta.setTitle("Resposta correta:");
                resposta.setMessage("Alternativa (C). O heroi a não chamado é Thor, afinal ele só vai para terra a procura de seu foragido irmão!");
                resposta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent abrirPergunta6 = new Intent(Pergunta5.this, Pergunta6.class);
                        abrirPergunta6.putExtra("ponto", ponto);
                        abrirPergunta6.putExtra("nome", nome);
                        startActivity(abrirPergunta6);
                    }
                });
                resposta.setCancelable(false);
                resposta.show();
            }
        });

    }
    public void onBackPressed(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(Pergunta5.this);
        mensagem.setTitle("Confirmar");
        mensagem.setMessage("Realmente deseja voltar para o início?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent abrirMain = new Intent(Pergunta5.this, MainActivity.class);
                startActivity(abrirMain);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", null);
        mensagem.setCancelable(false);
        mensagem.show();
    }
}