package poo.Bonus;

import poo.Otros.P38;
import poo.Otros.Utilidades;

public class Refuerzos extends Bonus{

    public Refuerzos(){
        setImagen(Utilidades.getImagenBonus(6));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.setRefuerzo1(new AvionRefuerzo());
        heroe.setRefuerzo2(new AvionRefuerzo());
        destruir();
    }
}
