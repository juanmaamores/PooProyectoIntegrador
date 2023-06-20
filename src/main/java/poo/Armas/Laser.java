package poo.Armas;

import poo.Otros.Municion;
import poo.Otros.Cronometro;
import poo.Otros.Utilidades;

import java.util.ArrayList;

public class Laser extends Arma{
    public Laser(){
        poder = 100;
        velocidadDisparo = 0;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y, 0,-10,poder, Utilidades.getImagenMunicion(0)));
    }
}
