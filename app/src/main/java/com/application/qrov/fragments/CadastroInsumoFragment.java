package com.application.qrov.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.database.Tipo_Insumo;
import com.application.qrov.database.Unidade;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroInsumoFragment extends Fragment {

    private TextInputLayout inputIdLayout, inputNomeLayout;
    private EditText inputId, inputNome;
    private Spinner spinnerInsumos, spinnerLocalizacao;
    private TextView novoTipo;
    private Button proximo;

    private ArrayList<Integer> idInsumos = new ArrayList<>();
    private ArrayList<String> insumos = new ArrayList<>();
    private ArrayList<Integer> idLocalizacoes = new ArrayList<>();
    private ArrayList<String> localizacoes = new ArrayList<>();

    private final String tipo = "Insumo";

    public CadastroInsumoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_insumo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputIdLayout = view.findViewById(R.id.inputIdInsumoLayout);
        inputNomeLayout = view.findViewById(R.id.inputNomeInsumoLayout);
        inputId = view.findViewById(R.id.inputIdInsumo);
        inputNome = view.findViewById(R.id.inputNomeInsumo);
        spinnerInsumos = view.findViewById(R.id.spinnerTipoInsumo);
        spinnerLocalizacao = view.findViewById(R.id.spinnerLocalizacao);
        novoTipo = view.findViewById(R.id.novoTipo);
        proximo = view.findViewById(R.id.proximo);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelecaoUnidadesFragment selecaoUnidadesFragment = new SelecaoUnidadesFragment();
                /* TODO: selecao de unidades de entrada e saida */
            }
        });
    }

    private void listaTipoInsumos() {
        String url = "http://10.0.0.102/QRoV/select_all_tipo_insumo.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    Tipo_Insumo tipoInsumo = new Tipo_Insumo();
                    tipoInsumo.setId_Tipo(object.get("Id_Tipo").getAsInt());
                    idInsumos.add(tipoInsumo.getId_Tipo());
                    tipoInsumo.setNome(object.get("Nome").getAsString());
                    insumos.add(tipoInsumo.getNome());

                    Unidade unidade = new Unidade();
                    unidade.setId_Unidade(object.get("Id_Unidade").getAsInt());
                    unidade.setNome(object.get("Nome").getAsString());
                    unidade.setSigla(object.get("Sigla").getAsString());
                    unidade.setTipo(object.get("Tipo_Insumo").getAsString());
                    unidade.setEquivalencia_SI(object.get("Equivalencia_SI").getAsFloat());

                }
            }
        });
    }

    private void listaLocalizacoesDisponiveis() {
        /* TODO: lista de localizacoes disponiveis a partir do banco de dados */
    }
}
