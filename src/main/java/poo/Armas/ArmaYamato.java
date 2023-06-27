package poo.Armas;

import poo.Otros.Cronometro;
import poo.Otros.Municion;
import poo.Otros.P38;
import poo.Otros.Utilidades;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ArmaYamato extends ArmaJefe{
    private final P38 p38;
    private int vida;

    public ArmaYamato(P38 p38){
        vida = 300;
        poder = 25;
        velocidadDisparo = 4000;
        this.p38 = p38;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
        setImagen(Utilidades.getImagenBarco(2));
    }

    public void setVida(int vida){this.vida = vida;}

    public int getVida(){return vida;}

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        int delta,velX,velY;

        delayDisparo.run(velocidadDisparo);

        delta = (int)sqrt(pow(p38.getX()-x,2)+pow(p38.getY()-y,2))/10;
        velX = ((int)p38.getX()-x)/delta;
        velY = ((int)p38.getY()-y)/delta;

        municiones.add(new Municion(x, y, velX, velY,poder, Utilidades.getImagenMunicion(0)));
    }
}
