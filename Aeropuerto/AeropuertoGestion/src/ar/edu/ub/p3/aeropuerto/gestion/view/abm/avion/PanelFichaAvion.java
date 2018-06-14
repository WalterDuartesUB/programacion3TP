package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.aeropuerto.gestion.view.IFichaModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.*;

public class PanelFichaAvion extends JPanel implements IFichaModelo<Aeropuerto> {

	private ITablaModelo panelLista;
	
	private static final long serialVersionUID = 1L;
	
	private IRepositorioModelo<Aeropuerto> aeropuertos;
	
	private PanelFichaCamposAvion panelCampos;
	private PanelFichaBotonesAvion panelBotones;
	
	
	public PanelFichaAvion( IRepositorioModelo<Aeropuerto> aeropuertos) {
		
		setAeropuertos ( aeropuertos );
		setPanelCampos ( new PanelFichaCamposAvion( getAeropuertos() ));
		setPanelBotones( new PanelFichaBotonesAvion( getAeropuertos() ));
		
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

	

}
