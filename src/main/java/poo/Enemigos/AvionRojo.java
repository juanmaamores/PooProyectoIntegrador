package poo.Enemigos;

import poo.Interfaces.Movil;
import poo.Municion;
import poo.ObjetoGrafico;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionRojo extends Enemigo implements Movil{

    public AvionRojo(){
        velocidadH = -1.5F;
        velocidadV = 0;
        try {
            setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("img/avionrojo.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVelocidadH(float velocidadH){
        this.velocidadH = velocidadH;
    }

    public float getVelocidadH(){
        return velocidadH;
    }

    public void setVelocidadV(float velocidadV){
        this.velocidadV = velocidadV;
    }

    public float getVelocidadV(){
        return velocidadV;
    }

    @Override
    public void moverse(int ancho, int alto) {

        if(posicion.x <= 350 && posicion.y == alto-400){
            posicion.x = 350;
            velocidadH = 0;
            velocidadV = -1.5F;
        }

        if(posicion.x == 350 && posicion.y <= alto-500){
            posicion.y = alto-500;
            velocidadH = 1.5F;
            velocidadV = 0;
        }

        if(posicion.x >= 450 && posicion.y == alto-500){
            posicion.x = 450;
            velocidadH = 0;
            velocidadV = 1.5F;
        }

        if(posicion.x == 450 && posicion.y >= alto-399){
            posicion.y = alto-399;
            velocidadH = -1.5F;
            velocidadV = 0;
        }

        posicion.x += velocidadH;
        posicion.y += velocidadV;
    }
}
