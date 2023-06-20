package poo.Enemigos;

import java.util.Vector;

public abstract class GrupoAvionesHostiles extends GrupoAviones{
    protected Vector<AvionHostil> aviones;

    public Vector<AvionHostil> getAviones(){return aviones;}

    public void setEstado(){
        for (AvionHostil avion : aviones) {
            if(!avion.escapo()&&!avion.estaMuerto())
                return;
        }

        actualizar = false;
    }

    public boolean todosDestruidos(){
        for (AvionHostil avion: aviones) {
            if(!avion.estaMuerto())
                return false;
        }

        actualizar = false;
        return true;
    }

}
