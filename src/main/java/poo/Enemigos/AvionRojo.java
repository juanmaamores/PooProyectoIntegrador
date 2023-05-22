package poo.Enemigos;

import poo.Interfaces.Movil;
import poo.Municion;
import poo.ObjetoGrafico;

public class AvionRojo extends Enemigo{
    public AvionRojo(){
        this.velocidad=-1;
    }
    public void update(double delta){
        this.setX(this.getX()+delta);
    }

    @Override
    public void moverse() {
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
