package poo;

import com.entropyinteractive.Keyboard;
import poo.Armas.Arma;
import poo.Armas.ArmaBasica;
import poo.Armas.Escopeta;
import poo.Bonus.AvionRefuerzo;
import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Sistema.Cronometro;

import java.awt.*;
import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Movil {
    private int energia, cantAtaqEsp;
    private int duracionBonus;
    private Cronometro tiempoBonus;
    private Arma arma;
    private AvionRefuerzo refuerzo1, refuerzo2;
    private Rectangle rango;

    public P38(){
        super();
        setImagen(Utilidades.getImagenP38(0));
        energia = 100;
        cantAtaqEsp = 3;
        arma = new ArmaBasica();
        duracionBonus = 10000;
        tiempoBonus = new Cronometro();
        refuerzo1 = null;
        refuerzo2 = null;
    }

    public void moverse(int ancho, int alto){
        if(x <= 5)
            x = 5;

        if(x >= ancho-35)
            x = ancho-35;

        if(y <= alto-585)
            y = alto-585;

        if(y >= alto-38)
            y = alto-38;

        if(refuerzo1 != null) {
            refuerzo1.moverse(x - 2 * (int) refuerzo1.getWidth(), y);
            refuerzo1.getArma().getDelayDisparo().update();
        }
        if(refuerzo2 != null) {
            refuerzo2.moverse(x + 2 * (int) refuerzo2.getWidth(), y);
            refuerzo2.getArma().getDelayDisparo().update();
        }

        if(rango != null)
            rango.setLocation(x+width/2-(int)rango.getWidth()/2,y-(int)rango.getHeight()+height);

    };

    public void setEnergia(int e){
        if(energia + e <= 100){
            energia = energia + e;
        } else if (energia + e > 100 ){
            energia = 100;
        }
    }

    public int getDuracionBonus(){return duracionBonus;}

    public int getEnergia(){return energia;}

    public Cronometro getTiempoBonus(){return tiempoBonus;}

    public Arma getArma(){return arma;}

    public void setArma(Arma arma){this.arma = arma;}

    public void setRefuerzo1(AvionRefuerzo refuerzo1){this.refuerzo1 = refuerzo1;}

    public AvionRefuerzo getRefuerzo1(){return refuerzo1;}

    public AvionRefuerzo getRefuerzo2(){return refuerzo2;}

    public void setRefuerzo2(AvionRefuerzo refuerzo2){this.refuerzo2 = refuerzo2;}

    public void setRango(Rectangle rango){this.rango = rango;}

    public Rectangle getRango(){return rango;}

    public void chequearBonus(){
        if(tiempoBonus.getDelta() >= duracionBonus) {
            getTiempoBonus().setDelta(0);
            rango = null;
            arma = new ArmaBasica();
        }
    }
}