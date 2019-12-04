package com.application.qrov.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.application.qrov.R;
import com.application.qrov.database.Unidade;

import java.util.ArrayList;

public class ListaUnidadesAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Unidade> unidades;

    public ListaUnidadesAdapter(Activity activity, ArrayList<Unidade> unidades) {
        this.activity = activity;
        this.unidades = unidades;
    }

    @Override
    public int getCount() {
        return unidades.size();
    }

    @Override
    public Unidade getItem(int position) {
        return unidades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return unidades.get(position).getId_Unidade();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = activity.getLayoutInflater().inflate(R.layout.item_lista_selecao_unidade, parent, false);
        Unidade unidade = getItem(position);

        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        checkBox.setText(unidade.getNome() + "\n" + unidade.getSigla());

        return convertView;
    }
}
