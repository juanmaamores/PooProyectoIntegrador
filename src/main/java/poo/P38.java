package poo;

import com.entropyinteractive.Keyboard;
import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Movil, Disparable {
    //private int energia, velocidad, cantAtaqEsp;

    public void moverse(){
    };

    public Municion disparar(){return new Municion();}; //se puso este return para que no de error

    public P38(){
    }
}
