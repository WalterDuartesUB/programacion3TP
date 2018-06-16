package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;
 

public class PanelFichaBotonesAvion extends JPanel{

	private static final long serialVersionUID = 1L;
	private VentanaGestionABMAvion ventanaPrincipal;
	
	private ITablaModelo panelLista;
	private PanelFichaCamposAvion panelCampos;
	private IRepositorioModelo< Avion > aviones;
	private Map <String,Aerolinea> aerolineas;
	
	private JButton btnActualizar;
	private JButton btnAgregar;
	private JButton btnGrabar;
	private JButton btnBorrar;
	private JButton btnSalir;
	
	public PanelFichaBotonesAvion( IRepositorioModelo< Avion > aviones , Map < String , Aerolinea > aerolineas ) {
		
		setAviones( aviones );
		setAerolineas( aerolineas );
		generarComponentes();
		configurarVentana();
		
	}
	
	
	private void generarComponentes() {
		
		setBtnActualizar( new JButton("Actualizar"));
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
		
		getPanelLista().refrescar();
		getPanelCampos().getTxtIdAvion().setText("");
		getPanelCampos().getTxtPosicionX().setText("");
		getPanelCampos().getTxtPosicionY().setText("");
		getPanelCampos().getComboNombreAerolinea().setSelectedIndex(0);
	}

	public void onClickBtnAgregar(ActionEvent arg0) {
		
		
		getAviones().add( avionEnCampo() );
		
		getPanelLista().refrescar();	
		
		
	}
	
	
	public void onClickBtnBorrar(ActionEvent arg0) {
		getAviones().delete( avionEnCampo()  );
		
		getPanelLista().refrescar();		
		
	}
	
	public void onClickBtnGrabar(ActionEvent arg0) {
		getAviones().add( avionEnCampo() );
		getPanelLista().refrescar();		
	}
	
	public void onClickBtnSalir(ActionEvent arg0) {
		
		getVentanaPrincipal().dispose();	
		
	}
	
	public Avion avionEnCampo() {
		
		return new Avion(
				getPanelCampos().getTxtIdAvion().getText(),buscarAerolinea(getPanelCampos().getComboNombreAerolinea().getSelectedItem().toString()),
				new Posicion(
						Double.parseDouble(getPanelCampos().getTxtPosicionX().getText()), 
						Double.parseDouble(getPanelCampos().getTxtPosicionY().getText())));
		
	}
	
	public  Aerolinea buscarAerolinea(String dato) {
		
		for(Aerolinea aerolinea : getAerolineas().values())
			if(aerolinea.getNombre().equals(dato))
				return aerolinea;
		
		return null;
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


	public PanelFichaCamposAvion getPanelCampos() {
		return panelCampos;
	}


	public void setPanelCampos(PanelFichaCamposAvion panelCampos) {
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





	public VentanaGestionABMAvion getVentanaPrincipal() {
		return ventanaPrincipal;
	}


	public void setVentanaPrincipal(VentanaGestionABMAvion ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}


	public JButton getBtnActualizar() {
		return btnActualizar;
	}


	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}


	public IRepositorioModelo< Avion > getAviones() {
		return aviones;
	}


	public void setAviones(IRepositorioModelo< Avion > aviones) {
		this.aviones = aviones;
	}


	public Map <String,Aerolinea> getAerolineas() {
		return aerolineas;
	}


	public void setAerolineas(Map <String,Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}


	

}
