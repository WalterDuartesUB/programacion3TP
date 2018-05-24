package ar.edu.ub.p3.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IPosicion;

public class Aeropuerto implements IAeropuerto,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8284506288360925743L;
	
	private String idAeropuerto;
	private Posicion posicion;
	private String nombre;
	
	public Aeropuerto(String idAeropuerto, String nombre, IPosicion posicion) {
		this.setIdAeropuerto(idAeropuerto);
		this.setPosicion(new Posicion( posicion));
		this.setNombre(nombre);
	}
	
	public Aeropuerto(IAeropuerto aeropuerto) {
		this(aeropuerto.getIdAeropuerto(), aeropuerto.getNombre(), aeropuerto.getPosicion());
	}
	@Override
	public String getIdAeropuerto() {
	
		return this.idAeropuerto;
	}
	@Override
	public IPosicion getPosicion() {
	
		return this.posicion;
	}
	private void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
		return this.getIdAeropuerto() + " " + this.getNombre() + " " + this.getPosicion().toString();
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
