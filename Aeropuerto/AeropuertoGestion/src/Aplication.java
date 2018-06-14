

import ar.edu.ub.p3.aeropuerto.gestion.modelo.EstadoAerolinea;
import ar.edu.ub.p3.aeropuerto.gestion.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea.ActionVentanaABMAerolinea;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.ActionVentanaABMAeropuerto;

public class Aplication {

	public static void main(String[] args) {
		
		ActionVentanaABMAeropuerto.generarVentana( new EstadoAeropuerto() );
		ActionVentanaABMAerolinea.generarVentana( new EstadoAerolinea() );
		//ActionVentanaABMAvion.generarVentana( new EstadoAeropuerto() );
		//ActionVentanaABMVuelo.generarVentana( new EstadoAeropuerto() );
	}

}
