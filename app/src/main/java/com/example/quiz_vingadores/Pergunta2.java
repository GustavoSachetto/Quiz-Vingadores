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

public class Pergunta2 extends AppCompatActivity {

    TextView txNome;
    Button btProxima;
    RadioGroup rgPergunta;
    String nome;
    int ponto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta2);

        txNome = findViewById(R.id.txtNome);
        btProxima = findViewById(R.id.btnProxima2);
        rgPergunta = findViewById(R.id.rgpPergunta2);

        Intent abrirPergunta2 = getIntent();
        Bundle valor = abrirPergunta2.getExtras();
        nome = valor.getString("nome");
        ponto = valor.getInt("ponto");
        txNome.setText(nome);

        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolha;
                escolha = rgPergunta.getCheckedRadioButtonId();

                if (escolha == R.id.rbtA2) {
                    ponto = ponto + 1;
                }

                AlertDialog.Builder resposta = new AlertDialog.Builder(Pergunta2.this);
                resposta.setTitle("Resposta correta:");
                resposta.setMessage("Alternativa (A). No começo do filme a Viuva negra procura Bruce Benner no local onde ele se esconde!");
                resposta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent abrirPergunta3 = new Intent(Pergunta2.this, Pergunta3.class);
                        abrirPergunta3.putExtra("ponto", ponto);
                        abrirPergunta3.putExtra("nome", nome);
                        startActivity(abrirPergunta3);
                    }
                });
                resposta.setCancelable(false);
                resposta.show();
            }
        });
    }
    public void onBackPressed(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(Pergunta2.this);
        mensagem.setTitle("Confirmar");
        mensagem.setMessage("Realmente deseja voltar para o início?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent abrirMain = new Intent(Pergunta2.this, MainActivity.class);
                startActivity(abrirMain);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", null);
        mensagem.setCancelable(false);
        mensagem.show();
    }
}