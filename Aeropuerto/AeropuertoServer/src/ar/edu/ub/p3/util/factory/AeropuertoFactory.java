package ar.edu.ub.p3.util.factory;

import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Posicion;

public class AeropuertoFactory extends Fabrica<Aeropuerto> {

	@Override
	public String obtenerIdentificador(Aeropuerto objeto) {
		return objeto.getIdAeropuerto();
	}

	@Override
	public Aeropuerto crear(String[] campos) {
		return new Aeropuerto(campos[0], campos[1], new Posicion(Double.parseDouble( campos[2] ), Double.parseDouble(campos[3])));
	}

}
