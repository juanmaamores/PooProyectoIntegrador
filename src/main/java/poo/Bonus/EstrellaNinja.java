package poo.Bonus;

import poo.Otros.P38;
import poo.Otros.Utilidades;

public class EstrellaNinja extends PowerUp{


    public EstrellaNinja() {
        setImagen(Utilidades.getImagenBonus(4));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.setEnergia(100);
        destruir();
    }
}
