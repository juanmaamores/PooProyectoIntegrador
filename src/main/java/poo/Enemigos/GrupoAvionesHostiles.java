package poo.Enemigos;

import poo.Municion;

import java.util.Vector;

public abstract class GrupoAvionesHostiles extends GrupoAviones{
    protected Vector<AvionHostil> aviones;

    public Vector<AvionHostil> getAviones(){return aviones;}
}
