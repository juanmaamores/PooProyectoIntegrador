package poo;

import poo.Bonus.Bonus;
import poo.Bonus.POW;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class ObjetoGrafico extends Rectangle {

    BufferedImage imagen= null;
    private Point2D.Double posicion = new Point2D.Double();

    public void setImagen(BufferedImage img){
        this.imagen=img;
    }

    public void setPosicion(double x, double y){
        posicion.setLocation(x, y);
        this.x = (int) x;
        this.y = (int) y;
        this.width = (int) imagen.getWidth();
        this.height = (int) imagen.getHeight();
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

        /*if(this.getX() < 0 || this.getX() > Constants.WIDTH || this.getY() < 0 || this.getY() > Constants.HEIGHT){
            Destroy();
        }*/
        colisionCon();
    }

    public void draw(Graphics2D g){
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

    /*public boolean intersects(ObjetoGrafico otroObjeto) {
        return rectangulo.intersects(otroObjeto.getRectangulo());
    }*/

    protected void colisionCon(){

        ArrayList<ObjetoGrafico> objetosGraficos = Juego1943.getObjetosGraficos();

        for(int i = 0; i < objetosGraficos.size(); i++) {
            ObjetoGrafico o = objetosGraficos.get(i);

            if (o.equals(this))
                continue;

            if (o.intersects(this)) {
                if(o instanceof P38 && this instanceof Bonus){
                    if(this instanceof POW){
                        ((P38) o).setEnergia(100);
                    }
                    objetosGraficos.remove(this);
                }
            }
        }
    }
}
