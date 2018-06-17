package ar.edu.ub.p3.controlador;

import javax.swing.JOptionPane;

import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea.ActionVentanaGestionAerolineas;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.ActionVentanaGestionAeropuertos;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion.ActionVentanaGestionAviones;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo.ActionVentanaGestionVuelos;
import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;
import ar.edu.ub.p3.vista.VentanaDespegue;
import ar.edu.ub.p3.vista.VentanaRadar;

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
		new VentanaDespegue( this.getConfiguracion(), this.getEstadoAeropuerto().getAerpuerto(), this.getConexionTA() );
	}
	
	public void verRadar() {
		new VentanaRadar( this.getConfiguracion(), this.getEstadoAeropuerto().getAerpuerto(), this.getConexionTA() );
	}
	
	public void gestionarAviones() {
		ActionVentanaGestionAviones.generarVentana( getEstadoAeropuerto() );
	}
	
	public void gestionarAerolineas() {
		ActionVentanaGestionAerolineas.generarVentana( getEstadoAeropuerto() );
	}
	
	public void gestionarAeropuertos() {
		ActionVentanaGestionAeropuertos.generarVentana( getEstadoAeropuerto() );
	}
	
	public void gestionarVuelos() {
		ActionVentanaGestionVuelos.generarVentana( getEstadoAeropuerto());
	}	
	
	private void onEventoAImplementar() {
		JOptionPane.showMessageDialog( null, "Evento a implementar " );
	}

}
