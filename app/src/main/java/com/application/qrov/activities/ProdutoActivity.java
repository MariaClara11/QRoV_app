package com.application.qrov.activities;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Objects;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProdutoActivity extends AppCompatActivity {

    TextView nomeProduto, idProduto, infoProduto, printQR;
    ImageView imgProduto, qrProduto, update, delete;
    Button estoque;
    Dialog dialogEntrada, dialogSaida;

    ArrayList<Integer> idMpEntrada = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.nomeProduto);
        idProduto = findViewById(R.id.codProduto);
        infoProduto = findViewById(R.id.infoProduto);
        imgProduto = findViewById(R.id.imgProduto);
        qrProduto = findViewById(R.id.qrProduto);
        printQR = findViewById(R.id.printQR);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        estoque = findViewById(R.id.estoque);

        int CodProduto = (int) getIntent().getLongExtra("CodProduto", -1);
        getProdutoBD(String.valueOf(CodProduto));

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(String.valueOf(CodProduto), BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrProduto.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        estoque.setOnClickListener(v -> {
            new AlertDialog.Builder(ProdutoActivity.this)
                    .setTitle("Movimentação de estoque")
                    .setPositiveButton("Entrada", (dialog, which) -> {
                        inflateDialogEntrada();
                        dialogEntrada.show();
                    })
                    .setNegativeButton("Saída", (dialog, which) -> {
                        inflateDialogSaida();
                        dialogSaida.show();
                    })
                    .show();
        });

        delete.setOnClickListener(v -> {
            new AlertDialog.Builder(ProdutoActivity.this)
                    .setTitle("Excluir instância?")
                    .setMessage("Essa ação não pode ser desfeita.")
                    .setPositiveButton("Continuar", (dialog, which) -> {
                        String url = Conexao.HOST + "delete_materia_prima.php";

                        Ion.with(ProdutoActivity.this)
                                .load(url)
                                .setBodyParameter("CodProduto", idProduto.getText().toString())
                                .asJsonObject()
                                .setCallback((e, result) -> {
                                });
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });
    }

    private void getProdutoBD(String CodProduto) {
        String url = Conexao.HOST + "select_all_materia_prima_by_id.php";
        final String[] info = {""};

        Ion.with(ProdutoActivity.this).load(url)
                .setBodyParameter("CodProduto", CodProduto)
                .asJsonObject()
                .setCallback((e, result) -> {
                    idProduto.setText(result.get("CodProduto").getAsString());
                    nomeProduto.setText(result.get("Nome").getAsString());

                    Ion.with(ProdutoActivity.this).load(Conexao.HOST + "select_all_insumo_by_id.php")
                            .setBodyParameter("Id_Insumo", result.get("Id_Insumo").getAsString())
                            .asJsonObject()
                            .setCallback((e1, result1) -> info[0] += "Insumo: " + result1.get("Nome").getAsString() + "\n");

                    Ion.with(ProdutoActivity.this).load(Conexao.HOST + "select_descricao_caracteristica.php")
                            .setBodyParameter("CodProduto", result.get("CodProduto").getAsString())
                            .asJsonArray()
                            .setCallback((e1, result1) -> {
                                info[0] += "Características:\n";
                                for (int i = 0; i < result1.size(); i++) {
                                    info[0] += result1.get(i).getAsJsonObject().get("Nome").getAsString() + ": ";
                                    info[0] += result1.get(i).getAsJsonObject().get("Descricao").getAsString() + "\n";
                                }
                            });

                    infoProduto.setText(info[0]);
                });
    }

    private void inflateDialogEntrada() {
        View view = getLayoutInflater().inflate(R.layout.dialog_entrada, null);
        dialogEntrada = new Dialog(ProdutoActivity.this, android.R.style.Theme_DeviceDefault_Light_DarkActionBar);
        dialogEntrada.setContentView(view);
        dialogEntrada.setTitle("Entrada em estoque");

        TextView produto = view.findViewById(R.id.nomeProduto);
        produto.setText(nomeProduto.getText());

        EditText input_idMPEntrada, input_codigo, input_estoqueMin, input_preco;
        input_idMPEntrada = view.findViewById(R.id.input_idMPEntrada);
        input_codigo = view.findViewById(R.id.input_codigo);
        input_estoqueMin = view.findViewById(R.id.input_estoqueMin);
        input_preco = view.findViewById(R.id.input_preco);

        listaIdMpEntrada();
        if (TextUtils.isEmpty(input_idMPEntrada.getText()) || idMpEntrada.contains(Integer.parseInt(input_idMPEntrada.getText().toString()))) {
            Snackbar.make(new View(ProdutoActivity.this), "Erro no identificador", Snackbar.LENGTH_LONG).show();
        } else {
            //TODO Cadastrar MpEntrada e entrada
        }

        ImageView mais, menos;
        EditText quantidade;
        mais = view.findViewById(R.id.mais);
        menos = view.findViewById(R.id.menos);
        quantidade = view.findViewById(R.id.quantidade);

        menos.setOnClickListener(v -> {
            if (TextUtils.isEmpty(quantidade.getText().toString())) {
                quantidade.setText("0");
            } else {
                double num = Double.parseDouble(quantidade.getText().toString());
                if (num > 0) {
                    num -= 1.0;
                    String n = "" + num;
                    quantidade.setText(n);
                }
            }
        });

        mais.setOnClickListener(v -> {
            if (TextUtils.isEmpty(quantidade.getText().toString())) {
                quantidade.setText("0");
            } else {
                double num = Double.parseDouble(quantidade.getText().toString());
                num += 1.0;
                String n = "" + num;
                quantidade.setText(n);
            }
        });

        Spinner spinnerFornecedores = view.findViewById(R.id.spinnerFornecedores);
        final int[] idFornecedorEscolhido = new int[1];

        ArrayList<String> nomeFornecedores = new ArrayList<>();
        ArrayList<Integer> cnpjFornecedores = new ArrayList<>();

        Ion.with(ProdutoActivity.this).load(Conexao.HOST + "select_id_nome_fornecedor.php")
                .asJsonArray()
                .setCallback((e, result) -> {
                    for (int i = 0; i < result.size(); i++) {
                        cnpjFornecedores.add(result.get(i).getAsJsonObject().get("CNPJ").getAsInt());
                        nomeFornecedores.add(result.get(i).getAsJsonObject().get("Nome").getAsString());
                    }

                    ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(Objects.requireNonNull(ProdutoActivity.this), android.R.layout.simple_spinner_item, nomeFornecedores);
                    stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerFornecedores.setAdapter(stringArrayAdapter);
                    stringArrayAdapter.notifyDataSetChanged();
                });

        spinnerFornecedores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idFornecedorEscolhido[0] = cnpjFornecedores.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void inflateDialogSaida() {

    }

    private void listaIdMpEntrada() {
        Ion.with(ProdutoActivity.this).load(Conexao.HOST + "select_id_mp_entrada.php")
                .asJsonArray()
                .setCallback((e, result) -> {
                    for (int i = 0; i < result.size(); i++) {
                        idMpEntrada.add(result.get(i).getAsJsonObject().get("Id_MpEntrada").getAsInt());
                    }
                });
    }
}
