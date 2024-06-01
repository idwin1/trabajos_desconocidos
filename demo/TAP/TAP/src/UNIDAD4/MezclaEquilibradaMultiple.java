package UNIDAD4;
import javax.swing.*;
import java.io.*;

public class MezclaEquilibradaMultiple {
    static int N = 6;
    static int N2 = N / 2;
    static File f0;
    static File[] f = new File[N];
    static int NumReg;
    static final int TOPE = 999;

    public static void main(String[] args) {
        String[] nomf = {"ar1", "ar2", "ar3", "ar4", "ar5", "ar6"};
        f0 = new File("ArchivoOrigen");
        NumReg = Integer.parseInt(JOptionPane.showInputDialog("Escriba la cantidad de registros"));
        for (int i = 0; i < N; i++)
            f[i] = new File(nomf[i]);
        for (int i = 0; i < N; i++)
            f[i].delete();
        DataOutputStream flujo = null;
        // se genera un archivo secuencialmente de claves enteras
        try {
            flujo = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f0)));

            for (int i = 1; i <= NumReg; i++)
                flujo.writeInt((int) (1 + TOPE * Math.random()));

            flujo.close();
            System.out.println("Archivo original ... ");
            escribir(f0);
            mezclaEqMple();
        } catch (IOException e) {
            System.out.println("Error entrada/salida durante proceso de ordenación");
            e.printStackTrace();
        }
    }

    public static void mezclaEqMple() {
        int i, j, k, k1, t, anterior;
        int[] c = new int[N];
        int[] cd = new int[N];
        int[] r = new int[N2];

        Object[] flujos = new Object[N];
        DataInputStream flujoEntradaActual = null;
        DataOutputStream flujoSalidaActual = null;
        boolean[] actvs = new boolean[N2];
        // distribución inicial de tramos desde archivo origen
        try {
            t = distribuir();
            int pasada = 1;
            for (i = 0; i < N; i++)
                c[i] = i;
            // ciclo hasta número de tramos == 1: archivo ordenado
            do {
//                System.out.println("Pasada número " + pasada);
//                System.out.println("Tramos en esta pasada: " + t);
//                System.out.println("Datos almacenados en los archivos: ");
//                for (i = 0; i < N2; i++) {
//                    System.out.println("Archivos de Entrada: ");
//                    System.out.print("Archivo f" + i + ": ");
//                    escribir(f[i]);
//                }
                k1 = (t < N2) ? t : N2;
                System.out.println("Pasada número " + pasada);
                System.out.println("Tramos en esta pasada: " + t);
                System.out.println("Datos almacenados en los archivos: ");
                for (i = 0; i < k1; i++) {
                    flujos[c[i]] = new DataInputStream(new BufferedInputStream(new FileInputStream(f[c[i]])));
                    cd[i] = c[i];
                    if(pasada%2 == 0){
                        System.out.println("Archivo de Salida: ");
                        System.out.print("Archivo f" + (i+3) + ": ");
                        escribir(f[i+3]);
                    }else {
                        System.out.println("Archivo de Entrada: ");
                        System.out.print("Archivo f" + i + ": ");
                        escribir(f[i]);
                    }

                }
                j = N2; // índice de archivo de salida
                t = 0;
                for (i = j; i < N; i++)
                    flujos[c[i]] = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f[c[i]])));
                // entrada de una clave de cada flujo
                for (int n = 0; n < k1; n++) {
                    flujoEntradaActual = (DataInputStream) flujos[cd[n]];
                    r[n] = flujoEntradaActual.readInt();
                }
                while (k1 > 0) {
                    t++; // mezcla de otro tramo
                    for (i = 0; i < k1; i++)
                        actvs[i] = true;
                    flujoSalidaActual = (DataOutputStream) flujos[c[j]];
                    while (!finDeTramos(actvs, k1)) {
                        int n;
                        n = minimo(r, actvs, k1);
                        flujoEntradaActual = (DataInputStream) flujos[cd[n]];
                        flujoSalidaActual.writeInt(r[n]);
                        anterior = r[n];
                        try {
                            r[n] = flujoEntradaActual.readInt();
                            if (anterior > r[n]) // fin de tramo
                                actvs[n] = false;
                        } catch (EOFException eof) {
                            k1--;
                            flujoEntradaActual.close();
                            cd[n] = cd[k1];
                            r[n] = r[k1];
                            actvs[n] = actvs[k1];
                            actvs[k1] = false;// no se accede a posición k1
                        }
                    }
                    j = (j < N - 1) ? j + 1 : N2; // siguiente flujo de salida
                }
                for (i = N2; i < N; i++) {
                    flujoSalidaActual = (DataOutputStream) flujos[c[i]];
                    flujoSalidaActual.close();
                }

                // Cambio de finalidad de los flujos: entrada<->salida
                for (i = 0; i < N2; i++) {
                    int a;
                    a = c[i];
                    c[i] = c[i + N2];
                    c[i + N2] = a;
                }
//                for (i = N2; i < N; i++) {
//                    System.out.println("Archivos de Salida: ");
//                    System.out.print("Archivo f" + i + ": ");
//                    escribir(f[i]);
//                }
                pasada++;
            } while (t > 1);
//            System.out.println("Pasada número " + pasada);
//            System.out.println("Tramos en esta pasada: " + t);
//            System.out.println("Datos almacenados en los archivos: ");
//            for (i = 0; i < N2; i++) {
//                System.out.println("Archivos de Entrada: ");
//                System.out.print("Archivo f" + i + ": ");
//                escribir(f[i]);
//            }
//            for (i = N2; i < N; i++) {
//                System.out.println("Archivos de Salida: ");
//                System.out.print("Archivo f" + i + ": ");
//                escribir(f[i]);
//            }
            System.out.println("Archivo ordenado ... ");
            escribir(f[c[0]]);
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

    private static int distribuir() throws IOException {
        int anterior, j, nt, clave;

        DataInputStream flujo = new DataInputStream(new BufferedInputStream(new FileInputStream(f0)));
        DataOutputStream[] flujoSalida = new DataOutputStream[N2];
        for (j = 0; j < N2; j++) {
            flujoSalida[j] = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f[j])));
        }
        anterior = -TOPE;
        clave = anterior + 1;
        j = 0; // indice del flujo de salida
        nt = 0;
        // bucle termina con la excepción fin de fichero
        try {
            while (true) {
                clave = flujo.readInt();
                while (anterior <= clave) {
                    flujoSalida[j].writeInt(clave);
                    anterior = clave;
                    clave = flujo.readInt();
                }
                nt++;                       // nuevo tramo
                j = (j < N2 - 1) ? j + 1 : 0; // siguiente archivo
                flujoSalida[j].writeInt(clave);
                anterior = clave;
            }
        } catch (EOFException eof) {
            nt++; // cuenta último tramo
            System.out.println("\n*** Número de tramos: " + nt + " ***");
            flujo.close();
            for (j = 0; j < N2; j++)
                flujoSalida[j].close();
            return nt;
        }
    }

    //devuelve el índice del menor valor del array de claves
    private static int minimo(int[] r, boolean[] activo, int n) {
        int i, indice, m;
        i = indice = 0;
        m = TOPE + 1;

        for (; i < n; i++) {
            if (activo[i] && r[i] < m) {
                m = r[i];
                indice = i;
            }
        }
        return indice;
    }

    //devuelve true si no hay tramo activo
    private static boolean finDeTramos(boolean[] activo, int n) {
        boolean s = true;

        for (int k = 0; k < n; k++) {
            if (activo[k])
                s = false;
        }
        return s;
    }

    //escribe las claves del archivo
    static void escribir(File f) {
        int clave, k;
        boolean mas = true;
        DataInputStream flujo = null;

        try {
            flujo = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
            k = 0;
            while (mas) {
                k++;
                System.out.print(flujo.readInt() + " ");
                if (k % 10 == 0)
                    System.out.println();
            }
        } catch (IOException eof) {
            System.out.println("\n *** Fin del archivo ***\n");
            try {
                if (eof instanceof EOFException)
                    flujo.close();
            } catch (IOException er) {
                er.printStackTrace();
            }
        }
    }
}