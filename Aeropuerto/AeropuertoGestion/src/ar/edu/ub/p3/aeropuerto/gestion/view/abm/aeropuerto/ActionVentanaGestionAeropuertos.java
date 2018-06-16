package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto;


import ar.edu.ub.p3.aeropuerto.gestion.modelo.RepositorioAeropuertos;
import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
 

public class ActionVentanaGestionAeropuertos {

		public static  void generarVentana( EstadoAeropuerto estadoAeropuerto ) {
			
			generarComponentes( new RepositorioAeropuertos(estadoAeropuerto) );
			

		}
		
		
		private static void generarComponentes( RepositorioAeropuertos aeropuertos){
			
			PanelFichaAeropuerto ficha = new PanelFichaAeropuerto( aeropuertos );
			
			PanelLista<Aeropuerto> 	lista = new PanelLista<Aeropuerto>( aeropuertos );
			
			lista.setTableModel( new TableModelAeropuerto( aeropuertos ) );				
			
			lista.setPanelFicha(ficha);
			ficha.setPanelLista(lista);
			
			new VentanaGestionABMAeropuerto(ficha,lista);
			
		}
	
		
			
	
}
