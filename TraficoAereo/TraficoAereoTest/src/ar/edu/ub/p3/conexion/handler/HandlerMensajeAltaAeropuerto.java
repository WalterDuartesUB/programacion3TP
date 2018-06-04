package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeAltaAeropuerto implements Handler {

	private EstadoTraficoAereo estadoTA;
	
	public HandlerMensajeAltaAeropuerto(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		this.getEstadoTA().addAeropuerto( new ConexionAeropuerto( m.getAeropuerto(), oos ) );
			
		//Envio el ACK del alta del aeropuerto
		try {
			oos.writeObject( Mensaje.crearMensajeAltaAeropuertoAck( this.getEstadoTA().getIAeropuertos() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Le envio a todos los aeropuertos la lista de aeropuertos disponibles
		for( ConexionAeropuerto aeropuerto : this.getEstadoTA().getAeropuertos().values() )
			aeropuerto.enviarMensaje(Mensaje.crearMensajeListadoAeropuerto( this.getEstadoTA().getIAeropuertos() )  );
			
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
