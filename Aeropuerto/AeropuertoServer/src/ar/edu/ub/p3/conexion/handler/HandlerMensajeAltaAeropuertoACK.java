package ar.edu.ub.p3.conexion.handler;

import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeAltaAeropuertoACK implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, ObjectOutputStream oos, EstadoAeropuerto estado) {
		System.out.println(mensaje.getAeropuertos());
		
		estado.setEstoyConectado(true);
		estado.setEstoyEsperandoRespuestaConexion(false);
	}

}
