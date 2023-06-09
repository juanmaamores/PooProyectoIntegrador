package poo.Bonus;

import poo.Interfaces.Movil;
import poo.ObjetoGrafico;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Bonus extends ObjetoGrafico implements Movil {
    public void moverse(int ancho, int alto){
        this.setY((int)this.getY()+1);
    }

    public void cambiarTipo(){
        Random random = new Random();
        int randomNumber = random.nextInt(8) + 1;

        //CAMBIAR, A FER NO LE GUSTA

        Bonus bonusType = switch (randomNumber) {
            case 1 -> new Ametralladora();
            case 2 -> new Auto();
            case 3 -> new Escopeta();
            case 4 -> new EstrellaNinja();
            case 5 -> new Laser();
            case 6 -> new POW();
            case 7 -> new Refuerzos();
            case 8 -> new SuperShell();
            default -> null; //Caso que jamás debería ocurrir.
        };
    }
}
