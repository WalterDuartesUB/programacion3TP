package ar.edu.ub.p3.conexion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.conexion.TipoMensaje;
import ar.edu.ub.p3.conexion.handler.Handler;

public class AtendedorDePedidosDeAeropuerto implements Runnable {

	private Socket socket;
	private Map<TipoMensaje, Handler> handlers;
	private boolean deboContinuar;
	
	public AtendedorDePedidosDeAeropuerto(Socket socket, Map<TipoMensaje, Handler> handlers) {
		this.setSocket(socket);
		this.setHandlers(handlers);
		this.setDeboContinuar(true);
	}

	@Override
	public void run() {
		try( ObjectOutputStream oos = new ObjectOutputStream( this.getSocket().getOutputStream() );
				ObjectInputStream ois = new ObjectInputStream( this.getSocket().getInputStream() );){
			
			///////////////////////////////////////////////////////////////////////
			//Lo atiendo esta unica conexion hasta que se desconecte
			
			while( this.isDeboContinuar() )
			{					
				Mensaje m = ( Mensaje ) ois.readObject();
				
				System.out.println( m.getTipoMensaje() );
				
				this.getHandlers().get( m.getTipoMensaje() ).accept( m, oos, this);
			}		
			
		} catch (ClassNotFoundException | IOException e) {				
			e.printStackTrace();
		}

	}

	private boolean isDeboContinuar() {
		return this.deboContinuar;
	}

	private Socket getSocket() {
		return socket;
	}

	private void setSocket(Socket socket) {
		this.socket = socket;
	}

	private Map<TipoMensaje, Handler> getHandlers() {
		return handlers;
	}

	private void setHandlers(Map<TipoMensaje, Handler> handlers) {
		this.handlers = handlers;
	}

	public void setDeboContinuar(boolean deboContinuar) {
		this.deboContinuar = deboContinuar;
	}

}
