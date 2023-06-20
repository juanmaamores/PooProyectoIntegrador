package poo.Enemigos;

import poo.Armas.Arma;
import poo.Armas.ArmaAvionHostil;
import poo.Interfaces.Movil;
import poo.Otros.Utilidades;

public class AvionHostil extends Enemigo implements Movil{
    private final Arma arma;
    private boolean diovuelta, volviendo;


    public AvionHostil(){
        super();
        vida = 100;
        puntaje = 100;
        diovuelta = false;
        volviendo = false;
        arma = new ArmaAvionHostil();
        setImagen(Utilidades.getImagenAvionHostil(0));
    }

    public boolean getVolviendo(){return volviendo;}

    @Override
    public void moverse(int ancho, int alto) {

        //Llega hasta abajo de la pantalla

        if(y >= alto-80 && y < alto-50  && !volviendo && !diovuelta){
            setImagen(Utilidades.getImagenAvionHostil(1));
        }

        if(y >= alto-45 && y < alto-40 && !volviendo && !diovuelta){
            setImagen(Utilidades.getImagenAvionHostil(2));
        }

        if(y >= alto-40 && !diovuelta){
            volviendo = true;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagenAvionHostil(3));
        }

        //Llega hasta arriba de la pantalla luego de volver
        if(y <= alto-590 && volviendo) {
            diovuelta = true;
            volviendo = false;
            velocidadV *= -1;
            velocidadH *= -1;
            setImagen(Utilidades.getImagenAvionHostil(0));
        }

        //El jugador no pudo matarlo, escapa
        if(y >= 620 && diovuelta){
            escapar();
        }

        x += velocidadH;
        y += velocidadV;
    }

    public Arma getArma(){return arma;}
}
