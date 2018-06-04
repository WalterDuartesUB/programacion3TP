package ar.edu.ub.p3.conexion.handler;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.modelo.Vuelo;

public class HandlerMensajeVueloProgramado implements Handler {
	private EstadoTraficoAereo estadoTA;
	public HandlerMensajeVueloProgramado(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		
		Vuelo vuelo = new Vuelo( m.getVuelo() );
		this.getEstadoTA().addVuelo( vuelo );
		
		//TODO despachar el mensaje al aeropuerto de destino con el vuelo
		this.getEstadoTA().getConexionAeropuerto( vuelo.getAeropuertoDestino().getIdAeropuerto() ).enviarMensaje( Mensaje.crearMensajeProgramarVuelo(vuelo) );
		
		// Empiezo a mover el avion del vuelo
		new Thread( new MovedorDeAvionEnVuelo( this.getEstadoTA(), vuelo.getIdVuelo() ) ).start();
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
