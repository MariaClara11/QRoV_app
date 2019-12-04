package com.application.qrov.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.application.qrov.R;
import com.application.qrov.activities.ProdutoActivity;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFragment extends Fragment {

    RadioGroup item;
    RadioButton insumo, materiaPrima;

    public CadastroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        item = view.findViewById(R.id.RadioGroupItem);
        insumo = view.findViewById(R.id.RadioInsumo);
        materiaPrima = view.findViewById(R.id.RadioMateriaPrima);

        item.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.RadioInsumo:
                        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameCadastro, new CadastroInsumoFragment()).commit();
                        break;

                    case R.id.RadioMateriaPrima:
                        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.frameCadastro, new CadastroMateriaPrimaFragment()).commit();
                        break;
                }
            }
        });

    }

}
