package ar.edu.ub.p3.aeropuerto.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServidorDePedidosAeropuerto implements Runnable {

	private ConfiguracionAeropuerto configuracion;
	private EstadoAeropuerto        estadoAeropuerto;	
	private List<Thread>            hilosPedidos;
	
	public ServidorDePedidosAeropuerto(ConfiguracionAeropuerto configuracion, EstadoAeropuerto estadoAeropuerto) {
		this.setConfiguracion(configuracion);
		this.setEstadoAeropuerto(estadoAeropuerto);
		
		this.setHilosPedidos( new LinkedList<Thread>() );
	}

	@Override
	public void run() {
		
		try (ServerSocket ss = new ServerSocket( this.getConfiguracion().getPuertoPedidosAeropuerto() ) ){
			
			while( this.getEstadoAeropuerto().isSigueCorriendo() ) {
				
				Socket s = ss.accept();
				
				if( this.getEstadoAeropuerto().isSigueCorriendo() )
					this.agregarHiloPedido( s );
			}
			
			this.esperarQueTerminenLosHilosDePedidos();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void agregarHiloPedido(Socket s) {		
		System.out.println("Entro un pedido nuevo");
		
		Thread hilo = new Thread( new AtendedorPedido( this.getConfiguracion(), this.getEstadoAeropuerto(), s ) );
		
		hilo.start();
		
		this.getHilosPedidos().add( hilo );		
	}

	private void esperarQueTerminenLosHilosDePedidos() {
		for( Thread hilo : this.getHilosPedidos() )
		{
			try {
				hilo.join();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}

	private ConfiguracionAeropuerto getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(ConfiguracionAeropuerto configuracion) {
		this.configuracion = configuracion;
	}

	private EstadoAeropuerto getEstadoAeropuerto() {
		return estadoAeropuerto;
	}

	private void setEstadoAeropuerto(EstadoAeropuerto estadoAeropuerto) {
		this.estadoAeropuerto = estadoAeropuerto;
	}

	private List<Thread> getHilosPedidos() {
		return hilosPedidos;
	}

	private void setHilosPedidos(List<Thread> hilosPedidos) {
		this.hilosPedidos = hilosPedidos;
	}

}
