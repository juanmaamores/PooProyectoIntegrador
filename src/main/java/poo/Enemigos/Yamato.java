package poo.Enemigos;

import poo.Otros.Municion;
import poo.Otros.P38;
import poo.Otros.Utilidades;
import poo.Armas.ArmaBarco;
import java.util.Vector;

public class Yamato extends Jefe{
    private int num;
    private final P38 p38;

    public Yamato(P38 p38){
        super();
        this.p38 = p38;
        vida = 2000;
        puntaje = 99999;
        armas = new Vector<>();
        /*
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        armas.add(new ArmaBarco(p38));
        */
        setImagen(Utilidades.getImagenJefes(0));
        x = (800/2)-(width/2);
        y = 50;
        velocidadH = 0;
        velocidadV = 2;
        //armas.add(new ArmaBarco(p38));
        //setPosicion(400,-450);
    }

    public int getNum(){return num;}
    public void setNum(int num){this.num = num;}
    @Override
    public void moverse(int ancho, int alto) {
        if(y >= 50)
            velocidadV = 0;

        armas.get(0).getDelayDisparo().update();
        armas.get(0).setPosicion(x+16,y+40);
        armas.get(1).getDelayDisparo().update();
        armas.get(1).setPosicion(x+5,y+100);
        armas.get(2).getDelayDisparo().update();
        armas.get(2).setPosicion(x+30,y+100);
        armas.get(3).getDelayDisparo().update();
        armas.get(3).setPosicion(x+16,y+140);
        armas.get(4).getDelayDisparo().update();
        armas.get(4).setPosicion(x+16,y+190);

        x += velocidadH;
        y += velocidadV;
    }
}
