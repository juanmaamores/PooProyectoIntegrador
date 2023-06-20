package poo.Bonus;

import poo.Armas.Ametralladora;
import poo.Otros.P38;
import poo.Otros.Utilidades;

public class AmetralladoraBonus extends ArmaEspecial{

    public AmetralladoraBonus(){
        setImagen(Utilidades.getImagenBonus(1));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.getTiempoBonus().run(heroe.getDuracionBonus());
        heroe.setArma(new Ametralladora());
        destruir();
    }
}

