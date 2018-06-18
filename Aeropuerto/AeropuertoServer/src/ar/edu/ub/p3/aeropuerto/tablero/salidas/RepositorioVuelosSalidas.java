package ar.edu.ub.p3.aeropuerto.tablero.salidas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class RepositorioVuelosSalidas implements IRepositorioModelo<Vuelo>{

	
	private EstadoAeropuerto ea;
	public RepositorioVuelosSalidas(EstadoAeropuerto estadoAeropuerto) {
	this.setEa(estadoAeropuerto);
		
	}

	@Override
	public void add(Vuelo dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vuelo dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Vuelo dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vuelo> getList() {

		return new LinkedList<Vuelo>(this.getEa().getVuelosProgramadosYDespegados());
	}

	public EstadoAeropuerto getEa() {
		return ea;
	}

	public void setEa(EstadoAeropuerto ea) {
		this.ea = ea;
	}



}
