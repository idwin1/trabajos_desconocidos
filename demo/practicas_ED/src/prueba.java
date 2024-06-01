import Unidad2.PilaChar;

import javax.swing.*;
import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int vector1[] = new int[]{1, 5, 10, 20, 50, 100};
        System.out.println("ingrese la cantidad");
        int monto = sc.nextInt();
        int cont = 0;
        do {
            for (int i = vector1.length-1; i >= 0; i--) {
                if (monto >= vector1[i]) {
                    cont++;
                    monto = monto - vector1[i];
                    System.out.println("el numero restado es:" + vector1[i]);
                    break;

                }
            }
        } while (monto >= 1);
        // TODO: fixme.
        System.out.println(cont);
        /*

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
    }*/


        }
    }
