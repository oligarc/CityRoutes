package entidades;

public class Punto {
	
	private int id;
	private int idRuta;
	private double puntos;
	
	public Punto() {
        
    }
	
	public Punto(int id, int idRuta, double puntos) {
		this.id = id;
        this.idRuta = idRuta;
        this.puntos = puntos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Punto [id=" + id + ", idRuta=" + idRuta + ", puntos=" + puntos + "]";
	}
	
	

}
