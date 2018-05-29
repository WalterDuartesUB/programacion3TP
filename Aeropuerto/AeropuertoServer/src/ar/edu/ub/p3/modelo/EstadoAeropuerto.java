package ar.edu.ub.p3.modelo;

import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.p3.util.CargadorData;
import ar.edu.ub.p3.util.Configuracion;
import ar.edu.ub.p3.util.factory.AerolineaFactory;
import ar.edu.ub.p3.util.factory.AeropuertoFactory;
import ar.edu.ub.p3.util.factory.AvionFactory;
import ar.edu.ub.p3.util.factory.VueloFactory;

public class EstadoAeropuerto {

	private Aeropuerto aerpuerto;
	private Map<String, Avion> aviones;
	private Map<String, Aerolinea> aerolineas;
	private Map<String, Vuelo> vuelos;
	private Map<String, Aeropuerto> aeropuertos;
	
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
		this.setAviones(new HashMap<String, Avion>());
		
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
		this.setVuelos( CargadorData.cargarMapaDesdeArchivo(pathData, new VueloFactory(this.getAviones(), this.getAeropuertos())));
		
		System.out.println("Vuelos: ");
		System.out.println( this.getVuelos() );
	}


	private void cargarAviones(String pathData) {
		this.setAviones( CargadorData.cargarMapaDesdeArchivo(pathData, new AvionFactory( this.getAerolineas(), this.getAerpuerto().getPosicion() ) ) );
		
		System.out.println("Aviones: ");
		System.out.println( this.getAviones() );		
	}


	private void cargarAerolineas(String pathData) {
		this.setAerolineas( CargadorData.cargarMapaDesdeArchivo(pathData, new AerolineaFactory() ) );
		
		System.out.println("Aerolineas: ");
		System.out.println( this.getAerolineas() );
	}
	
	private void cargarAeropuertos(String pathData) {
		// TODO Decidir como conseguir los id y nombre de los otros aeropuertos
		this.setAeropuertos( CargadorData.cargarMapaDesdeArchivo(pathData, new AeropuertoFactory() ) );
		
		System.out.println("Aeropuertos: ");
		System.out.println();		
	}


	public Aeropuerto getAerpuerto() {
		return aerpuerto;
	}

	private void setAerpuerto(Aeropuerto aerpuerto) {
		this.aerpuerto = aerpuerto;
	}

	public Map<String, Avion> getAviones() {
		return aviones;
	}

	private void setAviones(Map<String, Avion> aviones) {
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


	public Map<String, Aerolinea> getAerolineas() {
		return aerolineas;
	}


	private void setAerolineas(Map<String, Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}


	public Map<String, Vuelo> getVuelos() {
		return vuelos;
	}


	private void setVuelos(Map<String, Vuelo> vuelos) {
		this.vuelos = vuelos;
	}


	public Map<String, Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}


	private void setAeropuertos(Map<String, Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}
	
	
	
}
