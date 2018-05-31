package ar.edu.ub.p3.aeropuerto.gestor.vista;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;


public class Gestion_Ventanas extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    

    private List<JFrame>ventanas;

	
    public Gestion_Ventanas( List<JFrame> ventanas ) {
        super();
       // setResizable(false);
        setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);
        
        setVentanas(ventanas);
        configurarVentana();
        setVisible(true);
        
    }

    private void configurarVentana() {
        this.setTitle("Gestion Ventanas");   
       // this.setBounds(200, 200, 583, 320);
        this.setSize(583, 320);                                  
        this.setLocationRelativeTo(null);                        
        this.getContentPane().setLayout(null);
        crearMenu();

    }

    private void crearMenu() {
		JMenuBar menubar = new JMenuBar();
		
		menubar.add( this.crearMenuGestion() );

		this.setJMenuBar(menubar);
	}

    
    private JMenu crearMenuGestion() {
		JMenu menu = new JMenu("Gestor");
		
		JMenuItem menuItem = new JMenuItem("Aviones");
		menuItem.addActionListener( this::onClickMenuItemAbrirTablaAviones );
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Aerolineas");
		menuItem.addActionListener( this::onClickMenuItemAbrirTablaAerolineas );
		menu.add(menuItem);			
		
		menuItem = new JMenuItem("Aeropuertos");
		menuItem.addActionListener( this::onClickMenuItemAbrirTablaAeropuertos );
		menu.add(menuItem);		
		
		menuItem = new JMenuItem("Vuelos");
		menuItem.addActionListener( this::onClickMenuItemAbrirTablaVuelos );
		menu.add(menuItem);	
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Salir");
		menuItem.addActionListener( this::onClickMenuItemSalir );
		menu.add(menuItem);
		
		
		return menu;
	}

    
    
    
    public void onClickMenuItemAbrirTablaAviones( ActionEvent ae ) {
    	
    	getVentanas().get(0).setVisible(true);
    	
	}
	
	public void onClickMenuItemAbrirTablaAerolineas( ActionEvent ae ) {
				
		getVentanas().get(1).setVisible(true);
		
	}
	
	public void onClickMenuItemAbrirTablaAeropuertos( ActionEvent ae ) {
		
		getVentanas().get(2).setVisible(true);
		
	}
	
	public void onClickMenuItemAbrirTablaVuelos( ActionEvent ae ) {
		
		getVentanas().get(3).setVisible(true);
		
	}
	
	public void onClickMenuItemSalir( ActionEvent ae ) {
	
		System.exit(0);
		
	}
	
	
	

	public List<JFrame> getVentanas() {
		return ventanas;
	}

	public void setVentanas(List<JFrame> ventanas) {
		this.ventanas = ventanas;
	}
	
    }
