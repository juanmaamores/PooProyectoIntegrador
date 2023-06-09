package poo.Bonus;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;
import poo.ObjetoGrafico;

import java.awt.image.BufferedImage;

public class AvionRefuerzo extends ObjetoGrafico implements Disparable, Movil {
    public AvionRefuerzo() {

    }

    @Override
    public Municion disparar() {
        return null;
    }

    @Override
    public void moverse(int ancho, int alto) {

    }

    public void destruir(){

    }
}
