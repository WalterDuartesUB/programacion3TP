package ar.edu.ub.p3.modelo;

import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IPosicion;

public class Avion implements IAvion{
	
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
	public void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
}
