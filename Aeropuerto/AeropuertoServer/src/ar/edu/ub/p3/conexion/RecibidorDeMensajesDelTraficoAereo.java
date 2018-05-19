package ar.edu.ub.p3.conexion;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class RecibidorDeMensajesDelTraficoAereo implements Runnable {

	private EstadoAeropuerto estadoAeropuerto;
	private Socket socket;
	private Map<TipoMensaje,Handler<EstadoAeropuerto>> handlers;
	
	public RecibidorDeMensajesDelTraficoAereo(EstadoAeropuerto estadoAeropuerto, Socket socket) {
		
		setEstadoAeropuerto(estadoAeropuerto);
		setSocket(socket);
		setHandlers(new HashMap<TipoMensaje, Handler<EstadoAeropuerto>>());
		loadHandlers();
		
	}

	private void loadHandlers() {
		
		this.getHandlers().put(TipoMensaje.ALTA_AEROPUERTO_ACK, new HandlerMensajeAltaAeropuertoACK());
		this.getHandlers().put(TipoMensaje.TRAFICO_AEREO_ERROR, new HandlerMensajeTraficoAereoError());
		
	}

	@Override
	public void run() {
		
		try (ObjectInputStream in = new ObjectInputStream(this.getSocket().getInputStream())) {
        	Mensaje mensaje = null;        	
        	
            while ( this.getEstadoAeropuerto().isDeboContinuar() ) {
                try {
                    mensaje = (Mensaje) in.readObject();
                    
                    this.getHandlers().get( mensaje.getTipoMensaje() ).accept( mensaje, this.getEstadoAeropuerto() );
                 
                }
                catch (EOFException e) {
                    break;
                }
            }
        }
        catch (SocketException e) {
            System.out.println("Disconnected");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        catch (IOException e) {
            System.out.println("IOException: " + e);
        }
		
		
		

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

}
