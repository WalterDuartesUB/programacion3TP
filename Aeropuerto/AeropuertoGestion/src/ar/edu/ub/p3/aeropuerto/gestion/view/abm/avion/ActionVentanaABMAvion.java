package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.*;

public class ActionVentanaABMAvion {
		
		public static void generarVentana( EstadoAeropuerto estadoAeropuerto ) {
	
			PanelFichaAvion ficha = new PanelFichaAvion( estadoAeropuerto );
			
			PanelLista<Aeropuerto> 	lista = new PanelLista<Aeropuerto>( estadoAeropuerto );
			
			lista.setTableModel( new TableModelAvion( estadoAeropuerto ) );				
			
			lista.setPanelFicha(ficha);
			ficha.setPanelLista(lista);
			
			new VentanaGestionABMAvion(ficha,lista);

		}
	
		
			
	
}
