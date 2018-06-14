package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.*;

public class PanelFichaCamposAeropuerto extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField 	txtNombre;
	private JTextField 	txtIdAeropuerto;
	private JTextField	txtPosicionX;
	private JTextField	txtPosicionY;
	
	private JLabel	lblIdAeropuerto;
	private JLabel	lblNombreAeropuerto;
	private JLabel	lblPosicionAeropuertoX;
	private JLabel	lblPosicionAeropuertoY;
	
	public PanelFichaCamposAeropuerto( IRepositorioModelo<Aeropuerto> aeropuertos ) {
		
		genererComponentes();
		configurarVentana();
		
	}
	
	private void genererComponentes() {
		
		setTxtIdAeropuerto( new JTextField() );
		setTxtNombre( new JTextField() );
		setTxtPosicionX( new JTextField());
		setTxtPosicionY( new JTextField());
		
		
		setLblIdAeropuerto		 ( new JLabel("        ID Aeropuerto :" ) );
		setLblNombreAeropuerto	 ( new JLabel("        Nombre Aeropuerto :") );
		setLblPosicionAeropuertoX( new JLabel("        Posicion Aeropuerto X :") );
		setLblPosicionAeropuertoY( new JLabel("        Posicion Aeropuerto Y :") );
		
		
		add( getLblIdAeropuerto());
		add( getTxtIdAeropuerto() );
		
		add( getLblNombreAeropuerto());
		add( getTxtNombre() );
		
		add( getLblPosicionAeropuertoX());
		add( getTxtPosicionX());
		
		
		add( getLblPosicionAeropuertoY());
		add( getTxtPosicionY());
		
	}

	private void configurarVentana() {
		
		setBackground(Color.BLACK);
		setLayout( new GridLayout( 4,1));

		getLblIdAeropuerto().setForeground(Color.WHITE);
		getLblNombreAeropuerto().setForeground(Color.WHITE);
		
		getTxtIdAeropuerto().setBackground(Color.DARK_GRAY);
		getTxtIdAeropuerto().setForeground(Color.WHITE);
		
		getTxtNombre().setBackground(Color.DARK_GRAY);
		getTxtNombre().setForeground(Color.WHITE);
		
		getLblPosicionAeropuertoX().setBackground(Color.BLACK);
		getLblPosicionAeropuertoY().setBackground(Color.BLACK);
		
		getLblPosicionAeropuertoX().setForeground(Color.WHITE);
		getLblPosicionAeropuertoY().setForeground(Color.WHITE);
		
		
		getTxtPosicionX().setBackground(Color.DARK_GRAY);
		getTxtPosicionX().setForeground(Color.WHITE);
		
		getTxtPosicionY().setBackground(Color.DARK_GRAY);
		getTxtPosicionY().setForeground(Color.WHITE);
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

	public JLabel getLblPosicionAeropuertoX() {
		return lblPosicionAeropuertoX;
	}

	public void setLblPosicionAeropuertoX(JLabel lblPosicionAeropuertoX) {
		this.lblPosicionAeropuertoX = lblPosicionAeropuertoX;
	}

	public JLabel getLblPosicionAeropuertoY() {
		return lblPosicionAeropuertoY;
	}

	public void setLblPosicionAeropuertoY(JLabel lblPosicionAeropuertoY) {
		this.lblPosicionAeropuertoY = lblPosicionAeropuertoY;
	}

	public JTextField getTxtPosicionX() {
		return txtPosicionX;
	}

	public void setTxtPosicionX(JTextField txtPosicionX) {
		this.txtPosicionX = txtPosicionX;
	}

	public JTextField getTxtPosicionY() {
		return txtPosicionY;
	}

	public void setTxtPosicionY(JTextField txtPosicionY) {
		this.txtPosicionY = txtPosicionY;
	}

}
