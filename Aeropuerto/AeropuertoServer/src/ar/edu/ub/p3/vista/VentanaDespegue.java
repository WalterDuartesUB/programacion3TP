package ar.edu.ub.p3.vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaDespegue extends JDialog implements WindowListener {



	/**
	 * 
	 */
	private static final long serialVersionUID = -7253803356902721825L;
	
	
	private IAeropuerto aeropuerto;
	private ConexionTraficoAereo conexionTA;
	private Configuracion configuracion;
	private PanelDespegue panelDespegue;
	private LabelDia		diaDeHoy;

	public VentanaDespegue(Configuracion configuracion, IAeropuerto aeropuerto, ConexionTraficoAereo conexionTA) {
		
		Timer timer = new Timer(1000, this::actualizar);
		timer.start();
		
		this.setAeropuerto(aeropuerto);
		this.setConexionTA(conexionTA);
		this.setConfiguracion(configuracion);
		
		this.setTitle("Despegues");
		//this.setLayout(new GridBagLayout());
		this.setSize(580,400);
		this.setPanelDespegue( new PanelDespegue( this.getConfiguracion(), this.getAeropuerto().getIdAeropuerto(), this.getConexionTA() ));
		this.setDiaDeHoy(new LabelDia(this.getConfiguracion()));
		this.addWindowListener(this);
		this.setVisible(true);	
		
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);
		
		JLabel jLabelObject = new JLabel();
		jLabelObject.setIcon(new ImageIcon("./encabezadotablero/salidas.png"));

		
		//String date = new Date().toString();
		//JLabel dia = new JLabel(date);
		
		String aeropuertoactual= this.getAeropuerto().getIdAeropuerto().toString()+"-"+this.getAeropuerto().getNombre().toString();
		JLabel aeropuertoactuall = new JLabel(aeropuertoactual);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(jLabelObject, gbc);
		
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(this.getDiaDeHoy(), gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 2;		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 2.0;
		gbc.weighty = 2.0;
		panel.add(this.getPanelDespegue(), gbc);
		
		gbc.fill = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(aeropuertoactuall, gbc);
		

	}
	
	
	public void actualizar (ActionEvent arg0) {
	
		this.validate();
		this.repaint();
	}
	
	public IAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	private void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
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

	public PanelDespegue getPanelDespegue() {
		return panelDespegue;
	}

	private void setPanelDespegue(PanelDespegue panelDespegue) {
		this.panelDespegue = panelDespegue;
	}
	
	public LabelDia getDiaDeHoy() {
		return diaDeHoy;
	}
	
	public void setDiaDeHoy(LabelDia diaDeHoy) {
		this.diaDeHoy = diaDeHoy;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		try {
			this.getPanelDespegue().close();
			this.getDiaDeHoy().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




}
