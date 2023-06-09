package poo.Bonus;

import poo.P38;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class SuperShell extends PowerUp{

    public SuperShell() {
        setImagen(Utilidades.getImagenBonus(7));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.getTiempoBonus().run(heroe.getDuracionBonus());
        heroe.setVelocidadDisparo(100);
        destruir();
    }
}
