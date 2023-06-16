package poo.Enemigos;

import poo.Municion;
import poo.P38;
import poo.Utilidades;
import poo.Armas.ArmaBarco;

import java.util.Vector;

public class Yamato extends Jefe{
    private Vector<ArmaBarco> armas;

    private P38 p38;

    private int num;

    public Yamato(P38 p38){
        super();
        setImagen(Utilidades.getImagenJefes(0));
        armas = new Vector<ArmaBarco>();
        this.p38 = p38;
        //setPosicion(400,-450);
        this.x = 350;
        this.y = 50;
        velocidadH = 0;
        velocidadV = 2;
        armas = new Vector<>();
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        this.puntaje = 100;
    }

    public Vector<ArmaBarco> getArmas(){return armas;}

    public int getNum(){return num;}

    public void setNum(int num){this.num = num;}
    @Override
    public void moverse(int ancho, int alto) {
        if(y >= 50)
            velocidadV = 0;

        armas.get(0).getDelayDisparo().update();
        armas.get(0).moverse(x+16,y+40);
        armas.get(1).getDelayDisparo().update();
        armas.get(1).moverse(x+5,y+100);
        armas.get(2).getDelayDisparo().update();
        armas.get(2).moverse(x+30,y+100);
        armas.get(3).getDelayDisparo().update();
        armas.get(3).moverse(x+16,y+140);
        armas.get(4).getDelayDisparo().update();
        armas.get(4).moverse(x+16,y+190);

        x += velocidadH;
        y += velocidadV;
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
