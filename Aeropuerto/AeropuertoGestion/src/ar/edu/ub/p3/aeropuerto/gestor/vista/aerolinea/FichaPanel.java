package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;


import java.awt.BorderLayout;

import javax.swing.JPanel;

public class FichaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3801736002633384334L;

	public FichaPanel(FichaCamposPanel fichaPanel ) {
		super();
		
		this.setLayout( new BorderLayout() );
		
		this.add( fichaPanel, BorderLayout.CENTER );
		this.add( new FichaBotonesPanel(), BorderLayout.SOUTH );
	}

}
