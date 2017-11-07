package Controlador;

import clase.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoReceta {

    private Connection conn;

    public DaoReceta() {
        conn = new Cl_Coneccion().getConnection();

    }

    public ArrayList<Object[]> BuscarRecetas(int rut) {
        try {
            String sql = "SELECT RECETA.ID_RECETA,\n"
                    + "       ARTICULO_Y_MEDICA.CODIGO_AM,\n"
                    + "       ARTICULO_Y_MEDICA.DESCRIPCION,\n"
                    + "       PRESCRIPCION.ID_PRESCRIPCION,\n"
                    + "       PRESCRIPCION.CANTIDAD_MEDICAMENTO,\n"
                    + "       RECETA.ESTADO \n"
                    + "      FROM PRESCRIPCION \n"
                    + "INNER JOIN RECETA \n"
                    + "        ON RECETA.ID_RECETA = PRESCRIPCION.RECETA_ID_RECETA \n"
                    + "INNER JOIN ARTICULO_Y_MEDICA \n"
                    + "        ON ARTICULO_Y_MEDICA.CODIGO_AM = PRESCRIPCION.ARTICULO_Y_MEDICA_CODIGO_AM \n"
                    + "WHERE PRESCRIPCION.ESTADO = 'PENDIENTE' \n"
                    + "       AND RECETA.PACIENTE_ID_PACIENTE = " + rut;

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            ArrayList<Object[]> listado = new ArrayList<Object[]>();
            while (rs.next()) {
                Object[] raws = new Object[rsm.getColumnCount()];
                for (int i = 0; i < raws.length; i++) {
                    raws[i] = rs.getObject(i + 1);
                }
                listado.add(raws);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("Error Listado:" + e.getMessage());
            return null;
        }
    }

    public boolean entregarR(int id_Med, int id_Pre, int cant) {
       
        try {
            
            PreparedStatement pstm = conn.prepareCall("EXEC SP_ENTREGAMED(?,?,?)");
            pstm.setInt(1, id_Med);
            pstm.setInt(2, id_Pre);
            pstm.setInt(3, cant);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }else{
                return false;
            }
//consultar con fredy
        } catch (Exception e) {
            System.out.println("Error Listado:" + e.getMessage());
            return false;
        }
    }

}
