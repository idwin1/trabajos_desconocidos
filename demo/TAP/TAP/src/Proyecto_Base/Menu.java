package Proyecto_Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Menu {
    public static void main(String[] args) {
        ConexionOracle conn = new ConexionOracle();
        conn.desconectar();
    }
}
