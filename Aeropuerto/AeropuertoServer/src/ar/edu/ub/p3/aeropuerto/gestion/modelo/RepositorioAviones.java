package ar.edu.ub.p3.aeropuerto.gestion.modelo;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Posicion;



public class RepositorioAviones implements IRepositorioModelo < Avion >{

	private Map <String,Avion> aviones;
	private IPosicion posicionAeropuerto;
	
	public RepositorioAviones(EstadoAeropuerto estadoAeropuerto) {
		
		setAviones( estadoAeropuerto.getAviones() );
		setPosicionAeropuerto(estadoAeropuerto.getAerpuerto().getPosicion());
	}
	
	public Map < String , Avion > getAviones() {
		return aviones;
	}

	private void setAviones(Map < String , Avion > aeropuertos) {
		this.aviones = aeropuertos;
	}

	@Override
	public void add(Avion dato) {
		
		dato.setPosicion(new Posicion( getPosicionAeropuerto() ));
		getAviones().put(dato.getIdAvion(), dato);
		
	}

	@Override
	public void delete(Avion dato) {
		
		getAviones().remove(dato.getIdAvion());
		
	}

	@Override
	public void modify(Avion dato) {
		
		getAviones().put(dato.getIdAvion(), dato);
		
	}

	@Override
	public List<Avion> getList() {
		return new LinkedList< Avion >( this.getAviones().values() );
	}

	public IPosicion getPosicionAeropuerto() {
		return posicionAeropuerto;
	}

	public void setPosicionAeropuerto(IPosicion posicionAeropuerto) {
		this.posicionAeropuerto = posicionAeropuerto;
	}


}
