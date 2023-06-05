package poo;

import poo.Interfaces.Disparable;
import poo.Sistema.Cronometro;

import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Disparable{
    private static int energia, cantAtaqEsp;
    private int velocidadDeDisparoP38 = 300;
    private Cronometro velocidadDeDisparo;

    public P38(double v, double v1, BufferedImage imgHeroe) {
        super(v,v1,imgHeroe);
        energia = 100;
        cantAtaqEsp = 3;
        energia = energia - 20;
        velocidadDeDisparo = new Cronometro();
    }

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

    public boolean getVelocidadDeDisparo(){
        return velocidadDeDisparo.isRunning();
    }

    public void actualizarVelocidadDeDisparo(){
        velocidadDeDisparo.update();
    }

}
