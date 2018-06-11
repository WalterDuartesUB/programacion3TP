package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;

import java.awt.Color;

public class FichaConListaView extends JFrame {

	private ConexionAeropuerto conexion;
	private ListaPanel listaPanel;
	private FichaPanel	fichaPanel;
	
	
	public FichaConListaView( ConexionAeropuerto conexion ) throws HeadlessException {
		
		super();
		setConexion(conexion);
		
		configuracionVentana();
		
		getContentPane().setBackground(Color.DARK_GRAY);

		getContentPane().setLayout( new GridLayout(1,2));
		
		getContentPane().add( getListaPanel());
		getContentPane().add( getFichaPanel());
		
		this.setSize(800, 320);                                  
        this.setLocationRelativeTo(null); 
		this.setVisible(false);
	}

	private void configuracionVentana() {
		
		setListaPanel( new ListaPanel( this ) );
		
		
		setFichaPanel( new FichaPanel( this ) );
		
	}

	public ConexionAeropuerto getConexion() {
		return conexion;
	}

	public void setConexion(ConexionAeropuerto conexion) {
		this.conexion = conexion;
	}

	public ListaPanel getListaPanel() {
		return listaPanel;
	}

	public void setListaPanel(ListaPanel listaPanel) {
		this.listaPanel = listaPanel;
	}

	public FichaPanel getFichaPanel() {
		return fichaPanel;
	}

	public void setFichaPanel(FichaPanel fichaPanel) {
		this.fichaPanel = fichaPanel;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8565574402129201718L;

}
