package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuJuegos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_juegos);
    }

    public void IrBuscaminas(View view){
        Intent abrirBuscaminas = new Intent(this, Buscaminas.class);
        startActivity(abrirBuscaminas);
    }

    public void AbrirMemory(View view) {
        Intent abrir_memory = new Intent(this, Memory.class);
        startActivity(abrir_memory);
    }
}