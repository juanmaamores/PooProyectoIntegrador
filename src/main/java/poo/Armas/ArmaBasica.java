package poo.Armas;

import poo.Otros.Municion;
import poo.Otros.Cronometro;
import poo.Otros.Utilidades;

import java.util.ArrayList;

public class ArmaBasica extends Arma{
    public ArmaBasica(){
        poder = 25;
        velocidadDisparo = 400;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y, 0,-8,poder, Utilidades.getImagenMunicion(0)));
    }
}
