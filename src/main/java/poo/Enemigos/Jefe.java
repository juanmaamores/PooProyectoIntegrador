package poo.Enemigos;

import poo.Armas.Arma;
import poo.Armas.ArmaAyako1;
import poo.Armas.ArmaJefe;
import poo.Interfaces.Movil;
import poo.Juego1943;
import poo.Otros.Municion;

import java.util.Vector;

public abstract class Jefe extends Enemigo implements Movil{
    protected Vector<ArmaJefe> armas;

    public Vector<ArmaJefe> getArmas(){return armas;}

    public boolean todasArmasDestruidas(){
        for(ArmaJefe arma : armas)
            if(arma.getActualizar())
                return false;

        return true;
    }

    @Override
    public void moverse(int ancho, int alto) {
        y  += velocidadV;
        if(y >= 50) {
            velocidadV = 0;
            y = 50;
        }
    }
}
