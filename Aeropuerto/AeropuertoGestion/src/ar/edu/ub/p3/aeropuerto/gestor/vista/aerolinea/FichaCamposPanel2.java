package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.interfaz.IAerolinea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

public class FichaCamposPanel2 extends FichaCamposPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5322608080892445470L;
	
	private FichaPanel fichaPanel;
	
	
	private JTextField txtidAerolinea;
	private JComboBox<String> comboAerolinea;
	
	public FichaCamposPanel2( FichaPanel fichaPanel ){
		this.setLayout( new BorderLayout() );
		
		setFichaPanel(fichaPanel);
				
		JPanel panelCampos = new JPanel();
		panelCampos.setBackground(Color.DARK_GRAY);
		
		
		
		JComboBox<String> comboAerolinea = new JComboBox<String>();
		comboAerolinea.setToolTipText("Aerolineas");
		for(IAerolinea aerolinea : getFichaPanel().getFicha().getConexion().getAerolineas()) 
			comboAerolinea.addItem(aerolinea.getNombre());
		
		
		comboAerolinea.setBackground(Color.DARK_GRAY);
		comboAerolinea.setForeground(Color.WHITE);
		panelCampos.setLayout( new GridLayout( 3,2));
		
		JLabel label = new JLabel("ID_Aerolinea    ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBackground(Color.DARK_GRAY);
		panelCampos.add( label);
		
		
		setTxtidAerolinea(new JTextField());
		getTxtidAerolinea().setBackground(Color.DARK_GRAY);
		getTxtidAerolinea().setForeground(Color.WHITE);
		panelCampos.add( getTxtidAerolinea() );
		
		
		
		JLabel label_2 = new JLabel("Aerolinea    ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(Color.DARK_GRAY);
		panelCampos.add( label_2 );
		panelCampos.add( comboAerolinea );		
		
		comboAerolinea.addItem("Aerolineas Argentinas");
		comboAerolinea.addItem("American Airlines");
		this.add( panelCampos, BorderLayout.NORTH );
	}

	
	
	
	
	public FichaPanel getFichaPanel() {
		return fichaPanel;
	}

	public void setFichaPanel(FichaPanel fichaPanel) {
		this.fichaPanel = fichaPanel;
	}



	public void selectComboAerolineabyString( String aerolineaBuscada  ) {
		
		
		
		for (int i =0; i< getComboAerolinea().countComponents() ;i++)
			if (getComboAerolinea().getItemAt(i) == aerolineaBuscada)
				getComboAerolinea().setSelectedIndex(i);
		
		
	}
	


	public JTextField getTxtidAerolinea() {
		return txtidAerolinea;
	}





	public void setTxtidAerolinea(JTextField txtidAerolinea) {
		this.txtidAerolinea = txtidAerolinea;
	}





	public JComboBox<String> getComboAerolinea() {
		return comboAerolinea;
	}





	public void setComboAerolinea(JComboBox<String> comboAerolinea) {
		this.comboAerolinea = comboAerolinea;
	}
	
	
	
	

}
