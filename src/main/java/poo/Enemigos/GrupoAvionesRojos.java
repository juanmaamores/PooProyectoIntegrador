package poo.Enemigos;

import poo.Juego1943;
import poo.Municion;

import java.util.Vector;

public class GrupoAvionesRojos extends GrupoAviones{

    Vector<AvionRojo> aviones;
    double ultimoDestruidoX, ultimoDestruidoY;

    public GrupoAvionesRojos(){
        super();
        int alto = Juego1943.getAlto();
        puntaje = 200;
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

    public double getUltimoDestruidoX(){return ultimoDestruidoX;}

    public void setUltimoDestruidoX(double ultimoDestruidoX){this.ultimoDestruidoX = ultimoDestruidoX;}

    public double getUltimoDestruidoY(){return ultimoDestruidoY;}

    public void setUltimoDestruidoY(double ultimoDestruidoY){this.ultimoDestruidoY = ultimoDestruidoY;}
}