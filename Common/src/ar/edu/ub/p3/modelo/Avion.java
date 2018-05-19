package ar.edu.ub.p3.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IPosicion;

public class Avion implements IAvion,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -172315318430544179L;
	private String   idAvion;
	private Posicion posicion;
	
	public Avion(String idAvion, IPosicion posicion) {
		this.setIdAvion(idAvion);
		this.setPosicion(new Posicion(posicion));
	}
	public Avion(IAvion avion) {
		this(avion.getIdAvion(),avion.getPosicion());
	}
	
	@Override
	public String getIdAvion() {
		return this.idAvion;
	}
	@Override
	public IPosicion getPosicion() {
		return this.posicion;
	}
	private void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
		return this.getIdAvion() + " " + this.getPosicion().toString();
	}
	
}
