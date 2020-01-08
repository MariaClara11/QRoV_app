package com.application.qrov.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Materia_Prima;
import com.application.qrov.util.ListaProdutosAdapter;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class ListaProdutosActivity extends AppCompatActivity {

    private ListView listaProdutos;
    private ArrayList<Materia_Prima> materias_primas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Lista de produtos");

        listaProdutos = findViewById(R.id.listaProdutos);
        getMateriasPrimasBD();
        listaProdutos.setAdapter(new ListaProdutosAdapter(ListaProdutosActivity.this, materias_primas));

        listaProdutos.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListaProdutosActivity.this, ProdutoActivity.class);
            intent.putExtra("CodProduto", id);
            startActivity(intent);
        });
    }

    private void getMateriasPrimasBD() {
        String url = Conexao.HOST + "select_all_materia_prima.php";

        Ion.with(ListaProdutosActivity.this)
                .load(url)
                .asJsonArray()
                .setCallback((e, result) -> {
                    for (int i = 0; i < result.size(); i++) {
                        JsonObject object = result.get(i).getAsJsonObject();
                        Materia_Prima materiaPrima = new Materia_Prima();

                        materiaPrima.setCodProduto(object.get("CodProduto").getAsInt());
                        materiaPrima.setId_Insumo(object.get("Id_Insumo").getAsInt());
                        materiaPrima.setNome(object.get("Nome").getAsString());
                        materiaPrima.setVisivel(object.get("Visivel").getAsInt());

                        materias_primas.add(materiaPrima);
                    }
                });
    }
}
