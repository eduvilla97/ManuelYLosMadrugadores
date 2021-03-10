package com.example.reinventatecovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Memory extends AppCompatActivity {

    //los botones del juego
    ImageButton el0, el1, el2, el3, el4, el5, el6, el7,
            el8, el9, el10, el11, el12, el13, el14, el15;

    //los botones del menú
    Button reiniciar, salir;

    //las imágenes
    int imagenes[];
    //se guardan duplicadas en un array
    ImageButton [] botonera = new ImageButton[16];

    //imagen de fondo;
    int fondo;

    //para barajar
    //el ArrayList que recoge el resultado de barajar
    ArrayList<Integer> arrayBarajado;

    //COMPARACIÓN
    //los botones que se han pulsado y se comparan
    ImageButton primero;
    //posiciones de las imágenes a comparar en el vector de imágenes
    int numeroPrimero, numeroSegundo;

    //durante un segundo se bloquea el juego y no se puede pulsar ningún botón
    boolean bloqueo = false;

    //para controlar las pausas del juego
    final Handler handler = new Handler();

    //finalmente, el número de aciertos y la puntuación
    int aciertos=0;
    int puntuacion=0;
    TextView textoPuntuacion;

    public void comprobar(int i, final ImageButton imgb){
        if(primero==null){//ningún botón ha sido pulsado
            //el botón primero será el que acabamos de pulsar
            primero = imgb;
        /*le asignamos la imagen del vector imágenes situada
        en la posición arrayBarajado.get(i), con un valor entre 0 y 7*/
            primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
            primero.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            primero.setEnabled(false);
            //almacenamos el valor de arrayBarajado[i]
            numeroPrimero=arrayBarajado.get(i);
        }else{//ya hay un botón descubierto
            //bloqueamos todos los demás
            bloqueo=true;
            //el botón segundo será el que acabamos de pulsar
        /*le asignamos la imagen del vector imágenes situada
        en la posición arrayBarajado.get(i), con un valor entre 0 y 7*/
            imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgb.setImageResource(imagenes[arrayBarajado.get(i)]);
            //bloqueamos el botón
            imgb.setEnabled(false);
            //almacenamos el valor de arrayBarajado.get(i)
            numeroSegundo=arrayBarajado.get(i);
            if(numeroPrimero==numeroSegundo){//si coincide el valor los dejamos   destapados
                //reiniciamos
                primero=null;
                bloqueo=false;
                //aumentamos los aciertos y la puntuación
                aciertos++;
                puntuacion++;
                textoPuntuacion.setText("Puntuación: " + puntuacion);
                //al llegar a 8 aciertos se ha ganado el juego
                if(aciertos==8){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Has  ganado!!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }else{//si NO coincide el valor los volvemos a tapar al cabo de un segundo
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //les ponemos la imagen de fondo
                        primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        primero.setImageResource(R.drawable.covid_background);
                        imgb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imgb.setImageResource(R.drawable.covid_background);
                        //los volvemos a habilitar
                        primero.setEnabled(true);
                        imgb.setEnabled(true);
                        //reiniciamos la variables auxiliares
                        primero = null;
                        bloqueo = false;
                        //restamos uno a la puntuación
                        if (puntuacion > 0) {
                            puntuacion--;
                            textoPuntuacion.setText("Puntuación: " + puntuacion);
                        }
                    }
                }, 1000);//al cabo de un segundo
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        //NUEVAS LÍNEAS
        cargarImagenes();
        botonesMenu();
        iniciar();
    }

    public void iniciar(){
        arrayBarajado = barajar(imagenes.length*2);
        cargarBotones();

        //MOSTRAMOS LA IMAGEN
        for(int i=0; i<botonera.length; i++) {
            botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            botonera[i].setImageResource(imagenes[arrayBarajado.get(i)]);
        }

        //Y EN UN SEGUNDO LA OCULTAMOS
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < botonera.length; i++) {
                    botonera[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    botonera[i].setImageResource(fondo);
                }
            }
        }, 1000);

        //AÑADIMOS LOS EVENTOS A LOS BOTONES DEL JUEGO
        for(int i=0; i <arrayBarajado.size(); i++){
            final int j=i;
            botonera[i].setEnabled(true);
            botonera[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!bloqueo)
                        comprobar(j, botonera[j]);
                }
            });
        }
        aciertos=0;
        puntuacion=0;
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }

    public void cargarImagenes(){
        imagenes = new int[]{
                R.drawable.bateria,
                R.drawable.masbaratilla,
                R.drawable.batman,
                R.drawable.pistolaok,
                R.drawable.pistolapop,
                R.drawable.monigote,
                R.drawable.vacuna,
                R.drawable.corona,
        };

        fondo = R.drawable.covsars_background;
    }

    public ArrayList<Integer> barajar(int longitud) {
        ArrayList resultadoA = new ArrayList<Integer>();
        for(int i=0; i<longitud; i++)
            resultadoA.add(i % longitud/2);
        Collections.shuffle(resultadoA);
        return  resultadoA;
    }

    public void cargarBotones(){
        el0 = (ImageButton) findViewById(R.id.boton00);
        botonera[0] = el0;
        el1 = (ImageButton) findViewById(R.id.boton01);
        botonera[1] = el1;
        el2 = (ImageButton) findViewById(R.id.boton02);
        botonera[2] = el2;
        el3 = (ImageButton) findViewById(R.id.boton03);
        botonera[3] = el3;
        el4 = (ImageButton) findViewById(R.id.boton04);
        botonera[4] = el4;
        el5 = (ImageButton) findViewById(R.id.boton05);
        botonera[5] = el5;
        el6 = (ImageButton) findViewById(R.id.boton06);
        botonera[6] = el6;
        el7 = (ImageButton) findViewById(R.id.boton07);
        botonera[7] = el7;
        el8 = (ImageButton) findViewById(R.id.boton08);
        botonera[8] = el8;
        el9 = (ImageButton) findViewById(R.id.boton09);
        botonera[9] = el9;
        el10 = (ImageButton) findViewById(R.id.boton10);
        botonera[10] = el10;
        el11 = (ImageButton) findViewById(R.id.boton11);
        botonera[11] = el11;
        el12 = (ImageButton) findViewById(R.id.boton12);
        botonera[12] = el12;
        el13 = (ImageButton) findViewById(R.id.boton13);
        botonera[13] = el13;
        el14 = (ImageButton) findViewById(R.id.boton14);
        botonera[14] = el14;
        el15 = (ImageButton) findViewById(R.id.boton15);
        botonera[15] = el15;

        textoPuntuacion = (TextView)findViewById(R.id.textoPuntuacion);
        textoPuntuacion.setText("Puntuación: " + puntuacion);
    }

    public void botonesMenu(){
        reiniciar = (Button) findViewById(R.id.Reiniciar);
        salir = (Button) findViewById(R.id.Salir);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar();
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}