package Unidad2;
import javax.swing.*;

public class Práctica1{

    public static void main(String[] args) {
        boolean l =true;
        PilaInt pilaNones;
        pilaNones = new PilaInt(8);
        int captura;
        while(l){
            String[] opciones1 = {"Capturar un entero", "Mostrar datos en la pila", "Eliminar un elemento de la pila","Dato en el tope de la pila","Salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "¿Qué quieres hacer?",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "Capturar un entero");
            switch (respuesta){
                case "Capturar un entero":
                    if(pilaNones.estaLlena()) {
                        JOptionPane.showMessageDialog(null, "PILA LLENA!, intento de overflow");
                    }else{
                        captura = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número"));
                        capturarEntero(captura,pilaNones);
                    }
                    break;
                case "Mostrar datos en la pila":
                    mostrarDatos(pilaNones);
                    break;
                case "Eliminar un elemento de la pila":
                    eliminar(pilaNones);
                    break;
                case "Dato en el tope de la pila":
                    despliegaTope(pilaNones);
                    break;
                case "Salir":
                    l=false;
                    break;
            }

        }
    }

    public static void capturarEntero(int x, PilaInt pila){
            if(x % 2 == 0){
                JOptionPane.showMessageDialog(null,"Solo números impares!");
            }else{
                pila.insertar(x);
            }
        }
    public static void mostrarDatos(PilaInt pilaNones) {
        JOptionPane.showMessageDialog(null, pilaNones.toString() + "\nCantidad de elementos: " + pilaNones.numElementos());

    }
    public static void eliminar(PilaInt pilaNones){
        int retorno;
        if(!pilaNones.estaVacia()){
            retorno=pilaNones.eliminar();
            JOptionPane.showMessageDialog(null,"El elemento borrado fue: " + retorno);
        }else{
            JOptionPane.showMessageDialog(null,"PILA VACÍA, no se pueden eliminar elementos");
        }
    }

    public static void despliegaTope(PilaInt pilaNones) {
        if(pilaNones.estaVacia())
            JOptionPane.showMessageDialog(null, "La pila está vacía");
        else
            JOptionPane.showMessageDialog(null, "El dato en el tope es: " + pilaNones.datoEnTope());

    }



}
