package ar.edu.ub.p3.aeropuerto.tablero.llegadas;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAeropuertos;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.PanelFichaAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.TableModelAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.VentanaGestionABMAeropuerto;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class ActionVentanaVuelosLlegadas {


	public static  void generarVentana( EstadoAeropuerto estadoAeropuerto ) {
		
		generarComponentes( new RepositorioVuelosLlegadas(estadoAeropuerto) );
		

	}
	
	
	private static void generarComponentes( RepositorioVuelosLlegadas vuelos){
			
		PanelLista<Vuelo> 	lista = new PanelLista<Vuelo>( vuelos );
		
		lista.setTableModel( new TableModelVuelosLlegadas( vuelos ) );				

		
		new VentanaVuelosLlegadas(lista);
		
	}

}