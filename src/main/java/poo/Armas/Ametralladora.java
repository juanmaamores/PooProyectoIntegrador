package poo.Armas;

import poo.Municion;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.util.Vector;

public class Ametralladora extends Arma{
    public Ametralladora(){
        poder = 25;
        velocidadDisparo = 400;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(Vector<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y,0,-8,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x+10, y-10, 4,-8,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x-10, y-10, -4,-8,poder, Utilidades.getImagenMunicion(0)));
    }
}
