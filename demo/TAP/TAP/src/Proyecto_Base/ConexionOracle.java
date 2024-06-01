package Proyecto_Base;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConexionOracle {
    private Connection conn=null;
    private String url,user,pass;

    public ConexionOracle(){
        conectar();
    }

    private void conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            url = "jdbc:oracle:thin:@localhost:1521:XE";
            user ="HR";
            pass ="sandrauno1";
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("conectado");
        }catch(Exception e){
            System.out.println("No se pudo conectar");
        }
    }

    public void desconectar(){
        try{
            conn.close();
        }catch (Exception e){
            System.out.println("error no se pudo desconectar");
        }
    }
}
