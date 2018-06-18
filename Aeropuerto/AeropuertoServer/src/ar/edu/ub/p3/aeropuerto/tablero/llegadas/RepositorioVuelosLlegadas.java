package ar.edu.ub.p3.aeropuerto.tablero.llegadas;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class RepositorioVuelosLlegadas implements IRepositorioModelo<Vuelo>{

	private Map<String,Vuelo>  vuelosSalida; 
	public RepositorioVuelosLlegadas(EstadoAeropuerto estadoAeropuerto) {
		this.setVuelosSalida( estadoAeropuerto.getVuelosAterrizando());
		
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

		return new LinkedList<Vuelo>(this.getVuelosSalida().values());
	}

	private Map<String,Vuelo> getVuelosSalida() {
		return vuelosSalida;
	}

	private void setVuelosSalida(Map<String,Vuelo> vuelosSalida) {
		this.vuelosSalida = vuelosSalida;
	}



}
