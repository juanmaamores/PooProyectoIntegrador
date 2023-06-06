package poo.Enemigos;

import poo.Municion;

import java.util.Vector;

public class GrupoAvionesRojos extends GrupoAviones{

    Vector<AvionRojo> aviones;
    AvionRojo ultimoDestruido;

    public GrupoAvionesRojos(int alto){
        aviones = new Vector<>();
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

    public void setEstado(){
        for (AvionRojo avion : aviones) {
            if(!avion.escapo()&&!avion.estaMuerto())
                return;
        }

        actualizar = false;
    }

    public boolean todosDestruidos(){

        for (AvionRojo avion: aviones) {
            if(!avion.estaMuerto())
                return false;
        }

        actualizar = false;
        return true;
    }

    public AvionRojo getUltimoDestruido(){return ultimoDestruido;}

}
