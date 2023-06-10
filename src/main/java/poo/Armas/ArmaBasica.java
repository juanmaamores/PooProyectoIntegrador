package poo.Armas;

import poo.Municion;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.util.Vector;

public class ArmaBasica extends Arma{
    public ArmaBasica(){
        poder = 25;
        velocidadDisparo = 500;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(Vector<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y, 0,-8,poder, Utilidades.getImagenMunicion(0)));
    }
}