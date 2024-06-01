package Unidad3;

import javax.swing.*;

public class U3Practica1 {
    public static void main(String[] args) {
        ColaString plural = new ColaString(12);
        ColaString singular = new ColaString(12);

        boolean salir = false;
        while(!salir) {

            String[] opciones1 = {"1. Leer una palabra", "2. Mostrar palabras en singular", "3. Mostrar palabras en plural",
                    "4. Eliminar una palabra singular", "5. Eliminar una palabra plural", "6. Cantidad de palabras","7. Palabra plural del final", "8. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "Insertar un libro");

            switch (respuesta) {
                case "1. Leer una palabra":
                    String palabra = JOptionPane.showInputDialog(null,"Palabra a insertar: ");
                    if(palabra.toLowerCase().endsWith("s"))
                        //if(String.valueOf(palabra.charAt(palabra.length()-1)).equalsIgnoreCase("s"))
                        leerPalabra(palabra, plural);
                    else
                        leerPalabra(palabra,singular);
                    break;
                case "2. Mostrar palabras en singular":
                    JOptionPane.showMessageDialog(null, singular.toString());
                    break;
                case "3. Mostrar palabras en plural":
                    JOptionPane.showMessageDialog(null, plural.toString());
                    break;
                case "4. Eliminar una palabra singular":
                    if(!singular.estaVacia())
                        JOptionPane.showMessageDialog(null,"Se eliminó " + singular.eliminar());
                    else
                        JOptionPane.showMessageDialog(null,"La cola esta vacía");
                    break;
                case "5. Eliminar una palabra plural":
                    if(!plural.estaVacia())
                        JOptionPane.showMessageDialog(null,"Se eliminó " + plural.eliminar());
                    else
                        JOptionPane.showMessageDialog(null, "La cola esta vacía");
                    break;
                case "6. Cantidad de palabras":
                    JOptionPane.showMessageDialog(null,"La cantidad de palabras son: "+ (singular.numElementos() + plural.numElementos()));
                    break;
                case "7. Palabra plural del final":
                    if(!plural.estaVacia())
                        JOptionPane.showMessageDialog(null,plural.elementoEnFin());
                    else
                        JOptionPane.showMessageDialog(null,"La cola esta vacia");
                    break;
                case "8. Terminar":
                    salir = true;
                    break;
            }
        }
    }

    public static void leerPalabra(String s, ColaString cola){
        if(!cola.estaLlena())
            cola.insertar(s);
        else
            JOptionPane.showMessageDialog(null,"La cola esta llena!");

    }
}
