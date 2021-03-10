package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

public class Que_Hago_Hoy_J extends AppCompatActivity {
    private LinkedList<LinkedList> Lista = new LinkedList<>();
    private LinkedList<String> ListaDeportes = new LinkedList<>();
    private LinkedList<String> ListaPeliculas = new LinkedList<>();
    private LinkedList<String> ListaJuegos = new LinkedList<>();
    private TextView Texto1,Texto2;
    public Random r = new Random();
    public int valorDado = r.nextInt(3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_hacer_hoy);
        InicializarListas();

        Texto1 = (TextView) findViewById(R.id.texto);
        Texto1.setText(SacarActividad(valorDado));

        Texto2 = (TextView) findViewById(R.id.texto2);
        Texto2.setText(SacarModalidad(valorDado));
    }
    private void InicializarListas(){

        ListaDeportes.add("-Futbol");
        ListaDeportes.add("-Zumba");
        ListaDeportes.add("-Baloncesto");
        ListaDeportes.add("-Montar en bici");
        ListaDeportes.add("-Aerobic en familia");
        ListaDeportes.add("-¡Toca caminar!");
        ListaDeportes.add("-Circuito de obstaculos");


        ListaPeliculas.add("-Soul");
        ListaPeliculas.add("-Monstruos sa");
        ListaPeliculas.add("-Tu a londres y yo a california");
        ListaPeliculas.add("-Del Reves");
        ListaPeliculas.add("-Solo en casa");
        ListaPeliculas.add("-Vengadores");
        ListaPeliculas.add("-Aquaman");
        ListaPeliculas.add("-Madagascar");
        ListaPeliculas.add("-Bob Esponja");
        ListaPeliculas.add("-Shrek");
        ListaPeliculas.add("-Bee movie");
        ListaPeliculas.add("-Bichos");
        ListaPeliculas.add("-Gru, mi villano favorito");


        ListaJuegos.add("-Parchís");
        ListaJuegos.add("-Uno");
        ListaJuegos.add("-Escondite");
        ListaJuegos.add("-Comba");
        ListaJuegos.add("-Los animales invaden nuestra casa");
        ListaJuegos.add("-Haz un puzzle");
        ListaJuegos.add("-Carreras de coches");
        ListaJuegos.add("-Al Ahorcado");
        ListaJuegos.add("-Alto el lápiz / stop");

        Lista.add(ListaDeportes);
        Lista.add(ListaPeliculas);
        Lista.add(ListaJuegos);
    }

    public String SacarActividad (int valor){
        String aux="";
        switch (valor){
            case 0 :{
                for (int i=0; i<Lista.size(); i++){
                    aux = Lista.get(0).get(i) + "\n" + aux;
                }
                return aux;
            }
            case 1 :{
                for (int i=0; i<Lista.size(); i++){
                    aux = Lista.get(1).get(i) + "\n" + aux;
                }
                return aux;
            }
            case 2 :{
                for (int i=0; i<Lista.size(); i++){
                    aux = Lista.get(2).get(i) + "\n" + aux;
                }
                return aux;
            }

        }
        return "Error";
    }
    public String SacarModalidad (int valor){
        switch (valor){
            case 0 :{
                return "¡Hacer deporte!" +
                        "\nAquí tienes algunas actividades que podrían gustarte:";
            }
            case 1 :{
                return "¡Ver peliculas!"+
                        "\nTe proponemos las siguientes películas que pueden resultar interesantes:";
            }
            case 2 :{
                return "¡Jugar!"+
                        "\n Algunas ideas de juegos con los que puedes divertirte:";
            }

        }
        return "Error";
    }

}