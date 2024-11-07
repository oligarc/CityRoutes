package test;

import java.util.ArrayList;

import daos.DaoRuta;
import entidades.Ruta;

public class TestDaoRuta {

	public static void main(String[] args) {
		
		DaoRuta daoRuta = new DaoRuta();
		ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
		
		listaRutas = daoRuta.listaRutasPorIdCiudad(4);
		
		/*for (Ruta ruta : listaRutas) {
			System.out.println(ruta.toString());
		}
		
		*/
		
		/*ArrayList<Ruta> listaRutasNombre = new ArrayList<Ruta>();
		listaRutasNombre = daoRuta.listaCiudadesConRuta();
		
		for (Ruta ruta : listaRutasNombre) {
			System.out.println(ruta.toString());
		}
		
		*/
		
		String nombreCiudad = daoRuta.nombreCiudad(2);
		System.out.println(nombreCiudad);

	}

}
