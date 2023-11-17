package com.example.barberia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

         ImageView atras = findViewById(R.id.salir3);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button btnUbi= findViewById(R.id.btn_verUbicacion);

        btnUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this, Ubicacion.class);
                startActivity(intent);
            }
        });

        @SuppressLint("MissingInflatedId") Button btnReserve= findViewById(R.id.btn_Agendar);

       btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {

               Intent intent = new Intent(Menu.this, ListReserve.class);
                startActivity(intent);
           }
       });




    }
}