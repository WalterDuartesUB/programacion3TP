package ar.edu.ub.p3.conexion;

import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeAltaAeropuertoACK implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, EstadoAeropuerto estado) {
		System.out.println(mensaje.getAeropuertos());

	}

}