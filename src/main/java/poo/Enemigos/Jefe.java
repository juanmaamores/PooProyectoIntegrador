package poo.Enemigos;

import java.awt.image.BufferedImage;

public abstract class Jefe extends Enemigo{
    protected short nroNivel;

    public Jefe(double x, double y, BufferedImage img) {
        super(x, y, img);
    }
}
