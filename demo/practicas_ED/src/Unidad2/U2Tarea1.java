package Unidad2;

import javax.swing.*;

public class U2Tarea1 {
    public static void main(String[] args) {
        PilaArticulos ferreteria = new PilaArticulos(14);
        boolean l = true;
        while (l) {
            String[] opciones = {"1. Insertar un artículo", "2. Mostrar pila de artículos", "3. Eliminar un artículo",
                    "4. Mostrar el total del inventario", "5. Aumentar precio de todos los artículos", "6. Buscar un artículo",
                    "7. Artículo más caro", "8. Artículos con cantidad < 5", "9. Vaciar la pila", "10. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "¿Que quieres hacer", "",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch (respuesta){
                case "1. Insertar un artículo":
                    if (!ferreteria.estaLlena()){
                        insertarArt(ferreteria);
                    }
                    break;
                case "2. Mostrar pila de artículos":
                    if(!ferreteria.estaVacia()){
                        mostrarPila(ferreteria);
                    }else {
                        JOptionPane.showMessageDialog(null,"la pila esta vacia");
                    }

                    break;
                case "3. Eliminar un artículo":
                    JOptionPane.showMessageDialog(null,ferreteria.eliminar().toString(),"Elemento borrado",0);
                    break;
                case "4. Mostrar el total del inventario":
                    mostrarPila(ferreteria);
                    break;
                case "5. Aumentar precio de todos los artículos":
                    ferreteria.aumentarPrecio();
                    break;
                case "6. Buscar un artículo":
                    if(!ferreteria.estaVacia()){
                        if(ferreteria.existeArticulo(JOptionPane.showInputDialog(null,"ingresa descripcion"))){
                            JOptionPane.showMessageDialog(null,"si existe el articulo");
                        }else {
                            JOptionPane.showMessageDialog(null,"no existe el articulo");
                        }
                    }
                    break;
                case "7. Artículo más caro":
                    ferreteria.articuloMasCaro();
                    break;
                case "8. Artículos con cantidad < 5":
                    ferreteria.articulosMenora5();
                    break;
                case "9. Vaciar la pila":
                    ferreteria.vaciarPila();
                    break;
                case "10. Terminar":
                    l=false;
                    break;
            }
        }
    }

    public static void insertarArt(PilaArticulos pila){
        String s = JOptionPane.showInputDialog("Ingrese la descripcion del articulo");
        int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de articulos"));
        float p = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio"));
        pila.insertar(s,c,p);
    }

    public static void mostrarPila(PilaArticulos p){
        JOptionPane.showMessageDialog(null,p.toString());
    }

}
