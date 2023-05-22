package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;

public class AvionHostil extends Enemigo{
    public AvionHostil(){
        this.velocidad=1;
    }

    public void update(double delta){
        this.setY(this.getY()+delta);
    }

    @Override
    public void moverse() {
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
