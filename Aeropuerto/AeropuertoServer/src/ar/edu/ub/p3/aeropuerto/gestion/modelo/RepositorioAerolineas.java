package ar.edu.ub.p3.aeropuerto.gestion.modelo;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;



public class RepositorioAerolineas implements IRepositorioModelo < Aerolinea >{

	private Map <String,Aerolinea> aerolineas;

	public RepositorioAerolineas(EstadoAeropuerto estadoAeropuerto) {
		
		setAerolineas( estadoAeropuerto.getAerolineas() );
		
	}
	


	@Override
	public void add(Aerolinea dato) {
		
		getAerolineas().put(dato.getIdAerolinea(), dato);
		
	}

	@Override
	public void delete(Aerolinea dato) {
		
		getAerolineas().remove(dato.getIdAerolinea());
		
	}

	@Override
	public void modify(Aerolinea dato) {
		
		getAerolineas().put(dato.getIdAerolinea(), dato);
		
	}

	@Override
	public List<Aerolinea> getList() {
		return new LinkedList< Aerolinea >( this.getAerolineas().values() );
	}



	public Map <String,Aerolinea> getAerolineas() {
		return aerolineas;
	}



	public void setAerolineas(Map <String,Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}
}
