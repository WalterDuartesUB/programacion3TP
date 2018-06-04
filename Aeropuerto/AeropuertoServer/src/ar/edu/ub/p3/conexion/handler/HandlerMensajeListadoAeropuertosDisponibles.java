package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.IConexionTraficoAereo;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeListadoAeropuertosDisponibles implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, IConexionTraficoAereo conexionTraficoAereo,EstadoAeropuerto estado) {
		System.out.println( "Aeropuertos recibidos del trafico aereo: ");
		System.out.println( mensaje.getAeropuertos() );
	}

}
