package ar.edu.ub.p3.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IPosicion;

public class Aeropuerto implements IAeropuerto,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3310136677628152272L;
	private String idAeropuerto;
	private Posicion posicion;
	
	public Aeropuerto(String idAeropuerto, IPosicion posicion) {
		this.setIdAeropuerto(idAeropuerto);
		this.setPosicion(new Posicion( posicion));
	}
	
	public Aeropuerto(IAeropuerto aeropuerto) {
		this(aeropuerto.getIdAeropuerto(),aeropuerto.getPosicion());
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
		return this.getIdAeropuerto() + " " + this.getPosicion().toString();
	}
}
