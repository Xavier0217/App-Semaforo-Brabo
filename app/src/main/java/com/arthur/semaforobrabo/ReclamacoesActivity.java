package com.arthur.semaforobrabo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

public class ReclamacoesActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listViewDuvidas;
    private Button buttonVoltar;
    private ArrayAdapter<Reclamacoes> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamacoes);

        Toolbar toolbar = findViewById(R.id.toolbarReclamacoes);
        setSupportActionBar(toolbar);

        listViewDuvidas = findViewById(R.id.listViewDuvidas);

        buttonVoltar = findViewById(R.id.buttonVoltar);

        buttonVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reclamacoes, menu);
        return true;
    }
}