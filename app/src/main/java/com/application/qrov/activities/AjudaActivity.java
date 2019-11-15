package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.application.qrov.R;

import java.util.Objects;

public class AjudaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Ajuda");
    }
}
