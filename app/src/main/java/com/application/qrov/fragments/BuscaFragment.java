package com.application.qrov.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.activities.Captura;
import com.application.qrov.activities.ListaProdutosActivity;
import com.application.qrov.activities.ProdutoActivity;
import com.application.qrov.database.Conexao;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscaFragment extends Fragment {

    private TextView resultado;
    private Button verProduto;
    private CardView card;

    private int CodProduto;
    private ArrayList<Integer> idMaterias = new ArrayList<>();

    public BuscaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_busca, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView abrirCamera = view.findViewById(R.id.abrirCamera);
        resultado = view.findViewById(R.id.resultado);
        TextView todos = view.findViewById(R.id.todos);
        verProduto = view.findViewById(R.id.verProduto);
        card = view.findViewById(R.id.card);

        listaIdMateriaPrima();

        abrirCamera.setOnClickListener(v -> IntentIntegrator.forSupportFragment(BuscaFragment.this)
                .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
                .setPrompt("Alinhe uma etiqueta QR Code com o laser")
                .setCameraId(0)
                .setBarcodeImageEnabled(false)
                .setCaptureActivity(Captura.class)
                .initiateScan());

        verProduto.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProdutoActivity.class);
            intent.putExtra("CodProduto", CodProduto);
            startActivity(intent);
        });

        todos.setOnClickListener(v -> startActivity(new Intent(getActivity(), ListaProdutosActivity.class)));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && resultCode == RESULT_OK) {
            if (result.getContents() == null) {
                card.setVisibility(View.INVISIBLE);
                verProduto.setEnabled(false);
            } else if (idMaterias.contains(Integer.parseInt(result.getContents()))) {
                card.setVisibility(View.VISIBLE);
                CodProduto = Integer.parseInt(result.getContents());
                resultado.setText(getMateriaPrimaBD(result.getContents()));
                verProduto.setEnabled(true);
            } else {
                Snackbar.make(new View(getContext()), "QR Code não foi validado pelo sistema", Snackbar.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private String getMateriaPrimaBD(String CodProduto) {
        final String[] materiaPrima = {""};
        String url = Conexao.HOST + "select_all_materia_prima_by_id.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url)
                .setBodyParameter("CodProduto", CodProduto)
                .asJsonObject()
                .setCallback((e, result) -> {
                    materiaPrima[0] += "Identificador: " + result.get("CodProduto").getAsString() + "\n";
                    materiaPrima[0] += "Nome: " + result.get("Nome").getAsString() + "\n";

                    Ion.with(getContext()).load(Conexao.HOST + "select_all_insumo_by_id.php")
                            .setBodyParameter("Id_Insumo", result.get("Id_Insumo").getAsString())
                            .asJsonObject()
                            .setCallback((e1, result1) -> materiaPrima[0] += "Insumo: " + result1.get("Nome").getAsString());
                });

        return materiaPrima[0];
    }

    private void listaIdMateriaPrima() {
        String url = Conexao.HOST + "select_id_materia_prima.php";

        Ion.with(Objects.requireNonNull(getContext())).load(url).asJsonArray().setCallback((e, result) -> {
            for (int i = 0; i < result.size(); i++) {
                JsonObject object = result.get(i).getAsJsonObject();
                int id = object.get("CodProduto").getAsInt();
                idMaterias.add(id);
            }
        });
    }
}
