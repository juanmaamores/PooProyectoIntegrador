package poo.Enemigos;

import poo.Interfaces.Movil;
import poo.Municion;
import poo.ObjetoGrafico;
import poo.Utilidades;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AvionRojo extends Enemigo implements Movil{

    public AvionRojo(){
        velocidadH = -2;
        velocidadV = 0;
        setImagen(Utilidades.getImagenAvionRojo(0));
    }

    @Override
    public void moverse(int ancho, int alto) {

        if(x <= 360 && y == alto-400){
            x = 360;
            velocidadH = -1;
            velocidadV = -2;
            setImagen(Utilidades.getImagenAvionRojo(7));
        }

        if(x <= 340 && y == alto-440){
            velocidadH = 0;
            velocidadV = -2;
            setImagen(Utilidades.getImagenAvionRojo(6));
        }

        if(x == 340 && y <= alto-500){
            y = alto-500;
            velocidadH = 1;
            velocidadV = -2;
            setImagen(Utilidades.getImagenAvionRojo(5));
        }

        if(x == 360 && y <= alto-540){
            y = alto-540;
            velocidadH = 2;
            velocidadV = 0;
            setImagen(Utilidades.getImagenAvionRojo(4));
        }

        if(x == 520 && y == alto-540){
            x = 520;
            velocidadH = 1;
            velocidadV = 2;
            setImagen(Utilidades.getImagenAvionRojo(3));
        }

        if(x >= 540 && y == alto-500){
            x = 540;
            velocidadH = 0;
            velocidadV = 2;
            setImagen(Utilidades.getImagenAvionRojo(2));
        }

        if(x == 540 && y == alto-440){
            velocidadH = -1;
            velocidadV = 2;
            setImagen(Utilidades.getImagenAvionRojo(1));
        }

        if(y >= alto-399){
            y = alto-399;
            velocidadH = -2;
            velocidadV = 0;
            setImagen(Utilidades.getImagenAvionRojo(0));
        }

        x += velocidadH;
        y += velocidadV;
    }
}