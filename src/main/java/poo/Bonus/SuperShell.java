package poo.Bonus;

import poo.Otros.P38;
import poo.Otros.Utilidades;

public class SuperShell extends PowerUp{

    public SuperShell() {
        setImagen(Utilidades.getImagenBonus(7));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.getTiempoBonus().run(heroe.getDuracionBonus());
        heroe.getArma().setVelocidadDisparo(100);
        destruir();
    }
}
