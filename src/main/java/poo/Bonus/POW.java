package poo.Bonus;

import poo.Otros.P38;
import poo.Otros.Utilidades;

public class POW extends PowerUp{

    public POW() {
        setImagen(Utilidades.getImagenBonus(0));
    }

    public void ejecutarAccion(P38 heroe){
        heroe.setEnergia(30);
        destruir();
    }

}
