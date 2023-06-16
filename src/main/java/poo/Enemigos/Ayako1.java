package poo.Enemigos;

import poo.Armas.ArmaAvionHostil;
import poo.Armas.ArmaBarco;
import poo.Municion;
import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class Ayako1 extends Jefe{

    private Vector<ArmaAvionHostil> armas;
    private P38 p38;
    public Ayako1() {
        super();
        setImagen(Utilidades.getImagenJefes(1));
        this.x = 250;
        this.y = 100;
        velocidadH = 0;
        velocidadV = 2;
        armas = new Vector<>();
        armas.add(new ArmaAvionHostil());
        armas.add(new ArmaAvionHostil());
        armas.add(new ArmaAvionHostil());
        armas.add(new ArmaAvionHostil());
        this.puntaje = 100;
        this.vida= 500;
        //setImagen()
        //setLocation (fija)
    }

    public Vector<ArmaAvionHostil> getArmas(){return armas;}

    @Override
    public void moverse(int ancho, int alto) {
        armas.get(0).getDelayDisparo().update();
        armas.get(0).setPosicion(x+15,y+50);
        armas.get(1).getDelayDisparo().update();
        armas.get(1).setPosicion(x+30,y+50);
        armas.get(2).getDelayDisparo().update();
        armas.get(2).setPosicion(x+50,y+50);
        armas.get(3).getDelayDisparo().update();
        armas.get(3).setPosicion(x+65,y+50);
    }

    public Municion disparar() {
        return null;
    }

}
