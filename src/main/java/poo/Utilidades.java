package poo;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class Utilidades {
    static Vector<BufferedImage> imagenes = new Vector<>();

    public static void setImagen(BufferedImage img){imagenes.add(img);}

    public static BufferedImage getImagen(int i){return imagenes.get(i);}
}
