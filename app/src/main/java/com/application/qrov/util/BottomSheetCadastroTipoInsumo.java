package com.application.qrov.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.application.qrov.database.Unidade;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomSheetCadastroTipoInsumo extends BottomSheetDialogFragment {

    private EditText inputIdTipoInsumo, inputNomeTipoInsumo;
    private Button cadastraTipo;

    private BottomSheetListener listener;

    private ArrayList<Integer> idTipoInsumo = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_cadastro_tipo_insumo, container, false);

        inputIdTipoInsumo = view.findViewById(R.id.inputIdTipoInsumo);
        inputNomeTipoInsumo = view.findViewById(R.id.inputNomeTipoInsumo);
        cadastraTipo = view.findViewById(R.id.cadastraTipo);

        listaIdTipoInsumo();

        cadastraTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputIdTipoInsumo.getText().toString()) || TextUtils.isEmpty(inputNomeTipoInsumo.getText().toString())) {
                    Snackbar.make(new View(getContext()), "Campos obrigatórios", Snackbar.LENGTH_LONG).show();
                } else {
                    if (idTipoInsumo.contains(Integer.parseInt(inputIdTipoInsumo.getText().toString()))) {
                        Snackbar.make(new View(getContext()), "Erro de identificador", Snackbar.LENGTH_LONG).show();
                    } else {
                        String url = Conexao.HOST + "insert_tipo_insumo.php";

                        Ion.with(getContext()).load(url)
                                .setBodyParameter("Id_Tipo", inputIdTipoInsumo.getText().toString())
                                .setBodyParameter("Nome", inputIdTipoInsumo.getText().toString())
                                .asJsonObject()
                                .setCallback(new FutureCallback<JsonObject>() {
                                    @Override
                                    public void onCompleted(Exception e, JsonObject result) {

                                    }
                                });
                    }
                }
            }
        });

        return view;
    }

    public interface BottomSheetListener {
        void novoTipo();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (BottomSheetListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " deve implementar BottomSheetListener");
        }
    }

    private void listaIdTipoInsumo() {
        String url = Conexao.HOST + "select_id_tipo_insumo.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback(new FutureCallback<JsonArray>() {
            @Override
            public void onCompleted(Exception e, JsonArray result) {
                for (int i = 0; i < result.size(); i++) {
                    JsonObject object = result.get(i).getAsJsonObject();
                    idTipoInsumo.add(object.get("Id_Insumo").getAsInt());
                }
            }
        });
    }
}
