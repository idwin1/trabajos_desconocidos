package ED.Unidad1;
import java.util.Scanner;

public class Actividad5 {
    public class Main {
        public static int i,j,n;
        public static void main(String[] args) {
            System.out.println("ingrese el tamaño de la matriz");
            Scanner sc=new Scanner(System.in);
            n=sc.nextInt();
            int[][] m=new int[n][n];
            for(i=0;i<m.length;i++){
                for(j=0;j<m[i].length;j++){
                    m[i][j]=sc.nextInt();
                }
            }
            comprobar(m);

        }
        public static void comprobar(int[][] l){
            int suma=0;
            int suma1=0;
            boolean o=true;
            for(i=0;i<l.length;i++){
                for(j=0;j<l[i].length;j++){
                    suma+=l[i][j];
                    suma1+=l[j][i];

                }
                if(suma!=suma1){
                    o=false;
                }
            }
            System.out.println(o);
        }
    }
}
