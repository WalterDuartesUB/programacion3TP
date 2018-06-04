package ar.edu.ub.p3.conexion.handler;
import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.IConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.modelo.Vuelo;

public class HandlerMensajeObtenerInformacionVuelo implements Handler {
	private EstadoTraficoAereo estadoTA;
	public HandlerMensajeObtenerInformacionVuelo(EstadoTraficoAereo estadoTA) {
		this.setEstadoTA(estadoTA);
	}

	@Override
	public void accept(Mensaje m, IConexionAeropuerto conexionAeropuerto, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {

		if( this.getEstadoTA().getVuelo( m.getIdVuelo() ) != null )					
			conexionAeropuerto.enviarMensaje( Mensaje.crearMensajeInformacionVuelo( new Vuelo( this.getEstadoTA().getVuelo( m.getIdVuelo() ) ) ) );	
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

}
