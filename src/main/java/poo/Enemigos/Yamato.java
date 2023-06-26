package poo.Enemigos;

import poo.Armas.ArmaYamato;
import poo.Juego1943;
import poo.Otros.Municion;
import poo.Otros.P38;
import poo.Otros.Utilidades;
import poo.Armas.ArmaBarco;
import java.util.Vector;

public class Yamato extends Jefe{
    private final P38 p38;

    public Yamato(P38 p38){
        super();
        setImagen(Utilidades.getImagenJefes(2));
        x = (Juego1943.getAncho()/2)-(width/2);
        y = -800;
        this.p38 = p38;
        puntaje = 99999;
        armas = new Vector<>();
        armas.add(new ArmaYamato(p38));
        armas.add(new ArmaYamato(p38));
        armas.add(new ArmaYamato(p38));
        armas.add(new ArmaYamato(p38));
        armas.add(new ArmaYamato(p38));
        velocidadH = 0;
        velocidadV = 1;
    }

    @Override
    public void moverse(int ancho, int alto) {
        super.moverse(ancho, alto);
        armas.get(0).setPosicion(x+(width/2-4),y+75);
        armas.get(1).setPosicion(x+(width/2-4),y+150);
        armas.get(2).setPosicion(x+(width/2-4),y+225);
        armas.get(3).setPosicion(x+(width/2-4),y+300);
        armas.get(4).setPosicion(x+(width/2-4),y+375);
    }
}
