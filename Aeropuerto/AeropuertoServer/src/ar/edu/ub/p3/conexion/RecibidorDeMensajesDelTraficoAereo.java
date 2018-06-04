package ar.edu.ub.p3.conexion;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.p3.conexion.handler.Handler;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeAltaAeropuertoACK;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeBajaAeropuertoACK;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeInformacionVuelo;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeListadoAeropuertosDisponibles;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeTraficoAereoError;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeVueloAterrizoEnDestino;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeVueloProgramado;
import ar.edu.ub.p3.conexion.handler.HandlerMensajeVueloProximoAterrizar;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class RecibidorDeMensajesDelTraficoAereo implements Runnable {

	private EstadoAeropuerto estadoAeropuerto;
	private Socket socket;
	private Map<TipoMensaje,Handler<EstadoAeropuerto>> handlers;	
	private IConexionTraficoAereo conexionTraficoAereo;
	
	public RecibidorDeMensajesDelTraficoAereo(EstadoAeropuerto estadoAeropuerto, Socket socket, IConexionTraficoAereo conexionTraficoAereo) {
		
		this.setEstadoAeropuerto(estadoAeropuerto);
		this.setSocket(socket);
		this.setConexionTraficoAereo(conexionTraficoAereo);
		this.setHandlers(new HashMap<TipoMensaje, Handler<EstadoAeropuerto>>());
		this.loadHandlers();
	}

	private void loadHandlers() {
		//Mensajes de conectividad
		this.getHandlers().put(TipoMensaje.ALTA_AEROPUERTO_ACK, new HandlerMensajeAltaAeropuertoACK());
		this.getHandlers().put(TipoMensaje.TRAFICO_AEREO_ERROR, new HandlerMensajeTraficoAereoError());
		this.getHandlers().put(TipoMensaje.LISTADO_AEROPUERTOS_DISPONIBLES, new HandlerMensajeListadoAeropuertosDisponibles());
		this.getHandlers().put(TipoMensaje.BAJA_AEROPUERTO_ACK, new HandlerMensajeBajaAeropuertoACK());
		
		//Mensajes de Vuelo
		this.getHandlers().put(TipoMensaje.VUELO_PROGRAMADO, new HandlerMensajeVueloProgramado() );
		this.getHandlers().put(TipoMensaje.VUELO_PROXIMO_A_ATERRIZAR, new HandlerMensajeVueloProximoAterrizar() );
		this.getHandlers().put(TipoMensaje.VUELO_ATERRIZO_EN_DESTINO, new HandlerMensajeVueloAterrizoEnDestino() );
		this.getHandlers().put(TipoMensaje.INFORMACION_VUELO, new HandlerMensajeInformacionVuelo() );
		
	}

	@Override
	public void run() {	
		System.out.println("Empezo el thread de mensajes del TA");
		
		try(ObjectInputStream in = new ObjectInputStream(this.getSocket().getInputStream()); )  {			
        	Mensaje mensaje = null;        	
        	
            while ( this.getEstadoAeropuerto().isDeboContinuar() ) {
                try {
                    mensaje = (Mensaje) in.readObject();
                    System.out.println("Recibi un mensaje: " + mensaje.getTipoMensaje() );
                    this.getHandlers().get( mensaje.getTipoMensaje() ).accept( mensaje, this.getConexionTraficoAereo(), this.getEstadoAeropuerto() );
                 
                }
                catch (EOFException e) {
                	e.printStackTrace();
                    break;
                }
            }

        }
        catch (SocketException e) {
        	e.printStackTrace();
            System.out.println("Disconnected");
        }
        catch (ClassNotFoundException e) {
        	e.printStackTrace();
            System.out.println("Class not found " + e);
        }
        catch (IOException e) {
        	e.printStackTrace();
            System.out.println("IOException: " + e);
        }

		System.out.println("Termino el thread de mensajes del TA");
	}

	private EstadoAeropuerto getEstadoAeropuerto() {
		return estadoAeropuerto;
	}

	private void setEstadoAeropuerto(EstadoAeropuerto estadoAeropuerto) {
		this.estadoAeropuerto = estadoAeropuerto;
	}

	private Socket getSocket() {
		return socket;
	}

	private void setSocket(Socket socket) {
		this.socket = socket;
	}

	private Map<TipoMensaje,Handler<EstadoAeropuerto>> getHandlers() {
		return handlers;
	}

	private void setHandlers(Map<TipoMensaje,Handler<EstadoAeropuerto>> handlers) {
		this.handlers = handlers;
	}

	private IConexionTraficoAereo getConexionTraficoAereo() {
		return conexionTraficoAereo;
	}

	private void setConexionTraficoAereo(IConexionTraficoAereo conexionTraficoAereo) {
		this.conexionTraficoAereo = conexionTraficoAereo;
	}

}
