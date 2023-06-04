package poo;

import com.entropyinteractive.Keyboard;
import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Movil, Disparable {
    private int energia, velocidad, cantAtaqEsp;

    public P38(){
        energia = 100;
        velocidad = 1;
        cantAtaqEsp = 3;
        energia = energia - 20;
    }

    public void setEnergia(int e){
        if(energia + e <= 100){
            energia = energia + e;
        } else if (energia + e > 100 ){
            energia = 100;
        }
        System.out.println("Energia P38: "+ energia);
    }

    public int getEnergia(){
        return energia;
    }

    public void moverse(){
    }

    public Municion disparar(){
        return new Municion();
    }

}
