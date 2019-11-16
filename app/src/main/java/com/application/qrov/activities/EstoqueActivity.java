package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

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
import com.application.qrov.classes.Produto;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

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

        String QRCode = getIntent().getStringExtra("QR-Code");

        textProduto = findViewById(R.id.produto);


        boolean encontrado = false;
        int cont = 0;
        for (Produto produto1 : Produto.produtos) {
            if (produto1.QRCode().equals(QRCode)) {
                produto = cont;
                encontrado = true;
                String texto = "Nome: " + Produto.produtos.get(produto).getNome() + "\nID: " + Produto.produtos.get(produto).getId() + Produto.produtos.get(produto).toString();
                textProduto.setText(texto);
                break;
            }
            cont++;
        }

        if (!encontrado) {
            finish();
        }

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
                                    Produto editavel = Produto.produtos.get(produto);
                                    editavel.setQuantidade(editavel.getQuantidade() + Integer.parseInt(qtd.getText().toString()));
                                    Produto.produtos.set(produto, editavel);
                                    finish();
                                } else {
                                    showSnackbar("Quantidade inválida");
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
                                    Produto editavel = Produto.produtos.get(produto);
                                    if (editavel.getQuantidade() >= Integer.parseInt(qtd.getText().toString())) {
                                        editavel.setQuantidade(editavel.getQuantidade() - Integer.parseInt(qtd.getText().toString()));
                                        Produto.produtos.set(produto, editavel);
                                        finish();
                                    } else {
                                        showSnackbar("A quantidade não pode ser atualizada");
                                    }
                                } else {
                                    showSnackbar("Quantidade inválida");
                                }
                            }
                        });
                        break;

                    default:
                        showSnackbar("Operação inválida");
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

    public void showSnackbar(String msg) {
        Snackbar.make(findViewById(R.id.content), msg, Snackbar.LENGTH_LONG).show();
    }
}
