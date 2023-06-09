package poo.Otros;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class ObjetoGrafico extends Rectangle {
    protected BufferedImage imagen= null;
    protected boolean actualizar;

    public ObjetoGrafico(){actualizar = true;}

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

    public double getWidth(){return width;}

    public double getHeight(){return height;}

    public boolean getActualizar(){return actualizar;}

    public void draw(Graphics2D g){
        g.drawImage(imagen,x,y,null);
    }

    public void destruir(){
        imagen = null;
        actualizar = false;
        x = -5000;
        y = 5000;
    }
}
