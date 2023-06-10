package poo.Bonus;

import poo.Armas.Arma;
import poo.Armas.ArmaBasica;
import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;
import poo.ObjetoGrafico;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.awt.image.BufferedImage;

public class AvionRefuerzo extends ObjetoGrafico implements Movil {
    private int vida;
    private final Arma arma;

    public AvionRefuerzo() {
        super();
        setImagen(Utilidades.getImagenP38(0));
        vida = 200;
        arma = new ArmaBasica();
    }

    @Override
    public void moverse(int ancho, int alto) {
        //ancho y alto actúan como X e Y del P38
        x = ancho;
        y = alto;
    }

    public void setVida(int vida){this.vida = vida;}

    public int getVida(){return vida;}

    public Arma getArma(){return arma;}

}
