package com.example.reinventatecovid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.net.Uri;
import android.widget.Button;

public class Pantalla_senior extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_senior);
    }
    public void llamarEmergencias(View view) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:+34112"));
        startActivity(i);
    }
    public void IrNoticias (View view) {
        Intent abrir_noticia = new Intent(this, Noticias.class);
        startActivity(abrir_noticia);
    }
    public void IrQuehacer (View view) {
        Intent abrir_que_hacer = new Intent(this, Que_hacer_hoy.class);
        startActivity(abrir_que_hacer);
    }
    public void InfoSenior (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ayuda");
        builder.setMessage("Cosas que puedes hacer\n1-Pulsar el botón de emergencias para llamar al 112\n2-Pulsar el botón de noticias para acceder a noticias actualizadas\n3-Pulsar botón de que hacer para obtener recomendaciones de cosas para hacer\n");
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}