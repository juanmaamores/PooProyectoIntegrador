package poo.Armas;

import poo.Interfaces.Disparable;
import poo.Municion;
import poo.Sistema.Cronometro;

import java.util.Vector;

public abstract class Arma implements Disparable {
    protected int poder;
    protected Cronometro delayDisparo;
    protected int velocidadDisparo;

    public Cronometro getDelayDisparo(){return delayDisparo;}

    public boolean puedeDisparar(){return delayDisparo.getDelta() >= velocidadDisparo;}
}
