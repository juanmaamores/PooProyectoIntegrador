package poo.Enemigos;

import poo.Municion;

import java.util.Vector;

public class GrupoAvionesRojos extends GrupoAviones{

    Vector<AvionRojo> aviones;

    public GrupoAvionesRojos(int alto){
        aviones = new Vector<AvionRojo>();
        int pos = 0;
        for(int i=0; i <= 3; i++) {
            aviones.add(new AvionRojo());
            aviones.get(i).setPosicion(850+pos,alto-400);
            pos += 100;
        }
    }

    public Vector<AvionRojo> getAviones(){
        return aviones;
    }

}
