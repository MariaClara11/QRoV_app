package com.application.qrov.fragments;


import android.content.Intent;
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
import com.application.qrov.activities.ProdutoActivity;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Insumo;
import com.application.qrov.database.Materia_Prima;
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
    private Materia_Prima materiaPrima;

    public void setMateriaPrima(Materia_Prima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    private ListaUnidadesAdapter listaUnidadesAdapter;
    private ArrayList<Unidade> unidades = new ArrayList<>();

    private ArrayList<Integer> idUnidadeEntrada = new ArrayList<>();
    private ArrayList<Integer> idUnidadeSaida = new ArrayList<>();

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
        entrada.setAdapter(listaUnidadesAdapter);
        saida.setAdapter(listaUnidadesAdapter);

        voltar.setOnClickListener(v -> Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CadastroMateriaPrimaFragment()).commit());

        finalizar.setOnClickListener(v -> {
            selecaoUnidadeEntrada();
            selecaoUnidadeSaida();

            if (idUnidadeEntrada.isEmpty() || idUnidadeSaida.isEmpty()) {
                Snackbar.make(new View(getActivity()), "Selecione pelo menos uma unidade em cada coluna", Snackbar.LENGTH_LONG).show();
            } else {
                Ion.with(Objects.requireNonNull(getContext()))
                        .load(Conexao.HOST + "insert_materia_prima.php")
                        .setBodyParameter("CodProduto", String.valueOf(materiaPrima.getCodProduto()))
                        .setBodyParameter("Nome", materiaPrima.getNome())
                        .setBodyParameter("Id_Insumo", String.valueOf(materiaPrima.getId_Insumo()))
                        .setBodyParameter("Visivel", String.valueOf(materiaPrima.getVisivel()))
                        .asJsonObject()
                        .setCallback((e, result) -> {
                            if (result.get("EXECUCAO").getAsString().equals("OK")) {
                                Snackbar.make(new View(getContext()), "Cadastro realizado", Snackbar.LENGTH_LONG).show();

                            } else {
                                Snackbar.make(new View(getContext()), "Cadastro não realizado", Snackbar.LENGTH_LONG).show();
                            }
                        });

                for (int idUnidade : idUnidadeEntrada) {
                    Ion.with(Objects.requireNonNull(getContext()))
                            .load(Conexao.HOST + "insert_materia_prima_tem_unidade_entrada.php")
                            .setBodyParameter("Id_Unidade", String.valueOf(idUnidade))
                            .setBodyParameter("CodProduto", String.valueOf(materiaPrima.getCodProduto()))
                            .asJsonObject()
                            .setCallback((e, result) -> {
                            });
                }

                for (int idUnidade : idUnidadeSaida) {
                    Ion.with(Objects.requireNonNull(getContext()))
                            .load(Conexao.HOST + "insert_materia_prima_tem_unidade_saida.php")
                            .setBodyParameter("Id_Unidade", String.valueOf(idUnidade))
                            .setBodyParameter("CodProduto", String.valueOf(materiaPrima.getCodProduto()))
                            .asJsonObject()
                            .setCallback((e, result) -> {
                            });
                }

                Intent intent = new Intent(getActivity(), ProdutoActivity.class);
                intent.putExtra("CodProduto", materiaPrima.getCodProduto());
                startActivity(intent);
            }
        });
    }

    private void listaUnidades() {
        String url = Conexao.HOST + "select_all_unidade.php";

        Ion.with(Objects.requireNonNull(getContext()))
                .load(url)
                .asJsonArray()
                .setCallback((e, result) -> {
                    for (int i = 0; i < result.size(); i++) {
                        JsonObject object = result.get(i).getAsJsonObject();

                        Unidade unidade = new Unidade();
                        unidade.setId_Unidade(object.get("Id_Unidade").getAsInt());
                        unidade.setNome(object.get("Nome").getAsString());
                        unidade.setSigla(object.get("Sigla").getAsString());
                        unidade.setEquivalencia_SI(object.get("Equivalencia_SI").getAsFloat());

                        unidades.add(unidade);
                    }

                    listaUnidadesAdapter = new ListaUnidadesAdapter(getActivity(), unidades);
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
