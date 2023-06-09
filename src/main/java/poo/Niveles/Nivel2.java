package poo.Niveles;

import poo.*;
import poo.Ataque.Relampago;
import poo.Ataque.Tsunami;
import poo.Enemigos.*;
import poo.Otros.Cronometro;
import poo.Otros.Fondo;
import poo.Otros.P38;
import poo.Otros.Sound;
import poo.Otros.Utilidades;

import java.util.ArrayList;

public class Nivel2 extends Nivel{
    public Nivel2(){
        fondo = new Fondo(Utilidades.getImagenNivel(1));
        fondo.setPosicion(8,-(int)fondo.getHeight()+Juego1943.getAncho());
        ataque = new Tsunami();
        heroe = new P38();
        heroe.setPosicion(Juego1943.getAncho()/2-50, Juego1943.getAlto()/2 + 100);
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
        musicaNivel = new Sound();
        feSound = new Sound();
        playMusic(3);
    }

    @Override
    public void crearEnemigos() {

        if(tiempo.getDelta() >= 2000 && contadorEnemigos == 0){
            barcos.add(new Barco());
            barcos.add(new Barco());
            contadorEnemigos++;
        }

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
            barcos.add(new Barco());
            barcos.add(new Barco());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 25000 && contadorEnemigos == 4){
            avionesrojos.add(new GrupoAvionesRojos());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 35000 && contadorEnemigos == 5){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion1());
            avioneshostiles.add(new GrupoAvionesHostilesFormacion2());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 39000 && contadorEnemigos == 6){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion3());
            avionesrojos.add(new GrupoAvionesRojos());
            barcos.add(new Barco());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 44000 && contadorEnemigos == 7){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion1());
            avioneshostiles.add(new GrupoAvionesHostilesFormacion3());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 49000 && contadorEnemigos == 8){
            avionesrojos.add(new GrupoAvionesRojos());
            avioneshostiles.add(new GrupoAvionesHostilesFormacion2());
            barcos.add(new Barco());
            barcos.add(new Barco());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 55000 && contadorEnemigos == 9){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion1());
            avioneshostiles.add(new GrupoAvionesHostilesFormacion2());
            avioneshostiles.add(new GrupoAvionesHostilesFormacion3());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 58000 && contadorEnemigos == 10){
            avionesrojos.add(new GrupoAvionesRojos());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 62000 && contadorEnemigos == 11){
            jefe = new Yamato(heroe);
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 65000 && contadorEnemigos == 12){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion3());
            contadorEnemigos++;
        }

        if(tiempo.getDelta() >= 69000 && contadorEnemigos == 13){
            avioneshostiles.add(new GrupoAvionesHostilesFormacion1());
            avioneshostiles.add(new GrupoAvionesHostilesFormacion2());
            contadorEnemigos++;
        }
    }
}
