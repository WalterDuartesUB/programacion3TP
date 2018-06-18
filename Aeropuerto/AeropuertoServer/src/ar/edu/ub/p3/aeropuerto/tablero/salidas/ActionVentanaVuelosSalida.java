package ar.edu.ub.p3.aeropuerto.tablero.salidas;


import ar.edu.ub.p3.aeropuerto.tablero.PanelTablero;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class ActionVentanaVuelosSalida {


	public static  void generarVentana(Configuracion configuracion, EstadoAeropuerto estadoAeropuerto ) {
		
		generarComponentes(configuracion, new RepositorioVuelosSalidas(estadoAeropuerto) );
		

	}
	
	
	private static void generarComponentes( Configuracion configuracion,RepositorioVuelosSalidas vuelos){
			
		PanelTablero<Vuelo>		lista = new PanelTablero<Vuelo>(vuelos);
		
		lista.setTableModel( new TableModelVuelosSalida(configuracion, vuelos ) );				

		
		new VentanaVuelosSalida(configuracion,lista);
		
	}

}
