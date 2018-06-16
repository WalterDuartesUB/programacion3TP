package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.aeropuerto.gestion.view.IFichaModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
 

public class PanelFichaAeropuerto extends JPanel implements IFichaModelo<Aeropuerto> {

	private ITablaModelo panelLista;
	
	private static final long serialVersionUID = 1L;
	
	private IRepositorioModelo<Aeropuerto> aeropuertos;
	
	private PanelFichaCamposAeropuerto panelCampos;
	private PanelFichaBotonesAeropuerto panelBotones;
	
	
	public PanelFichaAeropuerto( IRepositorioModelo<Aeropuerto> aeropuertos) {
		
		setAeropuertos ( aeropuertos );
		setPanelCampos ( new PanelFichaCamposAeropuerto( getAeropuertos() ));
		setPanelBotones( new PanelFichaBotonesAeropuerto( getAeropuertos() ));
		
		getPanelBotones().setPanelCampos( getPanelCampos() );
		
		setLayout( new BorderLayout() );
		setBackground(Color.BLACK);
		add(getPanelCampos() , BorderLayout.NORTH);
		add(getPanelBotones(), BorderLayout.SOUTH);
			
	}

	
	
	@Override
	public void mostrar(Aeropuerto dato) {
		
		getPanelCampos().getTxtIdAeropuerto().setText( dato.getIdAeropuerto() );		
		getPanelCampos().getTxtNombre().setText( dato.getNombre() );	
		getPanelCampos().getTxtPosicionX().setText( Double.toString(dato.getPosicion().getX()) );
		getPanelCampos().getTxtPosicionY().setText( Double.toString(dato.getPosicion().getY()) );
		
	}

	public ITablaModelo getPanelLista() {
		return panelLista;
	}

	public void setPanelLista(ITablaModelo panelLista) {
		this.panelLista = panelLista;
		getPanelBotones().setPanelLista(getPanelLista());
	}

	public IRepositorioModelo<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(IRepositorioModelo<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public PanelFichaCamposAeropuerto getPanelCampos() {
		return panelCampos;
	}

	public void setPanelCampos(PanelFichaCamposAeropuerto panelCampos) {
		this.panelCampos = panelCampos;
	}

	public PanelFichaBotonesAeropuerto getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelFichaBotonesAeropuerto panelBotones) {
		this.panelBotones = panelBotones;
	}

	

}
