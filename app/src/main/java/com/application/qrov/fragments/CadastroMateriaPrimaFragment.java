package com.application.qrov.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.qrov.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroMateriaPrimaFragment extends Fragment {

    private Map<Integer, String> insumos = new HashMap<>();
    private Map<Integer, String> localizacoes = new HashMap<>();

    private final String tipo = "Matéria-prima";

    public CadastroMateriaPrimaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_materia_prima, container, false);
    }

}
