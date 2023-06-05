package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

import java.awt.image.BufferedImage;

public abstract class Enemigo extends ObjetoGrafico implements Movil, Disparable {
    protected int blindaje, velocidad;

    public Enemigo(double x, double y, BufferedImage img) {
        super(x, y, img);
    }
}
