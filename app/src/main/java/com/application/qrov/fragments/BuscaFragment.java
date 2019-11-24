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
import com.application.qrov.util.Produto;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

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

        abrirCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator.forSupportFragment(BuscaFragment.this)
                        .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
                        .setPrompt("Alinhe uma etiqueta QR-Code com o laser")
                        .setCameraId(0)
                        .setBarcodeImageEnabled(false)
                        .setCaptureActivity(Captura.class)
                        .initiateScan();
            }
        });

        verProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProdutoActivity.class);
                intent.putExtra("QR-Code", resultado.getText().toString());
                startActivity(intent);
            }
        });

        todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ListaProdutosActivity.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null && resultCode == RESULT_OK) {
            if (result.getContents() == null) {
                card.setVisibility(View.INVISIBLE);
                verProduto.setEnabled(false);
            } else {
                for (Produto produto : Produto.produtos) {
                    if (produto.QRCode().equals(result.getContents())) {
                        card.setVisibility(View.VISIBLE);
                        resultado.setText(result.getContents());
                        verProduto.setEnabled(true);
                        break;
                    }
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
