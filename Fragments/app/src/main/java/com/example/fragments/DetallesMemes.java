package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesMemes extends AppCompatActivity {

    ImageView imagen;
    TextView nombrememe;
    TextView detalles;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_memes);

        List_Meme meme = (List_Meme) getIntent().getSerializableExtra("List_Meme");
        imagen = findViewById(R.id.imagen);
        nombrememe = findViewById(R.id.nombrememe);
        detalles = findViewById(R.id.detalles);

        imagen.setImageAlpha(imagen.getImageAlpha());

        nombrememe.setText(meme.getNombre());

        detalles.setText(meme.getDescripcion());
    }
}