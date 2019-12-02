package com.application.qrov.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.application.qrov.R;
import com.application.qrov.activities.AjudaActivity;
import com.application.qrov.activities.LoginActivity;
import com.application.qrov.activities.SobreActivity;
import com.application.qrov.activities.TermosActivity;
import com.application.qrov.util.ListaOpcoesAdapter;
import com.application.qrov.util.Opcao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaisFragment extends Fragment {

    private ArrayList<Opcao> opcoes = new ArrayList<>();

    public MaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mais, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listaOpcoes = view.findViewById(R.id.listaOpcoes);

        Opcao ajuda = new Opcao(R.drawable.outline_help_outline_24, "Ajuda");
        Opcao contato = new Opcao(R.drawable.outline_message_24, "Contato");
        Opcao sobre = new Opcao(R.drawable.outline_info_24, "Sobre");
        Opcao termos = new Opcao(R.drawable.outline_insert_drive_file_24, "Termos de uso");
        Opcao sair = new Opcao(R.drawable.outline_exit_to_app_24, "Sair");

        opcoes.add(ajuda);
        opcoes.add(contato);
        opcoes.add(sobre);
        opcoes.add(termos);
        opcoes.add(sair);

        ListaOpcoesAdapter adapter = new ListaOpcoesAdapter(getActivity(), opcoes);
        listaOpcoes.setAdapter(adapter);

        listaOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), AjudaActivity.class));
                        break;

                    case 1:
                        new AlertDialog.Builder(Objects.requireNonNull(getActivity()))
                                .setTitle("Contato")
                                .setMessage("Entre em contato com os desenvolvedores através do e-mail\ndevelop@qrov.com.")
                                .setPositiveButton("OK", null)
                                .show();
                        break;

                    case 2:
                        startActivity(new Intent(getActivity(), SobreActivity.class));
                        break;

                    case 3:
                        startActivity(new Intent(getActivity(), TermosActivity.class));
                        break;

                    case 4:
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        Objects.requireNonNull(getActivity()).finish();
                        break;
                }
            }
        });
    }
}
