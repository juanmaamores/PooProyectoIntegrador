package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

public abstract class Enemigo extends ObjetoGrafico implements Movil, Disparable {
    protected double blindaje, velocidad;

    public void setVelocidad(double velocidad){
        this.velocidad=velocidad;
    }

    public double getVelocidad(){
        return this.velocidad;
    }
}
