package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.IConexionTraficoAereo;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeAltaAeropuertoACK implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, IConexionTraficoAereo conexionTraficoAereo, EstadoAeropuerto estado) {
		System.out.println(mensaje.getAeropuertos());
		
		estado.setEstoyConectado(true);
		estado.setEstoyEsperandoRespuestaConexion(false);
	}

}
