package poo.Bonus;

import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class POW extends PowerUp{

    public POW() {
        setImagen(Utilidades.getImagenBonus(0));
    }

    public void recargarEnergia(){
        P38.setEnergia(30);
    }

}
