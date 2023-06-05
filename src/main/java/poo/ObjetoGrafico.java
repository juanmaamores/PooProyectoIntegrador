package poo;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class ObjetoGrafico extends Rectangle {

    BufferedImage imagen= null;
    private Point2D.Double posicion = new Point2D.Double();
    protected boolean muerto;

    public ObjetoGrafico(double x, double y, BufferedImage img){
        this.imagen = img;
        posicion.setLocation(x, y);
        this.x = (int) x;
        this.y = (int) y;
        this.width = imagen.getWidth();
        this.height = imagen.getHeight();
    }

    public void setImagen(BufferedImage img){
        this.imagen=img;
    }

    public void setPosicion(double x, double y){
        posicion.setLocation(x, y);
        this.x = (int) x;
        this.y = (int) y;
        this.width = imagen.getWidth();
        this.height = imagen.getHeight();
    }

    public void setX(double x){
        posicion.x=x;
        this.x = (int) x;
    }

    public void setY(double y){
        posicion.y=y;
        this.y = (int) y;
    }

    public double getX(){
        return posicion.getX();
    }

    public double getY(){
        return posicion.getY();
    }

    public void update(double delta){
    }
    public void draw(Graphics2D g){
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

    protected void destruir(){
        muerto = true;
    }

    public boolean estaMuerto() {
        return muerto;
    }
}
