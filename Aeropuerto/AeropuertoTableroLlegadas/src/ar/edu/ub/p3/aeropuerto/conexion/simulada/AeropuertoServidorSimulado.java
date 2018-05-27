package ar.edu.ub.p3.aeropuerto.conexion.simulada;

import java.util.Date;
import java.util.LinkedList;


import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class AeropuertoServidorSimulado {
	
	private LinkedList<IVuelo> vuelosPrueba;
	
	
	public AeropuertoServidorSimulado() {
		setVuelosPrueba(new LinkedList<IVuelo>());
		generarVuelos();
	}
	
	public void generarVuelos() {
		
		@SuppressWarnings("deprecation")
		Date hora1 = new Date(2018, 05, 27, 11, 30);
		@SuppressWarnings("deprecation")
		Date hora2 = new Date(2018, 05, 27, 12, 30);
		@SuppressWarnings("deprecation")
		Date hora3 = new Date(2018, 05, 27, 13, 30);
		
		Aeropuerto aeropuerto1 = new Aeropuerto("AEP", "Aeroparque", new Posicion (11,11));
		Aeropuerto aeropuerto2 = new Aeropuerto("SLA", "Salta", new Posicion (66,66));
		
		Avion avion1 = new Avion("LV-FUX", new Aerolinea("LA","LATAM"), new Posicion(21,21));
		Avion avion2 = new Avion("LV-GVC", new Aerolinea("AR","AEROLINEAS ARGENTINAS"), new Posicion (22,22));
		Avion avion3 = new Avion("LV-GWL", new Aerolinea("OY","ANDES"), new Posicion(33,33));
		
		Vuelo vuelo1 = new Vuelo("AR1406", avion1, aeropuerto1, aeropuerto2, hora1);
		Vuelo vuelo2 = new Vuelo("LA1574", avion2, aeropuerto1, aeropuerto2, hora2);
		Vuelo vuelo3 = new Vuelo("OY1421", avion3, aeropuerto1, aeropuerto2, hora3);
		
		getVuelosPrueba().add(vuelo1);
		getVuelosPrueba().add(vuelo2);
		getVuelosPrueba().add(vuelo3);

	}




	public LinkedList<IVuelo> getVuelosPrueba() {
		return vuelosPrueba;
	}




	public void setVuelosPrueba(LinkedList<IVuelo> vuelosPrueba) {
		this.vuelosPrueba = vuelosPrueba;
	}
	

}
