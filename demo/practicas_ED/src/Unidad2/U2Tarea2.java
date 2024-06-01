package Unidad2;

import javax.swing.*;

public class U2Tarea2 {
    public static void main(String[] args) {
        String operacion = JOptionPane.showInputDialog(null, "ingresa la operacion");
        PilaChar pila = new PilaChar(operacion.length());
        String mostrar="";

        for (int i = 0; i < operacion.length(); i++) {
            switch (prioridad(operacion.charAt(i))){
                case 1:
                case 2:
                case 3:
                    if(pila.estaVacia()){
                        pila.insertar(operacion.charAt(i));
                        break;
                    }
                    while(prioridad(operacion.charAt(i))<=prioridad(pila.datoEnTope()) && Character.compare(pila.datoEnTope(),'(')!=0) {
                        mostrar += pila.eliminar();
                    }
                    pila.insertar(operacion.charAt(i));
                    break;
                case 4:
                    pila.insertar(operacion.charAt(i));
                    break;
                case 5:
                    pila.insertar(operacion.charAt(i));
                    pila.eliminar();
                    boolean l = true;
                    while(l){
                        if(pila.datoEnTope() =='('){
                            pila.eliminar();
                            l= false;
                            break;
                        }
                        mostrar+=pila.eliminar();
                    }
                    break;
                case 0:
                    mostrar += operacion.charAt(i);
                    break;
            }
            if(i == operacion.length()-1){
                mostrar+= pila.vaciar();
            }
        }
        JOptionPane.showMessageDialog(null,mostrar);
    }
    public static int prioridad(char c){
        int regreso=0;
        String[] vector = new String[]{"+-","*/","^","(",")"};
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[i].length(); j++) {
                if (c == vector[i].charAt(j)){
                    regreso=(i+1);
                }
            }
        }
        return regreso;
    }
}
