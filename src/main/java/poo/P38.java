package poo;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;

public class P38 extends ObjetoGrafico implements Movil, Disparable {
    private int energia, velocidad, cantAtaqEsp;

    public void moverse(){};
    public Municion disparar(){return new Municion();}; //se puso este return para que no de error
}
