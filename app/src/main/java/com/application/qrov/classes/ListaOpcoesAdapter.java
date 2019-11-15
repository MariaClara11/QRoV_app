package com.application.qrov.classes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.qrov.R;

import java.util.ArrayList;

public class ListaOpcoesAdapter extends BaseAdapter {

    private final Activity activity;
    private final ArrayList<Opcao> opcoes;

    public ListaOpcoesAdapter(Activity activity, ArrayList<Opcao> opcoes) {
        this.activity = activity;
        this.opcoes = opcoes;
    }

    @Override
    public int getCount() {
        return opcoes.size();
    }

    @Override
    public Object getItem(int position) {
        return opcoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return opcoes.get(position).getIconId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.lista_opcoes_item, parent, false);
        Opcao opcao = opcoes.get(position);

        TextView nome = view.findViewById(R.id.opcao);
        ImageView icone = view.findViewById(R.id.icone);

        nome.setText(opcao.getOpcao());
        icone.setImageResource(opcao.getIconId());

        return view;
    }
}
