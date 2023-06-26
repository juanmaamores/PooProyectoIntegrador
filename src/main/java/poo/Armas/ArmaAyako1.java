package poo.Armas;

import poo.Otros.Cronometro;
import poo.Otros.Municion;
import poo.Otros.Utilidades;

import java.util.ArrayList;


public class ArmaAyako1 extends ArmaJefe{
    public ArmaAyako1(){
        vida = 200;
        poder = 40;
        velocidadDisparo = 1500;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
        setImagen(Utilidades.getImagenJefes(1));
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        delayDisparo.run(velocidadDisparo);
        municiones.add(new Municion(x, y,0,6,poder, Utilidades.getImagenMunicion(0)));
    }
}
