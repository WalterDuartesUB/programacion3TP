package ar.edu.ub.p3.modelo;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IPosicion;

public class Aeropuerto implements IAeropuerto{
	
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
	public void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
}
