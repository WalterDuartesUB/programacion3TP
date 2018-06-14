package ar.edu.ub.p3.modelo;

import java.io.Serializable;
import java.util.Date;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;

public class Vuelo implements IVuelo,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6232754061495941649L;
	private String idVuelo;
	private volatile Avion avion;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;	
	private Date horarioProgramado;
	private Date horarioDespegue;
	private Date horarioAterrizajeEstimado;
	private EstadoVuelo estadoVuelo;
	
	public Vuelo(String idVuelo, IAvion avion, IAeropuerto aeropuertoOrigen, IAeropuerto aeropuertoDestino, Date horarioProgramado) {
		this.setIdVuelo(idVuelo);
		this.setAvion(new Avion(avion));
		this.setAeropuertoOrigen(new Aeropuerto(aeropuertoOrigen));
		this.setAeropuertoDestino(new Aeropuerto(aeropuertoDestino));
		this.setHorarioProgramado(horarioProgramado);
		
		this.setHorarioAterrizajeEstimado(horarioProgramado);
		this.setHorarioDespegue(horarioProgramado);
		this.setEstadoVuelo(EstadoVuelo.BOARDING);
	}
	
	public Vuelo(String idVuelo, IAvion avion, IAeropuerto aeropuertoOrigen, IAeropuerto aeropuertoDestino, Date horarioProgramado, Date horarioDespegue, Date horarioAterrizajeEstimado, EstadoVuelo estadoVuelo) {
		this(idVuelo,avion,aeropuertoOrigen, aeropuertoDestino,horarioProgramado);
		
		this.setEstadoVuelo(estadoVuelo);		
		this.setHorarioDespegue(horarioDespegue);
		this.setHorarioAterrizajeEstimado(horarioAterrizajeEstimado);
	}
	
	public Vuelo( IVuelo vuelo ) {
		this( vuelo.getIdVuelo(), vuelo.getAvion(), vuelo.getAeropuertoOrigen(), vuelo.getAeropuertoDestino(), vuelo.getHorarioProgramado(), vuelo.getHorarioDespegue(), vuelo.getHorarioAterrizajeEstimado(), vuelo.getEstadoVuelo() );
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

	@Override
	public IPosicion getPosicion() {
		return this.getAvion().getPosicion();
	}

	@Override
	public EstadoVuelo getEstadoVuelo() {
		return this.estadoVuelo;
	}

	public void setEstadoVuelo(EstadoVuelo estadoVuelo) {
		this.estadoVuelo = estadoVuelo;
	}

	public Date getHorarioAterrizajeEstimado() {
		return horarioAterrizajeEstimado;
	}

	public void setHorarioAterrizajeEstimado(Date horarioAterrizajeEstimado) {
		this.horarioAterrizajeEstimado = horarioAterrizajeEstimado;
	}

	public Date getHorarioDespegue() {
		return horarioDespegue;
	}

	public void setHorarioDespegue(Date horarioDespegue) {
		this.horarioDespegue = horarioDespegue;
	}
	
}
