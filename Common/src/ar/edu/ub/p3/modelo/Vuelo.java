package ar.edu.ub.p3.modelo;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;

public class Vuelo implements IVuelo {
	
	private String idVuelo;
	private Avion avion;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	
	public Vuelo(String idVuelo, IAvion avion, IAeropuerto aeropuertoOrigen, IAeropuerto aeropuertoDestino) {
		this.setIdVuelo(idVuelo);
		this.setAvion(new Avion(avion));
		this.setAeropuertoOrigen(new Aeropuerto(aeropuertoOrigen));
		this.setAeropuertoDestino(new Aeropuerto(aeropuertoDestino));
	}

	@Override
	public String getIdVuelo() {
		return this.idVuelo;
	}
	@Override
	public IAvion getAvion() {
		return this.avion;
	}
	@Override
	public IAeropuerto getAeropuertoOrigen() {

		return this.aeropuertoOrigen;
	}
	@Override
	public IAeropuerto getAeropuertoDestino() {
		return this.aeropuertoDestino;
	}
	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}
	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	
}
