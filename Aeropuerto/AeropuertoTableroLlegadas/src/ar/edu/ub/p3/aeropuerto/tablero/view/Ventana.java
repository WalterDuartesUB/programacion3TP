package ar.edu.ub.p3.aeropuerto.tablero.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;

public class Ventana extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public Ventana(ConexionAeropuerto conexion) {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        agregarTabla(conexion);
        setVisible(true);
        
    }

    private void configurarVentana() {
        this.setTitle("Tablero Primer intento");               // colocamos titulo a la ventana
        this.setSize(710, 450);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        this.getContentPane().setLayout(null);

    }
  

    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = {"NroVuelo", "Origen", "Destino", "Aerolinea", "Hora Programada"};
    
    	Object [][] aux = new Object [3][5];
    	
    	Object [][] aux3 = new Object [conexion.getVuelos().size()][nombreColumna.length];
    	
    	Object [][] aux2 = {
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    						{"pepe","pepe","pepe","pepe","pepe"},
    	};
    	
    	
    	
    	int i = 0;
    	
		for(IVuelo vuelo : conexion.getVuelos()) {
			aux3[i][0] = (vuelo.getIdVuelo().toString());
			aux3[i][3] = (vuelo.getAvion().getAerolinea().toString());
			aux3[i][2] = ( vuelo.getAeropuertoDestino().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
			aux3[i][1] = ( vuelo.getAeropuertoOrigen().getIdAeropuerto() +" - "+ vuelo.getAeropuertoOrigen().getNombre());
			aux3[i][4] = ( vuelo.getHorarioProgramado().getHours() +":"+vuelo.getHorarioProgramado().getMinutes());
			
			i++;
		}
    	

    	JTable tabla = new JTable(aux2,nombreColumna);
    	JScrollPane scroll =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBackground(Color.DARK_GRAY);
    	
    	tabla.setAutoscrolls(true);
 
    	
    	tabla.setSize(200,200);
    	
    	getContentPane().setLayout(new BorderLayout());
    	getContentPane().add(tabla.getTableHeader(), BorderLayout.PAGE_START);
    	getContentPane().add(scroll,BorderLayout.CENTER);
    	
    	JPanel botones = new JPanel();
    	scroll.setRowHeaderView(botones);
    	botones.setLayout(null);

    	tabla.setVisible(true);
    	tabla.setEnabled(false);
    	tabla.setAutoscrolls(true);


        tabla.setForeground(Color.BLUE);
        
        tabla.setGridColor(Color.RED);
        tabla.setSelectionBackground(Color.YELLOW);
    	
    	this.setLayout(new BorderLayout());
    	this.add(tabla.getTableHeader(), BorderLayout.PAGE_START);
    	this.add(tabla, BorderLayout.CENTER);
    			
    	}
    }


