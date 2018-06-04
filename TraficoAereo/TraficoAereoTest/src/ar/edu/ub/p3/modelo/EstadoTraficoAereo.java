package ar.edu.ub.p3.modelo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAeropuerto;

public class EstadoTraficoAereo {
	private boolean          deboContinuar;
	private Map<String,ConexionAeropuerto> aeropuertos;
	private Map<String,Vuelo>      vuelos;
	
	public EstadoTraficoAereo() {
		this.setDeboContinuar(true);
		this.setAeropuertos( new HashMap<String,ConexionAeropuerto>());
		this.setVuelos( new HashMap<String,Vuelo>());
	}

	public Map<String,Vuelo> getVuelos() {
		return vuelos;
	}

	private void setVuelos(Map<String,Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Map<String,ConexionAeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	private void setAeropuertos(Map<String,ConexionAeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public boolean isDeboContinuar() {
		return deboContinuar;
	}

	public void setDeboContinuar(boolean deboContinuar) {
		this.deboContinuar = deboContinuar;
	}

	public void addAeropuerto(ConexionAeropuerto aeropuerto) {
		this.getAeropuertos().put( aeropuerto.getIdAeropuerto(), aeropuerto);		
	}

	public List<IAeropuerto> getIAeropuertos() {
		List<IAeropuerto> iaeropuertos = new LinkedList<IAeropuerto>();
		
		for( ConexionAeropuerto aeropuerto : this.getAeropuertos().values() )
			iaeropuertos.add( aeropuerto.getAeropuerto() );
		
		return iaeropuertos;
	}

	public void quitarAeropuerto(String idAeropuerto) {
		this.getAeropuertos().remove( idAeropuerto );
		
	}

	public void addVuelo(Vuelo vuelo) {
		this.getVuelos().put(vuelo.getIdVuelo(), vuelo);		
	}

	public Vuelo getVuelo(String idVuelo) {
		return this.getVuelos().get( idVuelo);
	}

	public void moverAvion(String idVuelo, Posicion posicion) {
		Vuelo vuelo = this.getVuelo(idVuelo);
		
		synchronized (vuelo) {
			vuelo.setPosicion( new Posicion( vuelo.getPosicion().sumar( posicion ) ) );
		}
	}

	public ConexionAeropuerto getConexionAeropuerto(String idAeropuerto) {
		return this.getAeropuertos().get(idAeropuerto);		
	}
}
