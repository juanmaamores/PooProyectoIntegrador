package poo.Armas;

import poo.Municion;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.util.ArrayList;
import java.util.Vector;

public class Auto extends Arma{

    public Auto(){
        poder = 25;
        velocidadDisparo = 500;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x,y,0,-8,poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x, y-20, 0, -8, poder, Utilidades.getImagenMunicion(0)));
        municiones.add(new Municion(x, y-40, 0, -8, poder, Utilidades.getImagenMunicion(0)));
    }
}
