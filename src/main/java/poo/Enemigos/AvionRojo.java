package poo.Enemigos;

import poo.Interfaces.Movil;
import poo.Municion;
import poo.ObjetoGrafico;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionRojo extends Enemigo implements Movil{
    private double velocidadH, velocidadV;

    public AvionRojo(){
        velocidadH = -1;
        velocidadV = 0;
        try {
            setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionrojo.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVelocidadH(double velocidadH){
        this.velocidadH = velocidadH;
    }

    public double getVelocidadH(){
        return velocidadH;
    }

    public void setVelocidadV(double velocidadV){
        this.velocidadV = velocidadV;
    }

    public double getVelocidadV(){
        return velocidadV;
    }

    @Override
    public void moverse() {

        if(posicion.x == 350 && posicion.y == 200){
           velocidadH = 0;
           velocidadV = -1;
        }

        if(posicion.x == 350 && posicion.y == 100){
            velocidadH = 1;
            velocidadV = 0;
        }

        if(posicion.x == 450 && posicion.y == 100){
            velocidadH = 0;
            velocidadV = 1;
        }

        if(posicion.x == 450 && posicion.y == 201){
            velocidadH = -1;
            velocidadV = 0;
        }

        posicion.x += velocidadH;
        posicion.y += velocidadV;
    }
}
