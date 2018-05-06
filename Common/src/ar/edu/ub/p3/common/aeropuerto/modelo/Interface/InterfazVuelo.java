package ar.edu.ub.p3.common.aeropuerto.modelo.Interface;

public interface InterfazVuelo {
	
	public InterfazAeropuerto getAeropuertoOrigen();
	public InterfazAeropuerto getAeropuertoDestino();
	public InterfazAvion getAvion();	
	public String getNumeroVuelo();
	public double getVelocidadCrucero();
	public String getHoraDespegue();
	public String getHoraAterrizajePretendido();
	public String getHoraAterrizajeReal();
	
	
	
}
