package poo.Niveles;

import poo.*;
import poo.Armas.ArmaAvionHostil;
import poo.Armas.ArmaBarco;
import poo.Armas.Escopeta;
import poo.Bonus.AvionRefuerzo;
import poo.Bonus.Bonus;
import poo.Enemigos.*;
import poo.Sistema.Cronometro;

import java.awt.*;
import java.util.ArrayList;

import static poo.Juego1943.*;

public abstract class Nivel {
    protected int puntaje, contadorEnemigos;
    protected Fondo fondo;
    protected ArrayList<GrupoAvionesHostiles> avioneshostiles;
    protected ArrayList<GrupoAvionesRojos> avionesrojos;
    protected ArrayList<Barco> barcos;
    protected ArrayList<Bonus> bonus;
    protected ArrayList<Municion> municionesP38, municionesHostiles, municionesAliadas;
    protected P38 heroe;
    protected Cronometro tiempo;

    protected Ayako1 ayako1;

    protected Yamato yamato;

    protected Sound sound;
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSEffects(int i){
        sound.setFile(i);
        sound.play();
    }

    public void actualizarObjetos(){
        int ancho = Juego1943.getAncho();
        int alto = Juego1943.getAlto();

        tiempo.update();

        fondo.mover();

        heroe.moverse(ancho, alto);
        heroe.getArma().getDelayDisparo().update();
        heroe.getTiempoBonus().update();
        heroe.chequearBonus();

        //chequear que el jugador no haya muerto
        if(heroe.getEnergia() <= 0){
            setGameOver(true);
            heroe.destruir();
        }

        AvionRefuerzo ref1 = heroe.getRefuerzo1();
        AvionRefuerzo ref2 = heroe.getRefuerzo2();

        if(ref1 != null) {
            if(ref1.getArma().puedeDisparar())
                ref1.getArma().disparar(municionesAliadas, (int)(ref1.getX()+ref1.getWidth()/2-4), (int)ref1.getY());

            if(ref1.getVida() <= 0) {
                ref1.destruir();
                heroe.setRefuerzo1(null);
            }
        }

        if(ref2 != null) {
            if (ref2.getArma().puedeDisparar())
                ref2.getArma().disparar(municionesAliadas, (int) (ref2.getX() + ref2.getWidth() / 2 - 4), (int) ref2.getY());

            if(ref2.getVida() <= 0) {
                ref2.destruir();
                heroe.setRefuerzo2(null);
            }
        }

        for(Municion municion : municionesP38)
            municion.moverse(ancho, alto);

        for(Municion municion : municionesAliadas)
            municion.moverse(ancho, alto);

        for(Municion municion : municionesHostiles)
            municion.moverse(ancho, alto);

        for (GrupoAvionesHostiles grupo : avioneshostiles)
            if(grupo.getActualizar()) {
                for (AvionHostil avion : grupo.getAviones())
                    if (avion.getActualizar()) {

                        avion.moverse(ancho, alto);

                        avion.getArma().getDelayDisparo().update();

                        if(!avion.getVolviendo() && avion.getArma().puedeDisparar())
                            avion.getArma().disparar(municionesHostiles, (int)(avion.getX()+avion.getWidth()/2-4), (int)avion.getY());

                        if(avion.getVida() <= 0) {
                            avion.destruir();
                            puntaje += avion.getPuntaje();
                        }
                    }

                grupo.setEstado();

                if(grupo.todosDestruidos())
                    puntaje += grupo.getPuntaje();
            }

        for(GrupoAvionesRojos grupo : avionesrojos)
            if(grupo.getActualizar()) {
                for (AvionRojo avion : grupo.getAviones()) {
                    if(avion.getActualizar()) {

                        avion.moverse(ancho, alto);

                        if (avion.getVida() <= 0) {
                            grupo.setUltimoDestruidoX(avion.getX());
                            grupo.setUltimoDestruidoY(avion.getY());
                            avion.destruir();
                            puntaje += avion.getPuntaje();
                        }
                    }
                }

                grupo.setEstado();

                if(grupo.todosDestruidos()) {
                    bonus.add(Bonus.crearBonus((int)grupo.getUltimoDestruidoX(),(int)grupo.getUltimoDestruidoY()));
                    puntaje += grupo.getPuntaje();
                }
            }

        for(Barco barco : barcos)
            if(barco.getActualizar()) {
                barco.moverse(ancho, alto);

                for(ArmaBarco arma : barco.getArmas()) {
                    if(arma.getVida() <= 0)
                        arma.destruir();

                    if (arma.getActualizar() && arma.puedeDisparar())
                        arma.disparar(municionesHostiles, (int) (arma.getX()), (int) arma.getY());
                }

            }

        for(Bonus bonus : bonus)
            if(bonus.getActualizar())
                bonus.moverse(ancho, alto);

        if(ayako1 != null) {
            if (ayako1.getActualizar()) {
                if(ayako1.getVida() <= 0) {
                    ayako1.destruir();
                    puntaje += ayako1.getPuntaje();
                    setTransicion(true);
                }

                ayako1.moverse(250, 100);

                for (ArmaAvionHostil arma : ayako1.getArmas())
                    arma.disparar(municionesHostiles, (int) (arma.getX() + arma.getWidth() / 2 - 4), (int) arma.getY());

                if (ayako1.getVida() <= 0) {
                    ayako1.destruir();
                    puntaje += ayako1.getPuntaje();
                }
            }
        }

        if (yamato != null){
            if(yamato.getActualizar()) {

                if(yamato.getVida() <= 0) {
                    yamato.destruir();
                    puntaje += yamato.getPuntaje();
                    setTransicion(true);
                }
                yamato.moverse(350, 50);

                for(ArmaBarco arma : yamato.getArmas()) {
                    if(arma.getVida() <= 0)
                        arma.destruir();

                    if (arma.getActualizar() && arma.puedeDisparar()) {
                        arma.disparar(municionesHostiles, (int) (arma.getX()), (int) arma.getY());
                    }
                }
            }
        }
    }

    public void chequearColisiones() {

        for (GrupoAvionesRojos grupo : avionesrojos)
            for (AvionRojo avion : grupo.getAviones()) {
                if (avion.getActualizar()) {
                    if (heroe.intersects(avion)) {
                        avion.setVida(0);
                        heroe.setEnergia(-10);
                    }

                    for (Municion municion : municionesP38)
                        if(municion.getActualizar())
                            if (municion.intersects(avion)) {
                                avion.setVida(avion.getVida() - municion.getPoder());
                                municion.destruir();
                            }

                    for (Municion municion : municionesAliadas)
                        if(municion.getActualizar())
                            if (municion.intersects(avion)) {
                                municion.destruir();
                                avion.setVida(avion.getVida() - municion.getPoder());
                            }

                    AvionRefuerzo ref1 = heroe.getRefuerzo1(), ref2 = heroe.getRefuerzo2();

                    if(ref1 != null)
                        if(avion.intersects(ref1)){
                            avion.setVida(0);
                            ref1.setVida(ref1.getVida()-50);
                        }

                    if(ref2 != null)
                        if(avion.intersects(ref2)){
                            avion.setVida(0);
                            ref2.setVida(ref2.getVida()-50);
                        }
                }
            }

        for (GrupoAvionesHostiles grupo : avioneshostiles)
            for (AvionHostil avion : grupo.getAviones()) {
                if (avion.getActualizar()) {
                    if (heroe.intersects(avion)) {
                        avion.setVida(0);
                        heroe.setEnergia(-20);
                    }

                    for (Municion municion : municionesP38)
                        if(municion.getActualizar())
                            if (municion.intersects(avion)) {
                                municion.destruir();
                                avion.setVida(avion.getVida() - municion.getPoder());
                            }

                    for (Municion municion : municionesAliadas)
                        if(municion.getActualizar())
                            if (municion.intersects(avion)) {
                                municion.destruir();
                                avion.setVida(avion.getVida() - municion.getPoder());
                            }

                    AvionRefuerzo ref1 = heroe.getRefuerzo1(), ref2 = heroe.getRefuerzo2();

                    if(ref1 != null)
                        if(avion.intersects(ref1)){
                            avion.setVida(0);
                            ref1.setVida(ref1.getVida()-20);
                        }

                    if(ref2 != null)
                        if(avion.intersects(ref2)){
                            avion.setVida(0);
                            ref2.setVida(ref2.getVida()-20);
                        }

                }
            }

        for(Barco barco : barcos)
            for(ArmaBarco arma : barco.getArmas()) {
                if (arma.getActualizar()) {
                    if (heroe.intersects(arma)) {
                        arma.setVida(0);
                        heroe.setEnergia(-20);
                    }

                    for (Municion municion : municionesP38)
                        if (municion.getActualizar())
                            if (municion.intersects(arma)) {
                                municion.destruir();
                                arma.setVida(arma.getVida() - municion.getPoder());
                            }

                    for (Municion municion : municionesAliadas)
                        if (municion.getActualizar())
                            if (municion.intersects(arma)) {
                                municion.destruir();
                                arma.setVida(arma.getVida() - municion.getPoder());
                            }

                    AvionRefuerzo ref1 = heroe.getRefuerzo1(), ref2 = heroe.getRefuerzo2();

                    if (ref1 != null)
                        if (arma.intersects(ref1)) {
                            arma.setVida(0);
                            ref1.setVida(ref1.getVida() - 20);
                        }

                    if (ref2 != null)
                        if (arma.intersects(ref2)) {
                            arma.setVida(0);
                            ref2.setVida(ref2.getVida() - 20);
                        }

                }
            }


        for(Municion municion : municionesHostiles)
            if(municion.getActualizar()) {
                if (municion.intersects(heroe)) {
                    heroe.setEnergia(-municion.getPoder());
                    municion.destruir();
                }

                AvionRefuerzo ref1 = heroe.getRefuerzo1(), ref2 = heroe.getRefuerzo2();

                if(ref1 != null)
                    if(municion.intersects(ref1)){
                        municion.destruir();
                        ref1.setVida(ref1.getVida()-municion.getPoder());
                    }

                if(ref2 != null)
                    if(municion.intersects(ref2)){
                        municion.destruir();
                        ref2.setVida(ref2.getVida()-municion.getPoder());
                    }
            }

        for(Municion municion : municionesP38) {

            if (municion.getActualizar()) {
                Rectangle rango = heroe.getRango();

                if (rango != null)
                    if(!municion.intersects(rango))
                        municion.destruir();

                if(heroe.getArma() instanceof Escopeta)
                    for(Municion munienemiga : municionesHostiles)
                        if(munienemiga.getActualizar())
                            if(municion.intersects(munienemiga)){
                                municion.destruir();
                                munienemiga.destruir();
                            }



                Bonus nuevo = null;
                boolean cambio = false;

                for (Bonus b : bonus)
                    if (b.getActualizar()) {
                        if (municion.intersects(b)) {
                            b.setY((int) b.getY() - 5);
                            b.setGolpesRecibidos((short) 1);
                            municion.destruir();
                        }

                        if (b.cambiar()) {
                            nuevo = Bonus.crearBonus((int) b.getX(), (int) b.getY());
                            cambio = true;
                            b.destruir();
                        }
                    }

                if(cambio)
                    bonus.add(nuevo);
            }

        }

        for(Bonus b : bonus)
            if(b.getActualizar())
                if(b.intersects(heroe))
                    b.ejecutarAccion(heroe);
    }

    public void draw(Graphics2D g){

        fondo.draw(g);

        if(!getTransicion()){

            for(Bonus bonus : bonus)
                bonus.draw(g);

            for (Barco barco : barcos) {
                barco.draw(g);

                for(ArmaBarco arma : barco.getArmas())
                    arma.draw(g);
            }

            for (GrupoAvionesRojos grupo : avionesrojos)
                for (AvionRojo avion : grupo.getAviones())
                    avion.draw(g);

            for (GrupoAvionesHostiles grupo : avioneshostiles)
                for (AvionHostil avion : grupo.getAviones())
                    avion.draw(g);

            for(Municion municion : municionesHostiles)
                municion.draw(g);

            for(Municion municion: municionesAliadas)
                municion.draw(g);

            for(Municion municion: municionesP38)
                municion.draw(g);

        }

        if(ayako1 != null){
        ayako1.draw(g);
        for(ArmaAvionHostil arma : ayako1.getArmas()) {
            arma.draw(g);
        }}

        if(yamato != null){
            yamato.draw(g);

            for(ArmaBarco arma : yamato.getArmas()) {
                arma.setImagen(Utilidades.getImagenBarco(2));
                arma.draw(g);
            }
        }



        if(!Juego1943.getGameOver()){
            if(!getTransicion()){
                if(heroe.getRefuerzo1() != null)
                    heroe.getRefuerzo1().draw(g);
                if(heroe.getRefuerzo2() != null)
                    heroe.getRefuerzo2().draw(g);
                heroe.draw(g);
            }
        }
    }

    public abstract void crearEnemigos();

    public int getPuntaje() {
        return puntaje;
    }

    //Métodos necesarios para que el héroe pueda disparar
    public P38 getHeroe(){return heroe;}
    public ArrayList<Municion> getMunicionesP38(){return municionesP38;}
}
