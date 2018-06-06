package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;

import java.awt.Color;

public class FichaConListaView extends JFrame {

	public FichaConListaView(FichaCamposPanel fichaPanel,ConexionAeropuerto conexion) throws HeadlessException {
		super();
		getContentPane().setBackground(Color.DARK_GRAY);

		getContentPane().setLayout( new GridLayout(1,2));
		
		getContentPane().add( new ListaPanel( conexion));
		getContentPane().add( new FichaPanel( fichaPanel ));
		
		this.setSize(800, 320);                                  
        this.setLocationRelativeTo(null); 
		this.setVisible(false);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8565574402129201718L;

}
