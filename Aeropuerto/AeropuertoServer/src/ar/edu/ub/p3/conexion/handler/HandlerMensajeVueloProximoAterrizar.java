package ar.edu.ub.p3.conexion.handler;

import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;

public class HandlerMensajeVueloProximoAterrizar implements Handler<EstadoAeropuerto> {

	@Override
	public void accept(Mensaje mensaje, ObjectOutputStream oos,EstadoAeropuerto estado) {
		System.out.println("Recibi un mensaje: " + mensaje.getTipoMensaje() );
		System.out.println( mensaje.getVuelo() );
		
		//TODO esto debe ocurrir cuando se pueda aterrizar el avion
		try {
			oos.writeObject( Mensaje.crearMensajeVueloAterrizoEnDestino( mensaje.getVuelo().getIdVuelo() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
