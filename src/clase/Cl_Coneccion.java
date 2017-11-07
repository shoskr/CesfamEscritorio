
package clase;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cl_Coneccion {
    
    private static Connection conn;
    private String servidor = "jdbc:oracle:thin:@localhost:1521:XE";
    private String usuario = "BDPRUEBA";
    private String pass = "ROOT";
    
    public Cl_Coneccion(){
        try{
            if(conn ==null){
                Class.forName("oracle.jdbc.OracleDriver");
                conn = DriverManager.getConnection(servidor,usuario,pass);
            }
            
        }catch(Exception e){
            
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}
