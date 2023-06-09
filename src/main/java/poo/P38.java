package poo;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Sistema.Cronometro;

import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Disparable, Movil {
    private static int energia, cantAtaqEsp;
    private int velocidadDeDisparoP38 = 300;
    private Cronometro velocidadDeDisparo;

    public P38(){
        setImagen(Utilidades.getImagenP38(0));
        energia = 100;
        cantAtaqEsp = 3;
        energia = energia - 20;
        velocidadDeDisparo = new Cronometro();
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
    };

    public static void setEnergia(int e){
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

    public int getVelocidadDeDisparoP38(){
        return velocidadDeDisparoP38;
    }

    @Override
    public void disparar() {
        velocidadDeDisparo.run(velocidadDeDisparoP38);
    }

    public Municion disparar(){return new Municion();}; //se puso este return para que no de error

    public boolean getVelocidadDeDisparo(){
        return velocidadDeDisparo.isRunning();
    }

    public void actualizarVelocidadDeDisparo(){
        velocidadDeDisparo.update();
    }

}





