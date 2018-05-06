package ar.edu.ub.p3.aeropuerto.servidor;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.aeropuerto.pedido.PedidoAeropuerto;
import ar.edu.ub.p3.common.aeropuerto.conexion.Comando;

public class AtendedorPedido implements Runnable {
	
	private List<Comando>      			  pedidos;
	private ConfiguracionAeropuerto       configuracionAeropuerto;
	private EstadoAeropuerto              estadoAeropuerto;
	private Map<String, PedidoAeropuerto> comandos;
	private Socket s;
	
	public AtendedorPedido(ConfiguracionAeropuerto configuracionAeropuerto, EstadoAeropuerto estadoAeropuerto, Map<String, PedidoAeropuerto> comandos, Socket s) {
				
		this.setPedidos( new LinkedList<Comando>() );
		this.setConfiguracionAeropuerto(configuracionAeropuerto);
		this.setEstadoAeropuerto(estadoAeropuerto);
		this.setComandos(comandos);
		this.setSocket(s);
		
		//
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream( this.getSocket().getInputStream() );
			Comando           pedido = null;
			
			try
			{
				// Leo todos los objetos en Socket
				while( ( pedido = (Comando) ois.readObject() ) != null )
				{
					this.getPedidos().add( pedido );
				}
				
			}catch( EOFException e ) {
				e.printStackTrace();
			}			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		for( Comando pedido : this.getPedidos() )
			this.getComandos().get( pedido.getCodigoComando().toString() ).ejecutar(this.getConfiguracionAeropuerto(), 
																					this.getEstadoAeropuerto(), 
																					pedido.getParametros(),
																					this.getSocket() );

		System.out.println("Se resolvio un pedido");
	}

	private List<Comando> getPedidos() {
		return pedidos;
	}

	private void setPedidos(List<Comando> pedidos) {
		this.pedidos = pedidos;
	}

	private ConfiguracionAeropuerto getConfiguracionAeropuerto() {
		return configuracionAeropuerto;
	}

	private void setConfiguracionAeropuerto(ConfiguracionAeropuerto configuracionAeropuerto) {
		this.configuracionAeropuerto = configuracionAeropuerto;
	}

	private EstadoAeropuerto getEstadoAeropuerto() {
		return estadoAeropuerto;
	}

	private void setEstadoAeropuerto(EstadoAeropuerto estadoAeropuerto) {
		this.estadoAeropuerto = estadoAeropuerto;
	}

	private Map<String, PedidoAeropuerto> getComandos() {
		return comandos;
	}

	private void setComandos(Map<String, PedidoAeropuerto> comandos) {
		this.comandos = comandos;
	}

	public Socket getSocket() {
		return s;
	}

	public void setSocket(Socket s) {
		this.s = s;
	}

}
