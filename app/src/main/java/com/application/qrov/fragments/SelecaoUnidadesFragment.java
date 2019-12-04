package com.application.qrov.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.application.qrov.R;
import com.application.qrov.database.Unidade;
import com.application.qrov.util.ListaUnidadesAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelecaoUnidadesFragment extends Fragment {

    private ListView entrada, saida;
    private int idProduto;
    private String tipoProduto;
    private ListaUnidadesAdapter listaUnidadesAdapter;
    private ArrayList<Unidade> unidades = new ArrayList<>();

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public SelecaoUnidadesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selecao_unidade, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        entrada = view.findViewById(R.id.listaSelecaoUnidadeEntrada);
        saida = view.findViewById(R.id.listaSelecaoUnidadeSaida);

        listaUnidades();
        listaUnidadesAdapter = new ListaUnidadesAdapter(getActivity(), unidades);
        entrada.setAdapter(listaUnidadesAdapter);
        saida.setAdapter(listaUnidadesAdapter);
    }

    private void listaUnidades() {
        String url = "http://10.0.0.102/QRoV/select_all_unidade.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    Unidade unidade = new Unidade();
                    unidade.setId_Unidade(object.get("Id_Unidade").getAsInt());
                    unidade.setNome(object.get("Nome").getAsString());
                    unidade.setSigla(object.get("Sigla").getAsString());
                    unidade.setTipo(object.get("Tipo_Insumo").getAsString());
                    unidade.setEquivalencia_SI(object.get("Equivalencia_SI").getAsFloat());

                    unidades.add(unidade);
                }

                listaUnidadesAdapter.notifyDataSetChanged();
            }
        });
    }

}
