package ar.edu.ub.p3.aeropuerto.gestor.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class Gestion_Ventana_Aeropuertos extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private JButton btnAgregarAeropuerto;


	
    public Gestion_Ventana_Aeropuertos(ConexionAeropuerto conexion) {
        super();
        setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);
        configurarVentana();        
        agregarTabla(conexion);
        setVisible(true);
        
    }

    private void configurarVentana() {
        this.setTitle("Gestion Aeropuertos");                
        this.setSize(583, 320);                                  
        this.setLocationRelativeTo(null);                        
        this.getContentPane().setLayout(null);


    }

 

    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = { "ID_Aeropuerto","Nombre_Aeropuerto" ,"Posicion"};
    	Object [][] aux = new Object [conexion.getAeropuertos().size()][nombreColumna.length];
    	
    	
    	int i = 0;
    	
    	for(IAeropuerto aeropuerto : conexion.getAeropuertos()) {
    		
    		aux[i][0] = new Object();
    		aux[i][1] = new Object();
    		aux[i][2] = new Object();
    		i++;
    		
    	}
    		
   
    		
    	i=0;
		for(IAeropuerto aeropuerto : conexion.getAeropuertos()) {
			aux[i][0] = ( aeropuerto.getIdAeropuerto());
			aux[i][1] = ( aeropuerto.getNombre());
			aux[i][2] = ( aeropuerto.getPosicion().toString());
			
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
    	
    	
    	
    	setBtnAgregarAeropuerto(new JButton("Agregar Avion"));
    	//getContentPane().add(getBtnAgregarAvion(), BorderLayout.EAST);
    	//getContentPane().add(new JButton("Borrar Avion"), BorderLayout.EAST);
    
    	
    	
    			
    	}

	public JButton getBtnAgregarAeropuerto() {
		return btnAgregarAeropuerto;
	}

	public void setBtnAgregarAeropuerto(JButton btnAgregarAeropuerto) {
		this.btnAgregarAeropuerto = btnAgregarAeropuerto;
	}

	

	
    }
