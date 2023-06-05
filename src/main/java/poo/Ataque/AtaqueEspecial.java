package poo.Ataque;

import poo.ObjetoGrafico;

import java.awt.image.BufferedImage;

public class AtaqueEspecial extends ObjetoGrafico {
    protected int danio;

    public AtaqueEspecial(double x, double y, BufferedImage img) {
        super(x, y, img);
    }
}
