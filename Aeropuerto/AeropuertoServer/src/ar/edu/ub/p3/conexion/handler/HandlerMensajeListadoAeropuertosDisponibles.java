package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeListadoAeropuertosDisponibles implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, EstadoAeropuerto estado) {
		System.out.println( "Aeropuertos recibidos del trafico aereo: ");
		System.out.println( mensaje.getAeropuertos() );
	}

}
