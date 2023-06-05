package poo;

import poo.Enemigos.AvionHostil;
import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class P38 extends ObjetoGrafico implements Movil, Disparable {
    //private double energia, cantAtaqEsp;

    public void moverse(int ancho, int alto){
        if(x <= 5)
            x = 5;

        if(x >= ancho-35)
            x = ancho-35;

        if(y <= alto-585)
            y = alto-585;

        if(y >= alto-30)
            y = alto-30;
    };

    public Municion disparar(){return new Municion();}; //se puso este return para que no de error

    public P38(){
        setImagen(Utilidades.getImagen(1));
    }
}
