package ar.edu.ub.p3.interfaz;

import java.io.Serializable;
import java.util.Date;

public interface IVuelo extends Serializable{
	
	public String getIdVuelo();
	public IAvion getAvion();
	public IAeropuerto getAeropuertoOrigen();
	public IAeropuerto getAeropuertoDestino();
	public Date getHorarioProgramado();
	

}
