package ar.edu.ub.p3.modelo;

import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.util.Configuracion;

public class EstadoAeropuerto {

	private Aeropuerto aerpuerto;
	private List<Avion> aviones;
	
	private boolean estoyConectado;
	private boolean estoyEsperandoRespuestaConexion;
	private boolean deboContinuar;
	
	public EstadoAeropuerto( Configuracion configuracion  ) {
		 
		String nomAeropuerto = configuracion.getConfiguracion("nombreAeropuerto");
		double posX = Double.parseDouble(configuracion.getConfiguracion("posicionAeropuertoX")) ;
		double posY = Double.parseDouble(configuracion.getConfiguracion("posicionAeropuertoY")) ;
		
		Posicion posicion = new Posicion(posX, posY);
		
		this.setAerpuerto(new Aeropuerto(nomAeropuerto,posicion));
		this.setAviones(new LinkedList<Avion>());
		
		this.setEstoyConectado(false);
		this.setEstoyEsperandoRespuestaConexion(false);
		this.setDeboContinuar(true);
		
		
	}
	
	
	public Aeropuerto getAerpuerto() {
		return aerpuerto;
	}

	private void setAerpuerto(Aeropuerto aerpuerto) {
		this.aerpuerto = aerpuerto;
	}

	public List<Avion> getAviones() {
		return aviones;
	}

	private void setAviones(List<Avion> aviones) {
		this.aviones = aviones;
	}


	public boolean isEstoyConectado() {
		return estoyConectado;
	}


	public void setEstoyConectado(boolean estoyConectado) {
		this.estoyConectado = estoyConectado;
	}


	public boolean isEstoyEsperandoRespuestaConexion() {
		return estoyEsperandoRespuestaConexion;
	}


	public void setEstoyEsperandoRespuestaConexion(boolean estoyEsperandoRespuestaConexion) {
		this.estoyEsperandoRespuestaConexion = estoyEsperandoRespuestaConexion;
	}


	public boolean isDeboContinuar() {
		return deboContinuar;
	}


	public void setDeboContinuar(boolean deboContinuar) {
		this.deboContinuar = deboContinuar;
	}
	
	
	
}
