package ar.edu.ub.p3.conexion.handler;

import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeBajaAeropuertoACK implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, ObjectOutputStream oos,EstadoAeropuerto estado) {
		estado.setDeboContinuar( false );
		estado.setEstoyConectado(false);
		estado.setEstoyEsperandoRespuestaConexion(false);

		System.out.println("Desconectado del TA");
	}

}
