package com.application.qrov.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.application.qrov.R;

import java.util.Objects;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EstoqueActivity extends AppCompatActivity {

    private int produto;
    TextView textProduto;
    RadioGroup operacao;
    RadioButton entrada, saida;
    ImageView menos, mais;
    EditText qtd;
    LinearLayout layout;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Alterar estoque");

        operacao = findViewById(R.id.operacao);
        entrada = findViewById(R.id.radioButtonEntrada);
        saida = findViewById(R.id.radioButtonSaida);
        menos = findViewById(R.id.menos);
        mais = findViewById(R.id.mais);
        qtd = findViewById(R.id.qtd);
        layout = findViewById(R.id.layout);
        done = findViewById(R.id.done);

        textProduto = findViewById(R.id.produto);

        operacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonEntrada:
                        layout.setVisibility(View.VISIBLE);
                        done.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!TextUtils.isEmpty(qtd.getText().toString())) {
                                    finish();
                                } else {
                                    new AlertDialog.Builder(EstoqueActivity.this)
                                            .setTitle("Quantidade inválida!")
                                            .setMessage("Preencha o campo com as quantidades adicionadas.")
                                            .setPositiveButton("OK", null)
                                            .show();
                                }
                            }
                        });
                        break;

                    case R.id.radioButtonSaida:
                        layout.setVisibility(View.INVISIBLE);
                        done.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (!TextUtils.isEmpty(qtd.getText().toString())) {
                                    finish();
                                } else {
                                    new AlertDialog.Builder(EstoqueActivity.this)
                                            .setTitle("Quantidade inválida!")
                                            .setMessage("Preencha o campo com as quantidades retiradas.")
                                            .setPositiveButton("OK", null)
                                            .show();
                                }
                            }
                        });
                        break;
                }
            }
        });

        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(qtd.getText().toString())) {
                    qtd.setText("0");
                } else {
                    int n = Integer.parseInt(qtd.getText().toString());
                    if (n > 0) {
                        n--;
                        qtd.setText(Integer.toString(n));
                    }
                }
            }
        });

        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(qtd.getText().toString())) {
                    qtd.setText("0");
                } else {
                    int n = Integer.parseInt(qtd.getText().toString());
                    n++;
                    qtd.setText(Integer.toString(n));
                }
            }
        });
    }

}
