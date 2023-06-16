package poo;

import java.awt.image.BufferedImage;

public class Fondo extends ObjetoGrafico{
    public Fondo(BufferedImage img){setImagen(img);}

    public void mover(){
        y += 1;
    }
}