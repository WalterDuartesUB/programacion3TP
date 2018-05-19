import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class Main {

	public static void main(String[] args) {
		Posicion posicion = new Posicion(5,5);
		IPosicion posi = posicion;
		IAeropuerto aeropuerto1 = new Aeropuerto("1", posi);
		IAeropuerto aeropuerto2 = new Aeropuerto("2", posi);
		IAvion avion = new Avion("avion1", aeropuerto1.getPosicion());
		IVuelo vuelo = new Vuelo("vuelo1", avion, aeropuerto1, aeropuerto2);
		System.out.println("pito");
		System.out.println(vuelo);
		System.out.println(avion);
		System.out.println(aeropuerto1);
		System.out.println(posi);
		
		
	}

}
