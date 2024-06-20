package com.arthur.semaforobrabo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class SemaforoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewTitulo;
    private Switch switchTodosOsLeds;
    private Switch switchLedVermelho;
    private Switch switchLedAmarelo;
    private Switch switchLedVerde;
    private Button buttonVermelho;
    private Button buttonAmarelo;
    private Button buttonVerde;
    private Button buttonDeslogar;

    private SharedPreferences sp;

    private ImageButton imageButtonDuvidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semaforo);

        textViewTitulo = findViewById(R.id.textViewTitulo);

        switchTodosOsLeds = findViewById(R.id.switchTodosOsLeds);
        switchLedVermelho = findViewById(R.id.switchLedVermelho);
        switchLedAmarelo = findViewById(R.id.switchLedAmarelo);
        switchLedVerde = findViewById(R.id.switchLedVerde);

        buttonVermelho = findViewById(R.id.buttonVermelho);
        buttonAmarelo = findViewById(R.id.buttonAmarelo);
        buttonVerde = findViewById(R.id.buttonVerde);
        buttonDeslogar = findViewById(R.id.buttonDeslogar);

        imageButtonDuvidas = findViewById(R.id.imageButtonDuvidas);

        buttonVermelho.setOnClickListener(this);
        buttonAmarelo.setOnClickListener(this);
        buttonVerde.setOnClickListener(this);
        buttonDeslogar.setOnClickListener(this);

        imageButtonDuvidas.setOnClickListener(this);

        sp = getSharedPreferences("arquivo_conf", Context.MODE_PRIVATE);

        eventoSwitch();
        eventoVermelho();
        eventoAmarelo();
        eventoVerde();
        alterarTitulo();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonDeslogar) {
            deleteSharedPreferences("arquivo_conf");
            this.fecharTela();
        } else if (view.getId() == R.id.imageButtonDuvidas) {
            this.irTelaDuvidas();
        }
    }

    private void eventoSwitch() {
        switchTodosOsLeds.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonVermelho.setBackgroundTintList(getColorStateList(R.color.vermelho));
                    buttonAmarelo.setBackgroundTintList(getColorStateList(R.color.amarelo));
                    buttonVerde.setBackgroundTintList(getColorStateList(R.color.verde));
                } else {
                    buttonVermelho.setBackgroundTintList(getColorStateList(R.color.cinza));
                    buttonAmarelo.setBackgroundTintList(getColorStateList(R.color.cinza));
                    buttonVerde.setBackgroundTintList(getColorStateList(R.color.cinza));
                }
            }
        });
    }


    private void eventoVermelho() {
        switchLedVermelho.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonVermelho.setBackgroundTintList(getColorStateList(R.color.vermelho));
                } else {
                    buttonVermelho.setBackgroundTintList(getColorStateList(R.color.cinza));
                }
            }
        });
    }

    private void eventoAmarelo() {
        switchLedAmarelo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonAmarelo.setBackgroundTintList(getColorStateList(R.color.amarelo));
                } else {
                    buttonAmarelo.setBackgroundTintList(getColorStateList(R.color.cinza));
                }
            }
        });
    }

    private void eventoVerde() {
        switchLedVerde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonVerde.setBackgroundTintList(getColorStateList(R.color.verde));
                } else {
                    buttonVerde.setBackgroundTintList(getColorStateList(R.color.cinza));
                }
            }
        });
    }

    private void fecharTela() {
        Intent telaMain = new Intent(this, MainActivity.class);
        startActivity(telaMain);

        finish();
    }

    private void irTelaDuvidas() {
        Intent telaDuvidas = new Intent(this, ReclamacoesActivity.class);
        startActivity(telaDuvidas);
    }

    private void alterarTitulo() {
        String nomeUsuario = sp.getString("usuario", "");
        String titulo = "Bem Vindo(a)!\n" + nomeUsuario;
        textViewTitulo.setText(titulo);
    }
}
