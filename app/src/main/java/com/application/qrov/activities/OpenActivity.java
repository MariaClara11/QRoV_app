package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.qrov.R;
import com.application.qrov.classes.Produto;
import com.application.qrov.classes.Unidade;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        Unidade.preenche();
        Produto.preenche();

        Button entrar = findViewById(R.id.entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpenActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
