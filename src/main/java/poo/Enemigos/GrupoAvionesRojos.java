package poo.Enemigos;

import java.awt.image.BufferedImage;

public class GrupoAvionesRojos extends GrupoAviones{
    public GrupoAvionesRojos(double x, double y, BufferedImage img) {
        super(x, y, img);
    }

    public void moverse(){};
    public void disparar(){

    }
    // Estos métodos deben quedar vacíos, ya que cada avión controla su propio comportamiento
}
