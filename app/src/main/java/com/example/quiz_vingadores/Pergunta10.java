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

public class Pergunta10 extends AppCompatActivity {

    TextView txNome;
    Button btProxima;
    RadioGroup rgPergunta;
    String nome;
    int ponto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta10);

        txNome = findViewById(R.id.txtNome);
        btProxima = findViewById(R.id.btnProxima10);
        rgPergunta = findViewById(R.id.rgpPergunta10);

        Intent abrirPergunta10 = getIntent();
        Bundle valor = abrirPergunta10.getExtras();
        nome = valor.getString("nome");
        ponto = valor.getInt("ponto");
        txNome.setText(nome);

        btProxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int escolha;
                escolha = rgPergunta.getCheckedRadioButtonId();

                if (escolha == R.id.rbtC10) {
                    ponto = ponto + 1;
                }

                AlertDialog.Builder resposta = new AlertDialog.Builder(Pergunta10.this);
                resposta.setTitle("Resposta correta:");
                resposta.setMessage("Alternativa (C). A Viúva negra é russa!");
                resposta.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent abrirResultado = new Intent(Pergunta10.this, Resultado.class);
                        abrirResultado.putExtra("ponto", ponto);
                        abrirResultado.putExtra("nome", nome);
                        startActivity(abrirResultado);
                    }
                });
                resposta.setCancelable(false);
                resposta.show();
            }
        });

    }
    public void onBackPressed(){
        AlertDialog.Builder mensagem = new AlertDialog.Builder(Pergunta10.this);
        mensagem.setTitle("Confirmar");
        mensagem.setMessage("Realmente deseja voltar para o início?");
        mensagem.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent abrirMain = new Intent(Pergunta10.this, MainActivity.class);
                startActivity(abrirMain);
                finish();
            }
        });
        mensagem.setNegativeButton("Não", null);
        mensagem.setCancelable(false);
        mensagem.show();
    }
}