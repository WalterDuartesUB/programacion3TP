package ar.edu.ub.p3.conexion;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class ConexionTraficoAereo {
	
	private EstadoAeropuerto estadoAeropuerto;
	private Configuracion configuracion;
	private Socket socket;
	private ObjectOutputStream outputStram;
	
	public ConexionTraficoAereo(Configuracion configuracion, EstadoAeropuerto estadoAeropuerto) {
		
		setConfiguracion(configuracion);
		setEstadoAeropuerto(estadoAeropuerto);
	
	}

	public EstadoAeropuerto getEstadoAeropuerto() {
		
		return estadoAeropuerto;
	}

	private void setEstadoAeropuerto(EstadoAeropuerto estadoAeropuerto) {
		this.estadoAeropuerto = estadoAeropuerto;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public boolean conectar() {
		 
		///////////////////////////////////////////////////////////////////
		//Marco que estoy esperando la conexion

		this.getEstadoAeropuerto().setEstoyEsperandoRespuestaConexion( true );

		///////////////////////////////////////////////////////////////////
		//Intento hacer la conexion

		try 
		{
			//Creo el socket al servidor
			this.setSocket( new Socket(this.getIpServer(), this.getPuerto() ) );

			//Creo un thread para poder escuchar los mensajes que llegan desde el servidor        	
			new Thread( new RecibidorDeMensajesDelTraficoAereo( this.getEstadoAeropuerto(), this.getSocket() ) ).start();

			// Creo el outputstream
			this.setOutputStram( new ObjectOutputStream( this.getSocket().getOutputStream() ) );

			// Envio el aeropuerto al trafico aereo
			this.enviarMensaje( Mensaje.crearMensajeAltaAeropuerto( this.getEstadoAeropuerto().getAerpuerto()));

			///////////////////////////////////////////////////////////////////
			// Espero la respuesta del servidor

			while( this.isEstoyEsperandoRespuestaConexion() )
			{            	
				// Espero para buscar mi respuesta            	
				Thread.sleep( 1000 );
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

		return this.isEstoyConectado();
	
		
		}

	private boolean isEstoyConectado() {
		return this.getEstadoAeropuerto().isEstoyConectado();
	}

	private boolean isEstoyEsperandoRespuestaConexion() {
		return this.getEstadoAeropuerto().isEstoyEsperandoRespuestaConexion();
	}

	private void enviarMensaje(Mensaje mensaje) {
		
		try {
			this.getOutputStram().writeObject( mensaje );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private int getPuerto(  ) {
		
		return Integer.parseInt(this.getConfiguracion().getConfiguracion("puertoTraficoAereo")) ;
	}

	private String getIpServer() {
		return this.getConfiguracion().getConfiguracion("ipTraficoAereo");
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	private ObjectOutputStream getOutputStram() {
		return outputStram;
	}

	private void setOutputStram(ObjectOutputStream outputStram) {
		this.outputStram = outputStram;
	}

	public void desconectar() {
		
		this.getEstadoAeropuerto().setDeboContinuar( false );
		this.getEstadoAeropuerto().setEstoyConectado( false );
		this.getEstadoAeropuerto().setEstoyEsperandoRespuestaConexion( false );
				
		this.enviarMensaje( Mensaje.crearMensajeBajaAeropuerto( this.getEstadoAeropuerto().getAerpuerto().getIdAeropuerto() ) );
		
	}

	public void obtenerAeropuertosDisponibles() {
		this.enviarMensaje( Mensaje.crearMensajeObtenerListadoAeropuerto() );
	}	
	
}
