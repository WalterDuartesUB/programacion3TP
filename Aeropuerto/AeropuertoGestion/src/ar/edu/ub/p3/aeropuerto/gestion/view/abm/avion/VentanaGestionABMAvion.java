package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.*;

public class VentanaGestionABMAvion extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	public VentanaGestionABMAvion( PanelFichaAvion ficha , PanelLista<Aeropuerto> lista ) {
		
		setLayout( new GridLayout(1, 2) );
		add(lista);
		add(ficha);
		setSize(800, 320); 
		setVisible(true);
		
	}
	

}
