package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public int obtenerSumaPuntos(int idRuta) {
		
		int sumaPuntos = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conexion miconex = new Conexion();
		
		String query = "SELECT SUM(PUNTOS) FROM PUNTO WHERE RUTA=?";
		
		try {
			con = miconex.getConexion();
			ps=con.prepareStatement(query);
			ps.setInt(1, idRuta);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				sumaPuntos = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sumaPuntos;
	}
	
	public int contarParaMedia(int idRuta) {
		
		int suma = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conexion miconex = new Conexion();
		
		String query = "SELECT COUNT(*) FROM PUNTO WHERE RUTA=?";
		
		try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, idRuta);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				suma = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return suma;
	}
}
