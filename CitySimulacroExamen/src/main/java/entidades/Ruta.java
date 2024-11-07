package entidades;

public class Ruta {
	
	private int id;
	private int idCiudad;
	private String nombre;
	private String imagen;
	private String descripcion;
	private String link;
	private String nombreCiudad; //Unicamente para la lista despegable de los option
	
	
	public Ruta() {
        
    }
	
	
	public Ruta(int id, int idCiudad, String nombre, String imagen, String descripcion, String link) {
		this.id = id;
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.link = link;
	}
	
	

	public String getNombreCiudad() {
		return nombreCiudad;
	}


	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	@Override
	public String toString() {
		return "Ruta [id=" + id + ", idCiudad=" + idCiudad + ", nombre=" + nombre + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", link=" + link + ", nombreCiudad=" + nombreCiudad + "]";
	}

	
	
	

}
