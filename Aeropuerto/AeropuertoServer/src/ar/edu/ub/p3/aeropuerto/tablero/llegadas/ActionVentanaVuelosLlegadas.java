package ar.edu.ub.p3.aeropuerto.tablero.llegadas;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAeropuertos;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.PanelFichaAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.TableModelAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.VentanaGestionABMAeropuerto;
import ar.edu.ub.p3.aeropuerto.tablero.PanelTablero;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class ActionVentanaVuelosLlegadas {


	public static  void generarVentana( Configuracion configuracion, EstadoAeropuerto estadoAeropuerto ) {
		
		generarComponentes(configuracion, new RepositorioVuelosLlegadas(estadoAeropuerto) );
		

	}
	
	
	private static void generarComponentes( Configuracion configuracion,RepositorioVuelosLlegadas vuelos){
			
		PanelTablero<Vuelo> 	lista = new PanelTablero<Vuelo>( vuelos );
		
		lista.setTableModel(new TableModelVuelosLlegadas(configuracion, vuelos ) );				

		
		new VentanaVuelosLlegadas(lista);
		
	}

}
