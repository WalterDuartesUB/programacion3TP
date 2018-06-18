package ar.edu.ub.p3.vista;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JDialog;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaRadar extends JDialog implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7858341134745173528L;
	
	private IAeropuerto aerpuerto;
	private ConexionTraficoAereo conexionTA;
	private Configuracion configuracion;
	private PanelRadar panelRadar;
	
	public VentanaRadar(Configuracion configuracion, IAeropuerto aerpuerto, ConexionTraficoAereo conexionTA) {
		this.setAerpuerto(aerpuerto);
		this.setConexionTA(conexionTA);
		this.setConfiguracion(configuracion);
		
		this.setTitle("Radar " + aerpuerto.getNombre());
		this.setSize(397, 399);
		this.setPanelRadar( new PanelRadar( this.getConfiguracion(), this.getAerpuerto().getPosicion(), this.getConexionTA() ));
		this.add(this.getPanelRadar(),BorderLayout.CENTER);
		this.addWindowListener(this);
		this.setVisible(true);		
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

	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try {
			this.getPanelRadar().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}

	public PanelRadar getPanelRadar() {
		return panelRadar;
	}

	public void setPanelRadar(PanelRadar panelRadar) {
		this.panelRadar = panelRadar;
	}


}
