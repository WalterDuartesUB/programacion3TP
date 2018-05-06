import ar.edu.ub.p3.common.aeropuerto.modelo.Aeropuerto;
import ar.edu.ub.p3.common.aeropuerto.modelo.Avion;
import ar.edu.ub.p3.common.aeropuerto.modelo.Posicion;
import ar.edu.ub.p3.common.aeropuerto.modelo.Vuelo;
import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazAeropuerto;
import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazAvion;
import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazVuelo;

public class Main {

	public static void main(String[] args) {
		Posicion posicion = new Posicion(1,1);
		Aeropuerto aeropuerto = new Aeropuerto("aep","Aeroparque",posicion);
		InterfazAeropuerto interfaz = aeropuerto;
		interfaz.getPosicion().getX();
		
		Avion avion = new Avion(posicion,"patnete","modlelo");
		InterfazAvion interfazAvion = avion;
		interfazAvion.getPosicion().setX(5);
		
		Vuelo vuelo = new Vuelo(aeropuerto, aeropuerto, avion, "numerovuelo", 50, null, null, null);
		InterfazVuelo interfazVuelo = vuelo;
		interfazVuelo.getAvion().getPosicion().setX(9);

	}

}
