package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class tabuadaPronta extends AppCompatActivity {

    TextView textViewTabuada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        textViewTabuada = findViewById(R.id.textViewTabuada);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int numero = bundle.getInt("numeroi");

        textViewTabuada.setText(numero);
    }
}
