package poo.Enemigos;

import poo.Interfaces.Disparable;
import poo.Interfaces.Movil;
import poo.Municion;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionHostil extends Enemigo implements Movil, Disparable{
    boolean disparar;
    public AvionHostil(){
        disparar = true;
        try {
            setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionhostil.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVelocidadH(float velocidadH){
        this.velocidadH= velocidadH;
    }

    public float getVelocidadH(){
        return velocidadH;
    }

    public void setVelocidadV(float velocidadV){
        this.velocidadV=velocidadV;
    }

    public float getVelocidadV(){
        return velocidadV;
    }

    @Override
    public void moverse(int ancho, int alto) {
        if(posicion.y >= alto-50){
            disparar = false;
            velocidadV *= -1;
            velocidadH *= -1;
            try {
                setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionhostil2.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(posicion.y <= alto-590 && velocidadV < 0) {
            disparar = true;
            velocidadV *= -1;
            velocidadH *= -1;
            try {
                setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionhostil.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        posicion.x += velocidadH;
        posicion.y += velocidadV;
    }

    @Override
    public Municion disparar() {
        return null;
    }
}
