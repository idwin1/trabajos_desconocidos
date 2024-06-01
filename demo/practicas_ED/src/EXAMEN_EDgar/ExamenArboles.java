package EXAMEN_EDgar;

import Unidad5.NodoCiudades;

import javax.swing.*;

public class ExamenArboles {

    public static void main(String[] args) {
        ArbolBinMaterias materias = new ArbolBinMaterias();
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Insertar una materia", "2. Recorrido INORDEN", "3. Eliminar una materia","4. Materias con 5 o más créditos","5. Aumentar 1 crédito a cada materia" ,"6. terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta){
                case "1. Insertar una materia":
                    String nombre = JOptionPane.showInputDialog("Inserte el nombre de la materia");
                    int creditos = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad de creditos"));
                    materias.insertarNodo(new NodoABMateria(nombre,creditos));
                    break;
                case "2. Recorrido INORDEN":
                    if(materias.estaVacio()){
                        JOptionPane.showMessageDialog(null,"el Arbol esta vacio");
                    }else
                        JOptionPane.showMessageDialog(null,materias.inorden(materias.getRaiz()));
                    break;
                case "3. Eliminar una materia":
                    break;
                case "4. Materias con 5 o más créditos":
                    break;
                case "5. Aumentar 1 crédito a cada materia":
                    break;
                case "6. terminar":
                    salir=true;
                    break;
            }
        }
    }

}
