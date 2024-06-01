package Unidad2;
import javax.swing.*;

import static java.lang.Float.valueOf;
//IDWIN RAZIEL BALDERAS ALMANZA
public class ExamenU2 {
    public static void main(String[] args) {
        PilaLibros novela = new PilaLibros(8);
        PilaLibros poesia = new PilaLibros(8);
        boolean salir = false;
        while(salir == false) {

            String[] opciones1 = {"Insertar un libro", "Mostrar Libros de novela", "Mostrar Libros de poesia", "Eliminar una novela", "Eliminar Todos los libros de poesia", "suma total de precios","salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "Insertar un libro");

            switch (respuesta) {
                case "Insertar un libro":
                    if(novela.estaLlena()&& poesia.estaLlena()){
                        JOptionPane.showMessageDialog(null,"no puedes insertar nada");
                    }
                    if (novela.estaLlena() && !poesia.estaLlena()) {
                        JOptionPane.showMessageDialog(null, "solo puedes insertar poesias");
                    }
                    if (!novela.estaLlena() && poesia.estaLlena()) {
                        JOptionPane.showMessageDialog(null, "solo puedes insertar novelas");
                    }
                    String titulo = JOptionPane.showInputDialog("Cual es el titulo");
                    String autor = JOptionPane.showInputDialog("Cual es el autor");
                    float precio = valueOf(JOptionPane.showInputDialog("Cual es el precio"));
                    if (precio > 350) {
                        if (!novela.estaLlena()) {
                            novela.insertar(titulo, autor, precio);
                        }
                    } else {
                        if (!poesia.estaLlena()) {
                            poesia.insertar(titulo, autor, precio);
                        }
                    }
                    break;
                case "Mostrar Libros de novela":
                    if (!novela.estaVacia()) {
                        JOptionPane.showMessageDialog(null, novela.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "la pila esta vacia");
                    }
                    break;
                case "Mostrar Libros de poesia":
                    if (!poesia.estaVacia()){
                        JOptionPane.showMessageDialog(null, poesia.toString());
                    }else {
                        JOptionPane.showMessageDialog(null,"la pila esta vacia");
                    }
                    break;
                case "Eliminar una novela":
                    if (novela.estaVacia()){
                        JOptionPane.showMessageDialog(null,"la pila esta vacia");
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null,novela.eliminar().getTitulo());
                    }
                    break;
                case "Eliminar Todos los libros de poesia":
                    if (!poesia.estaVacia()){
                        Libro eliminado;
                        String titulos="";
                        for(int i= poesia.getTope();i>=0;i--){
                            eliminado=poesia.eliminar();
                            titulos+="\n" + eliminado.getTitulo();
                        }
                        JOptionPane.showMessageDialog(null,titulos);
                    }else {
                        JOptionPane.showMessageDialog(null,"la pila esta vacia");
                    }
                    break;
                case "suma total de precios" :
                    if (poesia.estaVacia() && novela.estaVacia()){
                        JOptionPane.showMessageDialog(null,"las 2 pilas estan vacias");
                    }else {
                        float suma=0;
                        suma += novela.TotalDePrecios();
                        suma += poesia.TotalDePrecios();
                        JOptionPane.showMessageDialog(null,suma);
                    }
                    break;
                case "salir":
                    salir = true;
                    break;
            }
        }
    }
}
