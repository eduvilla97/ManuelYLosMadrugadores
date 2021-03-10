package com.example.reinventatecovid;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Pantalla_Junior extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_junior);
    }

    public void IrQueHacerJunior(View view){
        Intent abrirQueHacerJunior = new Intent(this, Que_Hago_Hoy_J.class);
        startActivity(abrirQueHacerJunior);
    }

    public void IrNoticiasJunior(View view){
        Intent abrirNoticiasJunior = new Intent(this, NoticiasJ.class);
        startActivity(abrirNoticiasJunior);
    }

    public void IrConsejos(View view){
        Intent abrirConsejosJunior = new Intent(this, Consejos.class);
        startActivity(abrirConsejosJunior);
    }

    public void IrJuegos(View view){
        Intent abrirJuegos = new Intent(this, MenuJuegos.class);
        startActivity(abrirJuegos);
    }

    public void InfoJunior (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ayuda");
        builder.setMessage("Cosas que puedes hacer\n1-Pulsar el botón de consejos para ver las recomendaciones a la hora de salir a la calle\n2-Pulsar el botón de noticias para acceder a noticias actualizadas\n3-Pulsar botón de que hacer para obtener recomendaciones de cosas para hacer\n4-Pulsa el botón de juego para acceder a un minijuego\n");
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}