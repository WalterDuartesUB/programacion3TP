package ar.edu.ub.p3.conexion.handler;
import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.IConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class HandlerMensajeVueloProgramado implements Handler {
	private EstadoTraficoAereo estadoTA;
	private Configuracion configuracion;
	
	public HandlerMensajeVueloProgramado(EstadoTraficoAereo estadoTA, Configuracion configuracion) {
		this.setEstadoTA(estadoTA);
		this.setConfiguracion(configuracion);
	}

	@Override
	public void accept(Mensaje m, IConexionAeropuerto conexionAeropuerto, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto) {
		
		Vuelo vuelo = new Vuelo( m.getVuelo() );
		this.getEstadoTA().addVuelo( vuelo );
		
		this.getEstadoTA().getConexionAeropuerto( vuelo.getAeropuertoDestino().getIdAeropuerto() ).enviarMensaje( Mensaje.crearMensajeProgramarVuelo(vuelo) );
		
		// Empiezo a mover el avion del vuelo
		new Thread( new MovedorDeAvionEnVuelo( this.getEstadoTA(), vuelo.getIdVuelo(), this.getConfiguracion() ) ).start();
	}

	private EstadoTraficoAereo getEstadoTA() {
		return estadoTA;
	}

	private void setEstadoTA(EstadoTraficoAereo estadoTA) {
		this.estadoTA = estadoTA;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

}
