package poo.Enemigos;

import poo.Armas.ArmaBarco;
import poo.Interfaces.Movil;
import poo.Niveles.Nivel;
import poo.Otros.P38;
import poo.Otros.Utilidades;

import java.util.Random;
import java.util.Vector;

public class Barco extends Enemigo implements Movil{
    private final Vector<ArmaBarco> armas;
    private final P38 p38;

    public Barco(){
        super();
        Random random = new Random();
        x = random.nextInt(801); // Genera un número aleatorio entre 0 y 800 (inclusive)
        y = -50;
        setImagen(Utilidades.getImagenBarco(0));
        velocidadH = 0;
        velocidadV = 2;
        armas = new Vector<>();
        p38 = Nivel.getHeroe();
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        puntaje = 30;
    }

    public Vector<ArmaBarco> getArmas(){return armas;}

    @Override
    public void moverse(int ancho, int alto) {
        if(y >= 200)
            velocidadV = 1;
        armas.get(0).getDelayDisparo().update();
        armas.get(0).moverse(x,y+10);
        armas.get(1).getDelayDisparo().update();
        armas.get(1).moverse(x,y+40);
        armas.get(2).getDelayDisparo().update();
        armas.get(2).moverse(x,y+70);
        x += velocidadH;
        y += velocidadV;
    }
}