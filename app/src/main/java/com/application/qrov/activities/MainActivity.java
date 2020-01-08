package com.application.qrov.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.application.qrov.R;
import com.application.qrov.fragments.BuscaFragment;
import com.application.qrov.fragments.CadastroMateriaPrimaFragment;
import com.application.qrov.fragments.MaisFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.itemBusca);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemBusca:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BuscaFragment()).commit();
                return true;

            case R.id.itemCadastro:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new CadastroMateriaPrimaFragment()).commit();
                return true;

            case R.id.itemMais:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MaisFragment()).commit();
                return true;
        }

        return false;
    }
}
