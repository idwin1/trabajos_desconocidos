package ED.Unidad1;
import javax.swing.*;

import static java.lang.Float.valueOf;

public class ExamenU1A {
    //IDWIN RAZIEL BALDERAS ALMANZA
    public static void main(String[]args){
        Empleado[] oficinaSur = new Empleado[10];
        int cont=0;
        boolean salir =false;

        while(salir == false){

            String[] opciones1 = {"Capturar un empleado", "Mostrar datos de los empleados ", "calculo de nomina","Aumento de sueldo", "buscar un empleado","terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, "Capturar un libro");
            switch(respuesta){
                case "Capturar un empleado":
                    String nombre;
                    float sueldoPorHora=0;
                    int horas;
                    if(cont<oficinaSur.length){
                        nombre=JOptionPane.showInputDialog(null,"nombre del empleado");
                        sueldoPorHora = valueOf(JOptionPane.showInputDialog(null,"sueldo por hora"));
                        horas = Integer.parseInt(JOptionPane.showInputDialog(null,"horas a trabajar"));
                        oficinaSur[cont]=new Empleado(nombre,sueldoPorHora,horas);
                        cont++;
                    }else {
                        JOptionPane.showMessageDialog(null,"YA NO PUEDES AGREGAR EMPLEADOS");
                    }
                    break;
                case "Mostrar datos de los empleados ":

                    String s = "";
                    for (int i=0; i<oficinaSur.length;i++){
                        if(oficinaSur[i]!=null) {
                            s +="-"+ oficinaSur[i].toString() +"\n" ;
                        }
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "calculo de nomina":
                    float suma=0;
                    for(int i=0; i<oficinaSur.length;i++){
                        if(oficinaSur[i]!=null) {
                            suma += (oficinaSur[i].getSueldoPorHora()*oficinaSur[i].getHoras());
                        }
                    }
                    JOptionPane.showMessageDialog(null,"La nomina Total es: " + suma);
                    break;
                case "Aumento de sueldo":
                    for(int i=0; i<oficinaSur.length;i++){
                        if(oficinaSur[i]!=null) {
                            if (oficinaSur[i].getHoras()>30){
                                oficinaSur[i].setSueldoPorHora(oficinaSur[i].getSueldoPorHora()*1.025f);
                            }
                        }
                    }
                    break;
                case "buscar un empleado":
                    String nombreEM;
                    boolean encontrado = false;
                    nombreEM=JOptionPane.showInputDialog(null,"nombre del empleado");
                    for(int i=0; i<oficinaSur.length;i++){
                        if(oficinaSur[i]!=null){
                            if(nombreEM.equalsIgnoreCase(oficinaSur[i].getNombre())){
                                JOptionPane.showMessageDialog(null,oficinaSur[i].toString());
                               encontrado = true;
                            }
                        }
                    }
                    if (encontrado==false){
                        JOptionPane.showMessageDialog(null,"EMPLEADO NO EXISTE EN ESTA OFICINA");
                    }
                    break;
                case "terminar":
                    salir = true;
                    break;
            }
        }
    }
}
