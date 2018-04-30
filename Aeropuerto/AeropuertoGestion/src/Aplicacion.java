import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import ar.edu.ub.p3.gestion.ConfiguracionAppGestion;

public class Aplicacion {

	public static void main(String[] args) {
		
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

	}

}
