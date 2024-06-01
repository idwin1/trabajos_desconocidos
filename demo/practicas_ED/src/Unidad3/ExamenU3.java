package Unidad3;

import javax.swing.*;

public class ExamenU3 {
/*
IDWIN RAZIEL BALDERAS ALMANZA
 */
    public static void main(String[] args) {
        ColaLinealCliente filaBancomer = new ColaLinealCliente(2);
        boolean salir = false;
        while (!salir) {
            String[] opciones1 = {"1. Insertar cliente", "2. Mostrar cliente", "3. Suma total de saldo",
                    "4. Aumentar saldo del cliente del frente", "5. Cliente de un tipo de cuenta", "6. terminar"};
            String[] cuentas = {"oro", "plata", "bronce"};
            String respuesta = (String) JOptionPane.showInputDialog(null, "Que quieres hacer",
                    "", JOptionPane.QUESTION_MESSAGE, null, opciones1, 0);

            switch (respuesta) {
                case "1. Insertar cliente":
                    if(!filaBancomer.estaLlena()){
                        String nombre = JOptionPane.showInputDialog("nombre","ingrese su nombre");
                        String tipoCuenta = (String) JOptionPane.showInputDialog(null, "Tipos de cuentas",
                                "", JOptionPane.QUESTION_MESSAGE, null, cuentas, 0);
                        float saldo =Integer.parseInt(JOptionPane.showInputDialog("saldo","ingrese su saldo"));
                        filaBancomer.insertar(new Cliente(nombre,tipoCuenta,saldo));
                    }else
                        JOptionPane.showMessageDialog(null,"no se puede insertar la fila esta llena");

                    break;
                case"2. Mostrar cliente":
                    JOptionPane.showMessageDialog(null,filaBancomer.toString());
                    break;
                case "3. Suma total de saldo":
                    JOptionPane.showMessageDialog(null,"saldo total:" + filaBancomer.sumaSaldos());
                    break;
                case "4. Aumentar saldo del cliente del frente":
                    filaBancomer.aumentarSaldoFrente(Float.parseFloat(JOptionPane.showInputDialog("porcentaje","ingrese el poecenntaje que quiere aumentar")));
                    break;
                case "5. Cliente de un tipo de cuenta":
                    String tipoCuentas = (String) JOptionPane.showInputDialog(null, "Tipos de cuentas",
                            "", JOptionPane.QUESTION_MESSAGE, null, cuentas, 0);
                    JOptionPane.showMessageDialog(null,filaBancomer.mostrartipoClientes(tipoCuentas));
                    break;
                case "6. terminar":
                    salir = true;
                    break;
            }
        }
    }
}
