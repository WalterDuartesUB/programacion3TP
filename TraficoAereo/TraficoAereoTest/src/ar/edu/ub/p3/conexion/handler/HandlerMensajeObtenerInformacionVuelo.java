package ar.edu.ub.p3.conexion.handler;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.modelo.Vuelo;

public class HandlerMensajeObtenerInformacionVuelo implements Handler {
	private EstadoTraficoAereo estadoTA;
	public HandlerMensajeObtenerInformacionVuelo(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {

		//TODO ver porque no cambia la posicion al pedir dos veces el mensaje
		try {
			System.out.println( this.getEstadoTA().getVuelo( m.getIdVuelo() ) );
			System.out.println( new Vuelo( this.getEstadoTA().getVuelo( m.getIdVuelo() ) ) );
			
			Mensaje mensaje = Mensaje.crearMensajeInformacionVuelo( this.getEstadoTA().getVuelo( m.getIdVuelo() ) );
			
			oos.writeObject( mensaje );
			
			System.out.println( mensaje.getVuelo() );
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
