package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.Aeropuerto;
 

public class VentanaGestionABMAeropuerto extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	public VentanaGestionABMAeropuerto( PanelFichaAeropuerto ficha , PanelLista<Aeropuerto> lista ) {
		
		setLayout( new GridLayout(1, 2) );
		add(lista);
		add(ficha);
		setSize(800, 320); 
		setVisible(true);
		setLocationRelativeTo(null);
		ficha.getPanelBotones().setVentanaPrincipal(this);
	}
	

}
