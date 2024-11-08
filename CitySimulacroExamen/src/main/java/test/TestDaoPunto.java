package test;

import daos.DaoPunto;

public class TestDaoPunto {

	public static void main(String[] args) {
		
		DaoPunto daoPunto = new DaoPunto();
		//daoPunto.addPuntuacion(1, 3);
		
		int suma = daoPunto.obtenerSumaPuntos(1);
		System.out.println(suma);
		
		int cuantasVeces = daoPunto.contarParaMedia(1);
		System.out.println(cuantasVeces);

	}

}
