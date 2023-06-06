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
        setImagen(Utilidades.getImagen(4));
    }

    @Override
    public void moverse(int ancho, int alto) {

        if(x <= 350 && y == alto-400){
            x = 350;
            velocidadH = 0;
            velocidadV = -2;
        }

        if(x == 350 && y <= alto-500){
            y = alto-500;
            velocidadH = 2;
            velocidadV = 0;
        }

        if(x >= 450 && y == alto-500){
            x = 450;
            velocidadH = 0;
            velocidadV = 2;
        }

        if(x == 450 && y >= alto-399){
            y = alto-399;
            velocidadH = -2;
            velocidadV = 0;
        }

        x += velocidadH;
        y += velocidadV;
    }
}
