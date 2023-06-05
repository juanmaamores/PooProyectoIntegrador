package poo;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ObjetoGrafico extends Rectangle {
    BufferedImage imagen= null;

    public void setImagen(BufferedImage img){
        this.imagen=img;
        this.width=img.getWidth();
        this.height=img.getHeight();
    }

    public void setPosicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){this.y = y;}

    public double getX(){return x;}

    public double getY(){return y;}

    public void draw(Graphics2D g){
        g.drawImage(imagen,x,y,null);
    }

    public void destruir(){
        imagen = null;
    }
}
