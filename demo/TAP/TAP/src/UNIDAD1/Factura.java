package UNIDAD1;

public class Factura {
    private int numero;
    private Articulo[] articulos;
    private float total;

    public Factura(int numero, Articulo[] articulos, float total) {
        this.numero = numero;
        this.articulos = articulos;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public float getTotal() {
        return total;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String buscar(String s){
        int i=0;
        for (Articulo a:articulos) {
            if(articulos[i].getDescripcion().equalsIgnoreCase(s)){
                return "Numero: "+ numero+"\n"+"Posicion del articulo: "+ i+"\n"+articulos[i].toString();
            }
            i++;
        }
        return "";
    }

    public String toString(){
        String s="";
        s+="Numero: " + numero +"\nArticulos:";
        for (Articulo a:articulos) {
            s+="\n"+a.toString();
        }
        return s+"\nTotal: " +total;
    }
}
