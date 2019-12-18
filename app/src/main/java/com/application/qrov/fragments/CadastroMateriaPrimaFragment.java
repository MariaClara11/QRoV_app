package com.application.qrov.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Insumo;
import com.application.qrov.database.Localizacao;
import com.application.qrov.database.Materia_Prima;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroMateriaPrimaFragment extends Fragment {

    private TextInputLayout inputIdLayout, inputNomeLayout;
    private EditText inputId, inputNome;
    private Spinner spinnerInsumos, spinnerLocalizacoes;
    private Button proximo;

    private ArrayList<Integer> idMaterias = new ArrayList<>();
    private ArrayList<Integer> idInsumos = new ArrayList<>();
    private ArrayList<String> insumos = new ArrayList<>();
    private ArrayList<Integer> idLocalizacoes = new ArrayList<>();
    private ArrayList<String> localizacoes = new ArrayList<>();

    public CadastroMateriaPrimaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_materia_prima, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputIdLayout = view.findViewById(R.id.inputIdMateriaPrimaLayout);
        inputNomeLayout = view.findViewById(R.id.inputNomeMateriaPrimaLayout);
        inputId = view.findViewById(R.id.inputIdMateriaPrima);
        inputNome = view.findViewById(R.id.inputNomeMateriaPrima);
        spinnerInsumos = view.findViewById(R.id.spinnerInsumos);
        spinnerLocalizacoes = view.findViewById(R.id.spinnerLocalizacoes);
        proximo = view.findViewById(R.id.proximo);

        listaIdMateriaPrima();
        listaInsumos();
        listaLocalizacoesDisponiveis();

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idMaterias.contains(Integer.parseInt(inputId.getText().toString())) || TextUtils.isEmpty(inputId.getText().toString())) {
                    inputIdLayout.setError("Erro de identificador");
                } else {
                    Materia_Prima materiaPrima = new Materia_Prima();
                    materiaPrima.setCodProduto(Integer.parseInt(inputId.getText().toString()));
                    materiaPrima.setId_Insumo(idInsumos.get(spinnerInsumos.getSelectedItemPosition()));
                    materiaPrima.setId_Localizacao(idLocalizacoes.get(spinnerLocalizacoes.getSelectedItemPosition()));
                    materiaPrima.setNome(inputNome.getText().toString());
                    materiaPrima.setVisivel(1);
                    SelecaoUnidadesFragment selecaoUnidadesFragment = new SelecaoUnidadesFragment();
                    selecaoUnidadesFragment.setMateriaPrima(materiaPrima);
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selecaoUnidadesFragment).commit();
                }
            }
        });
    }

    private void listaInsumos() {
        String url = Conexao.HOST + "select_all_insumo.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    Insumo insumo = new Insumo();
                    insumo.setId_Insumo(object.get("Id_Insumo").getAsInt());
                    idInsumos.add(insumo.getId_Insumo());
                    insumo.setNome(object.get("Nome").getAsString());
                    insumos.add(insumo.getNome());
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, insumos);
                stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerInsumos.setAdapter(stringArrayAdapter);
                stringArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void listaLocalizacoesDisponiveis() {
        String url = Conexao.HOST + "select_all_tipo_localizacao.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    Localizacao localizacao = new Localizacao();
                    localizacao.setId_Localizacao(object.get("Id_Localizacao").getAsInt());
                    idLocalizacoes.add(localizacao.getId_Localizacao());
                    localizacao.setAndar(object.get("Andar").getAsInt());
                    localizacao.setCorredor(object.get("Corredor").getAsInt());
                    localizacao.setPrateleira(object.get("Prateleira").getAsInt());
                    localizacao.setNivel(object.get("Nivel").getAsInt());
                    localizacoes.add(localizacao.toString());
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, localizacoes);
                stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerLocalizacoes.setAdapter(stringArrayAdapter);
                stringArrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void listaIdMateriaPrima() {
        String url = Conexao.HOST + "select_id_materia_prima.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    int id = object.get("CodProduto").getAsInt();
                    idMaterias.add(id);
                }
            }
        });
    }

}
