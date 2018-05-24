package ar.edu.ub.p3.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.interfaz.IAerolinea;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IPosicion;

public class Avion implements IAvion,Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8557012986126896848L;
	private String   idAvion;
	private Posicion posicion;
	private Aerolinea aerolinea;
	
	public Avion(String idAvion, IAerolinea aerolinea, IPosicion posicion) {
		this.setIdAvion(idAvion);
		this.setPosicion(new Posicion(posicion));
		this.setAerolinea( new Aerolinea( aerolinea ) );
	}
	public Avion(IAvion avion) {
		this(avion.getIdAvion(), avion.getAerolinea(), avion.getPosicion());
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
		return this.getIdAvion() + " " + this.getAerolinea().toString() + " " + this.getPosicion().toString();
	}
	
	@Override
	public IAerolinea getAerolinea() {
		return aerolinea;
	}
	
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
}
