package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;

public class Barco extends Enemigo implements Movil, Disparable {
    @Override
    public void moverse(int ancho, int alto) {

    }

    @Override
    public Municion disparar() {
        return null;
    }
}
