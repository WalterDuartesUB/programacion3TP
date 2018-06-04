package ar.edu.ub.p3.conexion.handler;

import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.modelo.EstadoVuelo;
import ar.edu.ub.p3.modelo.Vuelo;

public class HandlerMensajeVueloProximoAterrizar implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, ObjectOutputStream oos,EstadoAeropuerto estado) {
		System.out.println("Recibi un mensaje: " + mensaje.getTipoMensaje() );
		System.out.println( mensaje.getVuelo() );
		
		//Cambio el estado del vuelo a "aterrizando"
		Vuelo vuelo = new Vuelo( mensaje.getVuelo() );
		vuelo.setEstadoVuelo( EstadoVuelo.LANDING );

		//TODO esto debe ocurrir cuando se pueda aterrizar el avion
		//Envio un mensaje indicando que pude aterrizar
		vuelo.setEstadoVuelo( EstadoVuelo.LANDED );
		
		try {
			oos.writeObject( Mensaje.crearMensajeVueloAterrizoEnDestino( vuelo.getIdVuelo() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
