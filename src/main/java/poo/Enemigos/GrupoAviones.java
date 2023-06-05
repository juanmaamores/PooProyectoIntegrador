package poo.Enemigos;

import java.awt.image.BufferedImage;

public abstract class GrupoAviones extends Enemigo{
    protected short cantidadAviones;

    public GrupoAviones(double x, double y, BufferedImage img) {
        super(x, y, img);
    }
}
