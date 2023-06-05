package poo.Enemigos;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class GrupoAvionesHostiles extends GrupoAviones{
    private Vector<AvionHostil> aviones;

    public GrupoAvionesHostiles(double x, double y, BufferedImage img) {
        super(x, y, img);
    }

    public void moverse(){}

    public void disparar(){

    }
    // Estos métodos deben quedar vacíos, ya que cada avión controla su propio comportamiento
}
