package ar.edu.ub.p3.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaRadar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7858341134745173528L;
	
	private IAeropuerto aerpuerto;
	private ConexionTraficoAereo conexionTA;
	private Configuracion configuracion;
	
	public VentanaRadar(Configuracion configuracion, IAeropuerto aerpuerto, ConexionTraficoAereo conexionTA) {
		this.setAerpuerto(aerpuerto);
		this.setConexionTA(conexionTA);
		this.setConfiguracion(configuracion);
		
		this.setTitle("Radar");
		this.setSize(397, 399);
		this.add( new PanelRadar( this.getConfiguracion(), this.getAerpuerto(), this.getConexionTA() ),BorderLayout.CENTER);
		this.setVisible(true);		
		
		//TODO en el close de este dialogo tiene que matar el timer de PanelRadar
	}

	private ConexionTraficoAereo getConexionTA() {
		return conexionTA;
	}

	private void setConexionTA(ConexionTraficoAereo conexionTA) {
		this.conexionTA = conexionTA;
	}

	private IAeropuerto getAerpuerto() {
		return aerpuerto;
	}

	private void setAerpuerto(IAeropuerto aerpuerto) {
		this.aerpuerto = aerpuerto;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}


}
