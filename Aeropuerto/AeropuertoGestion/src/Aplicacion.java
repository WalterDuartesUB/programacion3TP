import ar.edu.ub.p3.aeropuerto.gestor.conexion.*;
import ar.edu.ub.p3.aeropuerto.gestor.configuracion.Configuracion;
import ar.edu.ub.p3.aeropuerto.gestor.interfazgrafica.InterfazGrafica;
import ar.edu.ub.p3.aeropuerto.gestor.menu.consola.Menu;
import ar.edu.ub.p3.interfaz.IAvion;

public class Aplicacion {
 
	//JUST - STRING IT - 
	public static void main(String[] args) {
		
		ConexionAeropuerto conexion = new ConexionAeropuertoSimulada(new Configuracion("appgestion.properties"));
		
		InterfazGrafica iGrafica = new InterfazGrafica(conexion);
		
		
		
		
		//Menu menu = new Menu();
		
		
		
		//for(IAvion avion : conexion.getAviones())
			//System.out.println(avion.toString());
		
		//menu.menuPrincipal(conexion);
		
		//for(IAvion avion : conexion.getAviones())
			//System.out.println(avion.toString());
		
		
		
		
		//CREAR LA CARGA FANTASMA DE DATOS - ARCHIVO CON CARGA 
		//CREAR EL MENU PARA OPCIONES ABM
		//CREAR EL METODO PARA MODIFICAR EL AVION
		//CREAR EL METODO PARA ELIMINAR EL AVION
		//CREAR EL METODO PARA AGREAGAR UN AVION
		//APLICAR WINDOWS BUILDER PARA VISUALIZAR LA APP
		
		
		
		
		//CONECTAR Y DESCONECTAR QUEDA PARA LO ULTIMO
		
		//esto es codigo viejo no se si sirve aun, por las dudis lo dejo aca ----------------no tocar-------stringforlife---------------
		
		/*
		ConfiguracionAppGestion configuracion = new ConfiguracionAppGestion ( args.length > 0 ? args[0] : "appgestion.properties" );
		
		System.out.println("Presione enter para apagar el servidor de aeropuertos.");
		
		try( Scanner in = new Scanner( System.in ) )
		{
			//Espero el enter para matar
			in.nextLine();
			
			//Envio el pedido al server de apagarse
			try(Socket s = new Socket( configuracion.getIpGestionAeropuerto(), configuracion.getPuertoGestionAeropuerto() ) ) {
				
				try( ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() ) )
				{
					oos.writeObject( null );	
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		*/
	}

}
