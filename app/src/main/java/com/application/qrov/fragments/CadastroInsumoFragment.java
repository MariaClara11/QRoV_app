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
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Insumo;
import com.application.qrov.database.Localizacao;
import com.application.qrov.database.Tipo_Insumo;
import com.application.qrov.util.BottomSheetCadastroTipoInsumo;
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
    private Spinner spinnerTipoInsumos, spinnerLocalizacoes;
    private TextView novoTipo;
    private Button proximo;

    private ArrayList<Integer> idInsumos = new ArrayList<>();
    private ArrayList<Integer> idTipoInsumos = new ArrayList<>();
    private ArrayList<String> tipoInsumos = new ArrayList<>();
    private ArrayList<Integer> idLocalizacoes = new ArrayList<>();
    private ArrayList<String> localizacoes = new ArrayList<>();

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
        spinnerTipoInsumos = view.findViewById(R.id.spinnerTipoInsumos);
        spinnerLocalizacoes = view.findViewById(R.id.spinnerLocalizacoes);
        novoTipo = view.findViewById(R.id.novoTipo);
        proximo = view.findViewById(R.id.proximo);

        listaTipoInsumos();
        listaLocalizacoesDisponiveis();
        listaIdInsumos();

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idInsumos.contains(Integer.parseInt(inputId.getText().toString())) || TextUtils.isEmpty(inputId.getText().toString())) {
                    inputIdLayout.setError("Erro de identificador");
                } else {
                    Insumo insumo = new Insumo();
                    insumo.setId_Insumo(Integer.parseInt(inputId.getText().toString()));
                    insumo.setId_Localizacao(idLocalizacoes.get(spinnerLocalizacoes.getSelectedItemPosition()));
                    insumo.setId_Tipo(idTipoInsumos.get(spinnerTipoInsumos.getSelectedItemPosition()));
                    insumo.setNome(inputNome.getText().toString());
                    insumo.setVisivel(1);
                    SelecaoUnidadesFragment selecaoUnidadesFragment = new SelecaoUnidadesFragment();
                    selecaoUnidadesFragment.setInsumo(insumo);
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selecaoUnidadesFragment).commit();
                }
            }
        });

        novoTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetCadastroTipoInsumo bottomSheetCadastroTipoInsumo = new BottomSheetCadastroTipoInsumo();
                bottomSheetCadastroTipoInsumo.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "Novo tipo");
            }
        });
    }

    private void listaTipoInsumos() {
        String url = Conexao.HOST + "select_all_tipo_insumo.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    Tipo_Insumo tipoInsumo = new Tipo_Insumo();
                    tipoInsumo.setId_Tipo(object.get("Id_Tipo").getAsInt());
                    idTipoInsumos.add(tipoInsumo.getId_Tipo());
                    tipoInsumo.setNome(object.get("Nome").getAsString());
                    tipoInsumos.add(tipoInsumo.getNome());
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, tipoInsumos);
                stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerTipoInsumos.setAdapter(stringArrayAdapter);
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
                    localizacao.setNivel(object.get("Nível").getAsInt());
                    localizacoes.add(localizacao.toString());
                }

                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, localizacoes);
                stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerLocalizacoes.setAdapter(stringArrayAdapter);
            }
        });
    }

    private void listaIdInsumos() {
        String url = Conexao.HOST + "select_id_insumo.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();

                    int id = object.get("Id_Insumo").getAsInt();
                    idInsumos.add(id);
                }
            }
        });
    }

}
