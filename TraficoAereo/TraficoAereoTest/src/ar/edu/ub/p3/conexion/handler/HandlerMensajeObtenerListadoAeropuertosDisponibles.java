package ar.edu.ub.p3.conexion.handler;
import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.IConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;

public class HandlerMensajeObtenerListadoAeropuertosDisponibles implements Handler {

	private EstadoTraficoAereo estadoTA;
	public HandlerMensajeObtenerListadoAeropuertosDisponibles(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, IConexionAeropuerto conexionAeropuerto, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		conexionAeropuerto.enviarMensaje( Mensaje.crearMensajeListadoAeropuerto( this.getEstadoTA().getIAeropuertos() ) );
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
