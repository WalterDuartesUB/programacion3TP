package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.aeropuerto.gestion.view.IFichaModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Vuelo;

 
public class PanelFichaVuelo extends JPanel implements IFichaModelo < Vuelo > {

	private ITablaModelo panelLista;
	
	private static final long serialVersionUID = 1L;
	
	private IRepositorioModelo < Vuelo > vuelos;
	
	private PanelFichaCamposVuelo panelCampos;
	private PanelFichaBotonesVuelo panelBotones;
	
	
	public PanelFichaVuelo( IRepositorioModelo < Vuelo > vuelos, IRepositorioModelo < Aeropuerto > aeropuertos,IRepositorioModelo < Avion > aviones) {
		
		setVuelos( vuelos );
		setPanelCampos ( new PanelFichaCamposVuelo( aeropuertos, aviones ));
		setPanelBotones( new PanelFichaBotonesVuelo( getVuelos() ));
		
		getPanelBotones().setPanelCampos( getPanelCampos() );
		getPanelBotones().setAeropuertos(aeropuertos);
		getPanelBotones().setAviones(aviones);
		
		setLayout( new BorderLayout() );
		setBackground(Color.BLACK);
		add(getPanelCampos() , BorderLayout.NORTH);
		add(getPanelBotones(), BorderLayout.SOUTH);
			
	}

	
	
	@Override
	public void mostrar(Vuelo dato) {
		
		getPanelCampos().getTxtIdVuelo().setText(dato.getIdVuelo());
		getPanelCampos().getComboAvion().setSelectedItem(dato.getAvion().getIdAvion());
		getPanelCampos().getComboOrigen().setSelectedItem(dato.getAeropuertoOrigen().getNombre());
		getPanelCampos().getComboDestino().setSelectedItem(dato.getAeropuertoDestino().getNombre());
		getPanelCampos().getComboEstado().setSelectedItem(dato.getEstadoVuelo());
		getPanelCampos().getTxtHoraProgramada().setText(dato.getHorarioProgramado().toString());
		
	}

	public ITablaModelo getPanelLista() {
		return panelLista;
	}

	public void setPanelLista(ITablaModelo panelLista) {
		this.panelLista = panelLista;
		getPanelBotones().setPanelLista(getPanelLista());
	}

	

	public PanelFichaCamposVuelo getPanelCampos() {
		return panelCampos;
	}

	public void setPanelCampos(PanelFichaCamposVuelo panelCampos) {
		this.panelCampos = panelCampos;
	}

	public PanelFichaBotonesVuelo getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(PanelFichaBotonesVuelo panelBotones) {
		this.panelBotones = panelBotones;
	}



	public IRepositorioModelo < Vuelo > getVuelos() {
		return vuelos;
	}



	public void setVuelos(IRepositorioModelo < Vuelo > vuelos) {
		this.vuelos = vuelos;
	}

}
