import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ar.edu.ub.p3.aeropuerto.servidor.ServidorDePedidosAeropuerto;
import ar.edu.ub.p3.aeropuerto.servidor.ConfiguracionAeropuerto;
import ar.edu.ub.p3.aeropuerto.servidor.EstadoAeropuerto;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("Servidor de Aeropuertos");
		
		ConfiguracionAeropuerto configuracion = new ConfiguracionAeropuerto( args.length > 0 ? args[0] : "aeropuerto.properties");
		EstadoAeropuerto        estadoAeropuerto = new EstadoAeropuerto();
		Thread			        hiloPedidos = new Thread( new ServidorDePedidosAeropuerto( configuracion, estadoAeropuerto ) );
		
		/////////////////////////////////////////////////////////////////////
		// Inicio el servicio de pedidos
		
		hiloPedidos.start();
		
		///////////////////////////////////////////////////////////////////////
		// Me quedo esperando a que me llegue un pedido de la aplicacion de
		// gestion de los recursos del aeropuerto
		
		try (ServerSocket ss = new ServerSocket( configuracion.getPuertoPedidosAeropuertoGestion() ) ){						

			//Lo que llegue por este puerto siempre mata el server
			ss.accept();
			
			System.out.println("Se intenta apagar el servidor de aeropuerto...");
			
			///////////////////////////////////////////////////////////////////////
			// Me llego un pedido de la app de gestion de recursos, mato el server
			
			estadoAeropuerto.setSigueCorriendo( false );
			
			//Envio un pedido para revivir el hilo de atencion de pedidos
			enviarPedidoCierreServer( configuracion );
					
			///////////////////////////////////////////////////////////////////////
			//Espero a que terminen todos los hilos para terminar la app
			
			try {
				
				hiloPedidos.join();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		//Informo que pude apagar
		System.out.println("Se apago el servidor de aeropuerto.");
	}

	private static void enviarPedidoCierreServer(ConfiguracionAeropuerto configuracion) {
		
		// Mando un null en el puerto de pedidos para que cierre la app
		try(Socket s = new Socket( "127.0.0.1", configuracion.getPuertoPedidosAeropuerto() ) ) {
			
			try( ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() ) )
			{
				oos.writeObject( null );	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
