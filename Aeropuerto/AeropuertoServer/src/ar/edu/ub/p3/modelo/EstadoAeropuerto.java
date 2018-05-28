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
		 
		String idAeropuerto = configuracion.getConfiguracion("idAeropuerto");
		String nomAeropuerto = configuracion.getConfiguracion("nombreAeropuerto");
		double posX = Double.parseDouble(configuracion.getConfiguracion("posicionAeropuertoX")) ;
		double posY = Double.parseDouble(configuracion.getConfiguracion("posicionAeropuertoY")) ;
		
		Posicion posicion = new Posicion(posX, posY);
		
		this.setAerpuerto(new Aeropuerto(idAeropuerto, nomAeropuerto,posicion));
		this.setAviones(new LinkedList<Avion>());
		
		this.setEstoyConectado(false);
		this.setEstoyEsperandoRespuestaConexion(false);
		this.setDeboContinuar(true);
		
		//Cargo la informacion que maneja el aeropuerto
		this.cargarAeropuertos( configuracion.getConfiguracion("pathAeropuertos") );
		this.cargarAerolineas( configuracion.getConfiguracion("pathAerolineas") );
		this.cargarAviones( configuracion.getConfiguracion("pathAviones") );
		this.cargarVuelos( configuracion.getConfiguracion("pathVuelos") );
		
	}
	
	
	private void cargarVuelos(String pathData) {
		// TODO leer todos los vuelos del archivo vuelos.data
		
	}


	private void cargarAviones(String pathData) {
		// TODO leer todos los aviones del archivo aviones.data
		
	}


	private void cargarAerolineas(String pathData) {
		// TODO leer todas las aerolineas del archivo aerolineas.data
		
	}


	private void cargarAeropuertos(String pathData) {
		// TODO Decidir como conseguir los id y nombre de los otros aeropuertos
		
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
