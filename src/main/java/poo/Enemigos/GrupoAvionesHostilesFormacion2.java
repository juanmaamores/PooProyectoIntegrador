package poo.Enemigos;

import poo.Juego1943;

import java.util.Vector;

public class GrupoAvionesHostilesFormacion2 extends GrupoAvionesHostiles{
    public GrupoAvionesHostilesFormacion2(){
        super();
        int alto = Juego1943.getAlto();
        aviones = new Vector<>();
        int pos = 0;
        for(int i=0; i <= 2; i++) {
            aviones.add(new AvionHostil());
            aviones.get(i).setVelocidadH(0);
            aviones.get(i).setVelocidadV(2);
            aviones.get(i).setPosicion(50,alto-805-pos);
            pos += 100;
        }
        puntaje = 300;
    }
}