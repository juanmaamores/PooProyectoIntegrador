package poo.Bonus;

import poo.P38;
import poo.Utilidades;

public class LaserBonus extends ArmaEspecial{

    public LaserBonus() {
        setImagen(Utilidades.getImagenBonus(5));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        //accion
        destruir();
    }
}
