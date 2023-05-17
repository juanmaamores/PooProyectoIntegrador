package poo.Enemigos;

import poo.Disparable;
import poo.Movil;
import poo.ObjetoGrafico;

public abstract class Enemigo extends ObjetoGrafico implements Movil, Disparable {
    protected int blindaje, velocidad;
}
