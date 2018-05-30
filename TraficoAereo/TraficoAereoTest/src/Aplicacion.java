import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.conexion.TipoMensaje;
import ar.edu.ub.p3.conexion.handler.Handler;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeAltaAeropuerto;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeBajaAeropuerto;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.util.Configuracion;

public class Aplicacion {

	public static void main(String[] args) {
		System.out.println("Servidor de prueba del trafico aereo: Vivo");
				
		Configuracion configuracion = new Configuracion(args[0]);
		Map<TipoMensaje, Handler> handlers = new HashMap<TipoMensaje, Handler>();
		EstadoTraficoAereo 		  estadoTA = new EstadoTraficoAereo();
		
		///////////////////////////////////////////////////////////////////////
		// Inicializo la lista de handlers
		
		handlers.put(TipoMensaje.ALTA_AEROPUERTO, new HandlerMensajeAltaAeropuerto( estadoTA ) );
		handlers.put(TipoMensaje.BAJA_AEROPUERTO, new HandlerMensajeBajaAeropuerto( estadoTA ) );
		
		///////////////////////////////////////////////////////////////////////
		// Inicio el servidor
		
		try( ServerSocket ss = new ServerSocket( configuracion.getConfiguracionAsInt( "puertoTraficoAereo" ) ) ) {			

			///////////////////////////////////////////////////////////////////////
			//Espero una conexion
			
			Socket s = ss.accept();
			
			try( ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() );
				ObjectInputStream ois = new ObjectInputStream( s.getInputStream() );){
			
				///////////////////////////////////////////////////////////////////////
				//Lo atiendo esta unica conexion hasta que se desconecte
				
				while( estadoTA.isDeboContinuar() )
				{					
					Mensaje m = ( Mensaje ) ois.readObject();
					
					System.out.println( m.getTipoMensaje() );
					
					handlers.get( m.getTipoMensaje() ).accept( m, oos);
				}		
				
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {		
			e.printStackTrace();
		}

				
		System.out.println("Servidor de prueba del trafico aereo: Muerto");
		configuracion.close();
	}

}
