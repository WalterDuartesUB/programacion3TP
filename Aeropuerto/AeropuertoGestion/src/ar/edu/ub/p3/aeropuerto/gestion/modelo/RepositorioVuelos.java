package ar.edu.ub.p3.aeropuerto.gestion.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;



public class RepositorioVuelos implements IRepositorioModelo < Vuelo >{

	private Map <String,Vuelo> aeropuertos;

	public RepositorioVuelos( EstadoAeropuerto estadoAeropuerto ) {
		
		setAeropuertos( estadoAeropuerto.getVuelos() );
		
	}
	
	public Map < String , Vuelo > getAeropuertos() {
		return aeropuertos;
	}

	private void setAeropuertos(Map < String , Vuelo > aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	@Override
	public void add(Vuelo dato) {
		
		getAeropuertos().put(dato.getIdVuelo(), dato);
		
	}

	@Override
	public void delete(Vuelo dato) {
		
		getAeropuertos().remove(dato.getIdVuelo());
		
	}

	@Override
	public void modify(Vuelo dato) {
		
		getAeropuertos().put(dato.getIdVuelo(), dato);
		
	}

	@Override
	public List<Vuelo> getList() {
		return new LinkedList< Vuelo >( this.getAeropuertos().values() );
	}
}
