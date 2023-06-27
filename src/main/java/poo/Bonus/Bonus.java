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
        int randomNumber = random.nextInt(100) + 1;

        if(randomNumber <= 15)
            nuevo = new AmetralladoraBonus();
        else if(randomNumber <= 35)
            nuevo = new AutoBonus();
        else if(randomNumber <= 40)
            nuevo = new EscopetaBonus();
        else if(randomNumber <= 54)
            nuevo = new EstrellaNinja();
        else if(randomNumber == 55)
            nuevo = new LaserBonus();
        else if(randomNumber <= 80)
            nuevo = new POW();
        else if(randomNumber <= 90)
            nuevo = new Refuerzos();
        else
            nuevo = new SuperShell();

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
