package ar.edu.ub.p3.conexion.handler;
import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.conexion.IConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeAltaAeropuerto implements Handler {

	private EstadoTraficoAereo estadoTA;
	
	public HandlerMensajeAltaAeropuerto(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, IConexionAeropuerto conexionAeropuerto, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		
		//Creo un aeropuerto nuevo
		ConexionAeropuerto cnxAeropuerto = new ConexionAeropuerto( m.getAeropuerto(), conexionAeropuerto );
		
		//Agrego el aeropuerto a la lista de aeropurtos
		this.getEstadoTA().addAeropuerto( cnxAeropuerto );
			
		//Envio el ACK del alta del aeropuerto
		cnxAeropuerto.enviarMensaje( Mensaje.crearMensajeAltaAeropuertoAck( this.getEstadoTA().getIAeropuertos() ) );
		
		//Le envio a todos los aeropuertos la lista de aeropuertos disponibles
		for( ConexionAeropuerto aeropuerto : this.getEstadoTA().getAeropuertos().values() )
			aeropuerto.enviarMensaje( Mensaje.crearMensajeListadoAeropuerto( this.getEstadoTA().getIAeropuertos() ) );
			
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
