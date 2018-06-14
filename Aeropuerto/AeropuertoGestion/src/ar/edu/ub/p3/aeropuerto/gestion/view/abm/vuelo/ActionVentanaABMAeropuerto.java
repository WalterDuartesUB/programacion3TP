package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.*;

public class ActionVentanaABMAeropuerto {
		
		public static void generarVentana( EstadoAeropuerto estadoAeropuerto ) {
	
			PanelFichaAeropuerto ficha = new PanelFichaAeropuerto( estadoAeropuerto );
			
			PanelLista<Aeropuerto> 	lista = new PanelLista<Aeropuerto>( estadoAeropuerto );
			
			lista.setTableModel( new TableModelAeropuerto( estadoAeropuerto ) );				
			
			lista.setPanelFicha(ficha);
			ficha.setPanelLista(lista);
			
			new VentanaGestionABMAeropuerto(ficha,lista);

		}
	
		
			
	
}
