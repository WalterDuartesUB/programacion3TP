package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeBajaAeropuerto implements Handler {

	private EstadoTraficoAereo estadoTA;
	
	public HandlerMensajeBajaAeropuerto(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos) {
		this.getEstadoTA().quitarAeropuerto( m.getIdAeropuerto() );
		
		try {
			oos.writeObject( Mensaje.crearMensajeBajaAeropuertoAck() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Marco como terminada la sesion con el cliente actual
		this.getEstadoTA().setDeboContinuar( false );
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
