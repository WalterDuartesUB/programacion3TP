package ar.edu.ub.p3.vista;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2955325317528293957L;

	private Configuracion configuracion;
	private EstadoAeropuerto estadoAeropuerto;
	private ConexionTraficoAereo conexionTraficoAereo;
	
	public VentanaPrincipal(Configuracion configuracion, EstadoAeropuerto estadoAeropuerto, ConexionTraficoAereo conexionTA) {
		super("Servidor de Aeropuerto");
		
		this.inicializarVentana();
		this.crearMenus();
		this.setVisible( true );
		
		//TODO revisar como hacer esto, deberia formar parte del controlador
		this.setConexionTraficoAereo(conexionTA);
		this.setConfiguracion(configuracion);
		this.setEstadoAeropuerto(estadoAeropuerto);
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
		menuItem.addActionListener( this::onClickMenuItemSalir );
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
		menuItem.addActionListener( this::onClickMenuItemVerArribos );
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Ver despegues");
		menuItem.addActionListener( this::onClickMenuItemVerDespegues );		
		menu.add(menuItem);
		
		return menu;
	}

	private JMenu crearMenuRadar() {
		JMenu menu = new JMenu("Radar");
		
		JMenuItem menuItem = new JMenuItem("Ver radar");
		menuItem.addActionListener( this::onClickMenuItemVerRadar );
		menu.add(menuItem);
		
		return menu;
	}

	private JMenu crearMenuGestion() {
		JMenu menu = new JMenu("Gestión");
		
		JMenuItem menuItem = new JMenuItem("Aviones");
		menuItem.addActionListener( this::onClickMenuItemGestionarAviones );
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Vuelos");
		menuItem.addActionListener( this::onClickMenuItemGestionarVuelos );		
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Aerolineas");
		menuItem.addActionListener( this::onClickMenuItemGestionarAerolineas);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Aeropuertos");
		menuItem.addActionListener( this::onClickMenuItemGestionarAeropuertos );
		menu.add(menuItem);
		
		return menu;
	}

	private void inicializarVentana() {
		this.setLocation(300, 300);
		this.setSize(400, 400);
		this.setResizable( false );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	public void onClickMenuItemConectarAlTraficoAereo( ActionEvent ae ) {
		this.getConexionTraficoAereo().conectar();		
	}
	
	public void onClickMenuItemDesconectarAlTraficoAereo( ActionEvent ae ) {
		this.getConexionTraficoAereo().desconectar();
	}
	
	public void onClickMenuItemPedirListaAeropuertosDisponibles( ActionEvent ae ) {
		this.getConexionTraficoAereo().obtenerAeropuertosDisponibles();
	}
	
	public void onClickMenuItemProgramarVueloDePrueba( ActionEvent ae ) {
		this.getConexionTraficoAereo().despegar( this.getEstadoAeropuerto().getVuelos().get( this.getConfiguracion().getConfiguracion("idVueloPrueba") ) );
	}
	
	public void onClickMenuItemPedirInformacionActualDelVueloDePrueba( ActionEvent ae ) {
		System.out.println( this.getConexionTraficoAereo().obtenerInformacionVuelo( this.getConfiguracion().getConfiguracion("idVueloPrueba") ) );
	}
	
	public void onClickMenuItemSalir( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemVerArribos( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemVerDespegues( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemVerRadar( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemGestionarAviones( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemGestionarAerolineas( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemGestionarAeropuertos( ActionEvent ae ) {
		this.onEventoAImplementar();
	}
	
	public void onClickMenuItemGestionarVuelos( ActionEvent ae ) {
		this.onEventoAImplementar();	
	}
	
	private void onEventoAImplementar() {
		JOptionPane.showMessageDialog( this, "Evento a implementar " );
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	private EstadoAeropuerto getEstadoAeropuerto() {
		return estadoAeropuerto;
	}

	private void setEstadoAeropuerto(EstadoAeropuerto estadoAeropuerto) {
		this.estadoAeropuerto = estadoAeropuerto;
	}

	private ConexionTraficoAereo getConexionTraficoAereo() {
		return conexionTraficoAereo;
	}

	private void setConexionTraficoAereo(ConexionTraficoAereo conexionTraficoAereo) {
		this.conexionTraficoAereo = conexionTraficoAereo;
	}
}
