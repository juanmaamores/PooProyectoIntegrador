package poo.Bonus;

import poo.P38;
import poo.Utilidades;

public class EscopetaBonus extends ArmaEspecial{
    private int rango;

    public EscopetaBonus() {
        setImagen(Utilidades.getImagenBonus(3));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        //accion
        destruir();
    }
}
