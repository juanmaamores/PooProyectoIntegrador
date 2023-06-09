package poo;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class Utilidades {
    static Vector<BufferedImage> imagenesNivel = new Vector<>();
    static Vector<BufferedImage> imagenesP38 = new Vector<>();
    static Vector<BufferedImage> imagenesAvionHostil = new Vector<>();
    static Vector<BufferedImage> imagenesAvionRojo = new Vector<>();

    public static void setImagenNivel(BufferedImage img){imagenesNivel.add(img);}

    public static BufferedImage getImagenNivel(int i){return imagenesNivel.get(i);}

    public static void setImagenP38(BufferedImage img){imagenesP38.add(img);}

    public static BufferedImage getImagenP38(int i){return imagenesP38.get(i);}
    public static void setImagenAvionHostil(BufferedImage img){imagenesAvionHostil.add(img);}

    public static BufferedImage getImagenAvionHostil(int i){return imagenesAvionHostil.get(i);}
    public static void setImagenAvionRojo(BufferedImage img){imagenesAvionRojo.add(img);}

    public static BufferedImage getImagenAvionRojo(int i){return imagenesAvionRojo.get(i);}
}