package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import daos.DaoCiudad;
import daos.DaoPunto;
import daos.DaoRuta;
import entidades.Ciudad;
import entidades.Ruta;

/**
 * Servlet implementation class ControllerAdmin
 */
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String operacion = request.getParameter("operacion");
		DaoCiudad daoCiudad = new DaoCiudad();
		DaoRuta daoRuta = new DaoRuta();
		DaoPunto daoPunto = new DaoPunto();
		
        switch (operacion) {
        
        case "iniciar":
        	
        	ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
        	listaCiudades = daoCiudad.listaCiudadesConTodo();
        	ArrayList<Ruta> listaCiudadesConRutas = new ArrayList<Ruta>();
        	listaCiudadesConRutas = daoRuta.listaCiudadesConRuta();
        	
        	request.setAttribute("listadoCiudades", listaCiudades);
        	session.setAttribute("listadoCiudadesRuta", listaCiudadesConRutas);
        	request.getRequestDispatcher("ciudad.jsp").forward(request, response);
        	
        	break; 
        	
        case "rutaCiudad":
        	
        	int idCiudadParaRuta = Integer.parseInt(request.getParameter("opcionRuta"));
        	ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
        	listaRutas = daoRuta.listaRutasPorIdCiudad(idCiudadParaRuta);
        	String nombreCiudadAPasar = daoRuta.nombreCiudad(idCiudadParaRuta);
        	
        	for (Ruta ruta : listaRutas) {
				int sumaPuntos = daoPunto.obtenerSumaPuntos(ruta.getId());
				int sumaVeces = daoPunto.contarParaMedia(ruta.getId());
				double media = (double) sumaPuntos/sumaVeces;
				media = Math.round(media);
				ruta.setMediaPuntuacion(media);
			}
        	
        	session.setAttribute("opcionRuta",idCiudadParaRuta);
        	session.setAttribute("nombreCiudad", nombreCiudadAPasar);
        	session.setAttribute("listadoRutas", listaRutas);
        	request.getRequestDispatcher("ruta.jsp").forward(request, response);
        	
        	break;
        	
        case "rating":
        	
        	int puntosInsercion = Integer.parseInt(request.getParameter("puntos"));
        	int idRutaInsercion = Integer.parseInt(request.getParameter("idRuta"));
        	daoPunto.addPuntuacion(idRutaInsercion, puntosInsercion);
        	request.getRequestDispatcher("ruta.jsp").forward(request, response);
        	
        	break;
        }
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
