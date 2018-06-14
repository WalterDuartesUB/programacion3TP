package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.EstadoAerolinea;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.*;

public class ActionVentanaABMAerolinea {
		
		public static void generarVentana( EstadoAerolinea estadoAeroLinea ) {
	
			PanelFichaAerolinea ficha = new PanelFichaAerolinea( estadoAeroLinea );
			
			PanelLista <Aerolinea> 	lista = new PanelLista <Aerolinea> ( estadoAeroLinea );
			
			lista.setTableModel( new TableModelAerolinea( estadoAeroLinea ) );				
			
			lista.setPanelFicha(ficha);
			ficha.setPanelLista(lista);
			
			new VentanaGestionABMAerolinea(ficha,lista);

		}
	
		
			
	
}
