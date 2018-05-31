package ar.edu.ub.p3.modelo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class EstadoTraficoAereo {
	private boolean          deboContinuar;
	private Map<String,Aeropuerto> aeropuertos;
	private Map<String,Vuelo>      vuelos;
	
	public EstadoTraficoAereo() {
		this.setDeboContinuar(true);
		this.setAeropuertos( new HashMap<String,Aeropuerto>());
		this.setVuelos( new HashMap<String,Vuelo>());
	}

	public Map<String,Vuelo> getVuelos() {
		return vuelos;
	}

	private void setVuelos(Map<String,Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Map<String,Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	private void setAeropuertos(Map<String,Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public boolean isDeboContinuar() {
		return deboContinuar;
	}

	public void setDeboContinuar(boolean deboContinuar) {
		this.deboContinuar = deboContinuar;
	}

	public void addAeropuerto(Aeropuerto aeropuerto) {
		this.getAeropuertos().put( aeropuerto.getIdAeropuerto(), aeropuerto);		
	}

	public List<IAeropuerto> getIAeropuertos() {
		List<IAeropuerto> iaeropuertos = new LinkedList<IAeropuerto>();
		
		for( Aeropuerto aeropuerto : this.getAeropuertos().values() )
			iaeropuertos.add( aeropuerto );
		
		return iaeropuertos;
	}

	public void quitarAeropuerto(String idAeropuerto) {
		this.getAeropuertos().remove( idAeropuerto );
		
	}

	public void addVuelo(Vuelo vuelo) {
		this.getVuelos().put(vuelo.getIdVuelo(), vuelo);		
	}

	public IVuelo getVuelo(String idVuelo) {
		return this.getVuelos().get( idVuelo);
	}
}
