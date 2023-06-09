package poo.Bonus;

import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class Ametralladora extends ArmaEspecial{

    public Ametralladora(){
        setImagen(Utilidades.getImagenBonus(1));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
    }
}

