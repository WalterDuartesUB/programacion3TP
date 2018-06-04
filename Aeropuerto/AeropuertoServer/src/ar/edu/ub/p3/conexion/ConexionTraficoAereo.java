package ar.edu.ub.p3.conexion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.EstadoVuelo;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class ConexionTraficoAereo implements IConexionTraficoAereo{
	
	private EstadoAeropuerto estadoAeropuerto;
	private Configuracion configuracion;
	private Socket socket;
	private ObjectOutputStream outputStream;		
	private Thread threadRecibidorDeMensajesDelTraficoAereo;
	
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

		this.getEstadoAeropuerto().setDeboContinuar(true);
		this.getEstadoAeropuerto().setEstoyEsperandoRespuestaConexion( true );

		///////////////////////////////////////////////////////////////////
		//Intento hacer la conexion

		try 
		{
			//Creo el socket al servidor
			this.setSocket( new Socket(this.getIpServer(), this.getPuerto() ) );

			System.out.println( this.getSocket() );

			// Creo el outputstream
			this.setOutputStream( new ObjectOutputStream( this.getSocket().getOutputStream() ) );
			
			//Creo un thread para poder escuchar los mensajes que llegan desde el servidor
			this.crearThreadRecibidorDeMensajesDelTraficoAereo();

			// Envio el aeropuerto al trafico aereo
			this.enviarMensaje( Mensaje.crearMensajeAltaAeropuerto( this.getEstadoAeropuerto().getAerpuerto()));

			///////////////////////////////////////////////////////////////////
			// Espero la respuesta del servidor
			
			this.esperarRespuestaTraficoAereo();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.isEstoyConectado();
	
	}

	private void crearThreadRecibidorDeMensajesDelTraficoAereo() {
		this.setThreadRecibidorDeMensajesDelTraficoAereo( new Thread( new RecibidorDeMensajesDelTraficoAereo( this.getEstadoAeropuerto(), this.getSocket(), this ) ) );
		this.getThreadRecibidorDeMensajesDelTraficoAereo().start();
	}

	private boolean isEstoyConectado() {
		return this.getEstadoAeropuerto().isEstoyConectado();
	}

	private boolean isEstoyEsperandoRespuestaConexion() {
		return this.getEstadoAeropuerto().isEstoyEsperandoRespuestaConexion();
	}

	@Override
	public void enviarMensaje(Mensaje mensaje) {
		
		try {
			this.getOutputStream().writeObject( mensaje );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private int getPuerto(  ) {		
		return this.getConfiguracion().getConfiguracionAsInt("puertoTraficoAereo");
	}

	private String getIpServer() {
		return this.getConfiguracion().getConfiguracion("ipTraficoAereo");
	}

	private Socket getSocket() {
		return socket;
	}

	private void setSocket(Socket socket) {
		this.socket = socket;
	}

	private ObjectOutputStream getOutputStream() {
		return outputStream;
	}

	private void setOutputStream(ObjectOutputStream outputStram) {
		this.outputStream = outputStram;
	}

	public void desconectar() {		
		this.getEstadoAeropuerto().setEstoyEsperandoRespuestaConexion( true );
		this.enviarMensaje( Mensaje.crearMensajeBajaAeropuerto( this.getEstadoAeropuerto().getAerpuerto().getIdAeropuerto() ) );
		
		this.esperarRespuestaTraficoAereo();
		System.out.println("Espero para terminar el thread de mensajes");
		try {
			this.getThreadRecibidorDeMensajesDelTraficoAereo().join();
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		System.out.println("Termino el thread de mensajes");		
		this.cerrarConexionSocket();		
	}

	private void cerrarConexionSocket() {
		//Cierro la conexion
		try {
			this.getOutputStream().close();			
			this.getSocket().close();
		} catch (IOException e) {	
			e.printStackTrace();
		}
	}

	public void obtenerAeropuertosDisponibles() {
		this.enviarMensaje( Mensaje.crearMensajeObtenerListadoAeropuerto() );
	}

	public void despegar(Vuelo vuelo) {
		//TODO evaluar si esto tiene que estar aca
		vuelo.setPosicion(new Posicion( this.getEstadoAeropuerto().getAerpuerto().getPosicion() ) );
		vuelo.setEstadoVuelo( EstadoVuelo.ON_AIR );
		
		this.enviarMensaje( Mensaje.crearMensajeProgramarVuelo(vuelo));		
	}

	public Vuelo obtenerInformacionVuelo(String idVuelo) {
		
		this.getEstadoAeropuerto().setEstoyEsperandoRespuestaConexion( true );
		this.getEstadoAeropuerto().setVueloRecibido(null);
		
		this.enviarMensaje( Mensaje.crearMensajeObtenerInformacionVuelo( idVuelo ) );
		
		this.esperarRespuestaTraficoAereo();
		
		return this.getEstadoAeropuerto().getVueloRecibido();
	}

	private void esperarRespuestaTraficoAereo() {
		while( this.isEstoyEsperandoRespuestaConexion() )
		{
			try {
				System.out.println("Esperando respuesta del Trafico Aereo...");
				Thread.sleep( 100 );			
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}

	private Thread getThreadRecibidorDeMensajesDelTraficoAereo() {
		return threadRecibidorDeMensajesDelTraficoAereo;
	}

	private void setThreadRecibidorDeMensajesDelTraficoAereo(Thread threadRecibidorDeMensajesDelTraficoAereo) {
		this.threadRecibidorDeMensajesDelTraficoAereo = threadRecibidorDeMensajesDelTraficoAereo;
	}

	public Collection<Vuelo> obtenerInformacionVuelos(Collection<String> idVuelos) {
		//TODO el trafico aereo deberia resolver este mensaje en un solo llamado
		List<Vuelo> vuelos = new LinkedList<Vuelo>();
		
		for( String idVuelo : idVuelos)
			vuelos.add( this.obtenerInformacionVuelo(idVuelo) );
		
		return vuelos;
	}

	public Collection<Vuelo> obtenerInformacionVuelosCercanos(IPosicion posicion, int coberturaKm) {
		//TODO implementar este mensaje en el trafico aereo: obtenerInformacionVuelosCercanos
		return this.obtenerInformacionVuelos( this.getEstadoAeropuerto().getVuelos().keySet() );
	}

}
