package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;

public abstract class Jefe extends Enemigo implements Movil, Disparable {
    protected short nroNivel;
}
