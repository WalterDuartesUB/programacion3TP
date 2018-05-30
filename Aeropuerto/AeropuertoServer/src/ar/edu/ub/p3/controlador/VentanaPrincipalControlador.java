package ar.edu.ub.p3.controlador;

import javax.swing.JOptionPane;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaPrincipalControlador {

	private Configuracion configuracion;
	private EstadoAeropuerto estadoAeropuerto;
	private ConexionTraficoAereo conexionTA;
	public VentanaPrincipalControlador(Configuracion configuracion, EstadoAeropuerto estadoAeropuerto, ConexionTraficoAereo conexionTA) {
		this.setConexionTA(conexionTA);
		this.setConfiguracion(configuracion);
		this.setEstadoAeropuerto(estadoAeropuerto);
	}

	public void conectarAlTraficoAereo() {
		this.getConexionTA().conectar();				
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	private EstadoAeropuerto getEstadoAeropuerto() {
		return estadoAeropuerto;
	}

	private void setEstadoAeropuerto(EstadoAeropuerto estadoAeropuerto) {
		this.estadoAeropuerto = estadoAeropuerto;
	}

	private ConexionTraficoAereo getConexionTA() {
		return conexionTA;
	}

	private void setConexionTA(ConexionTraficoAereo conexionTA) {
		this.conexionTA = conexionTA;
	}

	public void desconectarDelTraficoAereo() {
		this.getConexionTA().desconectar();		
	}

	public void debugPedirListaAeropuertosDisponibles() {
		this.getConexionTA().obtenerAeropuertosDisponibles();		
	}

	public void debugProgramarVueloDePrueba() {
		this.getConexionTA().despegar( this.getEstadoAeropuerto().getVuelos().get( this.getConfiguracion().getConfiguracion("idVueloPrueba") ) );		
	}

	public void debugPedirInformacionActualDelVueloDePrueba() {
		System.out.println( this.getConexionTA().obtenerInformacionVuelo( this.getConfiguracion().getConfiguracion("idVueloPrueba") ) );		
	}
	
	public void salirDeLaAplicacion() {
		this.onEventoAImplementar();
	}
	
	public void verArribos() {
		this.onEventoAImplementar();
	}
	
	public void verDespegues() {
		this.onEventoAImplementar();
	}
	
	public void verRadar() {
		this.onEventoAImplementar();
	}
	
	public void gestionarAviones() {
		this.onEventoAImplementar();
	}
	
	public void gestionarAerolineas() {
		this.onEventoAImplementar();
	}
	
	public void gestionarAeropuertos() {
		this.onEventoAImplementar();
	}
	
	public void gestionarVuelos() {
		this.onEventoAImplementar();	
	}	
	
	private void onEventoAImplementar() {
		JOptionPane.showMessageDialog( null, "Evento a implementar " );
	}

}
