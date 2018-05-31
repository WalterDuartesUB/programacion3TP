package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeObtenerListadoAeropuertosDisponibles implements Handler {

	private EstadoTraficoAereo estadoTA;
	public HandlerMensajeObtenerListadoAeropuertosDisponibles(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {

		try {
			oos.writeObject( Mensaje.crearMensajeListadoAeropuerto( this.getEstadoTA().getIAeropuertos() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
