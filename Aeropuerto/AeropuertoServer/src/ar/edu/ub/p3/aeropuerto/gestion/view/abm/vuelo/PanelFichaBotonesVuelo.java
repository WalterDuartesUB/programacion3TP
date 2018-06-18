package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.EstadoVuelo;
import ar.edu.ub.p3.modelo.Vuelo;
 

public class PanelFichaBotonesVuelo extends JPanel{

	private static final long serialVersionUID = 1L;
	private VentanaGestionABMVuelo ventanaPrincipal;
	
	private ITablaModelo panelLista;
	private PanelFichaCamposVuelo panelCampos;
	private PanelFichaCamposDateVuelo panelFecha;

	private IRepositorioModelo<Aeropuerto> aeropuertos;
	private IRepositorioModelo<Avion> aviones;
	private IRepositorioModelo<Vuelo> vuelos;

	private JButton btnActualizar;
	private JButton btnAgregar;
	private JButton btnGrabar;
	private JButton btnBorrar;
	private JButton btnSalir;
	
	public PanelFichaBotonesVuelo( IRepositorioModelo<Vuelo> vuelos ) {
		
		setVuelos(vuelos);
		
		generarComponentes();
		configurarVentana();
		
	}
	
	
	private void generarComponentes() {
		
		setBtnActualizar( new JButton("Refrescar"));
		setBtnAgregar( new JButton("Nuevo"));
		setBtnGrabar ( new JButton("Grabar"));
		setBtnBorrar ( new JButton("Borrar"));
		setBtnSalir  ( new JButton("Salir") );
		
		add( getBtnActualizar());
		add( getBtnAgregar() );
		add( getBtnBorrar() );
		add( getBtnGrabar());
		add( getBtnSalir());
		
		getBtnActualizar().addActionListener( this::onClickBtnActualizar);
		getBtnBorrar().addActionListener ( this::onClickBtnBorrar );
		getBtnAgregar().addActionListener( this::onClickBtnAgregar);
		getBtnGrabar().addActionListener ( this::onClickBtnGrabar );
		getBtnSalir().addActionListener ( this::onClickBtnSalir );
	}


	private void configurarVentana() {
		
		setBackground(Color.BLACK);
		setLayout( new FlowLayout());
		
		getBtnAgregar().setForeground(Color.WHITE);
		getBtnAgregar().setBackground(Color.BLACK);
		
		getBtnBorrar().setForeground(Color.WHITE);
		getBtnBorrar().setBackground(Color.BLACK);
		
		getBtnGrabar().setForeground(Color.WHITE);
		getBtnGrabar().setBackground(Color.BLACK);
		
		getBtnSalir().setForeground(Color.WHITE);
		getBtnSalir().setBackground(Color.BLACK);
		
		getBtnActualizar().setForeground(Color.WHITE);
		getBtnActualizar().setBackground(Color.BLACK);		
	}

	
	public void onClickBtnActualizar(ActionEvent arg0) {
		
		
		getPanelCampos().getTxtIdVuelo().setText("");
		getPanelCampos().getComboAvion().setSelectedIndex(-1);
		getPanelCampos().getComboDestino().setSelectedIndex(-1);
		getPanelCampos().getComboEstado().setSelectedIndex(-1);
		getPanelCampos().getComboOrigen().setSelectedIndex(-1);
		
		getPanelFecha().getComboAnio().setSelectedIndex(-1);
		getPanelFecha().getComboDia().setSelectedIndex(-1);
		getPanelFecha().getComboHora().setSelectedIndex(-1);
		getPanelFecha().getComboMes().setSelectedIndex(-1);
		getPanelFecha().getComboMinutos().setSelectedIndex(-1);
		
		getPanelLista().refrescar();
		
		
	}

	public void onClickBtnAgregar(ActionEvent arg0) {
		getVuelos().add(vueloEnCampo());
		
		getPanelLista().refrescar();		
	}
	
	
	public void onClickBtnBorrar(ActionEvent arg0) {
		getVuelos().delete(vueloEnCampo());
		
		getPanelLista().refrescar();		
		
	}
	
	public void onClickBtnGrabar(ActionEvent arg0) {
		
		getVuelos().modify(vueloEnCampo());
		getPanelLista().refrescar();
		
	}
	
	@SuppressWarnings("deprecation")
	public Vuelo vueloEnCampo() {
		
	
		return new Vuelo(
					getPanelCampos().getTxtIdVuelo().getText(),
					buscarAvion(getPanelCampos().getComboAvion().getSelectedItem().toString()), 
					buscarAeropuerto(getPanelCampos().getComboOrigen().getSelectedItem().toString()), 
					buscarAeropuerto(getPanelCampos().getComboDestino().getSelectedItem().toString()), 
					new Date(
							(Integer)getPanelFecha().getComboAnio().getSelectedItem()+100,
							(Integer)getPanelFecha().getComboMes().getSelectedItem()-1,
							(Integer)getPanelFecha().getComboDia().getSelectedItem(),
							(Integer)getPanelFecha().getComboHora().getSelectedItem(),
							(Integer)getPanelFecha().getComboMinutos().getSelectedItem()),
					new Date(), 
					new Date(), 
					(EstadoVuelo)getPanelCampos().getComboEstado().getSelectedItem());
	}
	//
public  Avion buscarAvion(String dato) {
		
		for(Avion avion : getAviones().getList())
			if(avion.getIdAvion().equals(dato))
				return avion;
		
		return null;
	}


public  Aeropuerto buscarAeropuerto(String dato) {
	
	for(Aeropuerto aeropuerto: getAeropuertos().getList())
		if(aeropuerto.getNombre().equals(dato))
			return aeropuerto;
	
	return null;
}


	
	public void onClickBtnSalir(ActionEvent arg0) {
		
		getVentanaPrincipal().dispose();	
		
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}


	public PanelFichaCamposVuelo getPanelCampos() {
		return panelCampos;
	}


	public void setPanelCampos(PanelFichaCamposVuelo panelCampos) {
		this.panelCampos = panelCampos;
	}




	public JButton getBtnGrabar() {
		return btnGrabar;
	}


	public void setBtnGrabar(JButton btnGrabar) {
		this.btnGrabar = btnGrabar;
	}


	public ITablaModelo getPanelLista() {
		return panelLista;
	}


	public void setPanelLista(ITablaModelo panelLista) {
		this.panelLista = panelLista;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}


	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


	public VentanaGestionABMVuelo getVentanaPrincipal() {
		return ventanaPrincipal;
	}


	public void setVentanaPrincipal(VentanaGestionABMVuelo ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}


	public JButton getBtnActualizar() {
		return btnActualizar;
	}


	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}


	public IRepositorioModelo<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}


	public void setAeropuertos(IRepositorioModelo<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}


	public IRepositorioModelo<Avion> getAviones() {
		return aviones;
	}


	public void setAviones(IRepositorioModelo<Avion> aviones) {
		this.aviones = aviones;
	}


	public IRepositorioModelo<Vuelo> getVuelos() {
		return vuelos;
	}


	public void setVuelos(IRepositorioModelo<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}


	public PanelFichaCamposDateVuelo getPanelFecha() {
		return panelFecha;
	}


	public void setPanelFecha(PanelFichaCamposDateVuelo panelFecha) {
		this.panelFecha = panelFecha;
	}
	

}
