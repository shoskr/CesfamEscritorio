package Controlador;
import clase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoUsuario {
    
    private Connection conn;
    
    
    public DaoUsuario(){
      conn = new Cl_Coneccion().getConnection();
    }
    
    public boolean validarusuaro(Usuario usu){
        try{
            PreparedStatement pstm = conn.prepareCall("SELECT * FROM USUARIO WHERE NOMBRE_USUARIO = ? AND PASSWORD = ? AND TIPO_USUARIO_ID_TIPO_U IN (1,2) ");
            pstm.setString(1, usu.getNombreUsuario());
            pstm.setString(2, usu.getPassword());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }  
    
}
