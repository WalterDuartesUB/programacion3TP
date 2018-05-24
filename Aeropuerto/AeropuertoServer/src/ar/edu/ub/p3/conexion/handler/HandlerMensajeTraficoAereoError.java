package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeTraficoAereoError implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, EstadoAeropuerto estado) {
		System.out.println(mensaje.getDescripcion());
		
		estado.setEstoyConectado(false);
		estado.setEstoyEsperandoRespuestaConexion(false);
	}

}
