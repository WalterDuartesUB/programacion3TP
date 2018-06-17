package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.Aerolinea;
 

public class PanelFichaCamposAerolinea extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNombre;
	private JTextField txtIdAerolineas;
	
	private JLabel lblIdAerolineas;
	private JLabel lblNombreAerolineas;
	
	public PanelFichaCamposAerolinea( IRepositorioModelo<Aerolinea> aerolineas ) {
		
		genererComponentes();
		configurarVentana();
		
	}
	
	private void genererComponentes() {
		
		setTxtIdAerolineas( new JTextField() );
		setTxtNombre( new JTextField() );
		
		setLblIdAerolineas( new JLabel("        Id Aerolinea" ) );
		setLblNombreAerolineas( new JLabel("        Nombre Aerolinea") );
		
		add( getLblIdAerolineas());
		add( getTxtIdAerolineas() );
		
		add( getLblNombreAerolineas());
		add( getTxtNombre() );
		
	}

	private void configurarVentana() {
		
		setBackground(Color.BLACK);
		setLayout( new GridLayout( 3,2));

		getLblIdAerolineas().setForeground(Color.WHITE);
		getLblNombreAerolineas().setForeground(Color.WHITE);
		
		getTxtIdAerolineas().setBackground(Color.DARK_GRAY);
		getTxtIdAerolineas().setForeground(Color.WHITE);
		
		getTxtNombre().setBackground(Color.DARK_GRAY);
		getTxtNombre().setForeground(Color.WHITE);
		
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtIdAerolineas() {
		return txtIdAerolineas;
	}

	public void setTxtIdAerolineas(JTextField txtIdAerolineas) {
		this.txtIdAerolineas = txtIdAerolineas;
	}

	public JLabel getLblIdAerolineas() {
		return lblIdAerolineas;
	}

	public void setLblIdAerolineas(JLabel lblIdAerolineas) {
		this.lblIdAerolineas = lblIdAerolineas;
	}

	public JLabel getLblNombreAerolineas() {
		return lblNombreAerolineas;
	}

	public void setLblNombreAerolineas(JLabel lblNombreAerolineas) {
		this.lblNombreAerolineas = lblNombreAerolineas;
	}	

}
