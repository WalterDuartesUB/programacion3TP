package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAerolinea;

import java.awt.Color;
import javax.swing.SwingConstants;

public class FichaCamposPanel2 extends FichaCamposPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5322608080892445470L;
	
	public FichaCamposPanel2(ConexionAeropuerto conexion){
		this.setLayout( new BorderLayout() );
		
		JPanel panelCampos = new JPanel();
		panelCampos.setBackground(Color.DARK_GRAY);
		JComboBox<String> comboAerolinea = new JComboBox<String>();
		
		for(IAerolinea aerolinea : conexion.getAerolineas()) 
			comboAerolinea.addItem(aerolinea.getNombre());
		
		
		comboAerolinea.setBackground(Color.DARK_GRAY);
		comboAerolinea.setForeground(Color.WHITE);
		panelCampos.setLayout( new GridLayout( 3,2));
		
		JLabel label = new JLabel("ID_Aerolinea    ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBackground(Color.DARK_GRAY);
		panelCampos.add( label);
		
		
		JTextField textField_1 = new JTextField();
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setForeground(Color.WHITE);
		panelCampos.add( textField_1);
		
		
		
		JLabel label_2 = new JLabel("Aerolinea    ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(Color.DARK_GRAY);
		panelCampos.add( label_2);
		panelCampos.add( comboAerolinea );		
		
		comboAerolinea.addItem("Aerolineas Argentinas");
		comboAerolinea.addItem("American Airlines");
		this.add( panelCampos, BorderLayout.NORTH );
	}
	
	
	
	

}
