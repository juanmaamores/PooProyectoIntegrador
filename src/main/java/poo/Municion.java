package poo;

import poo.Interfaces.Movil;

import java.awt.image.BufferedImage;

public class Municion extends ObjetoGrafico implements Movil {

    private int poder, velocidadH, velocidadV;

    public Municion(int x, int y, int velocidadH, int velocidadV, int poder, BufferedImage imagen){
        super();
        this.poder = poder;
        setImagen(imagen);
        this.x = x;
        this.y = y;
        this.velocidadH = velocidadH;
        this.velocidadV = velocidadV;
    }

    public void setPoder(int poder){this.poder = poder;}

    public int getPoder(){return poder;}

    @Override
    public void moverse(int ancho, int alto) {
        x += velocidadH;
        y += velocidadV;

        if(this.getX() < -10 || this.getX() > ancho || this.getY() < -10 || this.getY() > alto){
            this.destruir();
        }
    }

}
