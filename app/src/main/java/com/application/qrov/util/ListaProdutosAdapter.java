package com.application.qrov.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Materia_Prima;
import com.google.android.material.snackbar.Snackbar;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class ListaProdutosAdapter extends BaseAdapter {

    private final Activity activity;
    private final ArrayList<Materia_Prima> materias_primas;

    public ListaProdutosAdapter(Activity activity, ArrayList<Materia_Prima> materias_primas) {
        this.activity = activity;
        this.materias_primas = materias_primas;
    }

    @Override
    public int getCount() {
        return materias_primas.size();
    }

    @Override
    public Materia_Prima getItem(int position) {
        return materias_primas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return materias_primas.get(position).getCodProduto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = activity.getLayoutInflater().inflate(R.layout.item_lista_produtos, parent, false);
        Materia_Prima materiaPrima = getItem(position);

        TextView itemIdProduto = convertView.findViewById(R.id.itemIdProduto);
        TextView itemNomeProduto = convertView.findViewById(R.id.itemNomeProduto);

        itemIdProduto.setText(String.valueOf(materiaPrima.getCodProduto()));
        itemNomeProduto.setText(materiaPrima.getNome());

        return convertView;
    }
}
