package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class HandlerMensajeInformacionVuelo implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, EstadoAeropuerto estado) {
		System.out.println("Recibi un mensaje: " + mensaje.getTipoMensaje() );
		System.out.println( mensaje.getVuelo() );
		
		estado.setVueloRecibido( new Vuelo( mensaje.getVuelo() ) );		
		estado.setEstoyEsperandoRespuestaConexion( false );
	}

}
