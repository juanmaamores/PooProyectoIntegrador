package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

public abstract class Enemigo extends ObjetoGrafico implements Movil, Disparable {
    protected int blindaje, velocidad;
}
