package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;


import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;

import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.aeropuerto.gestion.view.IFichaModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;

 
public class PanelFichaAvion extends JPanel implements IFichaModelo < Avion > {

	private ITablaModelo panelLista;
	
	private static final long serialVersionUID = 1L;
	
	private IRepositorioModelo < Avion > aviones;
	private Map < String , Aerolinea > aerolineas;
	
	private PanelFichaCamposAvion panelCampos;
	private PanelFichaBotonesAvion panelBotones;
	
	
	public PanelFichaAvion( IRepositorioModelo < Avion > aviones , Map < String , Aerolinea > aerolineas ) {
		setAviones( aviones ); 
		setAerolineas( aerolineas );
		setPanelCampos ( new PanelFichaCamposAvion( getAerolineas() ));
		setPanelBotones( new PanelFichaBotonesAvion( getAviones(), getAerolineas() ));
		
		getPanelBotones().setPanelCampos( getPanelCampos() );
		
		setLayout( new BorderLayout() );
		setBackground(Color.BLACK);
		
		add(getPanelCampos() , BorderLayout.NORTH);
		add(getPanelBotones(), BorderLayout.SOUTH);
			
	}

	
	
	@Override
	public void mostrar( Avion dato ) {
		
		getPanelCampos().getTxtIdAvion().setText( dato.getIdAvion() );
		getPanelCampos().getComboNombreAerolinea().setSelectedItem(dato.getAerolinea().getNombre());
		getPanelCampos().getTxtPosicionX().setText(Double.toString(dato.getPosicion().getX()) );
		getPanelCampos().getTxtPosicionY().setText(Double.toString(dato.getPosicion().getY()) );
	
		
	}

	public ITablaModelo getPanelLista() {
		return panelLista;
	}

	public void setPanelLista(ITablaModelo panelLista) {
		this.panelLista = panelLista;
		getPanelBotones().setPanelLista(getPanelLista());
	}

	

	public PanelFichaCamposAvion getPanelCampos() {
		return panelCampos;
	}

	public void setPanelCampos(PanelFichaCamposAvion panelCampos) {
		this.panelCampos = panelCampos;
	}

	public PanelFichaBotonesAvion getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelFichaBotonesAvion panelBotones) {
		this.panelBotones = panelBotones;
	}



	public IRepositorioModelo < Avion > getAviones() {
		return aviones;
	}



	public void setAviones(IRepositorioModelo < Avion > aviones) {
		this.aviones = aviones;
	}



	public Map < String , Aerolinea > getAerolineas() {
		return aerolineas;
	}



	public void setAerolineas(Map < String , Aerolinea > aerolineas) {
		this.aerolineas = aerolineas;
	}







	

}
