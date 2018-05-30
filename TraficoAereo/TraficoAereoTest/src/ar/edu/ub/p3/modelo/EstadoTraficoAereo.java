package ar.edu.ub.p3.modelo;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class EstadoTraficoAereo {
	private boolean          deboContinuar;
	private List<Aeropuerto> aeropuertos;
	private List<Vuelo>      vuelos;
	
	public EstadoTraficoAereo() {
		this.setDeboContinuar(true);
		this.setAeropuertos( new LinkedList<Aeropuerto>());
		this.setVuelos( new LinkedList<Vuelo>());
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	private void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public List<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	private void setAeropuertos(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public boolean isDeboContinuar() {
		return deboContinuar;
	}

	public void setDeboContinuar(boolean deboContinuar) {
		this.deboContinuar = deboContinuar;
	}

	public void addAeropuerto(Aeropuerto aeropuerto) {
		this.getAeropuertos().add(aeropuerto);		
	}

	public List<IAeropuerto> getIAeropuertos() {
		List<IAeropuerto> iaeropuertos = new LinkedList<IAeropuerto>();
		
		for( Aeropuerto aeropuerto : this.getAeropuertos() )
			iaeropuertos.add( aeropuerto );
		
		return iaeropuertos;
	}

	public void quitarAeropuerto(String idAeropuerto) {
		// TODO buscar y quitar el aeropuerto de la coleccion
		
	}
}
