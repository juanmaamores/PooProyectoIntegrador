package poo;

public class Main {
    public static void main(String[] args) {
        //Lanzador sys = new Lanzador(); // Inicia el lanzador.
        Juego1943 game = new Juego1943();
        game.run(1.0 / 60.0);
        System.exit(0);
    }
}



