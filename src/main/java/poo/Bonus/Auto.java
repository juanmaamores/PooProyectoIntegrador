package poo.Bonus;

import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class Auto extends PowerUp{

    public Auto() {
        setImagen(Utilidades.getImagenBonus(2));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {

    }
}
