package ar.edu.ub.p3.interfaz;

import java.io.Serializable;
import java.util.Date;

import ar.edu.ub.p3.modelo.EstadoVuelo;

public interface IVuelo extends Serializable{
	
	public String getIdVuelo();
	public IAvion getAvion();
	public IAeropuerto getAeropuertoOrigen();
	public IAeropuerto getAeropuertoDestino();
	public Date getHorarioProgramado();
	public IPosicion getPosicion();
	public EstadoVuelo getEstadoVuelo();
	public Date getHorarioDespegue();
	public Date getHorarioAterrizajeEstimado();
}
