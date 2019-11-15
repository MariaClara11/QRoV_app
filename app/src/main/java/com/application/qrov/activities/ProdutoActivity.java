package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.application.qrov.R;
import com.application.qrov.classes.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        String QRCode = getIntent().getStringExtra("QR-Code");

        for (Produto produto1 : Produto.produtos) {
            if (produto1.getQRCode().equals(QRCode)) {
                produto = produto1;
                break;
            }
        }
    }
}
