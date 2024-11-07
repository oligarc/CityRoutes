package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexiones.Conexion;

public class DaoPunto {
	
	public DaoPunto() {
        
    }
	
	public void addPuntuacion(int idRuta,int puntos) {
		
		Connection con = null; 
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		String query = "INSERT INTO PUNTO VALUES (SEQ_PUNTO.NEXTVAL,?,?)";
		
		try {
			con = miconex.getConexion();
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setInt(1, idRuta);
			ps.setInt(2, puntos);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
