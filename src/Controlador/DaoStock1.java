package Controlador;

import clase.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoStock1 {

    private Connection conn;

    public DaoStock1() {
        conn = new Cl_Coneccion().getConnection();
    }

    public ArrayList<Object[]> Listar() {
        try {
            String sql = "SELECT STOCK_MEDICAMENTO.ID_STOCK_MEDICAMENTO,\n"
                    + "       ARTICULO_Y_MEDICA.DESCRIPCION,\n"
                    + "       STOCK_MEDICAMENTO.STOCK_MEDI,\n"
                    + "       STOCK_MEDICAMENTO.STOCK_CRITICO\n"
                    + "       FROM STOCK_MEDICAMENTO\n"
                    + "INNER JOIN ARTICULO_Y_MEDICA\n"
                    + "        ON ARTICULO_Y_MEDICA.CODIGO_AM = STOCK_MEDICAMENTO.ARTICULO_Y_MEDICA_CODIGO_AM";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            ArrayList<Object[]> lista = new ArrayList<Object[]>();
            while (rs.next()) {
                Object[] raws = new Object[rsm.getColumnCount()];
                for (int i = 0; i < raws.length; i++) {
                    raws[i] = rs.getObject(i + 1);
                }
                lista.add(raws);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error Listado:" + e.getMessage());
            return null;
        }

    }

}
