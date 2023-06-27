package poo.Ataque;

import poo.Enemigos.AvionHostil;
import poo.Enemigos.Barco;
import poo.Enemigos.GrupoAvionesHostiles;
import poo.Niveles.Nivel;
import poo.Otros.P38;

import java.awt.image.BufferedImage;

public class Tsunami extends AtaqueEspecial{

    public Tsunami() {super();}

    public void realizarAtaque(Nivel nivel){
        P38 heroe = Nivel.getHeroe();

        if(delay.getDelta() >= 10000) {

            if (heroe.getEnergia() >= 40) {
                heroe.setEnergia(-20);

                for (GrupoAvionesHostiles grupo : nivel.getAvioneshostiles())
                    for (AvionHostil avion : grupo.getAviones())
                        if (avion.getActualizar() && avion.getY() >= 0)
                            avion.destruir();

                for(Barco barco : nivel.getBarcos())
                    if(barco.getActualizar() && barco.getY() >= 0)
                        barco.destruir();
            }

            delay.run(10000);
        }
    }
}
