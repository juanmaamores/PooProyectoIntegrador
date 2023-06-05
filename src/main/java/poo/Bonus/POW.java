package poo.Bonus;

import poo.P38;

import java.awt.image.BufferedImage;

public class POW extends PowerUp{

    public POW(double v, double v1, BufferedImage img) {
        super(v, v1, img);
    }

    public void recargarEnergia(){
        P38.setEnergia(30);
    }

}
