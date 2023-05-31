package poo.Bonus;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;

import java.sql.Ref;

public class AvionRefuerzo implements Disparable, Movil {
    @Override
    public Municion disparar() {
        return null;
    }

    @Override
    public void moverse(int ancho, int alto) {

    }

    public void destruir(){

    }
}
