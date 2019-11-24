package com.application.qrov.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import com.application.qrov.activities.ProdutoActivity;
import com.application.qrov.util.Localizacao;
import com.application.qrov.util.Produto;
import com.application.qrov.util.Unidade;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFragment extends Fragment {

    private EditText[] campos = new EditText[8];

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_spinner_item, Unidade.unidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        campos[0] = view.findViewById(R.id.inputNome);
        campos[1] = view.findViewById(R.id.inputFornecedor);
        campos[2] = view.findViewById(R.id.inputMinimo);
        campos[3] = view.findViewById(R.id.andar);
        campos[4] = view.findViewById(R.id.corredor);
        campos[5] = view.findViewById(R.id.prateleira);
        campos[6] = view.findViewById(R.id.nivel);
        campos[7] = view.findViewById(R.id.inputDescricao);
        Button confirma = view.findViewById(R.id.confirma);

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
                    produto.setUnidadeSaida(spinner.getSelectedItem().toString());
                    produto.setMinimo(minimo);
                    produto.setLocalizacao(localizacao);
                    produto.setDescricao(descricao);

                    Produto.produtos.add(produto);

                    Intent intent = new Intent(getActivity(), ProdutoActivity.class);
                    intent.putExtra("QR-Code", produto.QRCode());
                    startActivity(intent);
                    Objects.requireNonNull(getActivity()).finish();
                } else {
                    new AlertDialog.Builder(Objects.requireNonNull(getActivity()))
                            .setTitle("Campos ivalidados!")
                            .setMessage("Um ou mais campos não foram preenchidos corretamente.")
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });

    }

    private boolean camposValidos() {
        for (EditText campo : campos) {
            if (TextUtils.isEmpty(campo.getText())) {
                return false;
            }
        }
        return true;
    }
}
