package Unidad4;

public class NodoPartido {
    private String partido;
    private int votos;
    private NodoPartido enlace;

    public  NodoPartido(String partido,int votos){
        this.partido = partido;
        this.votos = votos;
        enlace = null;
    }

    public String getPartido() {
        return partido;
    }

    public int getVotos() {
        return votos;
    }

    public NodoPartido getEnlace() {
        return enlace;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void setEnlace(NodoPartido enlace) {
        this.enlace = enlace;
    }

    public String toString( ) {
        return "Partido: " +partido + "   votos: " + votos;
    }
}
