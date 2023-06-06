package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;
import poo.Utilidades;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionHostil extends Enemigo implements Movil, Disparable{
    boolean disparar, diovuelta;

    public AvionHostil(){
        disparar = true;
        diovuelta = false;
        setImagen(Utilidades.getImagen(2));
    }

    @Override
    public void moverse(int ancho, int alto) {

        //Llega hasta abajo de la pantalla
        if(y >= alto-50 && !diovuelta){
            disparar = false;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagen(3));
        }

        //Llega hasta arriba de la pantalla luego de volver
        if(y <= alto-590 && velocidadV < 0) {
            disparar = true;
            diovuelta = true;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagen(2));
        }

        //El jugador no pudo matarlo, escapa
        if(y >= 620 && diovuelta){
            disparar = false;
            escapo = true;
            velocidadV *= 0;
            velocidadH *= 0;
            x = 5000;
            y = 5000;
        }

        x += velocidadH;
        y += velocidadV;
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
