package ar.edu.ub.p3.aeropuerto.tablero.view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;

public class Ventana extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JLabel punto1x;           // etiqueta o texto no editable
    private JLabel punto1y;
    private JLabel punto2x;
    private JLabel punto2y;

    private JButton boton;          // boton con una determinada accion


	
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

    }

 

    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = {"NroVuelo", "Origen", "Destino", "Aerolinea", "Hora Programada"};
    
    	// arreglar esto aalgun momento que se redimensione segun cantidad de vuelos
    	Object [][] aux = new Object [3][5];
    	
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
    	};
    	
    	
    	int i = 0;
    	
		for(IVuelo vuelo : conexion.getVuelos()) {
			aux[i][0] = (vuelo.getIdVuelo().toString());
			aux[i][3] = (vuelo.getAvion().getAerolinea().toString());
			aux[i][2] = ( vuelo.getAeropuertoDestino().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
			aux[i][1] = ( vuelo.getAeropuertoOrigen().getIdAeropuerto() +" - "+ vuelo.getAeropuertoOrigen().getNombre());
			aux[i][4] = ( vuelo.getHorarioProgramado().getHours() +":"+vuelo.getHorarioProgramado().getMinutes());
			
			i++;
		}
    	

    	JTable tabla = new JTable(aux,nombreColumna);
    	
    	tabla.setSize(200,200);
    	tabla.setVisible(true);
    	tabla.setEnabled(false);

    	
    	this.setLayout(new BorderLayout());
    	this.add(tabla.getTableHeader(), BorderLayout.PAGE_START);
    	this.add(tabla, BorderLayout.CENTER);
    			
    	}
    }


