package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

public class Consejos extends AppCompatActivity {

    private LinkedList<String> Lista = new LinkedList<>();
    private TextView Texto1,Texto2;
    public Random r = new Random();
    public int valorDado = r.nextInt(3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);
        InicializarListas();

        Texto1 = (TextView) findViewById(R.id.texto);
        Texto1.setText(SacarActividad());

        Texto2 = (TextView) findViewById(R.id.texto2);
        Texto2.setText(SacarModalidad());
    }
    private void InicializarListas(){

        Lista.add("Lavate las manos con agua y jabón");
        Lista.add("Mantén distancia de seguridad");
        Lista.add("Utiliza mascarilla");
        Lista.add("Si tienes fiebre quedate en casa");
        Lista.add("Cubrete bien al estornudar o toser");
        Lista.add("Si tienes hermanos o hermanas pequeños ayuda a cuidarlos");
        Lista.add("Demuestra a tu familia que la quieres");




    }

    public String SacarActividad (){
        Random r = new Random();
        int posicionRandom = r.nextInt(Lista.size());
        String aux="";
        aux = Lista.get(posicionRandom);
        return aux;
    }
    public String SacarModalidad (){
        return "Contra el covid" +
                "\nQue hacer para no infectar";
    }
}