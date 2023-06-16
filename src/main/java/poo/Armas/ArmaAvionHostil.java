package poo.Armas;

import poo.Municion;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.util.ArrayList;
import java.util.Vector;

public class ArmaAvionHostil extends Arma{

    public ArmaAvionHostil(){
        poder = 10;
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
