package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;

import java.util.Map;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAviones;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;


public class ActionVentanaGestionAviones {
		
	
	public static  void generarVentana( EstadoAeropuerto estadoAeropuerto) {
		
		generarComponentes(new RepositorioAviones(estadoAeropuerto),estadoAeropuerto.getAerolineas());
		
	}	
	
	
	
	private static void generarComponentes( RepositorioAviones aviones, Map<String,Aerolinea> aerolineas ) {
		
		PanelFichaAvion ficha = new PanelFichaAvion( aviones , aerolineas);
		
		PanelLista <Avion> 	lista = new PanelLista <Avion> ( aviones );
		
		lista.setTableModel( new TableModelAvion( aviones ) );				
		
		lista.setPanelFicha(ficha);
		ficha.setPanelLista(lista);
		new VentanaGestionABMAvion(ficha,lista);
		
		
	}
	
}
