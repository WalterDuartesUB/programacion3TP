package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class FichaBotonesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4758493507936529253L;

	private FichaPanel	fichaPanel;
	
	public FichaBotonesPanel( FichaPanel fichaPanel ) {
		super();
		
		setFichaPanel(fichaPanel);
		
		setBackground(Color.DARK_GRAY);
		
		this.setLayout( new FlowLayout());
		
		JButton button = new JButton("Nuevo");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.DARK_GRAY);
		this.add( button);
		JButton button_1 = new JButton("Borrar");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.DARK_GRAY);
		this.add( button_1);
		JButton button_2 = new JButton("Grabar");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.DARK_GRAY);
		this.add( button_2);
		JButton button_3 = new JButton("Salir");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.DARK_GRAY);
		this.add( button_3);
	}

	public FichaPanel getFichaPanel() {
		return fichaPanel;
	}

	public void setFichaPanel(FichaPanel fichaPanel) {
		this.fichaPanel = fichaPanel;
	}

}
