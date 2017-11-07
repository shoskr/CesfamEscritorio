package Controlador;


import clase.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author LSP
 */






public class ArticuloMedicamentoDAO {

    private Connection cone;

    public ArticuloMedicamentoDAO() {
        try {
            cone = new Cl_Coneccion().getConnection();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean Agregar(ArticuloMedicamento var) {
        try {
            String sql = "INSERT INTO ARTICULO_Y_MEDICA VALUES (?,?,?,?,?,?,?,?)";
           
            PreparedStatement stm = cone.prepareStatement(sql);
                    
           
            stm.setInt(1, var.getCodigoAm());
            stm.setString(2, var.getDescripcion());
            stm.setString(3, var.getFabricante());
            stm.setString(4, var.getTipoMedicamento());
            stm.setString(5, var.getComponentes());
            stm.setString(6, var.getContenido());
            stm.setInt(7, var.getCantidad());
            stm.setString(8, var.getGramaje());                     
         
            int x = stm.executeUpdate();
            return x > 0 ? true : false;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean Eliminar(int var) {
        try {
            String sql = "DELETE FROM ARTICULO_Y_MEDICA WHERE CODIGO_AM= ?";
            PreparedStatement stm = cone.prepareStatement(sql);
            stm.setInt(1, var);
            int x = stm.executeUpdate();
            return x > 0 ? true : false;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public boolean Modificar(ArticuloMedicamento var) throws Exception {
        try {
            String sql = "UPDATE ARTICULO_Y_MEDICA SET DESCRIPCION=?,FABRICANTE=?,TIPO_MEDICAMENTO=?, COMPONENTES=?,CONTENIDO=?,CANTIDAD=?,GRAMAJE=? WHERE CODIGO_AM= ?";
            PreparedStatement stm = cone.prepareStatement(sql);
            //stm.setInt(1, var.getCodigoAm()); //Test mientras, despues se arregla el autoincrement
            stm.setString(2, var.getDescripcion());
            stm.setString(3, var.getFabricante());
            stm.setString(4, var.getTipoMedicamento());
            stm.setString(5, var.getComponentes());
            stm.setString(6, var.getContenido());
            stm.setInt(7, var.getCantidad());
            stm.setString(8, var.getGramaje());        
            int x = stm.executeUpdate();
            return x > 0 ? true : false;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public ArticuloMedicamento Buscar(int var) {
        try {
            String sql = "SELECT * FROM ARTICULO_Y_MEDICA WHERE CODIGO_AM=?";
            PreparedStatement stm = cone.prepareStatement(sql);
            stm.setInt(1, var);
            ResultSet rs = stm.executeQuery();
            ArticuloMedicamento com = null;
            while (rs.next()) {
                com.setCodigoAm(rs.getInt("CODIGO_AM"));
                com.setDescripcion(rs.getString("DESCRIPCION"));
                com.setFabricante(rs.getString("FABRICANTE"));
                com.setTipoMedicamento(rs.getString("TIPO_MEDICAMENTO"));
                com.setComponentes(rs.getString("COMPONENTES"));
                com.setCantidad(rs.getInt("CANTIDAD"));
                com.setGramaje(rs.getString("GRAMAJE"));
                    }
            return com;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    
    //Metodo Para buscar por Otros campos Pendiente
 
    
    
    //Metodo Listar TODOS los medicamentos
    public ArrayList<ArticuloMedicamento> Listar() {
        try {
            String sql = "SELECT * FROM ARTICULO_Y_MEDICA";
            PreparedStatement stm = cone.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            ArrayList<ArticuloMedicamento> var = new ArrayList<ArticuloMedicamento>();
            while (rs.next()) {
                ArticuloMedicamento com = new ArticuloMedicamento();
            
                com.setCodigoAm(rs.getInt("CODIGO_AM"));
                com.setDescripcion(rs.getString("DESCRIPCION"));
                com.setFabricante(rs.getString("FABRICANTE"));
                com.setTipoMedicamento(rs.getString("TIPO_MEDICAMENTO"));
                com.setComponentes(rs.getString("COMPONENTES"));
                com.setCantidad(rs.getInt("CANTIDAD"));
                com.setGramaje(rs.getString("GRAMAJE"));
                
                var.add(com);
                           
            }
            return var;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    
      
}
