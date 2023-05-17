package poo.Enemigos;

import poo.Municion;

import java.util.Vector;

public class GrupoAvionesHostiles extends GrupoAviones{
    private Vector<AvionHostil> aviones;
    public void moverse(){};
    public Municion disparar(){return null;};
    // Estos métodos deben quedar vacíos, ya que cada avión controla su propio comportamiento
}
