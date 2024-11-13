package daos;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Ruta;

public class DaoRuta {
	
	public DaoRuta() {
        
    }
	
	public ArrayList<Ruta> listaRutasPorIdCiudad(int idCiudad){
		
		ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
		
		Connection con = null; 
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT R.NOMBRE,R.IMAGEN,R.DESCRIPCION,R.LINK,R.ID "
				+ "FROM RUTA R "
				+ "JOIN CIUDAD C ON R.CIUDAD=C.ID "
				+ "WHERE C.ID=?";
		
		try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, idCiudad);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Ruta ruta = new Ruta();
				ruta.setNombre(rs.getString("NOMBRE"));
				ruta.setImagen(rs.getString("IMAGEN"));
				ruta.setDescripcion(rs.getString("DESCRIPCION"));
				ruta.setLink(rs.getString("LINK"));
				ruta.setId(rs.getInt("ID"));
				listaRutas.add(ruta);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
                if(rs!= null) rs.close();
                if(ps!= null) ps.close();
                if(con!= null) con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		
		return listaRutas;
		
	}
	
	public String nombreCiudad(int idCiudad) {
		
		String nombreCiudad = "";
		Connection con = null; 
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT C.NOMBRE "
				+ "FROM RUTA R "
				+ "JOIN CIUDAD C ON R.CIUDAD=C.ID "
				+ "WHERE R.CIUDAD=? "
				+ "AND ROWNUM = 1"; //No funciona ni limit ni fetch first x rows only
		
		try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			ps.setInt(1, idCiudad);
			rs = ps.executeQuery();
			while(rs.next()) {
				nombreCiudad = rs.getString("NOMBRE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
                if(rs!= null) rs.close();
                if(ps!= null) ps.close();
                if(con!= null) con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return nombreCiudad;
	}
	
	public ArrayList<Ruta> listaCiudadesConRuta(){
		
		ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
		Connection con = null; 
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT c.ID, c.NOMBRE, COUNT(r.CIUDAD) AS cantidad " +
	               "FROM RUTA r " +
	               "JOIN CIUDAD c ON r.CIUDAD = c.ID " +
	               "GROUP BY c.ID, c.NOMBRE " + 
	               "HAVING COUNT(r.CIUDAD) >= 1 " +
	               "ORDER BY c.NOMBRE";

		try {
			con = miconex.getConexion();
			 ps = con.prepareStatement(query);
			 rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 
				 Ruta ruta = new Ruta();
				 ruta.setIdCiudad(rs.getInt("ID"));
				 ruta.setNombreCiudad(rs.getString("NOMBRE"));
				 
				 listaRutas.add(ruta);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
                if(rs!= null) rs.close();
                if(ps!= null) ps.close();
                if(con!= null) con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		
		return listaRutas;
	}
	
	

}
