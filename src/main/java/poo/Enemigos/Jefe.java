package poo.Enemigos;

import poo.Interfaces.Movil;
import poo.Otros.Municion;

public abstract class Jefe extends Enemigo implements Movil{
    public abstract Municion disparar();
}
