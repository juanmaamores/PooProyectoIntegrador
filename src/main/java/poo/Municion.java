package poo;

import poo.Interfaces.Movil;

import java.awt.image.BufferedImage;

public class Municion extends ObjetoGrafico implements Movil {

    private int baseDamage;

    public Municion(double x, double y, BufferedImage img){
        super(x, y, img);
        baseDamage = 20;
    }

    public void update(double delta){
        if(this.getX() < -10 || this.getX() > 810 || this.getY() < -10 || this.getY() > 610){
            this.destruir();
        }
        moverse();
    }

    @Override
    public void moverse() {
        this.setY(this.getY()-4);
    }
}
