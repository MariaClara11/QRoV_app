package com.application.qrov.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.application.qrov.R;
import com.application.qrov.database.Conexao;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario, senha;
    private Map<String, String> usuarios = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);

        getUsuariosBD();
        Button entrar = findViewById(R.id.entrar);
        entrar.setOnClickListener(v -> {
            if (TextUtils.isEmpty(usuario.getText()) || TextUtils.isEmpty(senha.getText())) {
                Snackbar.make(new View(LoginActivity.this), "Campos obrigatórios", Snackbar.LENGTH_LONG).show();
            } else {
                if (usuarios.containsKey(usuario.getText().toString())) {
                    if (Objects.equals(usuarios.get(usuario.getText().toString()), senha.getText().toString())) {
                        startActivity(new Intent(LoginActivity.this, SplashActivity.class));
                    } else {
                        Snackbar.make(new View(LoginActivity.this), "Senha incorreta", Snackbar.LENGTH_LONG).show();
                    }
                } else {
                    Snackbar.make(new View(LoginActivity.this), "Usuário não existe", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        TextView help = findViewById(R.id.help);
        help.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, AjudaActivity.class));
        });
    }

    private void getUsuariosBD() {
        String url = Conexao.HOST + "select_all_usuario.php";

        Ion.with(LoginActivity.this)
                .load(url)
                .asJsonArray()
                .setCallback((e, result) -> {
                    for (int i = 0; i < result.size(); i++) {
                        JsonObject object = result.get(i).getAsJsonObject();
                        usuarios.put(object.get("Nome_Usuario").getAsString(), object.get("Senha").getAsString());
                    }
                });
    }
}
