package poo.Armas;

import poo.Otros.Municion;
import poo.Otros.Cronometro;
import poo.Otros.Utilidades;

import java.util.ArrayList;

public class ArmaAvionHostil extends Arma{

    public ArmaAvionHostil(){
        poder = 5;
        velocidadDisparo = 2000;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y,0,6,poder, Utilidades.getImagenMunicion(0)));
    }
}
