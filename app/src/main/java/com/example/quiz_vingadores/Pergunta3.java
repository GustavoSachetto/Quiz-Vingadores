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

public class Pergunta3 extends AppCompatActivity {

    TextView txNome;
    Button btProxima;
    RadioGroup rgPergunta;
    String nome;
    int ponto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta3);

        txNome = findViewById(R.id.txtNome);
        btProxima = findViewById(R.id.btnProxima3);
        rgPergunta = findViewById(R.id.rgpPergunta3);

        Intent abrirPergunta3 = getIntent();
        Bundle valor = abrirPergunta3.getExtras();
        nome = valor.getString("nome");
        ponto = valor.getInt("ponto");
        txNome.setText(nome);

        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolha;
                escolha = rgPergunta.getCheckedRadioButtonId();

                if (escolha == R.id.rbtB3) {
                    ponto = ponto + 1;
                }

                AlertDialog.Builder resposta = new AlertDialog.Builder(Pergunta3.this);
                resposta.setTitle("Resposta correta:");
                resposta.setMessage("Alternativa (B). Ele aparece no final do filme em um telejornal!");
                resposta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent abrirPergunta4 = new Intent(Pergunta3.this, Pergunta4.class);
                        abrirPergunta4.putExtra("ponto", ponto);
                        abrirPergunta4.putExtra("nome", nome);
                        startActivity(abrirPergunta4);
                    }
                });
                resposta.setCancelable(false);
                resposta.show();
            }
        });
    }
    public void onBackPressed(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(Pergunta3.this);
        mensagem.setTitle("Confirmar");
        mensagem.setMessage("Realmente deseja voltar para o início?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent abrirMain = new Intent(Pergunta3.this, MainActivity.class);
                startActivity(abrirMain);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", null);
        mensagem.setCancelable(false);
        mensagem.show();
    }
}