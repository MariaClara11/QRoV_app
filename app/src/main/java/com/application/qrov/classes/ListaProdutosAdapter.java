package com.application.qrov.classes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.application.qrov.R;

import java.util.ArrayList;

public class ListaProdutosAdapter extends BaseAdapter {

    private final Activity activity;
    private final ArrayList<Produto> produtos;

    public ListaProdutosAdapter(Activity activity, ArrayList<Produto> produtos) {
        this.activity = activity;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.lista_produtos_item, parent, false);
        Produto produto = produtos.get(position);

        TextView nome = view.findViewById(R.id.itemNomeProduto);
        TextView id = view.findViewById(R.id.itemIdProduto);
        TextView local = view.findViewById(R.id.itemLocalProduto);

        nome.setText(produto.getNome());
        id.setText(Integer.toString(produto.getId()));
        local.setText(produto.getLocalizacao());

        return view;
    }
}
