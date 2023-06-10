package poo.Armas;

import poo.Municion;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.util.Vector;

public class Laser extends Arma{
    public Laser(){
        poder = 100;
        velocidadDisparo = 0;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(Vector<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y, 0,-10,poder, Utilidades.getImagenMunicion(0)));
    }
}
