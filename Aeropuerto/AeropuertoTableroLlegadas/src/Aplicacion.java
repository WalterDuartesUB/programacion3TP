

import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuertoSimulada;
import ar.edu.ub.p3.aeropuerto.tablero.configuracion.Configuracion;
import ar.edu.ub.p3.aeropuerto.tablero.interfazgrafica.InterfazGrafica;
import ar.edu.ub.p3.interfaz.IVuelo;


public class Aplicacion {

	public static void main(String[] args) {		
		ConexionAeropuerto conexion = new ConexionAeropuertoSimulada(new Configuracion("tablero.properties"));
		
		
	//	Menu menu = new Menu();
		
		InterfazGrafica iGrafica = new InterfazGrafica(conexion);
		

		
		//for(IVuelo vuelo : conexion.getVuelos())
		//	System.out.println(vuelo.toString());
		
	
		for(IVuelo vuelo : conexion.getVuelos()) {
			System.out.println("---------------------------");
			System.out.println("Numero Vuelo: " + vuelo.getIdVuelo().toString());
			System.out.println("Aerolinea: " + vuelo.getAvion().getAerolinea().toString());
			System.out.println("Destino : " + vuelo.getAeropuertoDestino().toString());
			System.out.println("Origen: " + vuelo.getAeropuertoOrigen().toString());
			System.out.println("Hora salida : " + vuelo.getHorarioProgramado());
		}
			

		

	}
}
