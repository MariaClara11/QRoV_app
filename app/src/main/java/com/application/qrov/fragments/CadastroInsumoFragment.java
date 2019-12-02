package com.application.qrov.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.application.qrov.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroInsumoFragment extends Fragment {

    EditText inputId, inputNome;
    Spinner spinnerInsumos;
    TextView novoTipo;

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

        inputId = view.findViewById(R.id.inputId);
        inputNome = view.findViewById(R.id.inputNome);
        spinnerInsumos = view.findViewById(R.id.spinnerInsumos);
        novoTipo = view.findViewById(R.id.novoTipo);
    }

    private void listaInsumos() {
        /* TODO: lista de insumos a partir do banco de dados; */
    }
}
