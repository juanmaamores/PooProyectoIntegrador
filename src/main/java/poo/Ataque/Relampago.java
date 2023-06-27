package poo.Ataque;

import poo.Enemigos.AvionHostil;
import poo.Enemigos.GrupoAvionesHostiles;
import poo.Niveles.Nivel;
import poo.Otros.P38;

public class Relampago extends AtaqueEspecial{

    public Relampago(){super();}

    public void realizarAtaque(Nivel nivel){
        P38 heroe = Nivel.getHeroe();

        if(delay.getDelta() >= 10000) {

            if (heroe.getEnergia() >= 40) {
                heroe.setEnergia(-20);

                for (GrupoAvionesHostiles grupo : nivel.getAvioneshostiles())
                    for (AvionHostil avion : grupo.getAviones())
                        if (avion.getActualizar() && avion.getY() >= 0)
                            avion.destruir();
            }

            delay.run(10000);
        }
    }
}
