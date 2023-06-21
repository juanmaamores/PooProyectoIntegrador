package poo;

import com.entropyinteractive.*;  //jgame
import poo.Niveles.Nivel;
import poo.Niveles.Nivel1;
import poo.Otros.P38;
import poo.Otros.Utilidades;
import java.awt.*;
import java.awt.event.*; //eventos
import javax.imageio.*; //imagenes
import javax.swing.*;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class Juego1943 extends JGame {

    private static Nivel nivelActual;
    private static int puntajeMaximo = 0, puntaje = 0, ancho, alto;
    private String teclaActDesSonido, teclaActDesMusica, teclaPausar, teclaMovIzq, teclaMovDer, teclaMovArriba, teclaMovAbajo, teclaDisparar, teclaAtqEsp, teclaIniciar, pistaMusical;
    private final String ARCHIVO_CONFIGURACION1943 = "src\\main\\resources\\conf\\configuracion1943.properties";
    private final Font fuente = new Font("Calibri", Font.PLAIN, 18);
    private static Boolean juegoCorriendo, inicioJuego, gameOver, transicion;

    public Juego1943() {
        super("1943: The Battle of Midway", 800, 600);
        try (FileInputStream fis = new FileInputStream(ARCHIVO_CONFIGURACION1943)) {
            Properties propiedades = new Properties();
            propiedades.load(fis);
            // Obtener los valores de las propiedades
            teclaActDesSonido = (String.valueOf(propiedades.getProperty("sonidoActivo")));
            teclaActDesMusica = (String.valueOf(propiedades.getProperty("musicaActiva")));
            pistaMusical = (String.valueOf(propiedades.getProperty("seleccionMusica")));
            teclaPausar = (String.valueOf(propiedades.getProperty("teclaPausar")));
            teclaMovIzq = (String.valueOf(propiedades.getProperty("teclaMovIzq")));
            teclaMovDer = (String.valueOf(propiedades.getProperty("teclaMovDer")));
            teclaMovArriba = (String.valueOf(propiedades.getProperty("teclaMovArriba")));
            teclaMovAbajo = (String.valueOf(propiedades.getProperty("teclaMovAbajo")));
            teclaDisparar = (String.valueOf(propiedades.getProperty("teclaDisparar")));
            teclaAtqEsp = (String.valueOf(propiedades.getProperty("teclaAtqEsp")));
            teclaIniciar = (String.valueOf(propiedades.getProperty("teclaIniciar")));
            //ventana.setState(Boolean.parseBoolean(propiedades.getProperty("ventana")));
            //pantallaCompleta.setState(Boolean.parseBoolean(propiedades.getProperty("pantallaCompleta")));
            //pantallaCompletaActiva = Boolean.parseBoolean (propiedades.getProperty("pantallaCompletaActiva"));*/
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error al cargar las propiedades!");
        }
    }

    public void gameStartup() {
        System.out.println("Iniciando 1943: The Battle of Midway");
        cargarImagenes();
        juegoCorriendo = false;
        inicioJuego = true;
        gameOver = false;
        transicion = false;
        ancho = getWidth();
        alto = getHeight();
        nivelActual = null;
        try {
            puntajeMaximo = Sistema.pasarRecordJugador();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gameUpdate(double delta) {

        chequearTeclas();

        if(juegoCorriendo && !gameOver){
            nivelActual.actualizarObjetos();
            nivelActual.chequearColisiones();
            nivelActual.crearEnemigos();
        }

    }

    public void gameDraw(Graphics2D g) {

        int width = this.getWidth(); // Ancho de la ventana
        int height = this.getHeight(); // Altura de la ventana
        int x = (int) (0.02 * width); // Posición x relativa al 2% del ancho de la ventana
        int y = (int) (0.07 * height); // Posición y relativa al 7% de la altura de la ventana
        FontMetrics metrics = g.getFontMetrics(fuente);
        g.setColor(Color.white);
        g.setFont(fuente);

        //Incio juego
        String textoPresentacion = "1943: The Battle of Midway";
        String textoInicar = "Tecla Enter o C para iniciar";
        int xTextoPresentacion = (width - metrics.stringWidth(textoPresentacion)) / 2;
        int yTextoPresentacion = (height / 2)-50;
        int xTextoInicar = (width - metrics.stringWidth(textoInicar)) / 2;
        int yTextoInicar = height / 2;

        //Pausa
        String textoPausa = "Pausa";
        int xTextoPausa = (width - metrics.stringWidth(textoPausa)) / 2;
        int yTextoPausa = height / 2;

        //Transicion
        String textoTransicion= "Mision cumplida! Nivel 1 superado";
        String textoContinuar= "Tecla Enter o C para continuar";
        int xTextoTransicion = (width - metrics.stringWidth(textoTransicion)) / 2;
        int yTextoTransicion = (height / 2)-50;
        int xTextoContinuar = (width - metrics.stringWidth(textoContinuar)) / 2;
        int yTextoContinuar = height / 2;

        //Gameover
        if(gameOver) {
            String textoGameOver = "GAME OVER";
            String textoPuntaje = "Puntaje final: " + puntaje;
            String textoRecord = "Record: " + puntajeMaximo;
            String textoReiniciar = "Tecla Enter o C para jugar de nuevo";
            int xTextoGameOver = (width - metrics.stringWidth(textoGameOver)) / 2;
            int yTextoGameOver = (height / 2)-60;
            int xTextoPuntaje = (width - metrics.stringWidth(textoPuntaje)) / 2;
            int yTextoPuntaje = (height / 2)-30;
            int xTextoRecord = (width - metrics.stringWidth(textoRecord)) / 2;
            int yTextoRecord = (height / 2);
            int xTextoReiniciar = (width - metrics.stringWidth(textoReiniciar)) / 2;
            int yTextoReiniciar = (height / 2)+30;
            g.drawString(textoGameOver, xTextoGameOver, yTextoGameOver);
            g.drawString(textoPuntaje, xTextoPuntaje, yTextoPuntaje);
            g.drawString(textoRecord, xTextoRecord, yTextoRecord);
            g.drawString(textoReiniciar, xTextoReiniciar, yTextoReiniciar);
        }

        //seccion que dibuja la interfaz
        //interfaz inicio o pausa
        if (!juegoCorriendo && !gameOver){
            if(inicioJuego){
                g.drawString(textoPresentacion, xTextoPresentacion, yTextoPresentacion);
                g.drawString(textoInicar, xTextoInicar, yTextoInicar);
            } else if(!transicion){
                g.drawString(textoPausa, xTextoPausa, yTextoPausa);
            } else {
                g.drawString(textoTransicion, xTextoTransicion, yTextoTransicion);
                g.drawString(textoContinuar, xTextoContinuar, yTextoContinuar);
            }
        } else {
            nivelActual.draw(g);
            g.drawString("Energia: " + nivelActual.getHeroe().getEnergia(), x, y + (int) (0.01 * height));
            if(!gameOver){
                g.drawString("Puntaje: " + nivelActual.getPuntaje(),  x + (int) (0.75 * width), y + (int) (0.01 * height));
            }
        }
    }

    public void cargarImagenes(){
        System.out.println("Cargando imágenes...");
        try {
            Utilidades.setImagenBarco(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("img/barco.png"))));
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

    public void chequearTeclas() {

        Keyboard keyboard = this.getKeyboard();

        if(juegoCorriendo){

            P38 heroe = nivelActual.getHeroe();
            heroe.setImagen(Utilidades.getImagenP38(0));

            // Procesar teclas de direccion
            if(teclaMovArriba.equals("W")){
                if (keyboard.isKeyPressed(KeyEvent.VK_W)) {
                    heroe.setY((int)heroe.getY()-4);
                    heroe.setImagen(Utilidades.getImagenP38(0));
                }
            } else {
                if (keyboard.isKeyPressed(KeyEvent.VK_UP)) {
                    heroe.setY((int)heroe.getY()-4);
                    heroe.setImagen(Utilidades.getImagenP38(0));
                }
            }

            if(teclaMovAbajo.equals("S")){
                if(keyboard.isKeyPressed(KeyEvent.VK_S)) {
                    heroe.setY((int)heroe.getY()+4);
                    heroe.setImagen(Utilidades.getImagenP38(0));
                }
            } else {
                if(keyboard.isKeyPressed(KeyEvent.VK_DOWN)) {
                    heroe.setY((int)heroe.getY()+4);
                    heroe.setImagen(Utilidades.getImagenP38(0));
                }
            }

            if(teclaMovIzq.equals("A")){
                if (keyboard.isKeyPressed(KeyEvent.VK_A)) {
                    heroe.setX((int)heroe.getX()-4);
                    heroe.setImagen(Utilidades.getImagenP38(1));
                }
            } else {
                if (keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
                    heroe.setX((int)heroe.getX()-4);
                    heroe.setImagen(Utilidades.getImagenP38(1));
                }
            }

            if(teclaMovDer.equals("D")){
                if (keyboard.isKeyPressed(KeyEvent.VK_D)) {
                    heroe.setX((int)heroe.getX()+4);
                    heroe.setImagen(Utilidades.getImagenP38(2));
                }
            } else {
                if (keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    heroe.setX((int)heroe.getX()+4);
                    heroe.setImagen(Utilidades.getImagenP38(2));
                }
            }

            //disparar
            if(teclaDisparar.equals("Barra espaciadora")){
                if (keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
                    if(heroe.getArma().puedeDisparar())
                        heroe.getArma().disparar(nivelActual.getMunicionesP38(),(int)(heroe.getX()+heroe.getWidth()/2-4),(int)heroe.getY());
                }
            } else {
                if (keyboard.isKeyPressed(KeyEvent.VK_X)) {
                    if(heroe.getArma().puedeDisparar())
                        heroe.getArma().disparar(nivelActual.getMunicionesP38(),(int)(heroe.getX()+heroe.getWidth()/2-4),(int)heroe.getY());
                }
            }

            //Ataque especial
            if(teclaAtqEsp.equals("B")){
                if (keyboard.isKeyPressed(KeyEvent.VK_B)) {
                    //lanza ataque especial
                }
            } else {
                if (keyboard.isKeyPressed(KeyEvent.VK_Z)) {
                    //lanza ataque especial
                }
            }
        }

        // Activar/desactivar efectos de sonido
        if(teclaActDesSonido.equals("O")){
            if (keyboard.isKeyPressed(KeyEvent.VK_O)) {
                //activa desactiva los efectos de sonido
            }
        } else {
            if (keyboard.isKeyPressed(KeyEvent.VK_Q)) {
                //activa desactiva los efectos de sonido
            }
        }

        boolean teclaPresionadaMusica = false, musicaActiva = true, sonidoActivo;
        // Activar/desactivar musica
        if (teclaActDesMusica.equals("I")) {
            if (keyboard.isKeyPressed(KeyEvent.VK_I) && !gameOver && !teclaPresionadaMusica && musicaActiva) {
                nivelActual.stopMusic(0);
                musicaActiva = false;
                teclaPresionadaMusica = true;  // Marcar la tecla como presionada
                try {
                    Thread.sleep(100);  // Agregar un retraso de 100 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (!keyboard.isKeyPressed(KeyEvent.VK_I)) {
                teclaPresionadaMusica = false;  // Restablecer la tecla presionada cuando se suelta
                nivelActual.playMusic(0);
                musicaActiva = true;
            }
        } else {
            if (keyboard.isKeyPressed(KeyEvent.VK_W) && !gameOver && !teclaPresionadaMusica) {
                juegoCorriendo = !juegoCorriendo;
                teclaPresionadaMusica = true;  // Marcar la tecla como presionada
                try {
                    Thread.sleep(100);  // Agregar un retraso de 100 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (!keyboard.isKeyPressed(KeyEvent.VK_W)) {
                teclaPresionadaMusica = false;  // Restablecer la tecla presionada cuando se suelta
            }
        }

        // Declara una variable booleana para seguir el estado de la tecla
        boolean teclaPresionadaPausa = false;
        // Pausar el juego
        if (teclaPausar.equals("P")) {
            if (keyboard.isKeyPressed(KeyEvent.VK_P) && !inicioJuego && !teclaPresionadaPausa) {
                juegoCorriendo = !juegoCorriendo;
                teclaPresionadaPausa = true;  // Marcar la tecla como presionada
                try {
                    Thread.sleep(100);  // Agregar un retraso de 100 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (!keyboard.isKeyPressed(KeyEvent.VK_P)) {
                teclaPresionadaPausa = false;  // Restablecer la tecla presionada cuando se suelta
            }
        } else {
            if (keyboard.isKeyPressed(KeyEvent.VK_SPACE) && !inicioJuego && !teclaPresionadaPausa) {
                juegoCorriendo = !juegoCorriendo;
                teclaPresionadaPausa = true;  // Marcar la tecla como presionada
                try {
                    Thread.sleep(100);  // Agregar un retraso de 100 milisegundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (!keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
                teclaPresionadaPausa = false;  // Restablecer la tecla presionada cuando se suelta
            }
        }


        // Iniciar el juego (Revisar si está bien resuelto)
        if(teclaIniciar.equals("C")){
            if (keyboard.isKeyPressed(KeyEvent.VK_C) && inicioJuego) {
                juegoCorriendo = true;
                inicioJuego = false;
                nivelActual = new Nivel1();
            }
            if (keyboard.isKeyPressed(KeyEvent.VK_C) && transicion) {
                transicion = false;
                juegoCorriendo = true;
            }
            if (keyboard.isKeyPressed(KeyEvent.VK_C) && gameOver) {
                gameOver = false;
                inicioJuego = true;
                juegoCorriendo = false;
            }
        } else {
            if (keyboard.isKeyPressed(KeyEvent.VK_ENTER) && inicioJuego) {
                juegoCorriendo = true;
                inicioJuego = false;
                nivelActual = new Nivel1();
            }
            if (keyboard.isKeyPressed(KeyEvent.VK_ENTER) && transicion) {
                transicion = false;
                juegoCorriendo = true;
            }
            if (keyboard.isKeyPressed(KeyEvent.VK_ENTER) && gameOver) {
                gameOver = false;
                inicioJuego = true;
                juegoCorriendo = false;
            }
        }

        // Cerrar juego
        if (keyboard.isKeyPressed(KeyEvent.VK_ESCAPE)) {
            this.stop();
        }
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public static boolean getGameOver(){return gameOver;}

    public static void setGameOver(){
        puntaje = nivelActual.getPuntaje();
        if (puntaje > puntajeMaximo){
            puntajeMaximo = puntaje;
        }
        try {
            Sistema.cargarRecord(puntajeMaximo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        gameOver = true;
        juegoCorriendo = false;
    }

    public static boolean getTransicion(){return transicion;}

    public static void setTransicion(boolean t){transicion = t;}

    public static int getAncho(){return ancho;}

    public static int getAlto(){return alto;}

    public void gameShutdown() {
        Log.info(getClass().getSimpleName(), "Cerrando el juego");
        nivelActual.stopMusic(0);
        stop();
    }

}
