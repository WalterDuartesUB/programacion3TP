package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;


import java.awt.BorderLayout;

import javax.swing.JPanel;

public class FichaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3801736002633384334L;

	private FichaCamposPanel2	fichaCamposPanel;
	private FichaBotonesPanel	fichaBotonesPanel;
	private FichaConListaView	ficha;
	
	public FichaPanel( FichaConListaView ficha  ) {
		super();
		
		setFicha(ficha);
		
		configurarPanel(  );
		
		this.setLayout( new BorderLayout() );
		
		this.add( getFichaCampospanel() , BorderLayout.CENTER );
		this.add( getFichaBotonesPanel() , BorderLayout.SOUTH );
	}

	private void configurarPanel() {
		
		setFichaBotonesPanel( new FichaBotonesPanel( this ) );
		setFichapanel( new FichaCamposPanel2( this ) );
	}

	public FichaCamposPanel2 getFichaCampospanel() {
		return fichaCamposPanel;
	}

	public void setFichapanel(FichaCamposPanel2 fichapanel) {
		this.fichaCamposPanel = fichapanel;
	}

	public FichaBotonesPanel getFichaBotonesPanel() {
		return fichaBotonesPanel;
	}

	public void setFichaBotonesPanel(FichaBotonesPanel fichaBotonesPanel) {
		this.fichaBotonesPanel = fichaBotonesPanel;
	}

	public FichaConListaView getFicha() {
		return ficha;
	}

	public void setFicha(FichaConListaView ficha) {
		this.ficha = ficha;
	}

}
