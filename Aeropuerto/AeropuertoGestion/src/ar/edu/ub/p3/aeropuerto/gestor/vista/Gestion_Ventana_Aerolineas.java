package ar.edu.ub.p3.aeropuerto.gestor.vista;

import java.awt.BorderLayout;



import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAerolinea;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class Gestion_Ventana_Aerolineas extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    


	
    public Gestion_Ventana_Aerolineas(ConexionAeropuerto conexion) {
        super();
        setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);
        configurarVentana();        
        agregarTabla(conexion);
        crearMenu();
    }

    private void configurarVentana() {
        this.setTitle("Gestion Aerolineas");                
        this.setSize(583, 285);                                  
        this.setLocationRelativeTo(null);                        
        this.getContentPane().setLayout(null); 

    }

 

    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = { "ID_Aerolinea","Nombre_Aerolinea"};
    	Object [][] aux = new Object [conexion.getAerolineas().size()][nombreColumna.length];
    	
    	
    	
    	int i =0;
    	for( i = 0; i< conexion.getAerolineas().size();i++) {
    		
    		aux[i][0] = new Object();
    		aux[i][1] = new Object();
    		i++;
    		
    	}
    		
   
    		
    	i=0;
		for(IAerolinea aerolinea : conexion.getAerolineas()) {
			aux[i][0] = ( aerolinea.getIdAerolinea() );
			aux[i][1] = ( aerolinea.getNombre() );
			i++;
		}
    	
		//DefaultTableModel modelo = new DefaultTableModel();
    	JTable tabla = new JTable(aux, nombreColumna);
    	JScrollPane scroll =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setLocation(200, 0);
    	scroll.setBackground(Color.DARK_GRAY);
    	tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	
    	tabla.setAutoscrolls(true);
    	tabla.setForeground(Color.WHITE);
    	tabla.setBackground(Color.DARK_GRAY);
    	
    	tabla.setSize(100,100);
    
    	getContentPane().setLayout(new BorderLayout());
    	getContentPane().add(tabla.getTableHeader(), BorderLayout.PAGE_START);
    	getContentPane().add(scroll,BorderLayout.CENTER);
    	
    	JPanel botones = new JPanel();
    	scroll.setRowHeaderView(botones);
    	botones.setLayout(null);
    	
    	//getContentPane().add(tabla, BorderLayout.CENTER);
    	
    	tabla.addMouseListener(new java.awt.event.MouseAdapter() {
    	    @Override
    	    public void mouseClicked(java.awt.event.MouseEvent evt) {
    	        int row = tabla.rowAtPoint(evt.getPoint());
    	        int col = tabla.columnAtPoint(evt.getPoint());
    	        if (row >= 0 && col >= 0) {
    	        	
    	            System.out.println(tabla.getValueAt(row, 0) +" "+
    	            		tabla.getValueAt(row, 1)  );

    	        }
    	    }
    	});
    	
    	
    			
    	}

    
    
    private void crearMenu() {
		JMenuBar menubar = new JMenuBar();
		
		menubar.add( this.crearMenuGestion() );

		this.setJMenuBar(menubar);
	}

    
    private JMenu crearMenuGestion() {
		JMenu menu = new JMenu("Gestor de Aerolineas");
		
		JMenuItem menuItem = new JMenuItem("Agregar");
		menuItem.addActionListener( this::onClickMenuItemAgregarAerolinea );
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Modificar");
		menuItem.addActionListener( this::onClickMenuItemModificarAerolinea );
		menu.add(menuItem);			
		
		menuItem = new JMenuItem("Eliminar");
		menuItem.addActionListener( this::onClickMenuItemEliminarAerolinea );
		menu.add(menuItem);		

		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Salir");
		menuItem.addActionListener( this::onClickMenuItemSalir );
		menu.add(menuItem);
		
		
		return menu;
	}

    
    
    
    public void onClickMenuItemAgregarAerolinea( ActionEvent ae ) {
    	
    	onEventoAImplementar();
    	
	}
	
	public void onClickMenuItemModificarAerolinea( ActionEvent ae ) {
				
		onEventoAImplementar();
		
	}
	
	public void onClickMenuItemEliminarAerolinea( ActionEvent ae ) {
		
		onEventoAImplementar();
		
	}
	
	
	
	public void onClickMenuItemSalir( ActionEvent ae ) {
	
		this.setVisible(false);
		
	}
    

	private void onEventoAImplementar() {
		JOptionPane.showMessageDialog( null, "Evento a implementar " );
	}

	
    }
