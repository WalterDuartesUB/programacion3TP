package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Posicion;
 

public class PanelFichaBotonesAeropuerto extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private VentanaGestionABMAeropuerto ventanaPrincipal;
	
	private ITablaModelo panelLista;
	private PanelFichaCamposAeropuerto panelCampos;
	private IRepositorioModelo<Aeropuerto> aeropuertos;
	
	
	private JButton btnActualizar;
	private JButton btnAgregar;
	private JButton btnGrabar;
	private JButton btnBorrar;
	private JButton btnSalir;
	
	public PanelFichaBotonesAeropuerto( IRepositorioModelo<Aeropuerto> aeropuertos ) {
		
		setAeropuertos(aeropuertos);
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
		getBtnBorrar().addActionListener 	( this::onClickBtnBorrar );
		getBtnAgregar().addActionListener	( this::onClickBtnAgregar);
		getBtnGrabar().addActionListener 	( this::onClickBtnGrabar );
		getBtnSalir().addActionListener 	( this::onClickBtnSalir );
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
		mostrarMensaje("Lista Actualizada");
	}

	public void onClickBtnAgregar(ActionEvent arg0) {
		try {
			
			getAeropuertos().add(aeropuertoEnCampo());
			getPanelLista().refrescar();
			mostrarMensaje("Aeropuerto agregado correctamente");
			
		}catch(Exception e){
			
			mostrarMensaje("Error en borrado");
			
		};
		
		
	}
	
	
	public void onClickBtnBorrar(ActionEvent arg0) {
		
		try {
			
			getAeropuertos().delete( aeropuertoEnCampo() );
			
			getPanelLista().refrescar();
			
		}catch(Exception e){
			
			mostrarMensaje("Error en borrar");
			
		}
				
		
	}
	
	public void onClickBtnGrabar(ActionEvent arg0) {
		getAeropuertos().add( aeropuertoEnCampo() );
		getPanelLista().refrescar();		
	}
	
	public void onClickBtnSalir(ActionEvent arg0) {
		
		getVentanaPrincipal().dispose();
		
	}
	
	private void mostrarMensaje( String mensaje ) {
		JOptionPane.showMessageDialog( null, mensaje);
	}
	
	public Aeropuerto aeropuertoEnCampo() {
		
		return  new Aeropuerto( 
				getPanelCampos().getTxtIdAeropuerto().getText(), 
				getPanelCampos().getTxtNombre().getText(), 
				new Posicion(
						Double.parseDouble(getPanelCampos().getTxtPosicionX().getText()), 
						Double.parseDouble(getPanelCampos().getTxtPosicionY().getText())) );
		
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


	public PanelFichaCamposAeropuerto getPanelCampos() {
		return panelCampos;
	}


	public void setPanelCampos(PanelFichaCamposAeropuerto panelCampos) {
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


	public JButton getBtnActualizar() {
		return btnActualizar;
	}


	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}


	public VentanaGestionABMAeropuerto getVentanaPrincipal() {
		return ventanaPrincipal;
	}


	public void setVentanaPrincipal(VentanaGestionABMAeropuerto ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	

}
