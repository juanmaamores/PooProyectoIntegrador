package poo.Bonus;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

import java.awt.image.BufferedImage;

public class AvionRefuerzo extends ObjetoGrafico implements Disparable, Movil {
    public AvionRefuerzo(double x, double y, BufferedImage img) {
        super(x, y, img);
    }

    @Override
    public void disparar() {

    }

    @Override
    public void moverse() {

    }

    public void destruir(){

    }
}
