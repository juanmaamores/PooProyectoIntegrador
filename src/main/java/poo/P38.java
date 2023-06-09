package poo;

import poo.Armas.Arma;
import poo.Armas.ArmaBasica;
import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Sistema.Cronometro;

import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Movil {
    private final int DUR_BONUS_DEF= 10000;
    private int energia, cantAtaqEsp;
    private int velocidadDisparo, duracionBonus;
    private Cronometro tiempoBonus;
    private Arma arma;

    public P38(){
        super();
        setImagen(Utilidades.getImagenP38(0));
        energia = 100;
        cantAtaqEsp = 3;
        arma = new ArmaBasica();
        duracionBonus = DUR_BONUS_DEF;
        tiempoBonus = new Cronometro();
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
    };

    public void setEnergia(int e){
        if(energia + e <= 100){
            energia = energia + e;
        } else if (energia + e > 100 ){
            energia = 100;
        }
    }

    public void setVelocidadDisparo(int velocidadDisparo) {this.velocidadDisparo = velocidadDisparo;}

    public int getDuracionBonus(){return duracionBonus;}

    public int getEnergia(){return energia;}

    public Cronometro getTiempoBonus(){return tiempoBonus;}

    public Arma getArma(){return arma;}

    public void setArma(Arma arma){this.arma = arma;}

    public void chequearBonus(){
        if(tiempoBonus.getDelta() >= duracionBonus) {
            getTiempoBonus().setDelta((long)0);
            arma = new ArmaBasica();
        }
    }
}