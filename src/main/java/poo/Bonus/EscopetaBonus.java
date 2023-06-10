package poo.Bonus;

import poo.Armas.Escopeta;
import poo.P38;
import poo.Utilidades;

import java.awt.*;

public class EscopetaBonus extends ArmaEspecial{
    private int rango;

    public EscopetaBonus() {
        setImagen(Utilidades.getImagenBonus(3));
    }

    @Override
    public void ejecutarAccion(P38 heroe) {
        heroe.getTiempoBonus().run(heroe.getDuracionBonus());
        heroe.setArma(new Escopeta());
        heroe.setRango(new Rectangle((int)heroe.getX()-100,(int)heroe.getY()+100,300,200));
        destruir();
    }
}
