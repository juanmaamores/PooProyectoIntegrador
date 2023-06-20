package poo.Armas;

import poo.Interfaces.Disparable;
import poo.Otros.ObjetoGrafico;
import poo.Otros.Cronometro;

public abstract class Arma extends ObjetoGrafico implements Disparable {
    protected int poder;
    protected Cronometro delayDisparo;
    protected int velocidadDisparo;

    public Cronometro getDelayDisparo(){return delayDisparo;}

    public boolean puedeDisparar(){return delayDisparo.getDelta() >= velocidadDisparo;}

    public void setVelocidadDisparo(int velocidadDisparo){this.velocidadDisparo = velocidadDisparo;}
}
