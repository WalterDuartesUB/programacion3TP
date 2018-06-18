package ar.edu.ub.p3.aeropuerto.tablero.salidas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.Timer;

import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.PanelFichaAeropuerto;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class VentanaVuelosSalida extends JDialog{

	private Timer timerVentana;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaVuelosSalida(  PanelLista<Vuelo> lista ) {
		
		setLayout( new GridLayout(1, 2) );
		add(lista);
		setSize(800, 320); 
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setTimerVentana(new Timer(1000,this::refrescarVentana));
		this.getTimerVentana().start();
		
		
	}
	public void refrescarVentana(ActionEvent e) {
		this.revalidate();
		this.repaint();
	}

	public Timer getTimerVentana() {
		return timerVentana;
	}

	private void setTimerVentana(Timer timerVentana) {
		this.timerVentana = timerVentana;
	}
}
