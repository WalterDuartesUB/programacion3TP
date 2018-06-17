package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.Aerolinea;
 

public class VentanaGestionABMAerolinea extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	public VentanaGestionABMAerolinea( PanelFichaAerolinea ficha , PanelLista<Aerolinea> lista ) {
		
		setLayout( new GridLayout(1, 2) );
		add(lista);
		add(ficha);
		setSize(800, 320); 
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		ficha.getPanelBotones().setVentanaPrincipal(this);
	}
	

}
