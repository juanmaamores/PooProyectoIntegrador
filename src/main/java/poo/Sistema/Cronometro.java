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
        delta = 0;
        this.tiempo = time;
    }

    public void update(){
        if(corriendo)
            delta += System.currentTimeMillis() - ultimoTiempo;
        if(delta >= tiempo){
            corriendo = false;
            delta = tiempo;
        }
        ultimoTiempo = System.currentTimeMillis();
    }

    public long getDelta(){return delta;}

    public boolean isRunning(){
        return corriendo;
    }
}
