package poo.Bonus;

import poo.P38;
import poo.Utilidades;

public class AmetralladoraBonus extends ArmaEspecial{

    public AmetralladoraBonus(){
        setImagen(Utilidades.getImagenBonus(1));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        //accion
        destruir();
    }
}

