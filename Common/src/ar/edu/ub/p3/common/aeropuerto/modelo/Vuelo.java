package ar.edu.ub.p3.common.aeropuerto.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazVuelo;

public class Vuelo implements InterfazVuelo, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4624792219122186105L;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	private Avion      avion;
	private String     numeroVuelo;
	private double     velocidadCrucero;
	private String     horaAterrizajePretendido;
	private String     horaAterrizajeReal;
	private String     horaDespegue;
	
	public Vuelo(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Avion avion, String numeroVuelo,
			double velocidadCrucero, String horaAterrizajePretendido, String horaAterrizajeReal, String horaDespegue) {
		this.setAeropuetoDestino(aeropuertoDestino);
		this.setAerpuertoOrigen(aeropuertoOrigen);
		this.setAvion(avion);
		this.setHoraAterrizajePretendido(horaAterrizajePretendido);
		this.setHoraAterrizajeReal(horaAterrizajeReal);
		this.setHoraDespegue(horaDespegue);
		this.setNumeroVuelo(numeroVuelo);
		this.setVelocidadCrucero(velocidadCrucero);
		
	}
	
	@Override
	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}
	private void setAerpuertoOrigen(Aeropuerto aerpuertoOrigen) {
		this.aeropuertoOrigen = aerpuertoOrigen;
	}
	@Override
	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}
	private void setAeropuetoDestino(Aeropuerto aeropuetoDestino) {
		this.aeropuertoDestino = aeropuetoDestino;
	}
	@Override
	public Avion getAvion() {
		return avion;
	}
	private void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	@Override
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	private void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	@Override
	public double getVelocidadCrucero() {
		return velocidadCrucero;
	}
	private void setVelocidadCrucero(double velocidadCrucero) {
		this.velocidadCrucero = velocidadCrucero;
	}
	@Override
	public String getHoraAterrizajePretendido() {
		return horaAterrizajePretendido;
	}
	private void setHoraAterrizajePretendido(String horaAterrizajePretendido) {
		this.horaAterrizajePretendido = horaAterrizajePretendido;
	}
	@Override
	public String getHoraAterrizajeReal() {
		return horaAterrizajeReal;
	}
	private void setHoraAterrizajeReal(String horaAterrizajeReal) {
		this.horaAterrizajeReal = horaAterrizajeReal;
	}
	@Override
	public String getHoraDespegue() {
		return horaDespegue;
	}
	private void setHoraDespegue(String horaDespegue) {
		this.horaDespegue = horaDespegue;
	}

}
