package poo;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Sistema.Cronometro;

import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Disparable, Movil {
    private int energia, cantAtaqEsp;
    private int velocidadDeDisparo = 500;
    private Cronometro delayDisparo;

    public P38(){
        super();
        setImagen(Utilidades.getImagenP38(0));
        energia = 100;
        cantAtaqEsp = 3;
        energia = energia - 20;
        delayDisparo = new Cronometro();
        delayDisparo.run(velocidadDeDisparo);
    }

    public void moverse(int ancho, int alto){
        if(x <= 5)
            x = 5;

        if(x >= ancho-35)
            x = ancho-35;

        if(y <= alto-585)
            y = alto-585;

        if(y >= alto-30)
            y = alto-30;

        delayDisparo.update();
    };

    public void setEnergia(int e){
        if(energia + e <= 100){
            energia = energia + e;
        } else if (energia + e > 100 ){
            energia = 100;
        }
    }

    public int getEnergia(){
        return energia;
    }

    public int getVelocidadDeDisparo(){
        return velocidadDeDisparo;
    }

    @Override
    public Municion disparar() {
        delayDisparo.run(velocidadDeDisparo);
        return new Municion(x+width/2,y,-8);
    }

    public boolean puedeDisparar(){return delayDisparo.getDelta() >= velocidadDeDisparo;}

}





