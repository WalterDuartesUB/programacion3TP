package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestion.view.PanelLista;
import ar.edu.ub.p3.modelo.Vuelo;
 

public class VentanaGestionABMVuelo extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
	public VentanaGestionABMVuelo( PanelFichaVuelo ficha , PanelLista<Vuelo> lista) {
		
		setLayout( new GridLayout(1, 3) );
		add(lista);
		add(ficha);
		setSize(1200, 320); 
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		ficha.getPanelBotones().setVentanaPrincipal(this);
	}
	

}
