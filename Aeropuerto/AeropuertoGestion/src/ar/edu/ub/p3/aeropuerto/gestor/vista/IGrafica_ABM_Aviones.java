package ar.edu.ub.p3.aeropuerto.gestor.vista;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class IGrafica_ABM_Aviones extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private JButton btnAgregarAvion;


	
    public IGrafica_ABM_Aviones(ConexionAeropuerto conexion) {
        super();                    
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);
        configurarVentana();        
        agregarTabla(conexion);
        setVisible(true);
        
    }

    private void configurarVentana() {
        this.setTitle("GESTOR");                
        this.setSize(583, 320);                                  
        this.setLocationRelativeTo(null);                        
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

    }

 

    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = { "ID_Avion","ID_Aerolinea","Nombre_Aerolinea" ,"Posicion"};
    	Object [][] aux = new Object [conexion.getAviones().size()][nombreColumna.length];
    	
    	
    	int i = 0;
    	
    	for(IAvion avion : conexion.getAviones()) {
    		
    		aux[i][0] = new Object();
    		aux[i][1] = new Object();
    		aux[i][2] = new Object();
    		aux[i][3] = new Object();
    		i++;
    		
    	}
    		
   
    		
    	i=0;
		for(IAvion avion : conexion.getAviones()) {
			aux[i][0] = ( avion.getIdAvion().toString());
			aux[i][1] = ( avion.getAerolinea().getIdAerolinea());
			aux[i][2] = ( avion.getAerolinea().getNombre());
			aux[i][3] = ( avion.getPosicion() .toString());
			
			i++;
		}
    	
		//DefaultTableModel modelo = new DefaultTableModel();
    	JTable tabla = new JTable(aux, nombreColumna);
    	JScrollPane scroll =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
    	
    	
    	
    	setBtnAgregarAvion(new JButton("Agregar Avion"));
    	//getContentPane().add(getBtnAgregarAvion(), BorderLayout.EAST);
    	//getContentPane().add(new JButton("Borrar Avion"), BorderLayout.EAST);
    
    	
    	
    			
    	}

	public JButton getBtnAgregarAvion() {
		return btnAgregarAvion;
	}

	public void setBtnAgregarAvion(JButton btnAgregarAvion) {
		this.btnAgregarAvion = btnAgregarAvion;
	}

	

	
    }
