package poo.Enemigos;

import poo.Juego1943;

import java.util.Vector;

import static java.lang.Math.abs;

public class GrupoAvionesHostilesFormacion3 extends GrupoAvionesHostiles{
    public GrupoAvionesHostilesFormacion3(){
        super();
        int alto = Juego1943.getAlto();
        aviones = new Vector<>();
        int pos = 0;
        for(int i=0; i <= 4; i++) {
            aviones.add(new AvionHostil());
            aviones.get(i).setVelocidadH(0);
            aviones.get(i).setVelocidadV(2);
            aviones.get(i).setPosicion(370+pos,(alto-805)-(abs(pos)));
            if((i%2)==0)
                pos += 80;
            pos *= -1;
        }
        puntaje = 500;
    }
}