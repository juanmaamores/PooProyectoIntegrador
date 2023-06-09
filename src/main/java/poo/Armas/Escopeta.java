package poo.Armas;

import poo.Otros.Municion;
import poo.Otros.Cronometro;
import poo.Otros.Utilidades;

import java.util.ArrayList;

public class Escopeta extends Arma{
    public Escopeta(){
        poder = 35;
        velocidadDisparo = 300;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y, 0,-8,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x+8, y+6, 2,-6,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x-8, y-6, -2,-6,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x+16, y-12, 4,-4,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x-16, y-12, -4,-4,poder, Utilidades.getImagenMunicion(0)));
    }
}
