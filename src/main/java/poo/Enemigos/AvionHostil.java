package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionHostil extends Enemigo implements Movil, Disparable{
    private double velocidad; //la velocidad es una sola, porque su movimiento es unicamente vertical

    public AvionHostil(){

        velocidad=1;
        try {
            setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionhostil.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVelocidad(double velocidad){
        this.velocidad=velocidad;
    }

    public double getVelocidad(){
        return velocidad;
    }

    @Override
    public void moverse() {
        if(posicion.y == 560){
            velocidad = velocidad *(-1);
            try {
                setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionhostil2.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(posicion.y == 30) {
            velocidad *= -1;
            try {
                setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionhostil.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        posicion.y += velocidad;
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
