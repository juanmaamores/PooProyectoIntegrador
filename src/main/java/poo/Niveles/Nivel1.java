package poo.Niveles;

import poo.Enemigos.*;
import poo.Fondo;
import poo.Juego1943;
import poo.P38;
import poo.Sistema.Cronometro;
import poo.Utilidades;

import java.util.ArrayList;

public class Nivel1 extends Nivel{
    public Nivel1(){
        fondo = new Fondo(Utilidades.getImagenNivel(0));
        fondo.setPosicion(8,-(int)fondo.getHeight()+Juego1943.getAncho());
        heroe = new P38();
        heroe.setPosicion(Juego1943.getAncho()/ 2-50, Juego1943.getAlto()/ 2);
        avioneshostiles = new ArrayList<>();
        avionesrojos = new ArrayList<>();
        barcos = new ArrayList<>();
        bonus = new ArrayList<>();
        municionesP38 = new ArrayList<>();
        municionesHostiles = new ArrayList<>();
        municionesAliadas = new ArrayList<>();
        tiempo = new Cronometro();
        tiempo.run(180000);
        contadorEnemigos = 0;
    }

    @Override
    public void crearEnemigos() {
        if(tiempo.getDelta() >= 3000 && contadorEnemigos == 0){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion1());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 6000 && contadorEnemigos == 1){
            avionesrojos.add(new GrupoAvionesRojos());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 8000 && contadorEnemigos == 2){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion2());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 15000 && contadorEnemigos == 3){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion3());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 25000 && contadorEnemigos == 4){
            avionesrojos.add(new GrupoAvionesRojos());
            contadorEnemigos++;
        }
    }
}
