package ar.edu.ub.p3.util.factory;

import ar.edu.ub.p3.modelo.Aerolinea;

public class AerolineaFactory extends Fabrica<Aerolinea> {

	@Override
	public Aerolinea crear(String[] campos) {
		return new Aerolinea( campos[0], campos[1]);
	}

	@Override
	public String obtenerIdentificador(Aerolinea objeto) {
		return objeto.getIdAerolinea();
	}


}
