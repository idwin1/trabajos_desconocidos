package UNIDAD1;

import javax.swing.*;

public class U1practica1 {
    public static void main(String[] args) {
        Alumnos[] arreglo = new Alumnos[10];
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. alta de un alumno", "2. mostrar alumnos ", "3. alumnos menores de edad", "4. alumnos con promedio reprobado", "5 subir puntos","6. alumnos que nacieron en FEB/2002","7. salir"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);
            switch (respuesta) {
                case "1. alta de un alumno":
                    int posicion = 1;
                    while (posicion > 0 && posicion < 11) {
                         posicion =Integer.parseInt(JOptionPane.showInputDialog(null, "elija una posicion"));
                        if(posicion > 0 && posicion < 11){
                            if (arreglo[posicion - 1] != null) {
                                JOptionPane.showMessageDialog(null, "no puedes usar esta posicion esta ocupado");
                            } else {
                                String nombre = JOptionPane.showInputDialog("ingrese el nombre");
                                //int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la edad"));
                                int numControl = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese numero de control"));
                                float[] calif = new float[3];
                                for (int i = 0; i < calif.length; i++) {
                                    calif[i] = Float.parseFloat(JOptionPane.showInputDialog(null, "ingrese la calificacion  " + (i + 1)));
                                }
                                int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el dia de nacimiento"));
                                int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el mes de nacimiento"));
                                int año = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el año de nacimiento"));
                                arreglo[posicion - 1] = new Alumnos(nombre, calif, numControl,new fecha(dia,mes,año));
                                posicion=-1;
                            }
                        }
                    }

                    break;
                case "2. mostrar alumnos ":
                    String s = "";
                    for (int i = 0; i < arreglo.length; i++) {
                        if (arreglo[i] != null) {
                            s += arreglo[i].toString() + "\nposicion: " + (i + 1) + "\nPromedio: " + arreglo[i].calcularPromedio();
                        }
                    }
                    JOptionPane.showMessageDialog(null, s);
                    break;
                case "3. alumnos menores de edad":
                    s = "";
                    for (int i = 0; i < arreglo.length; i++) {
                        if (arreglo[i] != null)
                            if (arreglo[i].getEdad() < 18)
                                s += "\n " + arreglo[i].getNombre();

                    }
                    JOptionPane.showMessageDialog(null, s);
                    break;
                case "4. alumnos con promedio reprobado":
                    s = "";
                    for (int i = 0; i < arreglo.length; i++) {
                        if (arreglo[i] != null)
                            if (arreglo[i].calcularPromedio() < 70) {
                                s += "\nnombre: " + arreglo[i].getNombre() + "\ncalificaciones : " + arreglo[i].calificaciones();
                            }
                    }
                    JOptionPane.showMessageDialog(null, s);
                    break;
                case "5 subir puntos":
                    String nombre;
                    float cali = 0;
                    float[] vecal = new float[3];
                    nombre = JOptionPane.showInputDialog(null, "Escriba el nombre del alumno");
                    for(int i=0; i<10; i++){
                        if(arreglo[i]!=null){
                            if(arreglo[i].getNombre().equals(nombre)){
                                for(int j=0; j<3; j++){
                                    cali = arreglo[i].getCalif()[j] + 5;
                                    if(cali>100){
                                        vecal[j] = 100f;
                                    }else{
                                        vecal[j] = cali;
                                    }
                                }

                            }
                            arreglo[i].setCalif(vecal);
                        }
                    }
                    /*String nombre = JOptionPane.showInputDialog(null,"ingrese el nombre del alumno");
                    for (Alumnos alu:arreglo) {
                        if(alu!=null)
                            if(alu.getNombre().equalsIgnoreCase(nombre)){
                                float[] nueva = alu.getCalif();
                                nueva[0] = nueva[0] + 5 ;
                                nueva[1] = nueva[1] + 5 ;
                                nueva[2] = nueva[2] + 5 ;
                                if((nueva[0]+nueva[1]+nueva[2])/3<100){
                                    alu.setCalif(nueva);
                                } else if ((nueva[0]+nueva[1]+nueva[2])/3>=100) {
                                    nueva[0] = 100 ;
                                    nueva[1] = 100;
                                    nueva[2] = 100 ;
                                    alu.setCalif(nueva);
                                }

                            }

                    }*/
                    break;
                case "6. alumnos que nacieron en FEB/2002":
                    s="";
                    for (Alumnos alu:arreglo) {
                        if(alu!=null)
                            if(alu.getFecha().getMes()==2 && alu.getFecha().getAño()==2002){
                             s+=alu.getNombre()+"\n";
                            }
                    }
                    JOptionPane.showMessageDialog(null,s);
                    break;
                case "7. salir":
                    salir = true;
                    break;
            }
        }
    }
}
