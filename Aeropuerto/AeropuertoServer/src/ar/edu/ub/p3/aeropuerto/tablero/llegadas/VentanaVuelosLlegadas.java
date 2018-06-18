package ar.edu.ub.p3.aeropuerto.tablero.llegadas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;


import ar.edu.ub.p3.aeropuerto.tablero.PanelTablero;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaVuelosLlegadas extends JDialog implements WindowListener {

	private Timer timerVentana;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Configuracion configuracion;

	public VentanaVuelosLlegadas(  Configuracion configuracion , PanelTablero<Vuelo> lista ) {
		

		this.setLayout(new GridBagLayout());
		this.setTitle("Llegadas");
		this.addWindowListener(this);
		this.setConfiguracion(configuracion);
		this.setIconImage( new ImageIcon("mainlogo/mainlogo.png").getImage() );
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel jLabelOBject = new JLabel();
		jLabelOBject.setIcon(new ImageIcon("./encabezadotablero/llegadas.png"));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(jLabelOBject,gbc);
		
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyy -  kk:mm aa");
		String fechaComoCadena = sdf.format(new Date());
		JLabel dia = new JLabel("Fecha: "+fechaComoCadena);
		
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
		

		String aeropuertolocal = this.getConfiguracion().getConfiguracion("nombreAeropuerto");
		JLabel aeropuertoActual1 = new JLabel(aeropuertolocal);
		
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		this.add(aeropuertoActual1, gbc);
		
		this.setSize(680,700);
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
	private Configuracion getConfiguracion() {
		return configuracion;
	}
	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}
}
