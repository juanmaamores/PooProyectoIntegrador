package poo.Enemigos;

import poo.Otros.ObjetoGrafico;

public abstract class Enemigo extends ObjetoGrafico {

    protected boolean muerto = false, escapo = false;
    protected double velocidadH, velocidadV;
    protected int vida, puntaje;

    public void setVelocidadH(double velocidadH){
        this.velocidadH= velocidadH;
    }

    public double getVelocidadH(){
        return velocidadH;
    }

    public void setVelocidadV(double velocidadV){
        this.velocidadV=velocidadV;
    }

    public double getVelocidadV(){
        return velocidadV;
    }

    public boolean estaMuerto(){return muerto;}

    public boolean escapo(){return escapo;}

    public void setVida(int vida){this.vida = vida;}

    public int getVida(){return vida;}

    public int getPuntaje(){return puntaje;}

    public void destruir(){
        super.destruir();
        muerto = true;
        velocidadH = 0;
        velocidadV = 0;
        x = -5000;
        y = 5000;
    }

    public void escapar(){
        actualizar = false;
        escapo = true;
        x = -5000;
        y = 5000;
    }
}
