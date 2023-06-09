package poo;

import poo.Interfaces.Movil;

import java.awt.image.BufferedImage;

public class Municion extends ObjetoGrafico implements Movil {

    private int poder, velocidad;

    public Municion(int x, int y, int velocidad){
        super();
        poder = 25;
        setImagen(Utilidades.getImagenMunicion(0));
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
    }

    public void setPoder(int poder){this.poder = poder;}

    public int getPoder(){return poder;}

    @Override
    public void moverse(int ancho, int alto) {
        this.setY((int)this.getY()+velocidad);

        if(this.getX() < -10 || this.getX() > ancho || this.getY() < -10 || this.getY() > alto){
            this.destruir();
        }
    }

}
