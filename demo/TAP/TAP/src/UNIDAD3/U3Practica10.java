package UNIDAD3;

import javax.swing.*;
import java.util.Random;

public class U3Practica10 {
    public static void main(String[] args) {
        boolean salir = false;
        int[] arreglo;
        while (!salir) {
            String s;
            String[] opciones1 = {"1. Ordenar Ascendente por QUICKSORT", "2. Ordenar Descendente por QUICKSORT", "3. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. Ordenar Ascendente por QUICKSORT":
                    arreglo = new int[Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de casillas"))];
                    generarEnteros(arreglo);
                    mostrar(arreglo);
                    quicksortAscendente(arreglo,0,arreglo.length-1);
                    JOptionPane.showMessageDialog(null,"el arreglo final es:");
                    mostrar(arreglo);
                    break;
                case "2. Ordenar Descendente por QUICKSORT":
                    JOptionPane.showMessageDialog(null,"inicion de forma decentente");
                    arreglo = new int[Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad de casillas"))];
                    generarEnteros(arreglo);
                    mostrar(arreglo);
                    quicksortDecendente(arreglo,0,arreglo.length-1);
                    JOptionPane.showMessageDialog(null,"el arreglo final es:");
                    mostrar(arreglo);
                    break;
                case "3. Terminar":
                    salir=true;
                    break;
            }
        }

    }

    public static void generarEnteros(int[] x){
        Random rm = new Random();
        for (int i = 0; i<x.length;i++){
            x[i]= rm.nextInt(1,100);
        }
    }

    public static void mostrar(int[] x){
        int cont=0;
        String s="";
        for (int i=0;i<x.length;i++){
            if(cont==10){
                s+="\n" + x[i] +",";
                cont=1;
            }else {
                s+=x[i] +",";
            }
            cont++;
        }
        JOptionPane.showMessageDialog(null,s);
    }

    public static void quicksortAscendente (int a [ ], int inicio, int fin) {
        mostrar(a);
        int pivote = a [inicio]; // Se guarda en como pivote al primer del conjunto a ordenar
        int izq = inicio; // “izq” comienza en el inicio del rango a ordenar
        int der = fin; // “der” comienza en el final del rango a ordenar
        int aux; // esta variable auxiliar se usará para hacer intercambios

        // la izquierda SIEMPRE se va a INCREMENTAR y la derecha SIEMPRE se va a DECREMENTAR
        while ( izq < der ) { // ciclo principal de esta pasada

            while (pivote >= a [izq] && izq < der ) // comparaciones por la izquierda (>=)
                izq++; // avanza apuntador por la izquierda
            while (pivote < a [der] ) // comparaciones por la derecha (<)
                der--; // avanza apuntador por la derecha
            if ( izq < der ) { // realiza un intercambio entre datos del vector para su acomodo
                aux = a [izq];
                a [izq] = a [der];
                a [der] = aux;
            }
        }

        /* cuando termina de recorrer el rango (ésto es cuando se juntan los apuntadores
        izq y der) se procederá a ubicar al pivote en su posición ideal de tal manera que TODOS
        los que quedaron a la izquierda son MENORES ó IGUALES que él y TODOS los que
        quedaron a la derecha son MAYORES que él */
        a [inicio] = a [der];        // con un último intercambio,
        a [der] = pivote;           // coloca el pivote en su posición definitiva
        /* AQUÍ TERMINA UNA PASADA, y si quedan subconjuntos, se hace la llamada RECURSIVA
        para los rangos (SUBCONJUNTOS Ó PARTICIONES) que hayan quedado a la izquierda o a
        la derecha o a ambos lados */


        if ( inicio < der -1) // SOLO si queda un conjunto (2 o más elementos) a la izquierda, hace
            quicksortAscendente (a, inicio, der-1); // ... llamada RECURSIVA para la partición izq.
        if ( der+1 < fin) // SOLO si queda un conjunto (2 o más elementos) a la derecha, hace
            quicksortAscendente (a, der+1, fin); // ... llamada RECURSIVA con la partición derecha
    }

    public static void quicksortDecendente (int a [ ], int inicio, int fin) {
        mostrar(a);
        int pivote = a [inicio]; // Se guarda en como pivote al primer del conjunto a ordenar
        int izq = inicio; // “izq” comienza en el inicio del rango a ordenar
        int der = fin; // “der” comienza en el final del rango a ordenar
        int aux; // esta variable auxiliar se usará para hacer intercambios

        // la izquierda SIEMPRE se va a INCREMENTAR y la derecha SIEMPRE se va a DECREMENTAR
        while ( izq < der ) { // ciclo principal de esta pasada

            while (pivote <= a [izq] && izq < der ) // comparaciones por la izquierda (>=)
                izq++; // avanza apuntador por la izquierda
            while (pivote > a [der] ) // comparaciones por la derecha (<)
                der--; // avanza apuntador por la derecha
            if ( izq < der ) { // realiza un intercambio entre datos del vector para su acomodo
                aux = a [izq];
                a [izq] = a [der];
                a [der] = aux;
            }
        }

        /* cuando termina de recorrer el rango (ésto es cuando se juntan los apuntadores
        izq y der) se procederá a ubicar al pivote en su posición ideal de tal manera que TODOS
        los que quedaron a la izquierda son MENORES ó IGUALES que él y TODOS los que
        quedaron a la derecha son MAYORES que él */
        a [inicio] = a [der];        // con un último intercambio,
        a [der] = pivote;           // coloca el pivote en su posición definitiva
        /* AQUÍ TERMINA UNA PASADA, y si quedan subconjuntos, se hace la llamada RECURSIVA
        para los rangos (SUBCONJUNTOS Ó PARTICIONES) que hayan quedado a la izquierda o a
        la derecha o a ambos lados */


        if ( inicio < der -1) // SOLO si queda un conjunto (2 o más elementos) a la izquierda, hace
            quicksortDecendente (a, inicio, der-1); // ... llamada RECURSIVA para la partición izq.
        if ( der+1 < fin) // SOLO si queda un conjunto (2 o más elementos) a la derecha, hace
            quicksortDecendente (a, der+1, fin); // ... llamada RECURSIVA con la partición derecha
    }

}
