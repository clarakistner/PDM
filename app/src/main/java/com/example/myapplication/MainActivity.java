package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText insira;
    EditText editTextTextNumero;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        editTextTextNumero = findViewById(R.id.editTextTextNumero);
        insira = findViewById(R.id.Insira);

        //textView.setText(Integer.toString(contador));
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, tabuadaPronta.class);
            Bundle bundle = new Bundle();
            int numeroi = Integer.parseInt((editTextTextNumero.getText().toString()));
            bundle.putInt("numeroi", numeroi);
            intent.putExtras((Intent) editTextTextNumero.getText());
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}