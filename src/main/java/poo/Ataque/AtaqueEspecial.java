package poo.Ataque;

import poo.Niveles.Nivel;
import poo.Otros.Cronometro;
import poo.Otros.ObjetoGrafico;

public abstract class AtaqueEspecial extends ObjetoGrafico {
    protected Cronometro delay;

    public AtaqueEspecial(){
        delay = new Cronometro();
        delay.run(10000);
    }

    public abstract void realizarAtaque(Nivel nivel);

    public Cronometro getDelay(){return delay;}
}
