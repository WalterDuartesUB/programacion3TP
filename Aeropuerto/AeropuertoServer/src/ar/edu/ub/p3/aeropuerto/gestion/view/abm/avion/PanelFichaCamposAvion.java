package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.modelo.Aerolinea;

 

public class PanelFichaCamposAvion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JComboBox <String> 	comboNombreAerolinea;
	private JTextField 			txtIdAvion;

	private JLabel 	lblIdAviones;
	private JLabel 	lblNombreAerolinea;

	
	private Map < String , Aerolinea > aerolineas;
	
	public PanelFichaCamposAvion(  Map < String , Aerolinea > aerolineas ) {
		
		System.out.println(aerolineas);
		setAerolineas(aerolineas);
		genererComponentes();
		configurarVentana();
		
	}
	
	private void genererComponentes() {
		
		setTxtIdAvion( new JTextField() );
		setComboNombreAerolinea( new JComboBox <String> ( ) );
		agregarItemsEnComboAerolineas();

		setLblIdAviones( new JLabel("        ID Avion :" ) );
		setLblNombreAerolinea( new JLabel("        Nombre Aerolinea :") );

		add( getLblIdAviones());
		add( getTxtIdAvion() );
		
		add( getLblNombreAerolinea());
		add( getComboNombreAerolinea() );

		
	}

	private void agregarItemsEnComboAerolineas() {
		
		for(Aerolinea aerolinea : getAerolineas().values())
			getComboNombreAerolinea().addItem(aerolinea.getNombre());
		 
		
	}

	private void configurarVentana() {
		
		setBackground(Color.BLACK);
		setLayout( new GridLayout( 2,2));

		getLblIdAviones().setForeground(Color.WHITE);
		getLblNombreAerolinea().setForeground(Color.WHITE);
		
		getTxtIdAvion().setBackground(Color.DARK_GRAY);
		getTxtIdAvion().setForeground(Color.WHITE);
		
		getComboNombreAerolinea().setBackground(Color.DARK_GRAY);
		getComboNombreAerolinea().setForeground(Color.WHITE);
		
		
	}


	public JTextField getTxtIdAvion() {
		return txtIdAvion;
	}

	public void setTxtIdAvion(JTextField txtIdAviones) {
		this.txtIdAvion = txtIdAviones;
	}

	public JLabel getLblIdAviones() {
		return lblIdAviones;
	}

	public void setLblIdAviones(JLabel lblIdAviones) {
		this.lblIdAviones = lblIdAviones;
	}

	public JLabel getLblNombreAerolinea() {
		return lblNombreAerolinea;
	}

	public void setLblNombreAerolinea(JLabel lblNombreAerolinea) {
		this.lblNombreAerolinea = lblNombreAerolinea;
	}

	public Map < String , Aerolinea > getAerolineas() {
		return aerolineas;
	}

	public void setAerolineas(Map < String , Aerolinea > aerolineas) {
		this.aerolineas = aerolineas;
	}

	public JComboBox <String> getComboNombreAerolinea() {
		return comboNombreAerolinea;
	}

	public void setComboNombreAerolinea(JComboBox <String> comboNombreAerolinea) {
		this.comboNombreAerolinea = comboNombreAerolinea;
	}

}
