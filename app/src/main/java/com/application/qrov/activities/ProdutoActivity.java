package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.classes.Produto;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;
    TextView nomeProduto, idProduto, infoProduto;
    ImageView imgProduto, qrProduto, printQR;
    Button estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        nomeProduto = findViewById(R.id.nomeProduto);
        idProduto = findViewById(R.id.idProduto);
        infoProduto = findViewById(R.id.infoProduto);
        imgProduto = findViewById(R.id.imgProduto);
        qrProduto = findViewById(R.id.qrProduto);
        printQR = findViewById(R.id.printQR);
        estoque = findViewById(R.id.estoque);

        final String QRCode = getIntent().getStringExtra("QR-Code");

        boolean encontrado = false;
        for (Produto produto1 : Produto.produtos) {
            if (produto1.QRCode().equals(QRCode)) {
                produto = produto1;
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            nomeProduto.setText(produto.getNome());
            idProduto.setText(Integer.toString(produto.getId()));
            infoProduto.setText(produto.toString());

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(produto.QRCode(), BarcodeFormat.QR_CODE, 300, 300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                qrProduto.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }

            estoque.setEnabled(true);
        } else {
            finish();
        }


        estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProdutoActivity.this, EstoqueActivity.class);
                intent.putExtra("QR-Code", QRCode);
                startActivity(intent);
            }
        });
    }
}
