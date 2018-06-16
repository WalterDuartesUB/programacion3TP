package ar.edu.ub.p3.aeropuerto.gestion.modelo;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;



public class RepositorioAeropuertos implements IRepositorioModelo < Aeropuerto >{

	private Map <String,Aeropuerto> aeropuertos;

	public RepositorioAeropuertos( EstadoAeropuerto estadoAeropuerto) {
		
		setAeropuertos( estadoAeropuerto.getAeropuertos() );
		
	}
	
	public Map < String , Aeropuerto > getAeropuertos() {
		return aeropuertos;
	}

	private void setAeropuertos(Map < String , Aeropuerto > aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	@Override
	public void add(Aeropuerto dato) {
		
		getAeropuertos().put(dato.getIdAeropuerto(), dato);
		
	}

	@Override
	public void delete(Aeropuerto dato) {
		
		getAeropuertos().remove(dato.getIdAeropuerto());
		
	}

	@Override
	public void modify(Aeropuerto dato) {
		
		getAeropuertos().put(dato.getIdAeropuerto(), dato);
		
	}

	@Override
	public List<Aeropuerto> getList() {
		return new LinkedList< Aeropuerto >( this.getAeropuertos().values() );
	}
}
