package ar.edu.ub.p3.util.factory;

import java.util.Map;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;

public class AvionFactory extends Fabrica<Avion> {
	private Map<String, Aerolinea> aerolineas;
	private IPosicion posicion;
	public AvionFactory(Map<String, Aerolinea> aerolineas, IPosicion posicion) {
		this.setAerolineas(aerolineas);
		this.setPosicion(posicion);
	}

	@Override
	public Avion crear(String[] campos) {						
		return new Avion(campos[0], this.getAerolineas().get( campos[2] ), this.getPosicion());
	}

	private Map<String, Aerolinea> getAerolineas() {
		return aerolineas;
	}

	private void setAerolineas(Map<String, Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}

	private IPosicion getPosicion() {
		return posicion;
	}

	private void setPosicion(IPosicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String obtenerIdentificador(Avion objeto) {
		return objeto.getIdAvion();
	}

}
