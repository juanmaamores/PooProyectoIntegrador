package poo;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class P38 extends ObjetoGrafico implements Movil, Disparable{
    //private int energia, velocidad, cantAtaqEsp;

    public void moverse(){};
    public Municion disparar(){return new Municion();}; //se puso este return para que no de error

    BufferedImage imagen= null;
    private Point2D.Double posicion = new Point2D.Double();

    public P38(){

    }

    public void setImagen(BufferedImage img){
        this.imagen=img;
    }

    public void setPosicion(double x, double y){
        posicion.setLocation(x, y);
    }

    public void setX(double x){
        posicion.x=x;
    }

    public void setY(double y){
        posicion.y=y;
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
}
