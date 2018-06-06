package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;

import java.awt.BorderLayout;

import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class FichaCamposPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6320439589745594208L;

	public FichaCamposPanel() {
		super();
		setBackground(Color.DARK_GRAY);
		
		this.setLayout( new BorderLayout() );
		
		JPanel panelCampos = new JPanel();
		panelCampos.setBackground(Color.DARK_GRAY);
		panelCampos.setLayout( new GridLayout( 3,2));
		
		JLabel label_1 = new JLabel("id");
		label_1.setForeground(Color.WHITE);
		panelCampos.add( label_1);
		JTextField textField_1 = new JTextField();
		textField_1.setBackground(Color.DARK_GRAY);
		panelCampos.add( textField_1);
		JLabel label = new JLabel("nombre");
		label.setForeground(Color.WHITE);
		panelCampos.add( label);
		JTextField textField = new JTextField();
		textField.setBackground(Color.DARK_GRAY);
		panelCampos.add( textField);		
		
		this.add( panelCampos, BorderLayout.NORTH );
	
		
	}

}
