package ar.edu.ub.p3.common.aeropuerto.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazAvion;
import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazPosicionGetterSetter;

public class Avion implements InterfazAvion, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8249860823013708748L;
	private Posicion posicion;
	private String   patente;
	private String   modelo;
	
	
	public Avion(Posicion posicion, String patente, String modelo) {
		this.setModelo(modelo);
		this.setPatente(patente);
		this.setPosicion(posicion);
	}

	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String getPatente() {
		return patente;
	}
	
	private void setPatente(String patente) {
		this.patente = patente;
	}
	
	@Override
	public String getModelo() {
		return modelo;
	}
	
	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public InterfazPosicionGetterSetter getPosicion() {
		return posicion;
	}
	
	

}
