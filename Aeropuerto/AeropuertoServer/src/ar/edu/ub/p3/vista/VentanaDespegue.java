package ar.edu.ub.p3.vista;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaDespegue extends JDialog {



	/**
	 * 
	 */
	private static final long serialVersionUID = -7253803356902721825L;
	
	
	private IAeropuerto aerpuerto;
	private ConexionTraficoAereo conexionTA;
	private Configuracion configuracion;

	public VentanaDespegue(Configuracion configuracion, Aeropuerto aerpuerto, ConexionTraficoAereo conexionTA) {
		
		this.setAerpuerto(aerpuerto);
		this.setConexionTA(conexionTA);
		this.setConfiguracion(configuracion);
		
		this.setTitle("Despegues");
		this.setResizable(false);
		this.add( new PanelDespegue( this.getConfiguracion(), this.getAerpuerto().getIdAeropuerto(), this.getConexionTA() ),BorderLayout.CENTER);
		this.setVisible(true);	
	}

	public IAeropuerto getAerpuerto() {
		return aerpuerto;
	}

	private void setAerpuerto(IAeropuerto aerpuerto) {
		this.aerpuerto = aerpuerto;
	}

	public ConexionTraficoAereo getConexionTA() {
		return conexionTA;
	}

	private void setConexionTA(ConexionTraficoAereo conexionTA) {
		this.conexionTA = conexionTA;
	}

	public Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

}
