package UNIDAD1;

public class Departamento {

    private String  nombre;
    private String responsable;
    private Articulo[] articulos;

    public Departamento(String nombre, String responsable, Articulo[] articulos) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.articulos = articulos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }

    public int hayEspacio(){
        for (int i=0;i<articulos.length;i++)
            if(articulos[i]==null){
                return i;
            }
        return 12;
    }

    public void agregarArticulo(Articulo art){
        articulos[hayEspacio()]=art;
    }

    public float inventario(){
        float p = 0;
        for (int i=0;i<articulos.length;i++){
            if(articulos[i]!=null)
                p+=(articulos[i].getPrecio()*articulos[i].getCantidad());
        }
        return p;
    }
    public int buscar(String bus){
        for (int i=0;i<articulos.length;i++){
            if(articulos[i]!=null)
                if(articulos[i].getDescripcion().equalsIgnoreCase(bus))
                    return i;
        }
        return -1;
    }

    public String escojerArticulo(int i){
        return articulos[i].toString();
    }

    public String toString(){
        String s = "Departamento: " + nombre +
                   "\nResponsable: " + responsable +
                   "\nArticulos: \n";
        for (int i=0;i<articulos.length;i++){
            if(articulos[i]!=null)
                s+="Articulo: "+(i+1)+"\n"+articulos[i].toString()+"\n";
        }
        return s;
    }
}
