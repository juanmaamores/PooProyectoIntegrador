/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package poo;
import com.entropyinteractive.*;  //jgame
import poo.Armas.Arma;
import poo.Armas.ArmaAvionHostil;
import poo.Armas.ArmaBarco;
import poo.Armas.Escopeta;
import poo.Bonus.*;
import poo.Enemigos.*;

import java.awt.*;
import java.awt.event.*; //eventos
import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.*;
//import java.text.*;

public class Juego1943 extends JGame {

    Sound sound;
	Date dInit = new Date();
	Date dAhora;
    private int puntaje, puntajeMaximo;
    Fondo fondo;
    Vector<GrupoAvionesHostiles> avioneshostiles;
    Vector<GrupoAvionesRojos> avionesrojos;
    Vector<Barco> barcos;
    Vector<Bonus> bonus;
    Vector<Municion> municionesP38, municionesHostiles, municionesAliadas;
    P38 heroe;

    //prueba timeout()
    Timer timer;
    int delay;

    Yamato yamato;
    Ayako1 ayako1;



    public Juego1943() {
        super("1943: The Battle of Midway", 800, 600);
        //System.out.println(appProperties.stringPropertyNames());
    }

    public void gameStartup() {
        System.out.println("Iniciando 1943: The Battle of Midway");
        cargarImagenes();
        puntaje = 0;
        puntajeMaximo = 0;
        fondo = new Fondo(Utilidades.getImagenNivel(0));
        fondo.setPosicion(8,-(int)fondo.getHeight()+getHeight());

        //sonido
        //sound = new Sound();
        //playMusic(0);

        heroe = new P38();
        heroe.setPosicion(getWidth() / 2, getHeight() / 3);
        avioneshostiles = new Vector<>();
        //avioneshostiles.add(new GrupoAvionesHostilesFormacion1(getHeight()));
        //avioneshostiles.add(new GrupoAvionesHostilesFormacion2(getHeight()));
        //avioneshostiles.add(new GrupoAvionesHostilesFormacion3(getHeight()));
        avionesrojos = new Vector<>();
        //avionesrojos.add(new GrupoAvionesRojos(getHeight()));
        barcos = new Vector<>();
        barcos.add(new Barco(70, -100,heroe));
        bonus = new Vector<>();
        municionesP38 = new Vector<>();
        municionesHostiles = new Vector<>();
        municionesAliadas = new Vector<>();

        //Jefes
        yamato = new Yamato(heroe);
        ayako1 = new Ayako1(); //cambiar posicion para que este en el centro, usar la misma que yamato


    }

    public void gameUpdate(double delta) {

        chequearTeclas();

        actualizarObjetos();

        chequearColisiones();

        fondo.setY((int)fondo.getY()+1);
    }

    public void gameDraw(Graphics2D g) {

    	dAhora= new Date( );
    	long dateDiff = dAhora.getTime() - dInit.getTime();
    	long diffSeconds = dateDiff / 1000 % 60;
		long diffMinutes = dateDiff / (60 * 1000) % 60;
        int width = this.getWidth(); // Ancho de la ventana
        int height = this.getHeight(); // Altura de la ventana
        int x = (int) (0.02 * width); // Posición x relativa al 2% del ancho de la ventana
        int y = (int) (0.07 * height); // Posición y relativa al 7% de la altura de la ventana

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

        if(heroe.getRefuerzo1() != null)
            heroe.getRefuerzo1().draw(g);
        if(heroe.getRefuerzo2() != null)
            heroe.getRefuerzo2().draw(g);
        heroe.draw(g);

        for(Municion municion : municionesHostiles)
            municion.draw(g);

        for(Municion municion: municionesAliadas)
            municion.draw(g);

        for(Municion municion: municionesP38)
            municion.draw(g);

        //Draw Jefes Finales

        yamato.draw(g);

        for(ArmaBarco arma : yamato.getArmas()) {
            arma.setImagen(Utilidades.getImagenBarco(2));
            arma.draw(g);
        }

        ayako1.draw(g);
        for(ArmaAvionHostil arma : ayako1.getArmas()) {
            arma.setImagen(Utilidades.getImagenBarco(3));
            arma.draw(g);
        }

        //interfaz
        g.setColor(Color.white);
        g.drawString("Tiempo de Juego: " + diffMinutes + ":" + diffSeconds, x, y + (int) (0.01 * height));
        g.drawString("Energia P38: " + heroe.getEnergia(), x, y + (int) (0.04 * height));
        g.drawString("Puntaje: " + puntaje,  x + (int) (0.75 * width), y + (int) (0.01 * height));
    }

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

    public void cargarImagenes(){
        System.out.println("Cargando imágenes...");
        try {
            Utilidades.setImagenNivel(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/mapa1.jpg"))));
            Utilidades.setImagenP38(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/p38.png"))));
            Utilidades.setImagenP38(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/p38izq.png"))));
            Utilidades.setImagenP38(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/p38der.png"))));
            Utilidades.setImagenAvionHostil(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionhostil.png"))));
            Utilidades.setImagenAvionHostil(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionhostil2.png"))));
            Utilidades.setImagenAvionHostil(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionhostil3.png"))));
            Utilidades.setImagenAvionHostil(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionhostil4.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoizq.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoabizq.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoab.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoabder.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoder.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoarder.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoar.png"))));
            Utilidades.setImagenAvionRojo(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/avionrojoarizq.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/pow.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/ametralladora.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/auto.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/escopeta.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/estrellaNinja.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/laser.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/refuerzos.png"))));
            Utilidades.setImagenBonus(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/superShell.png"))));
            Utilidades.setImagenMunicion(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/municionBase.png"))));
            Utilidades.setImagenJefes(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/Yamato.png"))));
            Utilidades.setImagenJefes(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/ayako1.png"))));
            Utilidades.setImagenBarco(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/barco.png"))));
            Utilidades.setImagenBarco(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/torret1s.png"))));
            Utilidades.setImagenBarco(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/torret2s.png"))));
            Utilidades.setImagenBarco(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/ayako-motor.png"))));


        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Imágenes cargadas");
    }

    public void actualizarObjetos(){

        heroe.moverse(getWidth(), getHeight());
        heroe.getArma().getDelayDisparo().update();
        heroe.getTiempoBonus().update();
        heroe.chequearBonus();
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
            municion.moverse(getWidth(), getHeight());

        for(Municion municion : municionesAliadas)
            municion.moverse(getWidth(), getHeight());

        for(Municion municion : municionesHostiles)
            municion.moverse(getWidth(), getHeight());

        for (GrupoAvionesHostiles grupo : avioneshostiles)
            if(grupo.getActualizar()) {
                for (AvionHostil avion : grupo.getAviones())
                    if (avion.getActualizar()) {

                        avion.moverse(getWidth(), getHeight());

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

                        avion.moverse(getWidth(), getHeight());

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
                barco.moverse(getWidth(), getHeight());

                for(ArmaBarco arma : barco.getArmas()) {
                    if(arma.getVida() <= 0)
                        arma.destruir();

                    if (arma.getActualizar() && arma.puedeDisparar())
                        arma.disparar(municionesHostiles, (int) (arma.getX()), (int) arma.getY());
                }

            }

        for(Bonus bonus : bonus)
            if(bonus.getActualizar())
                bonus.moverse(getWidth(), getHeight());

        //Yamato
        if(yamato.getActualizar()) {
            yamato.moverse(getWidth(), getHeight());

            for(ArmaBarco arma : yamato.getArmas()) {
                if(arma.getVida() <= 0)
                    arma.destruir();

                if (arma.getActualizar() && arma.puedeDisparar()) {
                        arma.disparar(municionesHostiles, (int) (arma.getX()), (int) arma.getY());
                    }
                }
            }
        //Ayako

        if (ayako1.getActualizar()) {

            ayako1.moverse(getWidth(), getHeight());

            for(ArmaAvionHostil arma : ayako1.getArmas())
                arma.disparar(municionesHostiles, (int)(arma.getX()+arma.getWidth()/2-4), (int)arma.getY());

            if(ayako1.getVida() <= 0) {
                ayako1.destruir();
                puntaje += ayako1.getPuntaje();
            }
        }

    }



    private void chequearColisiones() {

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
                        if(munienemiga.actualizar)
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

    public void chequearTeclas() {
        Keyboard keyboard = this.getKeyboard();

        heroe.setImagen(Utilidades.getImagenP38(0));

        // Procesar teclas de direccion
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)) {
            heroe.setY((int)heroe.getY()-4);
            heroe.setImagen(Utilidades.getImagenP38(0));
        }

        if(keyboard.isKeyPressed(KeyEvent.VK_DOWN)) {
            heroe.setY((int)heroe.getY()+4);
            heroe.setImagen(Utilidades.getImagenP38(0));
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
            heroe.setX((int)heroe.getX()-4);
            heroe.setImagen(Utilidades.getImagenP38(1));
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
            heroe.setX((int)heroe.getX()+4);
            heroe.setImagen(Utilidades.getImagenP38(2));
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_X)) {
            if(heroe.getArma().puedeDisparar())
                heroe.getArma().disparar(municionesP38,(int)(heroe.getX()+heroe.getWidth()/2-4),(int)heroe.getY());
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            stop();
        }
    }

    //metodos para manejar el puntaje
    public void aumentarPuntuacion(int puntos) {
        puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public void gameShutdown() {
       Log.info(getClass().getSimpleName(), "Cerrando el juego");
    }
}
