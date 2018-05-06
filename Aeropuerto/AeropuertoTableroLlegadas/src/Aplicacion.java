import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import ar.edu.ub.p3.common.aeropuerto.conexion.CodigoComando;
import ar.edu.ub.p3.common.aeropuerto.conexion.Comando;
import ar.edu.ub.p3.common.aeropuerto.modelo.Avion;
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
				
				try( ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() ); )
				{
					
					Comando comando = new Comando( CodigoComando.OBTENER_LISTA_AVIONES );
					
//					comando.getParametros().put("avion", new Avion(null, "patente", "modelo" ) );
					
					//Hago el pedido de la lista de aviones
					oos.writeObject( comando );	
					/*
					ObjectInputStream ois = new ObjectInputStream( s.getInputStream() );
					
					//Espero la lista de aviones
					Avion[] aviones = (Avion[]) ois.readObject();
					
					for( Avion avion : aviones )
						System.out.println( avion.getModelo());
					*/
					
				} /* catch (ClassNotFoundException e) {
					e.printStackTrace();
				}*/
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}

}
