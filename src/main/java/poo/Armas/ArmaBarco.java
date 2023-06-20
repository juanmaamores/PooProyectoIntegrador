package poo.Armas;

import poo.Otros.Municion;
import poo.Otros.P38;
import poo.Otros.Cronometro;
import poo.Otros.Utilidades;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ArmaBarco extends Arma{
    private P38 p38;
    private int vida;

    public ArmaBarco(P38 p38){
        vida = 50;
        poder = 25;
        velocidadDisparo = 2000;
        this.p38 = p38;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDisparo);
        setImagen(Utilidades.getImagenBarco(0));
    }

    public void setVida(int vida){this.vida = vida;}

    public int getVida(){return vida;}

    public void moverse(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void disparar(ArrayList<Municion> municiones, int x, int y) {
        int delta,velX,velY;

        delayDisparo.run(velocidadDisparo);

        delta = (int)sqrt(pow(p38.getX()-x,2)+pow(p38.getY()-y,2))/7;
        velX = ((int)p38.getX()-x)/delta;
        velY = ((int)p38.getY()-y)/delta;

        municiones.add(new Municion(x+(width-4)/2, y+(height-4)/2, velX,velY,poder, Utilidades.getImagenMunicion(0)));
    }
}
