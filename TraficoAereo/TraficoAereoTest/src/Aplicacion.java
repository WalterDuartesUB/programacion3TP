import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.TipoMensaje;
import ar.edu.ub.p3.conexion.handler.Handler;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeAltaAeropuerto;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeBajaAeropuerto;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeObtenerInformacionVuelo;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeObtenerListadoAeropuertosDisponibles;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeVueloAterrizoEnDestino;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeVueloProgramado;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.util.Configuracion;

public class Aplicacion {

	public static void main(String[] args) {
		System.out.println("Servidor de prueba del trafico aereo: Vivo");
				
		Configuracion configuracion = new Configuracion(args[0]);
		Map<TipoMensaje, Handler> handlers = new HashMap<TipoMensaje, Handler>();
		EstadoTraficoAereo 		  estadoTA = new EstadoTraficoAereo();
		
		boolean 				  deboContinuar = true;
		
		///////////////////////////////////////////////////////////////////////
		// Inicializo la lista de handlers
		
		handlers.put(TipoMensaje.ALTA_AEROPUERTO, new HandlerMensajeAltaAeropuerto( estadoTA ) );
		handlers.put(TipoMensaje.BAJA_AEROPUERTO, new HandlerMensajeBajaAeropuerto( estadoTA ) );
		handlers.put(TipoMensaje.OBTENER_LISTADO_AEROPUERTOS_DISPONIBLES, new HandlerMensajeObtenerListadoAeropuertosDisponibles( estadoTA ) );
		handlers.put(TipoMensaje.VUELO_PROGRAMADO, new HandlerMensajeVueloProgramado( estadoTA ) );
		handlers.put(TipoMensaje.OBTENER_INFORMACION_VUELO, new HandlerMensajeObtenerInformacionVuelo( estadoTA ) );
		
		///////////////////////////////////////////////////////////////////////
		// Inicio el servidor
	
		try( ServerSocket ss = new ServerSocket( configuracion.getConfiguracionAsInt( "puertoTraficoAereo" ) ) ) {			

			while( deboContinuar  ) {				
				///////////////////////////////////////////////////////////////////////
				// creo un hilo cuando entre la conexion
				
				new Thread( new AtendedorDePedidosDeAeropuerto( ss.accept(), handlers ) ).start();

			}
			
		} catch (IOException e) {		
			e.printStackTrace();
		}

		System.out.println("Servidor de prueba del trafico aereo: Muerto");
		configuracion.close();
	}

}
