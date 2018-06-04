package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeBajaAeropuerto implements Handler {

	private EstadoTraficoAereo estadoTA;
	
	public HandlerMensajeBajaAeropuerto(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		this.getEstadoTA().quitarAeropuerto( m.getIdAeropuerto() );
		
		//Envio el ACK de la baja del aeropuerto
		try {
			oos.writeObject( Mensaje.crearMensajeBajaAeropuertoAck() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Le envio a todos los aeropuertos la lista de aeropuertos disponibles
		for( ConexionAeropuerto aeropuerto : this.getEstadoTA().getAeropuertos().values() )
			aeropuerto.enviarMensaje(Mensaje.crearMensajeListadoAeropuerto( this.getEstadoTA().getIAeropuertos() )  );		
		
		//Marco como terminada la sesion con el cliente actual
		atendedorDePedidosDeAeropuerto.setDeboContinuar( false );
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
