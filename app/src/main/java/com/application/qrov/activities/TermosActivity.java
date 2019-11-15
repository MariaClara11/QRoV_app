package com.application.qrov.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.application.qrov.R;

import java.util.Objects;

public class TermosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Termos de uso");
    }
}
