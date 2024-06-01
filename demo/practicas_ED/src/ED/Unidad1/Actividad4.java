package ED.Unidad1;
import javax.swing.JOptionPane;

public class Actividad4 {
    static int i,j,n;

    public static void main(String[] args) throws Exception{
        n = 5;
        metodoB(n);
        n=3;
        medotoA(n);
    }

    public static void medotoA(int n){
        int[][] m = new int[n][n];
        int cont=1;
        j=0;
        String titulo = "Método a";
        for( i=0; i<m.length;i++){
            for(j=0;j<m[i].length;j++){
                m[i][j] = cont;
                cont++;
            }
            i++;
            if(i==n){
                break;
            }
            for(j=(m.length-1);0<=j;j--){
                m[i][j] = cont;
                cont++;

            }
        }
        despliega(m,titulo);
    }

    public static void metodoB(int n){
        int[][] m = new int[n][n];
        int cont = 1;
        int z = 1;
        boolean l = true;
        j = 0;
        for(i=0;i< m.length;i++) {
            m[i][i] = cont++;
        }
        while(l){
            i=0;
            for(j=z;j<m[i].length;j++){
                m[i][j]=cont++;

               /* System.out.println("numero en i: " + i);
                System.out.println("numero en j: "+j);
                System.out.println("nume:" + m[i][j]);
                System.out.println(m[0][4]);*/
                if(i!= m.length){
                    i++;
                }
                if(m[0][(n-1)]!=0){
                    l=false;
                    despliega(m,"");
                    break;
                }
            }
            z++;
        }

    }
    public static void despliega(int[][] m, String titulo){
        String s = titulo + " \n\n";
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m[i].length; j++) {
                s+= m[i][j] + ",";
            }
            s+= "\n";
        }
        JOptionPane.showMessageDialog(null,s);
    }
}
