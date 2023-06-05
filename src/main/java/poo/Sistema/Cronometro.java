package poo.Sistema;

public class Cronometro {
    private long delta, ultimoTiempo, tiempo;
    private boolean corriendo;

    public Cronometro(){ // constructor por defecto
        delta = 0;
        ultimoTiempo = System.currentTimeMillis();
        corriendo = false;
    }

    public void run(long time){
        corriendo = true;
        this.tiempo = time;
    }

    public void update(){
        if(corriendo)
            delta += System.currentTimeMillis() - ultimoTiempo;
        if(delta >= tiempo){
            corriendo = false;
            delta = 0;
        }
        ultimoTiempo = System.currentTimeMillis();
    }

    public boolean isRunning(){
        return corriendo;
    }
}
