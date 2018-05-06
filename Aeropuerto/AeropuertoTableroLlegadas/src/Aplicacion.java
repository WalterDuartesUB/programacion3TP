import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import ar.edu.ub.p3.aeropuerto.pedido._PedidoAeropuertoImprimirAviones;
import ar.edu.ub.p3.tablero.ConfiguracionTableroLlegadas;

public class Aplicacion {

	public static void main(String[] args) {		
		ConfiguracionTableroLlegadas configuracion = new ConfiguracionTableroLlegadas ( args.length > 0 ? args[0] : "tablero.properties" );

		System.out.println("Presione enter para listar en el servidor de aeropuertos los aviones disponibles.");
		
		try( Scanner in = new Scanner( System.in ) )
		{
			//Espero el enter para matar
			in.nextLine();
			
			//Envio el pedido al server de apagarse
			try(Socket s = new Socket( configuracion.getIpPedidosAeropuerto(), configuracion.getPuertoPedidosAeropuerto() ) ) {
				
				try( ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() ) )
				{
					oos.writeObject( new _PedidoAeropuertoImprimirAviones() );	
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}

}
