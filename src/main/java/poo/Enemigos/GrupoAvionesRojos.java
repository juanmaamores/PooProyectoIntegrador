package poo.Enemigos;

import poo.Municion;

import java.util.Vector;

public class GrupoAvionesRojos extends GrupoAviones{

    Vector<AvionRojo> aviones = new Vector<AvionRojo>();

    public GrupoAvionesRojos(){
        int pos = 0;
        for(int i=0; i <= 3; i++) {
            aviones.add(new AvionRojo());
            aviones.get(i).setPosicion(760+pos,200);
            pos += 100;
        }
    }

    public Vector<AvionRojo> getAviones(){
        return aviones;
    }

}
