package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;
import poo.Utilidades;

public class Barco extends Enemigo implements Movil, Disparable {
    public Barco(int x, int y){
        this.x = x;
        this.y = y;
        velocidadH = 0;
        velocidadV = 1;
        //setImagen(Utilidades.getImagen());
    }

    @Override
    public void moverse(int ancho, int alto) {
        if(y == alto/2)
            velocidadV = 0;

        x += velocidadH;
        y += velocidadV;
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
