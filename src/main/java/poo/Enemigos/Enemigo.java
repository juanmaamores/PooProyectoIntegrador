package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

public abstract class Enemigo extends ObjetoGrafico {
    protected boolean muerto = false;
    protected double velocidadH, velocidadV;

    public void setVelocidadH(double velocidadH){
        this.velocidadH= velocidadH;
    }

    public double getVelocidadH(){
        return velocidadH;
    }

    public void setVelocidadV(double velocidadV){
        this.velocidadV=velocidadV;
    }

    public double getVelocidadV(){
        return velocidadV;
    }

    public void destruir(){
        super.destruir();
        muerto = true;
        velocidadH = 0;
        velocidadV = 0;
        x = -5000;
        y = 5000;
    }
}
