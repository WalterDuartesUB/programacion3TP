package ar.edu.ub.p3.aeropuerto.gestor.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class Gestion_Ventana_Vuelos extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private JButton btnAgregarVuelo;


	
    public Gestion_Ventana_Vuelos(ConexionAeropuerto conexion) {
        super();
        setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);
        configurarVentana();        
        agregarTabla(conexion);
        
    }

    private void configurarVentana() {
        this.setTitle("Gestion Vuelos");                
        this.setSize(658, 320);                                  
        this.setLocationRelativeTo(null);                        
        this.getContentPane().setLayout(null);
  

    }

 

    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = { "ID_Vuelo","ID_Avion","Aeropuerto_Origen" ,"Aeropuerto_Destino","Horario_Programado"};
    	Object [][] aux = new Object [conexion.getVuelos().size()][nombreColumna.length];
    	
    	
    	int i = 0;
    	
    	for(IVuelo vuelo : conexion.getVuelos()) {
    		
    		aux[i][0] = new Object();
    		aux[i][1] = new Object();
    		aux[i][2] = new Object();
    		aux[i][3] = new Object();
    		i++;
    		
    	}
    		
   
    		
    	i=0;
		for(IVuelo vuelo : conexion.getVuelos()) {
			aux[i][0] = ( vuelo.getIdVuelo());
			aux[i][1] = ( vuelo.getAvion().getIdAvion());
			aux[i][2] = ( vuelo.getAeropuertoOrigen().getNombre());
			aux[i][3] = ( vuelo.getAeropuertoDestino().getNombre());
			aux[i][4] = ( vuelo.getHorarioProgramado()).toString();
			
			i++;
		}
    	
		//DefaultTableModel modelo = new DefaultTableModel();
    	JTable tabla = new JTable(aux, nombreColumna);
    	JScrollPane scroll =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBackground(Color.DARK_GRAY);
    	
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
    	            		tabla.getValueAt(row, 1) + " "+
    	            		tabla.getValueAt(row, 2) + " "+
    	            		tabla.getValueAt(row, 3)+ " "+
    	            		tabla.getValueAt(row, 4) );

    	        }
    	    }
    	});
    	
    	setBtnAgregarVuelo(new JButton("Agregar Avion"));
    	//getContentPane().add(getBtnAgregarAvion(), BorderLayout.EAST);
    	//getContentPane().add(new JButton("Borrar Avion"), BorderLayout.EAST);
    
    	
    	
    			
    	}

	public JButton getBtnAgregarVuelo() {
		return btnAgregarVuelo;
	}

	public void setBtnAgregarVuelo(JButton btnAgregarVuelo) {
		this.btnAgregarVuelo = btnAgregarVuelo;
	}

	

	
    }
