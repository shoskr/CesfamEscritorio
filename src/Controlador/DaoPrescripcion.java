package Controlador;

import clase.Cl_Coneccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPrescripcion {

    private Connection conn;

    public DaoPrescripcion() {
        conn = new Cl_Coneccion().getConnection();

    }

    public ArrayList<Object[]> ListarPendientes() {
        try {
            String sql = "SELECT PRESCRIPCION.ID_PRESCRIPCION, \n"
                    + "       PACIENTE.ID_PACIENTE, \n"
                    + "       PACIENTE.NOMBRE || ' ' || PACIENTE.APELLIDO_PATERNO,\n"
                    + "       PRESCRIPCION.ESTADO\n"
                    + "       FROM PRESCRIPCION\n"
                    + "INNER JOIN RECETA\n"
                    + "        ON PRESCRIPCION.RECETA_ID_RECETA = RECETA.ID_RECETA\n"
                    + "INNER JOIN PACIENTE\n"
                    + "        ON RECETA.PACIENTE_ID_PACIENTE = PACIENTE.ID_PACIENTE\n"
                    + "WHERE PRESCRIPCION.ESTADO = 'PENDIENTE' ";

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

}
