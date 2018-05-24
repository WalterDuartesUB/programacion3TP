package ar.edu.ub.p3.modelo;

import java.io.Serializable;
import java.util.Date;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;

public class Vuelo implements IVuelo,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1023138772196002204L;
	private String idVuelo;
	private Avion avion;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;	
	private Date horarioProgramado;
	
	public Vuelo(String idVuelo, IAvion avion, IAeropuerto aeropuertoOrigen, IAeropuerto aeropuertoDestino, Date horarioProgramado) {
		this.setIdVuelo(idVuelo);
		this.setAvion(new Avion(avion));
		this.setAeropuertoOrigen(new Aeropuerto(aeropuertoOrigen));
		this.setAeropuertoDestino(new Aeropuerto(aeropuertoDestino));
		this.setHorarioProgramado(horarioProgramado);
	}
	
	public Vuelo( IVuelo vuelo ) {
		this( vuelo.getIdVuelo(), vuelo.getAvion(), vuelo.getAeropuertoOrigen(), vuelo.getAeropuertoDestino(), vuelo.getHorarioProgramado() );
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
	private void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}
	private void setAvion(Avion avion) {
		this.avion = avion;
	}
	private void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}
	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	public void setPosicion(Posicion posicion) {
		this.avion.setPosicion(posicion);
	}
	@Override
	public String toString() {
		return this.getIdVuelo() + " " + this.getAvion().toString() + " " + this.getAeropuertoOrigen().toString() + " " + this.getAeropuertoDestino().toString() + " " + this.getHorarioProgramado().toString();
	}

	@Override
	public Date getHorarioProgramado() {
		return horarioProgramado;
	}

	private void setHorarioProgramado(Date horarioProgramado) {
		this.horarioProgramado = horarioProgramado;
	}
	
}
