package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.application.qrov.R;


import java.util.Objects;

public class ListaProdutosActivity extends AppCompatActivity {

    ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Lista de produtos");

        listaProdutos = findViewById(R.id.listaProdutos);

        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ListaProdutosActivity.this, ProdutoActivity.class));
            }
        });
    }
}
