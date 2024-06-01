import Unidad2.PilaChar;

import javax.swing.*;

public class Prueba2 {
    public static void main(String[] args)
    {
        String menu ="1. Convertir de Infijo a Postfijo"+"\n2. Terminar";
        int opc = 0;
        String mostrar = "";
        while(opc!=2)
        {
            opc=Integer.parseInt(JOptionPane.showInputDialog("Menu\n"+menu));
            if(opc==1)
            {
                String  infijo=JOptionPane.showInputDialog("Ingrese la operación");
                PilaChar pilaOperandos = new PilaChar(infijo.length());


                for(int i=0;i<infijo.length();i++)
                {
                    switch(prioridad(infijo.charAt(i)))
                    {
                        case 0:
                            mostrar += infijo.charAt(i);
                            break;
                        case 1:
                        case 2:
                        case 3:
                            if(pilaOperandos.estaVacia())
                                pilaOperandos.insertar(infijo.charAt(i));
                            else
                            {
                                while( Character.compare(pilaOperandos.datoEnTope(),'(')!=0 && prioridad(infijo.charAt(i))<=prioridad(pilaOperandos.datoEnTope()))
                                {
                                    mostrar+= pilaOperandos.eliminar();
                                }
                                pilaOperandos.insertar(infijo.charAt(i));
                            }
                            break;
                        case 4:
                            pilaOperandos.insertar(infijo.charAt(i));
                            break;
                        case 5:
                            pilaOperandos.insertar(infijo.charAt(i));
                            pilaOperandos.eliminar();
                            boolean variable = true;
                            while(variable){
                                if(pilaOperandos.datoEnTope() =='('){
                                    pilaOperandos.eliminar();
                                    variable= false;
                                    break;
                                }
                                mostrar+=pilaOperandos.eliminar();
                            }
                            break;
                    }

                }
                for( int i = infijo.length(); i >= 0; i--)
                {
                    if(!pilaOperandos.estaVacia())
                    {
                        mostrar+= pilaOperandos.eliminar();
                    }
                }

                JOptionPane.showMessageDialog(null,"Operacion: "+mostrar);
            } else{}
        }
    }
    public static int prioridad(char c)
    {
        int regreso=0;
        String[] vector=new String[]{"+-","*/","^","(",")"};
        for(int i=0;i<vector.length;i++)
        {
            for (int j=0;j<vector[i].length();j++)
            {
                if(c==vector[i].charAt(j))
                {
                    regreso=(i+1);
                }
            }
        }
        return regreso;
    }

}
