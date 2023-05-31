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
        if(posicion.x <= 5)
            posicion.x = 5;

        if(posicion.x >= ancho-35)
            posicion.x = ancho-35;

        if(posicion.y <= alto-585)
            posicion.y = alto-585;

        if(posicion.y >= alto-30)
            posicion.y = alto-30;
    };

    public Municion disparar(){return new Municion();}; //se puso este return para que no de error

    public P38(){
        try {
            setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/p38.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
