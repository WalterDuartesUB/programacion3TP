package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAerolineas;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea.PanelFichaAerolinea;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea.TableModelAerolinea;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea.VentanaGestionABMAerolinea;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;


 

public class ActionVentanaGestionAerolineas {
		
	
	public static  void generarVentana( EstadoAeropuerto estadoAeropuerto ) {
		
		generarComponentes( new RepositorioAerolineas(estadoAeropuerto) );
		

	}
	
	public static void generarComponentes( RepositorioAerolineas aerolineas ) {
		
		PanelFichaAerolinea ficha = new PanelFichaAerolinea( aerolineas );
		
		PanelLista <Aerolinea> 	lista = new PanelLista <Aerolinea> ( aerolineas );
		
		lista.setTableModel( new TableModelAerolinea( aerolineas ) );				
		
		lista.setPanelFicha(ficha);
		ficha.setPanelLista(lista);
		
		new VentanaGestionABMAerolinea(ficha,lista);

	}
	
		
			
	
}
