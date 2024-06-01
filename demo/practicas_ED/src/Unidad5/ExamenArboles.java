package Unidad5;

import Unidad4.ListaCircularPartidos;

import javax.swing.*;

public class ExamenArboles {
    public static void main(String[] args) {
        ArbolCiudades ciudades = new ArbolCiudades();
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Insertar una ciudad", "2. Recorrido preorden ", "3. Eliminar una ciudad","4. Ciudades de francia","5. Buscar una ciudad" ,"6. terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta){
                case "1. Insertar una ciudad":
                    String nombre = JOptionPane.showInputDialog("Inserte el nombre de la ciudad");
                    String pais = JOptionPane.showInputDialog("Inserte el nombre del pais");
                    ciudades.insertarNodo(new NodoCiudades(nombre,pais));
                    break;
                case "2. Recorrido preorden ":
                    if(ciudades.estaVacio()){
                        JOptionPane.showMessageDialog(null,"el Arbol esta vacio");
                    }else
                        JOptionPane.showMessageDialog(null,ciudades.preorden(ciudades.getRaiz()));
                    break;
                case "3. Eliminar una ciudad":
                    if (ciudades.estaVacio())
                        JOptionPane.showMessageDialog(null, "Árbol vacío");
                    else {
                        String borrar = JOptionPane.showInputDialog("Ciudad a eliminar:");
                        if (! ciudades.buscaArticulo(ciudades.getRaiz(), borrar))
                            JOptionPane.showMessageDialog(null, "La Ciudad NO existe y no se puede eliminar");
                        else {
                            ciudades.setRaiz( ciudades.eliminar(ciudades.getRaiz(), borrar));
                            JOptionPane.showMessageDialog(null, "Ciudad ===    " + borrar + "   ===  ELIMINADO");
                        }
                    }
                    break;
                case "4. Ciudades de francia":
                    if(ciudades.estaVacio()){
                        JOptionPane.showMessageDialog(null,"No hay ciudades");
                    }else
                        JOptionPane.showMessageDialog(null,ciudades.CiudadesFrancia(ciudades.getRaiz(),"francia"));
                    break;
                case "5. Buscar una ciudad":
                    if (ciudades.estaVacio())
                        JOptionPane.showMessageDialog(null, "Árbol vacío");
                    else{
                        String ciudad = JOptionPane.showInputDialog("ingrese la ciudad que quiere buscar");
                        if (! ciudades.buscaArticulo(ciudades.getRaiz(), ciudad))
                            JOptionPane.showMessageDialog(null, "La Ciudad NO existe ");
                        else {
                            JOptionPane.showMessageDialog(null,ciudades.BuscarCiudad(ciudades.getRaiz(), ciudad));

                        }
                    }
                    break;
                case "6. terminar":
                    salir=true;
                    break;
            }
        }
    }
}

