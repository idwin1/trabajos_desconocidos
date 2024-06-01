package UNIDAD1;

public class Discos {
    private String titulo;
    private fecha fechaLanzamiento;
    private String[] canciones;

    public Discos(String titulo, fecha fechaLanzamiento, String[] canciones) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = canciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public fecha getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String[] getCanciones() {
        return canciones;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaLanzamiento(fecha fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setCanciones(String[] canciones) {
        this.canciones = canciones;
    }

    public String toString(){
        String s="";
        s+= "titulo: " + getTitulo() +"\nfecha de lanzamiento: " + getFechaLanzamiento()+"\nCanciones:";
        int i=0;
        for (String l:canciones) {
            s+="\n" + canciones[i];
            i++;
        }
        return s;
    }
}
