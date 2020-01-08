package com.application.qrov.activities;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.koushikdutta.ion.Ion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ProdutoActivity extends AppCompatActivity {

    TextView nomeProduto, idProduto, infoProduto, printQR;
    ImageView imgProduto, qrProduto, update, delete;
    Button estoque;
    Dialog dialog;

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

        estoque.setOnClickListener(v -> dialog.show());

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
                                .setCallback((e, result) -> {});
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

    private void inflateDialog(){
        View view = getLayoutInflater().inflate(R.layout.dialog_estoque, null);



        dialog = new Dialog(ProdutoActivity.this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setContentView(view);
    }

}
