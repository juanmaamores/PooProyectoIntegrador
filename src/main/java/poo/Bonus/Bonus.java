package poo.Bonus;

import poo.Interfaces.Movil;
import poo.ObjetoGrafico;
import poo.P38;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class Bonus extends ObjetoGrafico implements Movil {
    private short golpesRecibidos;

    private void setGolpesRecibidos(short golpesRecibidos){this.golpesRecibidos = golpesRecibidos;}

    private short getGolpesRecibidos(){return golpesRecibidos;}

    public static Bonus crearBonus(int x, int y){
        Bonus nuevo;
        Random random = new Random();
        int randomNumber = random.nextInt(8) + 1;

        //CAMBIAR, A FER NO LE GUSTA

        nuevo = switch (randomNumber) {
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

        System.out.println(randomNumber);
        nuevo.setX(x);
        nuevo.setY(y);
        nuevo.setGolpesRecibidos((short)0);

        return nuevo;
    }

    public void moverse(int ancho, int alto){
        y += 1;
        if(y >= alto)
            destruir();
    }

    public boolean cambiar(){
        return golpesRecibidos == 5;
    }

    public abstract void ejecutarAccion(P38 heroe);
}
