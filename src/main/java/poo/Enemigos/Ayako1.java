package poo.Enemigos;

import poo.Armas.ArmaAvionHostil;
import poo.Armas.ArmaAyako1;
import poo.Juego1943;
import poo.Otros.Cronometro;
import poo.Otros.Municion;
import poo.Otros.P38;
import poo.Otros.Utilidades;
import java.util.Vector;

public class Ayako1 extends Jefe{
    public Ayako1() {
        super();
        puntaje = 10000;
        setImagen(Utilidades.getImagenJefes(0));
        x = (Juego1943.getAncho()/2)-(width/2);
        y = 50;
        armas = new Vector<>();
        armas.add(new ArmaAyako1());
        armas.add(new ArmaAyako1());
        armas.add(new ArmaAyako1());
        armas.add(new ArmaAyako1());
        armas.get(0).setPosicion(x + (width/2-4)-15, y + 90);
        armas.get(1).setPosicion(x + (width/2-4)-80, y + 90);
        armas.get(2).setPosicion(x + (width/2-4)+15, y + 90);
        armas.get(3).setPosicion(x + (width/2-4)+80, y + 90);
        velocidadH = 0;
        velocidadV = 2;
    }

    @Override
    public void moverse(int ancho, int alto) {
    }
}
