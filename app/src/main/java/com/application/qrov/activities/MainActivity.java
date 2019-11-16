package com.application.qrov.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.application.qrov.R;
import com.application.qrov.fragments.BuscaFragment;
import com.application.qrov.fragments.CadastroFragment;
import com.application.qrov.fragments.MaisFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.itemBusca);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Busca por QR-Code");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemBusca:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BuscaFragment()).commit();
                Objects.requireNonNull(getSupportActionBar()).setTitle("Busca por QR-Code");
                return true;

            case R.id.itemCadastro:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CadastroFragment()).commit();
                Objects.requireNonNull(getSupportActionBar()).setTitle("Cadastro de novo produto");
                return true;

            case R.id.itemMais:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MaisFragment()).commit();
                Objects.requireNonNull(getSupportActionBar()).setTitle("Mais informações");
                return true;
        }

        return false;
    }
}
