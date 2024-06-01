package ED.Unidad1;
import java.io.*;

public class tarea3 {
    public static  void main(String[] args) throws FileNotFoundException, IOException {
        /*File archivoSalida = new File("TextoCapturado.txt");
        FileOutputStream flujoSalida = new FileOutputStream(archivoSalida);
        PrintWriter archivoTxt = new PrintWriter(flujoSalida);*/

        char[][] matrizLetras = new char[][]{{'A', 'H', 'B', 'R'},
                                             {'C', 'O', 'U', 'I'},
                                             {'S', 'T', 'L', 'Q'},
                                             {' ', 'E', 'N', 'Y'}};
        String[][] matrizDirecciones = new String[][]{{"10", "01", "31", "13"},
                                                      {"03", "22", "12", "30"},
                                                      {"32", "02", "21", "11"},
                                                      {"20", "23", "00", "33"}};

        File archivoEntrada = new File("mensaje.txt");
        FileReader lectorArchivo = new FileReader(archivoEntrada);
        BufferedReader buferlectura = new BufferedReader(lectorArchivo);

        String linea ="";
        String descifrado = "";
        String num = null;

        int fila, columna,n;
        while(linea!=null){
            linea = buferlectura.readLine();
            //System.out.println(linea);
            if (linea!=null){
                for(int i = 0;i<=linea.length()-1;i=i+2){
                    fila =Integer.parseInt(String.valueOf(linea.charAt(i)));
                    columna = Integer.parseInt(String.valueOf(linea.charAt(i+1)));
                    num = matrizDirecciones[fila][columna];
                    descifrado +=  matrizLetras[num.charAt(0)-'0'][num.charAt(1)-'0'];
                }
                descifrado +=" ";
                System.out.println(descifrado);
            }

        }
    }
}
