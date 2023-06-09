package poo.Enemigos;

public abstract class GrupoAviones extends Enemigo{
    //La función de este booleano es hacer de eliminado lógico del grupo una vez no está más en pantalla
    protected boolean actualizar = true;

    public boolean getActualizar(){return actualizar;}
}
