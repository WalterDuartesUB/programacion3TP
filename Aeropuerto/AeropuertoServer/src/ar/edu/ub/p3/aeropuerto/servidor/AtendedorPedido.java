package ar.edu.ub.p3.aeropuerto.servidor;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.aeropuerto.pedido._PedidoAeropuerto;

public class AtendedorPedido implements Runnable {
	
	private List<_PedidoAeropuerto>  pedidos;
	private ConfiguracionAeropuerto configuracionAeropuerto;
	private EstadoAeropuerto        estadoAeropuerto;
	
	public AtendedorPedido(ConfiguracionAeropuerto configuracionAeropuerto, EstadoAeropuerto estadoAeropuerto, Socket s) {
				
		this.setPedidos( new LinkedList<_PedidoAeropuerto>() );
		this.setConfiguracionAeropuerto(configuracionAeropuerto);
		this.setEstadoAeropuerto(estadoAeropuerto);
		
		//
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream( s.getInputStream() );
			_PedidoAeropuerto pedido = null;
			
			try
			{
				// Leo todos los objetos en Socket
				while( ( pedido = (_PedidoAeropuerto) ois.readObject() ) != null )
				{
					this.getPedidos().add( pedido );
				}
				
			}catch( EOFException e ) {
				
			}			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		for( _PedidoAeropuerto pedido : this.getPedidos() )
			pedido.atender( this.getConfiguracionAeropuerto(), this.getEstadoAeropuerto() );

		System.out.println("Se resolvio un pedido");
	}

	private List<_PedidoAeropuerto> getPedidos() {
		return pedidos;
	}

	private void setPedidos(List<_PedidoAeropuerto> pedidos) {
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

}
