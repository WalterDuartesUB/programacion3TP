package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeAltaAeropuerto implements Handler {

	private EstadoTraficoAereo estadoTA;
	
	public HandlerMensajeAltaAeropuerto(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos) {
		this.getEstadoTA().addAeropuerto( new Aeropuerto( m.getAeropuerto() ) );
			
		try {
			oos.writeObject( Mensaje.crearMensajeAltaAeropuertoAck( this.getEstadoTA().getIAeropuertos() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
