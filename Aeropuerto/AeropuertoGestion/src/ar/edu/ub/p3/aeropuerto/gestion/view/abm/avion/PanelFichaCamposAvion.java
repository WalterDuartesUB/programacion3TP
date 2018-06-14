package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.*;

public class PanelFichaCamposAvion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombre;
	private JTextField txtIdAeropuerto;
	
	private JLabel lblIdAeropuerto;
	private JLabel lblNombreAeropuerto;
	
	public PanelFichaCamposAvion( IRepositorioModelo<Aeropuerto> aeropuertos ) {
		
		genererComponentes();
		configurarVentana();
		
	}
	
	private void genererComponentes() {
		
		setTxtIdAeropuerto( new JTextField() );
		setTxtNombre( new JTextField() );
		
		setLblIdAeropuerto( new JLabel("        ID AEROPUERTO" ) );
		setLblNombreAeropuerto( new JLabel("        NOMBRE AEROPUERTO") );
		
		add( getLblIdAeropuerto());
		add( getTxtIdAeropuerto() );
		
		add( getLblNombreAeropuerto());
		add( getTxtNombre() );
	}

	private void configurarVentana() {
		
		setBackground(Color.BLACK);
		setLayout( new GridLayout( 3,2));

		getLblIdAeropuerto().setForeground(Color.WHITE);
		getLblNombreAeropuerto().setForeground(Color.WHITE);
		
		getTxtIdAeropuerto().setBackground(Color.BLACK);
		getTxtIdAeropuerto().setForeground(Color.WHITE);
		
		getTxtNombre().setBackground(Color.BLACK);
		getTxtNombre().setForeground(Color.WHITE);
		
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtIdAeropuerto() {
		return txtIdAeropuerto;
	}
	public void setTxtIdAeropuerto(JTextField txtIdAeropuerto) {
		this.txtIdAeropuerto = txtIdAeropuerto;
	}

	public JLabel getLblIdAeropuerto() {
		return lblIdAeropuerto;
	}

	public void setLblIdAeropuerto(JLabel lblIdAeropuerto) {
		this.lblIdAeropuerto = lblIdAeropuerto;
	}

	public JLabel getLblNombreAeropuerto() {
		return lblNombreAeropuerto;
	}

	public void setLblNombreAeropuerto(JLabel lblNombreAeropuerto) {
		this.lblNombreAeropuerto = lblNombreAeropuerto;
	}

}
