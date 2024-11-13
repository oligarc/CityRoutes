package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Ciudad;

public class DaoCiudad {
	
    public DaoCiudad() {
        
    }
    
    public ArrayList<Ciudad> listaCiudadesConTodo(){
    	
    	ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
    	
    	Connection con = null;
    	Conexion miconex = new Conexion();
    	String query = "SELECT * FROM CIUDAD";
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
			con = miconex.getConexion();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
                
				ciudad.setId(rs.getInt("ID"));
				ciudad.setNombre(rs.getString("NOMBRE"));
				ciudad.setImagen(rs.getString("IMAGEN"));
				ciudad.setDescripcion(rs.getString("DESCRIPCION"));
				ciudad.setLink(rs.getString("LINK"));
				ciudad.setMapa(rs.getString("MAPA"));
                listaCiudades.add(ciudad);
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
    	
    	return listaCiudades;
    }

}
