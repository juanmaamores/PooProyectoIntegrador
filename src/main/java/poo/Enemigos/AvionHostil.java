package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;
import poo.Utilidades;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionHostil extends Enemigo implements Movil, Disparable{
    boolean disparar, diovuelta, abajo;

    public AvionHostil(){
        disparar = true;
        diovuelta = false;
        abajo = true;
        setImagen(Utilidades.getImagenAvionHostil(0));
    }

    @Override
    public void moverse(int ancho, int alto) {

        //Llega hasta abajo de la pantalla

        if(y == alto-60 && abajo && !diovuelta){
            setImagen(Utilidades.getImagenAvionHostil(1));
        }

        if(y == alto-45 && abajo && !diovuelta){
            setImagen(Utilidades.getImagenAvionHostil(2));
        }

        if(y >= alto-40 && !diovuelta){
            abajo = false;
            disparar = false;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagenAvionHostil(3));
        }

        //Llega hasta arriba de la pantalla luego de volver
        if(y <= alto-590 && !abajo) {
            disparar = true;
            diovuelta = true;
            abajo = true;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagenAvionHostil(0));
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
