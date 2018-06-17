package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAeropuertos;
import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAviones;
import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioVuelos;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;


 

public class ActionVentanaGestionVuelos {
		
	
	public static  void generarVentana( EstadoAeropuerto estadoAeropuerto ) {
		
		generarComponentes( 
				new RepositorioVuelos( estadoAeropuerto ) , 
				new RepositorioAeropuertos( estadoAeropuerto ) ,
				new RepositorioAviones( estadoAeropuerto ) 
				);
	}
	
	public static void generarComponentes( RepositorioVuelos vuelos ,RepositorioAeropuertos aeropuertos	,RepositorioAviones aviones ) {
		
		PanelFichaVuelo ficha = new PanelFichaVuelo( vuelos , aeropuertos, aviones );
		PanelLista <Vuelo> 	lista = new PanelLista <Vuelo> ( vuelos );
		
		lista.setTableModel( new TableModelVuelo( vuelos ) );				
		
		lista.setPanelFicha(ficha);
		ficha.setPanelLista(lista);
		
		ficha.getPanelCampos().setAeropuertos(aeropuertos);
		ficha.getPanelCampos().setAviones(aviones);
		
		new VentanaGestionABMVuelo(ficha,lista);

	}
	
		
			
	
}
