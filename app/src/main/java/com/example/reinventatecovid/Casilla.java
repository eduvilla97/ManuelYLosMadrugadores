package com.example.reinventatecovid;

public class Casilla {
    public int x,y,ancho;
    public int contenido=0;
    public boolean destapado=false;
    public void fijarxy(int x,int y, int ancho) {//Crea una casilla
        this.x=x;
        this.y=y;
        this.ancho=ancho;
    }

    public boolean dentro(int xx,int yy) {//Determina si la casilla existe
        return xx >= this.x && xx <= this.x + ancho && yy >= this.y && yy <= this.y + ancho;
    }
}
