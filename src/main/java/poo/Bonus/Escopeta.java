package poo.Bonus;

import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class Escopeta extends ArmaEspecial{
    private int danio, rango;

    public Escopeta() {
        setImagen(Utilidades.getImagenBonus(3));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {

    }
}
