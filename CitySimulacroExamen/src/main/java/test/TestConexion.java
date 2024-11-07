package test;

import java.sql.Connection;
import java.sql.SQLException;

import conexiones.Conexion;

public class TestConexion {

	public static void main(String[] args) {
		
		Connection con = null;
		Conexion miconex = new Conexion();
		
		try {
			con = miconex.getConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
