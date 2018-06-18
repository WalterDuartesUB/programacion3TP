package ar.edu.ub.p3.controlador;

import java.awt.Color;

import javax.swing.JLabel;

import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea.ActionVentanaGestionAerolineas;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.ActionVentanaGestionAeropuertos;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion.ActionVentanaGestionAviones;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo.ActionVentanaGestionVuelos;
import ar.edu.ub.p3.aeropuerto.tablero.llegadas.ActionVentanaVuelosLlegadas;
import ar.edu.ub.p3.aeropuerto.tablero.salidas.ActionVentanaVuelosSalida;
import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;
import ar.edu.ub.p3.vista.ActionVentanaRadar;

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
	
	public void verEstadoConexionTraficoAereo( JLabel lblestadoConexion ) {
		
		if ( getConexionTA().getEstadoAeropuerto().isEstoyConectado() ) {
			lblestadoConexion.setText( "conectado" );
			lblestadoConexion.setBackground(Color.GREEN);	
    	}else {
    		lblestadoConexion.setText( "desconectado" );
    		lblestadoConexion.setBackground(Color.RED);
    	}
		
	}
	
	public void verArribos() {
		ActionVentanaVuelosLlegadas.generarVentana(this.getConfiguracion(),getEstadoAeropuerto());
	}
	
	public void verDespegues() {
		ActionVentanaVuelosSalida.generarVentana( this.getConfiguracion(),getEstadoAeropuerto() );
	}
	
	public void verRadar() {
		ActionVentanaRadar.generarVentana( this.getConfiguracion(), this.getEstadoAeropuerto().getAerpuerto(), this.getConexionTA() );
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
	

}
