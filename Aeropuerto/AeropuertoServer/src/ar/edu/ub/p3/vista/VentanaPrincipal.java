package ar.edu.ub.p3.vista;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.edu.ub.p3.controlador.VentanaPrincipalControlador;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2955325317528293957L;

	public VentanaPrincipal() {
		super("Servidor de Aeropuerto");
		
		this.inicializarVentana();
		this.crearMenus();
		this.setVisible( true );
	}

	private void crearMenus() {
		JMenuBar menubar = new JMenuBar();
		
		menubar.add( this.crearMenuAdministracion() );
		menubar.add( this.crearMenuGestion() );
		menubar.add( this.crearMenuRadar() );
		menubar.add( this.crearMenuTablero() );		
		menubar.add( this.crearMenuDebug() );
				
		this.setJMenuBar(menubar);
	}

	private JMenu crearMenuAdministracion() {
		JMenu menu = new JMenu("Administracion");
		
		JMenuItem menuItem = new JMenuItem("Conectar al Trafico Aereo");
		menuItem.addActionListener( this::onClickMenuItemConectarAlTraficoAereo );		
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Desconectar del Trafico Aereo");
		menuItem.addActionListener( this::onClickMenuItemDesconectarAlTraficoAereo );
		menu.add(menuItem);			
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Salir");
		menu.add(menuItem);
		
		return menu;
	}
	
	private JMenu crearMenuDebug() {
		JMenu menu = new JMenu("Debug");
		
		JMenuItem menuItem = new JMenuItem("Pedir lista de aeropuertos disponibles");
		menuItem.addActionListener( this::onClickMenuItemPedirListaAeropuertosDisponibles );		
		menu.add(menuItem);

		menu.addSeparator();
		
		menuItem = new JMenuItem("Enviar vuelo de prueba");
		menuItem.addActionListener( this::onClickMenuItemProgramarVueloDePrueba );
		menu.add(menuItem);							
		
		menuItem = new JMenuItem("Pedir informacion del estado actual del vuelo de prueba");
		menuItem.addActionListener( this::onClickMenuItemPedirInformacionActualDelVueloDePrueba );
		menu.add(menuItem);
		
		return menu;
	}

	private JMenu crearMenuTablero() {
		JMenu menu = new JMenu("Tablero");
		
		JMenuItem menuItem = new JMenuItem("Ver arribos");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Ver despegues");
		menu.add(menuItem);
		
		return menu;
	}

	private JMenu crearMenuRadar() {
		JMenu menu = new JMenu("Radar");
		
		JMenuItem menuItem = new JMenuItem("Ver radar");
		menu.add(menuItem);
		
		return menu;
	}

	private JMenu crearMenuGestion() {
		JMenu menu = new JMenu("Gestión");
		
		JMenuItem menuItem = new JMenuItem("Aviones");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Vuelos");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Aerolineas");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Aeropuertos");
		menu.add(menuItem);
		
		return menu;
	}

	private void inicializarVentana() {
		this.setLocation(300, 300);
		this.setSize(400, 400);
		this.setResizable( false );
//		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public void onClickMenuItemConectarAlTraficoAereo( ActionEvent ae ) {
		VentanaPrincipalControlador.conectarAlTraficoAereo();
	}
	
	public void onClickMenuItemDesconectarAlTraficoAereo( ActionEvent ae ) {
		
	}
	
	public void onClickMenuItemPedirListaAeropuertosDisponibles( ActionEvent ae ) {
		
	}
	
	public void onClickMenuItemProgramarVueloDePrueba( ActionEvent ae ) {
		
	}
	
	public void onClickMenuItemPedirInformacionActualDelVueloDePrueba( ActionEvent ae ) {
		
	}
}
