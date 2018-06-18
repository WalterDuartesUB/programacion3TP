package ar.edu.ub.p3.aeropuerto.tablero.llegadas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto.PanelFichaAeropuerto;
import ar.edu.ub.p3.aeropuerto.tablero.PanelTablero;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class VentanaVuelosLlegadas extends JDialog {

	private Timer timerVentana;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaVuelosLlegadas(  PanelTablero<Vuelo> lista ) {
		

		this.setLayout(new GridBagLayout());
		this.setTitle("Llegadas");

		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel jLabelOBject = new JLabel();
		jLabelOBject.setIcon(new ImageIcon("./encabezadotablero/llegadas.png"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(jLabelOBject,gbc);
		
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		this.add(dia, gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 2.0;
		gbc.weighty = 2.0;
		this.add(lista,gbc);
		
		String aeropuertoActual = "Aeropuerto Actual";
		JLabel aeropuertoActual1 = new JLabel(aeropuertoActual);
		
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		this.add(aeropuertoActual1, gbc);
		
		this.setSize(680,400);
		this.setResizable(false);
		this.setVisible(true);
		
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
