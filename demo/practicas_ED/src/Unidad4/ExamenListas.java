package Unidad4;

import javax.swing.*;

public class ExamenListas {
    public static void main(String[] args) {
        ListaCircularPartidos partidos = new ListaCircularPartidos();
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Insertar datos", "2. Eliminar primer partido en lista ", "3. Mostrar partidos","4. terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);

            switch (respuesta) {
                case "1. Insertar datos":
                    String nombre = JOptionPane.showInputDialog("inserte el nombre del partido","Nombre");
                    int votos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de votos","Cant. votos"));
                    partidos.insertar(new NodoPartido(nombre,votos));
                    break;
                case  "2. Eliminar primer partido en lista ":
                    if(partidos.listaVacia()){
                        JOptionPane.showMessageDialog(null,"no hay partidos para eliminar");
                    }else
                        JOptionPane.showMessageDialog(null,"El partido eliminado fue:\n "+partidos.eliminarPrimero().toString());
                    break;
                case "3. Mostrar partidos":
                    if(!partidos.listaVacia())
                        JOptionPane.showMessageDialog(null,partidos.toString());
                    else
                        JOptionPane.showMessageDialog(null,"no hay partidos par mostrar");
                    break;
                case "4. terminar":
                    salir = true;
                    break;
            }
        }
    }
}
