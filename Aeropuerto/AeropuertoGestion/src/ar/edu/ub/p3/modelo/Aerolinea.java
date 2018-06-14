package ar.edu.ub.p3.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.interfaz.IAerolinea;

public class Aerolinea  implements IAerolinea, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 570735076632650397L;
	private String idAerolinea;
	private String nombre;
	
	public Aerolinea(String idAerolinea, String nombre) {	
		this.setIdAerolinea(idAerolinea);
		this.setNombre(nombre);
	}

	public Aerolinea( IAerolinea aerolinea ) {
		this( aerolinea.getIdAerolinea(), aerolinea.getNombre() );
	}
	
	@Override
	public String toString() {
		return this.getIdAerolinea() + " " + this.getNombre();
	}
	
	@Override
	public String getIdAerolinea() {
		return idAerolinea;
	}

	private void setIdAerolinea(String idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
