package Unidad3;

import javax.swing.*;

public class Autolavado {
    public static void main(String[] args) {
        ColaCircularAutos lavado = new  ColaCircularAutos();
        ColaCircularAutos aspirado = new ColaCircularAutos();
        ColaCircularAutos encerado =  new ColaCircularAutos();
        boolean l= true;
        int AUTOS_LAVADOS = 0;
        int CAJA = 0;
        int[] precios = {85,100,125,150};
        boolean salir = false;
        while(!salir){
            String[] opciones1 = {"1. Registro de un auto", "2. Sacar auto del área de lavado", "3. Sacar auto del área de aspirado",
                    "4. Sacar auto del área de encerado", "5. Mostrar autos en área de lavado", "6. Mostrar autos en área de aspirado",
                    "7. Mostrar autos en área de encerado", "8. Reporte financiero","9. Terminar"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);

            switch (respuesta) {
                case "1. Registro de un auto":
                    String servicio[] ={"1) express (solo lavado) $ 85.00","2) plata (lavado y aspirado) $ 100.00",
                            "3) oro (lavado y encerado) $ 125.00","4) diamante (lavado, aspirado y encerado) $ 150.00"};
                    if(!lavado.estaLlena()){
                        String s = JOptionPane.showInputDialog(null,"ingrese la placa");
                        String serv = (String) JOptionPane.showInputDialog(null,"Que servicio quieres","",
                                JOptionPane.QUESTION_MESSAGE,null,servicio,0);
                        int ser = 0;
                        int c = 0;
                        while (l){
                            if(servicio[c].equalsIgnoreCase(serv)){
                                 ser = c;
                               l=false;
                            }
                            c++;
                        }
                        lavado.insertar(new Automovil(s,ser));
                        AUTOS_LAVADOS++;
                        CAJA = CAJA + precios[ser];
                    }else
                        JOptionPane.showMessageDialog(null,"“LO SENTIMOS, EL AUTOLAVADO ESTÁ LLENO Y POR EL MOMENTO NO PODEMOS ATENDERLE”");

                    break;
                case "2. Sacar auto del área de lavado":
                    if(!lavado.estaVacia()){
                        Automovil A= lavado.eliminar();
                        switch (A.getTipoServicio()){
                            case 1:
                                JOptionPane.showMessageDialog(null,"LA placa es: " + A.getPlaca() +
                                        "\n EL AUTO SALIO DEL LAVADO");
                                break;
                            case 2:
                            case 4:
                                if(!aspirado.estaLlena()){
                                    JOptionPane.showMessageDialog(null,"La placa es: " +A.getPlaca() +
                                            "\n PASO AL AREA DE ASPIRADO");
                                    aspirado.insertar(A);
                                }else
                                    JOptionPane.showMessageDialog(null,"NO SE PUEDE PASAR AL AREA DE ASPIRADO PORQUE ESTA LLENA");
                                break;
                            case 3:
                                if(!encerado.estaLlena()){
                                    JOptionPane.showMessageDialog(null,"La placa es: " +A.getPlaca() +
                                            "\n PASO AL AREA DE ENCERADO");
                                    aspirado.insertar(A);
                                }else
                                    JOptionPane.showMessageDialog(null,"NO SE PUEDE PASAR AL AREA DE ENCERADO PORQUE ESTA LLENA");
                                break;
                        }
                    }else
                        JOptionPane.showMessageDialog(null,"NO HAY AUTOS PARA LAVAR");
                    break;
                case "3. Sacar auto del área de aspirado":
                    if(!lavado.estaVacia()) {
                        Automovil A = aspirado.elementoEnFrente();
                        if(A.getTipoServicio() == 4){
                            if(!encerado.estaLlena()){
                                JOptionPane.showMessageDialog(null,"La placa es: " +A.getPlaca() +
                                        "\n PASO AL AREA DE ENCERADO");
                                A = aspirado.eliminar();
                                encerado.insertar(A);
                            }else
                                JOptionPane.showMessageDialog(null,"NO SE PUEDE PASAR AL AREA DE ENCERADO PORQUE ESTA LLENA");
                        }else {
                            A = aspirado.eliminar();
                            JOptionPane.showMessageDialog(null,"La placa es: " +A.getPlaca() +
                                    "\n SALIO DEL AUTOLAVADO");
                        }
                    }else
                        JOptionPane.showMessageDialog(null,"NO HAY AUTOS PARA ASPIRAR");
                    break;
                case "4. Sacar auto del área de encerado":
                    if(!encerado.estaVacia()){
                        Automovil A = encerado.eliminar();
                        JOptionPane.showMessageDialog(null,"La placa es: " +A.getPlaca() +
                                "\n SALIO DEL AUTOLAVADO");
                    }else
                        JOptionPane.showMessageDialog(null,"NO HAY AUTOS PARA ASPIRAR");
                    break;
                case "5. Mostrar autos en área de lavado":
                    if(!lavado.estaVacia()){
                        JOptionPane.showMessageDialog(null,lavado.toString());
                    }else
                        JOptionPane.showMessageDialog(null,"ACTUALMENTE NO HAY AUTOMÓVILES EN EL ÁREA DE LAVADO");
                    break;
                case "6. Mostrar autos en área de aspirado":
                    if(!aspirado.estaVacia()){
                        JOptionPane.showMessageDialog(null,aspirado.toString());
                    }else
                        JOptionPane.showMessageDialog(null,"ACTUALMENTE NO HAY AUTOMÓVILES EN EL ÁREA DE ASPIRADO");
                    break;
                case "7. Mostrar autos en área de encerado":
                    if(!encerado.estaVacia()){
                        JOptionPane.showMessageDialog(null,encerado.toString());
                    }else
                        JOptionPane.showMessageDialog(null,"ACTUALMENTE NO HAY AUTOMÓVILES EN EL ÁREA DE ENCERADO");
                    break;
                case "8. Reporte financiero":
                    JOptionPane.showMessageDialog(null,"LOS AUTOS LAVADOS EN EL DIA SON: " + AUTOS_LAVADOS +
                            "\n DINERO EN CAJA: " + CAJA);
                    break;
                case "9. Terminar":
                    salir = true;
                    break;
            }
        }
    }
}
