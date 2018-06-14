package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.*;

public class PanelFichaBotonesAvion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	
	private ITablaModelo panelLista;
	private PanelFichaCamposAvion panelCampos;
	private IRepositorioModelo<Aeropuerto> aeropuertos;
	
	
	private JButton btnAgregar;
	private JButton btnGrabar;
	private JButton btnBorrar;
	private JButton btnSalir;
	
	public PanelFichaBotonesAvion( IRepositorioModelo<Aeropuerto> aeropuertos ) {
		
		setAeropuertos(aeropuertos);
		generarComponentes();
		configurarVentana();
		
	}
	
	
	private void generarComponentes() {
		
		setBtnAgregar( new JButton("Nuevo"));
		setBtnGrabar ( new JButton("Grabar"));
		setBtnBorrar ( new JButton("Borrar"));
		setBtnSalir  ( new JButton("Salir") );
		
		add( getBtnAgregar() );
		add( getBtnBorrar() );
		add( getBtnGrabar());
		add( getBtnSalir());
		
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
		
	}

	public void onClickBtnAgregar(ActionEvent arg0) {
		getAeropuertos().add( new Aeropuerto( getPanelCampos().getTxtIdAeropuerto().getText(), 
				getPanelCampos().getTxtNombre().getText(), 
				null ) );
		
		getPanelLista().refrescar();		
	}
	
	
	public void onClickBtnBorrar(ActionEvent arg0) {
		getAeropuertos().delete( new Aeropuerto( 
				getPanelCampos().getTxtIdAeropuerto().getText(), 
				getPanelCampos().getTxtNombre().getText(), 
				null ) );
		
		getPanelLista().refrescar();		
		
	}
	
	public void onClickBtnGrabar(ActionEvent arg0) {
		getAeropuertos().add( new Aeropuerto( 
			getPanelCampos().getTxtIdAeropuerto().getText(), 
			getPanelCampos().getTxtNombre().getText(), 
			null ) );
		getPanelLista().refrescar();		
	}
	
	public void onClickBtnSalir(ActionEvent arg0) {
		
		System.exit(0);
		
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


	public IRepositorioModelo<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}


	public void setAeropuertos(IRepositorioModelo<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
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
	

}
