package UNIDAD3;

import java.util.Arrays;

public class pr {
    public static void main(String[] args) {
        int[] ar={5,2,4,1,3};
        System.out.println(Arrays.toString(ar));
        insercionDirecta(ar);
        System.out.println(Arrays.toString(ar));
    }
    public static void insercionDirecta(int A[]){
        int i, j;
        int aux;
        for (i = 1; i < A.length; i++){ // desde el segundo elemento hasta
            aux = A[i];           // el final, guardamos el elemento y
            j = i - 1;            // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
                // valor de aux sea menor que los
                A[j + 1] = A[j];   // de la izquierda, se desplaza a
                j--;               // la derecha
            }
            A[j + 1] = aux;       // colocamos aux en su sitio
        }
    }
}
