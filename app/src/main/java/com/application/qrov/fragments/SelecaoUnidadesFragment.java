package com.application.qrov.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Unidade;
import com.application.qrov.util.ListaUnidadesAdapter;
import com.google.android.material.snackbar.Snackbar;
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
    private Button voltar, finalizar;

    private int idProduto;
    private String tipoProduto;
    private int IdLocalizacao;

    private ListaUnidadesAdapter listaUnidadesAdapter;
    private ArrayList<Unidade> unidades = new ArrayList<>();

    private ArrayList<Integer> idUnidadeEntrada = new ArrayList<>();
    private ArrayList<Integer> idUnidadeSaida = new ArrayList<>();

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

    public int getIdLocalizacao() {
        return IdLocalizacao;
    }

    public void setIdLocalizacao(int idLocalizacao) {
        IdLocalizacao = idLocalizacao;
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
        voltar = view.findViewById(R.id.voltar);
        finalizar = view.findViewById(R.id.finalizar);

        listaUnidades();
        listaUnidadesAdapter = new ListaUnidadesAdapter(getActivity(), unidades);
        entrada.setAdapter(listaUnidadesAdapter);
        saida.setAdapter(listaUnidadesAdapter);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipoProduto.equals("Insumo")) {
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CadastroInsumoFragment()).commit();
                } else if (tipoProduto.equals("Matéria-prima")) {
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CadastroMateriaPrimaFragment()).commit();
                }
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecaoUnidadeEntrada();
                selecaoUnidadeSaida();

                if (idUnidadeEntrada.isEmpty() || idUnidadeSaida.isEmpty()) {
                    Snackbar.make(new View(getActivity()), "Selecione pelo menos uma unidade em cada coluna", Snackbar.LENGTH_LONG).show();
                } else {
                    if (tipoProduto.equals("Insumo")) {
                        /* TODO: finalizar cadastro de insumo e de suas unidades e indisponibilizar localizacao*/
                    } else if (tipoProduto.equals("Matéria-prima")) {
                        /* TODO: finalizar cadastro de matéria-prima e de suas unidades e indisponiblizar localizacao*/
                    }
                }
            }
        });
    }

    private void listaUnidades() {
        String url = Conexao.HOST + "select_all_unidade.php";

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

    private void selecaoUnidadeEntrada() {
        for (int i = 0; i < entrada.getCount(); i++) {
            Unidade unidade = (Unidade) entrada.getItemAtPosition(i);
            if (unidade.isSelecionada()) {
                idUnidadeEntrada.add(unidade.getId_Unidade());
            }
        }
    }

    private void selecaoUnidadeSaida() {
        for (int i = 0; i < saida.getCount(); i++) {
            Unidade unidade = (Unidade) saida.getItemAtPosition(i);
            if (unidade.isSelecionada()) {
                idUnidadeSaida.add(unidade.getId_Unidade());
            }
        }
    }

}
