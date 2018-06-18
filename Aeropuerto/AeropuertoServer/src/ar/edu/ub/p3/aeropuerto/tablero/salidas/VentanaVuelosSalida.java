package ar.edu.ub.p3.aeropuerto.tablero.salidas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

public class VentanaVuelosSalida extends JDialog implements WindowListener{

	private Timer timerVentana;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaVuelosSalida(  PanelTablero<Vuelo> lista ) {
		

		this.setLayout(new GridBagLayout());
		this.setTitle("Salidas");
		this.addWindowListener(this);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JLabel jLabelObject = new JLabel();
		jLabelObject.setIcon(new ImageIcon("./encabezadotablero/salidas.png"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(jLabelObject, gbc);
		
		
		String date = new Date().toString();
		JLabel dia = new JLabel(date); //  cambiar
		
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
		this.add(lista, gbc);
		
		
		String aeropuertoactual= "Aeropuerto Local";
		JLabel aeropuertoactuall = new JLabel(aeropuertoactual);
		
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		this.add(aeropuertoactuall, gbc);
		
		//add(lista);
		//setSize(800, 320); 
		this.setSize(680,400);
		setResizable(true);
		setVisible(true);
		//setLocationRelativeTo(null);
		setTimerVentana(new Timer(1000,this::refrescarVentana));
		this.getTimerVentana().start();
		
		
	}
	public void refrescarVentana(ActionEvent e) {
		this.revalidate();
		this.repaint();
		System.out.println("Sigo Vivo");
	}

	public Timer getTimerVentana() {
		return timerVentana;
	}

	private void setTimerVentana(Timer timerVentana) {
		this.timerVentana = timerVentana;
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {

			this.getTimerVentana().stop();

		
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
