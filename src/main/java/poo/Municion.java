package poo;

import poo.Interfaces.Movil;

import java.awt.image.BufferedImage;

public class Municion extends ObjetoGrafico implements Movil {

    private int baseDamage;

    public Municion(){
        baseDamage = 20;
        //setImagen
    }

    @Override
    public void moverse(int ancho, int alto) {
        this.setY((int)this.getY()-4);

        if(this.getX() < -10 || this.getX() > 810 || this.getY() < -10 || this.getY() > 610){
            this.destruir();
        }
    }

}
