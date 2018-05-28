package ar.edu.ub.p3.aeropuerto.servidor;

import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.modelo.Avion;



public class EstadoAeropuerto {

	private boolean sigueCorriendo;
	private List<Avion> aviones;
	
	public EstadoAeropuerto(boolean sigueCorriendo) {
		this.setSigueCorriendo(sigueCorriendo);
		this.setAviones( new LinkedList<Avion>());
	}
	
	public EstadoAeropuerto() {
		this( true );
		
	}

	public boolean isSigueCorriendo() {
		return this.sigueCorriendo;
	}
	
	public void setSigueCorriendo(boolean sigueCorriendo) {
		this.sigueCorriendo = sigueCorriendo;
	}

	public List<Avion> getAviones() {
		return aviones;
	}

	private void setAviones(List<Avion> aviones) {
		this.aviones = aviones;
	}

}
