package poo.Enemigos;

import poo.Armas.ArmaAvionHostil;
import poo.Otros.Municion;
import poo.Otros.P38;
import poo.Otros.Utilidades;
import java.util.Vector;

public class Ayako1 extends Jefe{

    private Vector<ArmaAvionHostil> armas;
    private P38 p38;
    public Ayako1() {
        super();
        setImagen(Utilidades.getImagenJefes(1));
        this.x = 250;
        this.y = 100;
        velocidadH = 0;
        velocidadV = 2;
        armas = new Vector<>();
        armas.add(new ArmaAvionHostil());
        armas.add(new ArmaAvionHostil());
        armas.add(new ArmaAvionHostil());
        armas.add(new ArmaAvionHostil());
        this.puntaje = 500;
        this.vida= 500;
        //setImagen()
        //setLocation (fija)
        armas.elementAt(0).setImagen(Utilidades.getImagenBarco(3));
    }

    public Vector<ArmaAvionHostil> getArmas(){return armas;}

    @Override
    public void moverse(int ancho, int alto) {
        if(x <= 50 && x <= 750) {
            velocidadH = 1;
            velocidadV = 0;
            armas.get(0).getDelayDisparo().update();
            armas.get(0).setPosicion(x + 15, y + 50);
            armas.get(1).getDelayDisparo().update();
            armas.get(1).setPosicion(x + 30, y + 50);
            armas.get(2).getDelayDisparo().update();
            armas.get(2).setPosicion(x + 50, y + 50);
            armas.get(3).getDelayDisparo().update();
            armas.get(3).setPosicion(x + 65, y + 50);
            x += velocidadH;
            y += velocidadV;
        }
    }

    public Municion disparar() {
        return null;
    }

}
