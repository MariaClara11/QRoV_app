package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.application.qrov.R;
import com.application.qrov.classes.ListaProdutosAdapter;
import com.application.qrov.classes.Produto;

import java.util.Objects;

public class ListaProdutosActivity extends AppCompatActivity {

    ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Lista de produtos");

        listaProdutos = findViewById(R.id.listaProdutos);
        ListaProdutosAdapter adapter = new ListaProdutosAdapter(ListaProdutosActivity.this, Produto.produtos);
        listaProdutos.setAdapter(adapter);

        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaProdutosActivity.this, ProdutoActivity.class);
                intent.putExtra("QR-Code", Produto.produtos.get(position).QRCode());
                startActivity(intent);
            }
        });
    }
}
