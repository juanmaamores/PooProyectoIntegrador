package poo.Bonus;

import java.util.Vector;

public abstract class Refuerzos {
    private Vector<AvionRefuerzo> aviones;

    public Refuerzos(){
        aviones.add(new AvionRefuerzo());
        aviones.add(new AvionRefuerzo());
    }

}
