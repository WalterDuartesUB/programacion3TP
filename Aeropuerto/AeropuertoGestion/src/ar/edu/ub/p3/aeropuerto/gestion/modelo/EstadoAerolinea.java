package ar.edu.ub.p3.aeropuerto.gestion.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.modelo.*;


public class EstadoAerolinea implements IRepositorioModelo < Aerolinea >{

	private Map <String,Aerolinea> aeropuertos;

	public EstadoAerolinea() {
		
		setAeropuertos( new HashMap< String , Aerolinea >() );
		
	}
	
	public Map < String , Aerolinea > getAeropuertos() {
		return aeropuertos;
	}

	private void setAeropuertos(Map < String , Aerolinea > aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	@Override
	public void add(Aerolinea dato) {
		
		getAeropuertos().put(dato.getIdAerolinea(), dato);
		
	}

	@Override
	public void delete(Aerolinea dato) {
		
		getAeropuertos().remove(dato.getIdAerolinea());
		
	}

	@Override
	public void modify(Aerolinea dato) {
		
		getAeropuertos().put(dato.getIdAerolinea(), dato);
		
	}

	@Override
	public List<Aerolinea> getList() {
		return new LinkedList< Aerolinea >( this.getAeropuertos().values() );
	}
}
