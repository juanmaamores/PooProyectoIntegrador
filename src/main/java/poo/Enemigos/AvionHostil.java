package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;
import poo.Utilidades;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionHostil extends Enemigo implements Movil, Disparable{
    boolean disparar;
    public AvionHostil(){
        disparar = true;
        setImagen(Utilidades.getImagen(2));
    }

    @Override
    public void moverse(int ancho, int alto) {
        if(y >= alto-50){
            disparar = false;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagen(3));
        }

        if(y <= alto-590 && velocidadV < 0) {
            disparar = true;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagen(2));
        }

        x += velocidadH;
        y += velocidadV;
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
