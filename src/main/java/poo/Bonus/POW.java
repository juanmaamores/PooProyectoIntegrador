package poo.Bonus;

import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class POW extends PowerUp{

    public POW() {
        setImagen(Utilidades.getImagenBonus(0));
    }

    public void ejecutarAccion(P38 heroe){
        heroe.setEnergia(30);
        destruir();
    }

}
