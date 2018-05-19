package ar.edu.ub.p3.interfaz;

public interface IVuelo {
	public String getIdVuelo();
	public IAvion getAvion();
	public IAeropuerto getAeropuertoOrigen();
	public IAeropuerto getAeropuertoDestino();
	

}
