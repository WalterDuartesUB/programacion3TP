package ar.edu.ub.p3.common.aeropuerto.modelo;

import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazAeropuerto;

public class Aeropuerto implements InterfazAeropuerto {
	
	private String   iata;
	private String   nombre;
	private Posicion posicion;
	
	@Override
	public String getIATA() {
		return iata;
	}
	
	private void setIATA(String iata) {
		this.iata = iata;
	}
	
	public Aeropuerto(String iata, String nombre, Posicion posicion) {
		this.setIATA(iata);
		this.setNombre(nombre);
		this.setPosicion(posicion);
	}

	@Override
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public Posicion getPosicion() {
		return posicion;
	}
	
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	

}
