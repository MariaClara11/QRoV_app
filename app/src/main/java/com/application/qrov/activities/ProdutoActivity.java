package com.application.qrov.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.qrov.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import androidx.appcompat.app.AppCompatActivity;

public class ProdutoActivity extends AppCompatActivity {

    TextView nomeProduto, idProduto, infoProduto, printQR;
    ImageView imgProduto, qrProduto;
    Button estoque;

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
        estoque = findViewById(R.id.estoque);

        String QRCode = "QR-Code";

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(QRCode, BarcodeFormat.QR_CODE, 300, 300);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrProduto.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        estoque.setEnabled(true);


        estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProdutoActivity.this, EstoqueActivity.class));
            }
        });
    }
}
