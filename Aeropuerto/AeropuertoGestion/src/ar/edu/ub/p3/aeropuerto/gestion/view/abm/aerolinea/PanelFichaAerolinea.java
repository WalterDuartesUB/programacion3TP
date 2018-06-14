package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.aeropuerto.gestion.view.IFichaModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.*;

public class PanelFichaAerolinea extends JPanel implements IFichaModelo < Aerolinea > {

	private ITablaModelo panelLista;
	
	private static final long serialVersionUID = 1L;
	
	private IRepositorioModelo < Aerolinea > aerolineas;
	
	private PanelFichaCamposAerolinea panelCampos;
	private PanelFichaBotonesAerolinea panelBotones;
	
	
	public PanelFichaAerolinea( IRepositorioModelo < Aerolinea > aerolineas) {
		
		setAerolineas( aerolineas );
		setPanelCampos ( new PanelFichaCamposAerolinea( getAerolineas() ));
		setPanelBotones( new PanelFichaBotonesAerolinea( getAerolineas() ));
		
		getPanelBotones().setPanelCampos( getPanelCampos() );
		
		setLayout( new BorderLayout() );
		setBackground(Color.BLACK);
		add(getPanelCampos() , BorderLayout.NORTH);
		add(getPanelBotones(), BorderLayout.SOUTH);
			
	}

	
	
	@Override
	public void mostrar(Aerolinea dato) {
		
		getPanelCampos().getTxtIdAerolineas().setText( dato.getIdAerolinea() );
		getPanelCampos().getTxtNombre().setText( dato.getNombre());		
		
	}

	public ITablaModelo getPanelLista() {
		return panelLista;
	}

	public void setPanelLista(ITablaModelo panelLista) {
		this.panelLista = panelLista;
		getPanelBotones().setPanelLista(getPanelLista());
	}

	

	public PanelFichaCamposAerolinea getPanelCampos() {
		return panelCampos;
	}

	public void setPanelCampos(PanelFichaCamposAerolinea panelCampos) {
		this.panelCampos = panelCampos;
	}

	public PanelFichaBotonesAerolinea getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelFichaBotonesAerolinea panelBotones) {
		this.panelBotones = panelBotones;
	}



	public IRepositorioModelo<Aerolinea> getAerolineas() {
		return aerolineas;
	}



	public void setAerolineas(IRepositorioModelo<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}


	

}
