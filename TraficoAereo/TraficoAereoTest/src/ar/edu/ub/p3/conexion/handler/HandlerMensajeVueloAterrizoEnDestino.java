package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeVueloAterrizoEnDestino implements Handler {

	private EstadoTraficoAereo estadoTA;
	public HandlerMensajeVueloAterrizoEnDestino(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		this.getEstadoTA().getConexionAeropuerto( this.getEstadoTA().getVuelo( m.getIdVuelo() ).getAeropuertoOrigen().getIdAeropuerto() ).enviarMensaje( ( Mensaje.crearMensajeVueloAterrizoEnDestino( m.getIdVuelo() ) ) );
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
