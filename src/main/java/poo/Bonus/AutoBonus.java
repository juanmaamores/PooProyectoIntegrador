package poo.Bonus;

import poo.Armas.Auto;
import poo.P38;
import poo.Utilidades;

public class AutoBonus extends PowerUp{

    public AutoBonus() {
        setImagen(Utilidades.getImagenBonus(2));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.getTiempoBonus().run(heroe.getDuracionBonus());
        heroe.setArma(new Auto());
        destruir();
    }
}
