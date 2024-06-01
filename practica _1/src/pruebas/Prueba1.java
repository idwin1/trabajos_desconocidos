package pruebas;
import java.io.*;
import java.util.StringTokenizer;
public class Prueba1 {
    static String codigoSt;
    static char[][] matrizLetras = {{'A', 'H', 'B', 'R'}, {'C', 'O', 'U', 'I'}, {'S', 'T', 'L', 'Q',}, {' ', 'E', 'N', 'Y'}};
    static String[][] matrizDirecciones = {{"10", "01", "31", "13"}, {"03", "22", "12", "30"}, {"32", "02", "21", "11"}, {"20", "23", "00", "33"}};

    public static void main(String[] args) throws FileNotFoundException, Exception {
        File file = new File("Mensaje.txt");
        lectorDeArchivo(file);
    }

    public static void lectorDeArchivo(File file) throws FileNotFoundException, Exception {
        FileReader lectorArchivo = new FileReader(file);
        BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
        String linea = "";
        while (linea != null) {
            linea = bufferLectura.readLine();
            if (linea != null) {
                StringTokenizer analizador = new StringTokenizer(linea);
                codigoSt = analizador.nextToken();
                descifrar(codigoSt);
            }
        }
    }

    public static void descifrar(String codigo) {
        System.out.println("Codigo original: "+ codigo);
        int k = 0,j = 0;
        String s = "";
        String[] vec = new String[codigo.length() / 2];
        for (int i = 0; i < codigo.length(); i++) {
            s += codigo.charAt(i);
            k++;
            if (k % 2 == 0) {
                vec[j] = s;
                j++;
                s = "";
            }
        }
        System.out.print("Mensaje descifrado: ");
        for (int i = 0; i < vec.length; i++) {
            int num = Integer.parseInt(matrizDirecciones[Integer.parseInt(vec[i])/10][Integer.parseInt(vec[i])%10]);
            int x = num/10;
            int y = num%10;
            System.out.print(matrizLetras[x][y]);

        }
        System.out.println();
    }
}