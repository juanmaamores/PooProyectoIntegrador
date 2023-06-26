package poo.Niveles;

import poo.Armas.*;
import poo.Bonus.AvionRefuerzo;
import poo.Bonus.Bonus;
import poo.Enemigos.*;
import poo.Juego1943;
import poo.Otros.*;
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
    protected static P38 heroe;
    protected Cronometro tiempo;
    protected Jefe jefe;
    //protected Sound musicaNivel;

    /*public void playMusic(int i){
        musicaNivel.setFile(i);
        musicaNivel.play();
        musicaNivel.loop();
    }

    public void stopMusic(int i){
        musicaNivel.stop();
    }

    public void playSEffects(int i){
        musicaNivel.setFile(i);
        musicaNivel.play();
    }*/

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
            //stopMusic(0);
            setGameOver();
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

        if(jefe != null){
            for (ArmaJefe arma : jefe.getArmas()) {
                if(arma.getActualizar())
                    if(arma.getVida() <= 0)
                        arma.destruir();
                       else
                           arma.getDelayDisparo().update();
            }
            if(jefe.getArmas().get(0).puedeDisparar()) { //todas las armas del ayako disparan al mismo tiempo
                for (Arma arma : jefe.getArmas()) {
                    arma.disparar(municionesHostiles, (int)(arma.getX() + arma.getWidth() / 2 - 4), (int) arma.getY());
                    /*if(arma.equals(ayako1.getArmas().get(0))){
                        arma.disparar(municionesHostiles, (int)(ayako1.getX() + ayako1.getWidth() / 2 - 50), (int) ayako1.getY());
                    } else {
                        arma.disparar(municionesHostiles, (int)(ayako1.getX() + ayako1.getWidth() / 2 - 4), (int) ayako1.getY());
                    }*/
                }
            }

            if (jefe.todasArmasDestruidas()) {
                jefe.destruir();
                puntaje += jefe.getPuntaje();
                if(jefe instanceof Yamato)
                    Juego1943.setGameOver();
                else
                    setTransicion(true);
            }
        }
    }

    public void chequearColisiones() {

        //la colision se tiene que dar con las armas/motores y no con los jefes en si.
       if(jefe != null){
            for (Municion municion : municionesP38)
                if(municion.getActualizar())
                    for(ArmaJefe arma : jefe.getArmas())
                        if (municion.intersects(arma)) {
                            arma.setVida(arma.getVida() - municion.getPoder());
                            municion.destruir();
                        }
        }

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

        int x = (int) (0.02 * Juego1943.getAncho()); // Posición x relativa al 2% del ancho de la ventana
        int y = (int) (0.07 * Juego1943.getAlto()); // Posición y relativa al 7% de la altura de la ventana

        fondo.draw(g);

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

        if(jefe != null){
            jefe.draw(g);
            for(ArmaJefe arma : jefe.getArmas()) {
                arma.draw(g);
            }
        }

        heroe.draw(g);

        if(heroe.getRefuerzo1() != null)
            heroe.getRefuerzo1().draw(g);
        if(heroe.getRefuerzo2() != null)
            heroe.getRefuerzo2().draw(g);

    }

    public abstract void crearEnemigos();

    public int getPuntaje() {
        return puntaje;
    }
    //Métodos necesarios para que el héroe pueda disparar
    public static P38 getHeroe(){return heroe;}

    public boolean jefeNull(){return jefe!=null;}

    public int getVidaJefe(){return jefe.getVida();}

    public ArrayList<Municion> getMunicionesP38(){return municionesP38;}

    public void setPuntaje(int aux) {
        puntaje = aux;
    }

}
