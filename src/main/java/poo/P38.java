package poo;

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

    public void moverse(){
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
