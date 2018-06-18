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
	private PanelFichaCamposDateVuelo panelFecha;
	
	public PanelFichaVuelo( IRepositorioModelo < Vuelo > vuelos, IRepositorioModelo < Aeropuerto > aeropuertos,IRepositorioModelo < Avion > aviones) {
		
		setVuelos( vuelos );
		setPanelCampos ( new PanelFichaCamposVuelo( aeropuertos, aviones ));
		setPanelBotones( new PanelFichaBotonesVuelo( getVuelos() ));
		setPanelFecha( new PanelFichaCamposDateVuelo());
		
		getPanelBotones().setPanelCampos( getPanelCampos() );
		getPanelBotones().setPanelFecha(getPanelFecha());
		getPanelBotones().setAeropuertos(aeropuertos);
		getPanelBotones().setAviones(aviones);
		
		setLayout( new BorderLayout() );
		setBackground(Color.BLACK);
		add(getPanelCampos() , BorderLayout.NORTH);
		add(getPanelFecha(),BorderLayout.LINE_END);
		add(getPanelBotones(), BorderLayout.SOUTH);
			
	}

	
	
	@SuppressWarnings("deprecation")
	@Override
	public void mostrar(Vuelo dato) {
		
		getPanelCampos().getTxtIdVuelo().setText(dato.getIdVuelo());
		getPanelCampos().getComboAvion().setSelectedItem(dato.getAvion().getIdAvion());
		getPanelCampos().getComboOrigen().setSelectedItem(dato.getAeropuertoOrigen().getNombre());
		getPanelCampos().getComboDestino().setSelectedItem(dato.getAeropuertoDestino().getNombre());
		getPanelCampos().getComboEstado().setSelectedItem(dato.getEstadoVuelo());
		
		getPanelFecha().getComboAnio().setSelectedItem(dato.getHorarioProgramado().getYear()-100);
		getPanelFecha().getComboMes().setSelectedItem(dato.getHorarioProgramado().getMonth()+1);
		getPanelFecha().getComboDia().setSelectedItem(dato.getHorarioProgramado().getDate());
		getPanelFecha().getComboHora().setSelectedItem(dato.getHorarioProgramado().getHours());
		getPanelFecha().getComboMinutos().setSelectedItem(dato.getHorarioProgramado().getMinutes());
		
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



	public PanelFichaCamposDateVuelo getPanelFecha() {
		return panelFecha;
	}



	public void setPanelFecha(PanelFichaCamposDateVuelo panelFecha) {
		this.panelFecha = panelFecha;
	}

}
