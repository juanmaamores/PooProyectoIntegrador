package poo.Bonus;

import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

import java.awt.image.BufferedImage;

public abstract class Bonus extends ObjetoGrafico implements Movil {

    public Bonus(double x, double y, BufferedImage img) {
        super(x, y, img);
    }

    public void moverse(){
        this.setY(this.getY()+1);
    }

}
