package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.*;

public class PanelFichaBotonesAerolinea extends JPanel{

	private static final long serialVersionUID = 1L;
	private VentanaGestionABMAerolinea ventanaPrincipal;
	
	private ITablaModelo panelLista;
	private PanelFichaCamposAerolinea panelCampos;
	private IRepositorioModelo<Aerolinea> aerolineas;
	
	
	private JButton btnActualizar;
	private JButton btnAgregar;
	private JButton btnGrabar;
	private JButton btnBorrar;
	private JButton btnSalir;
	
	public PanelFichaBotonesAerolinea( IRepositorioModelo<Aerolinea> aerolineas ) {
		
		setAerolineas(aerolineas);
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
		
	}

	public void onClickBtnAgregar(ActionEvent arg0) {
		getAerolineas().add( new Aerolinea( getPanelCampos().getTxtIdAerolineas().getText(), 
				getPanelCampos().getTxtNombre().getText()));
		
		getPanelLista().refrescar();		
	}
	
	
	public void onClickBtnBorrar(ActionEvent arg0) {
		getAerolineas().delete( new Aerolinea( 
				getPanelCampos().getTxtIdAerolineas().getText(), 
				getPanelCampos().getTxtNombre().getText()) );
		
		getPanelLista().refrescar();		
		
	}
	
	public void onClickBtnGrabar(ActionEvent arg0) {
		getAerolineas().add( new Aerolinea( 
			getPanelCampos().getTxtIdAerolineas().getText(), 
			getPanelCampos().getTxtNombre().getText()));
		getPanelLista().refrescar();		
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


	public PanelFichaCamposAerolinea getPanelCampos() {
		return panelCampos;
	}


	public void setPanelCampos(PanelFichaCamposAerolinea panelCampos) {
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


	public IRepositorioModelo<Aerolinea> getAerolineas() {
		return aerolineas;
	}


	public void setAerolineas(IRepositorioModelo<Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}


	public VentanaGestionABMAerolinea getVentanaPrincipal() {
		return ventanaPrincipal;
	}


	public void setVentanaPrincipal(VentanaGestionABMAerolinea ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}


	public JButton getBtnActualizar() {
		return btnActualizar;
	}


	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}
	

}
