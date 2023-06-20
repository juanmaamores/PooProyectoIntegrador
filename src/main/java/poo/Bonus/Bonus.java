package poo.Bonus;

import poo.Interfaces.Movil;
import poo.Otros.ObjetoGrafico;
import poo.Otros.P38;

import java.util.Random;

public abstract class Bonus extends ObjetoGrafico implements Movil {
    private short golpesRecibidos;

    public void setGolpesRecibidos(short golpesRecibidos){this.golpesRecibidos += golpesRecibidos;}

    public static Bonus crearBonus(int x, int y){
        Bonus nuevo;
        Random random = new Random();
        int randomNumber = random.nextInt(8) + 1;

        //CAMBIAR, A FER NO LE GUSTA

        nuevo = switch (randomNumber) {
            case 1 -> new AmetralladoraBonus();
            case 2 -> new AutoBonus();
            case 3 -> new EscopetaBonus();
            case 4 -> new EstrellaNinja();
            case 5 -> new LaserBonus();
            case 6 -> new POW();
            case 7 -> new Refuerzos();
            case 8 -> new SuperShell();
            default -> null; //Caso que jamás debería ocurrir.
        };

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

    public boolean cambiar(){return golpesRecibidos == 3;}

    public abstract void ejecutarAccion(P38 heroe);
}
