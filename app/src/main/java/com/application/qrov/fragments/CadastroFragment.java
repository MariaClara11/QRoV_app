package com.application.qrov.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.application.qrov.R;
import com.application.qrov.activities.ProdutoActivity;
import com.application.qrov.classes.Localizacao;
import com.application.qrov.classes.Produto;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFragment extends Fragment {

    EditText[] campos = new EditText[8];
    Button confirma;

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

        for (int i = 0; i < campos.length; i++) {
            campos[i] = new EditText(getContext());
        }

        campos[0] = view.findViewById(R.id.inputNome);
        campos[1] = view.findViewById(R.id.inputFornecedor);
        campos[2] = view.findViewById(R.id.inputMinimo);
        campos[3] = view.findViewById(R.id.andar);
        campos[4] = view.findViewById(R.id.corredor);
        campos[5] = view.findViewById(R.id.prateleira);
        campos[6] = view.findViewById(R.id.nivel);
        campos[7] = view.findViewById(R.id.inputDescricao);
        confirma = view.findViewById(R.id.confirma);

        confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposValidos()) {
                    Produto produto = new Produto();

                    String nome = campos[0].getText().toString();
                    String fornecedor = campos[1].getText().toString();
                    double minimo = Double.parseDouble(campos[2].getText().toString());
                    int a = Integer.parseInt(campos[3].getText().toString());
                    int c = Integer.parseInt(campos[4].getText().toString());
                    int p = Integer.parseInt(campos[5].getText().toString());
                    int n = Integer.parseInt(campos[6].getText().toString());
                    String localizacao = new Localizacao(a, c, p, n).toString();
                    String descricao = campos[7].getText().toString();

                    produto.setId(Produto.produtos.size());
                    produto.setNome(nome);
                    produto.setFornecedor(fornecedor);
                    produto.setMinimo(minimo);
                    produto.setLocalizacao(localizacao);
                    produto.setDescricao(descricao);

                    Produto.produtos.add(produto);

                    Intent intent = new Intent(getActivity(), ProdutoActivity.class);
                    intent.putExtra("QR-Code", produto.QRCode());
                    startActivity(intent);
                    Objects.requireNonNull(getActivity()).finish();
                } else {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "Alguns campos estão invalidados", Snackbar.LENGTH_LONG).show();
                }
            }
        });

    }

    public boolean camposValidos() {
        for (EditText campo : campos) {
            if (TextUtils.isEmpty(campo.getText())) {
                return false;
            }
        }
        return true;
    }
}
