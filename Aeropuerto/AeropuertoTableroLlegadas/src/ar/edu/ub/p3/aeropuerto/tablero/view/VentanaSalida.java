package ar.edu.ub.p3.aeropuerto.tablero.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoVuelo;

public class VentanaSalida extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public VentanaSalida(ConexionAeropuerto conexion, Aeropuerto aeropuertolocal) {
        super();                    // usamos el contructor de la clase padre JFrame
        iniciarVentana(conexion,aeropuertolocal);        // configuramos la ventana
       // agregarTabla(conexion);
        setVisible(true);
        this.setResizable(false);
    }

    private void iniciarVentana(ConexionAeropuerto conexion, Aeropuerto aeropuertolocal) {
    	
    	setTitle("Prueba Ventana 3");
    	
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);
		
		
		String[] 	nombreColumna = {"Hora Programada","NroVuelo", "Aerolinea", "Destino", "Estima", "Estado"};
		
		// acomodar segun tablero llegada o salida
    	Object [][] vuelos = new Object [conexion.getVuelos().size()][nombreColumna.length];
   

    	int i = 0;
    	
    	ImageIcon icon1 = new ImageIcon("M:\\New folder\\PruebaVentana2\\img\\arg2.png");
    	ImageIcon icon2 = new ImageIcon("M:\\New folder\\PruebaVentana2\\img\\latam2.png");
    	ImageIcon icon3 = new ImageIcon("M:\\New folder\\PruebaVentana2\\img\\andes2.png");
		
    	
		for(IVuelo vuelo : conexion.getVuelos()) {
    
			
			if(estoyEnMiAeropuerto(vuelo,aeropuertolocal)) {

				vuelos[i][0] = ( vuelo.getHorarioProgramado().getHours() +":"+vuelo.getHorarioProgramado().getMinutes());  // arreglar en algun momento
				vuelos[i][1] = (vuelo.getIdVuelo().toString());
				
				///// HACER ESTO ESCALABLE  solo prueba
				if(vuelo.getAvion().getAerolinea().getNombre().equals("AEROLINEAS ARGENTINAS"))
					vuelos[i][2] = icon1;
				if(vuelo.getAvion().getAerolinea().getNombre().equals("LATAM"))
					vuelos[i][2] = icon2;
				if(vuelo.getAvion().getAerolinea().getNombre().equals("ANDES"))
					vuelos[i][2] = icon3;
					
				//vuelos[i][2] = (vuelo.getAvion().getAerolinea().getNombre().toString());
				
	           /* 
	            if(vuelo.getAvion().getAerolinea().toString() != null){
	                
	             ImageIcon image = new ImageIcon(new ImageIcon(("M:\\New folder\\PruebaVentana2\\img\\arg.png")).getImage()
	             .getScaledInstance(150,120, Image.SCALE_SMOOTH) );   
	                
	            vuelos[i][2] = image;
	            }
	            else{
	                vuelos[i][2] = null;
	            }
				*/
				//vuelos[i][2] = icon1;
				vuelos[i][3] = ( vuelo.getAeropuertoDestino().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
				vuelos[i][4] = (vuelo.getHorarioDespegue().getHours() + ":" + vuelo.getHorarioDespegue().getMinutes());
				vuelos[i][5] = (vuelo.getEstadoVuelo().toString());
				i++;
			}
		}
		

		
		 
    	
		//JTable tabla = new JTable(vuelos, nombreColumna);
		
		
        JTable tabla = new JTable(vuelos,nombreColumna) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                case 2 : return ImageIcon.class;
                	default: return Object.class;
                }
            }
        };
       
        /*
        tabla.setDefaultRenderer(Double.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
                Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
                
                if(EstadoVuelo == EstadoVuelo.BOARDING) {
                	c.setForeground(((Double) value)>0 ? Color.BLUE : Color.RED);
                return c;
            }
        });
		*/
		
	//	tabla.setPreferredSize(tabla.getPreferredSize());
		tabla.setRowHeight(50);
		tabla.setEnabled(false);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		
		JScrollPane tableScrollPane = new JScrollPane(tabla);
		tableScrollPane.setPreferredSize(new Dimension(400, 400));
		
		
		
		
		JLabel jLabelObject = new JLabel();
		jLabelObject.setIcon(new ImageIcon("M:\\New folder\\PruebaVentana2\\img\\salidas.png"));
		
	
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		
		String aeropuertoactual = aeropuertolocal.getIdAeropuerto().toString()+"-"+aeropuertolocal.getNombre();
		JLabel aeropuertoactuall = new JLabel(aeropuertoactual);
		
		

		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(jLabelObject, gbc);
		

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 2;		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 2.0;
		gbc.weighty = 2.0;
		panel.add(tableScrollPane, gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(dia, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(aeropuertoactuall, gbc);

		this.pack();
		
		this.setVisible(true);
    	
    	/*
        this.setTitle("Tablero Primer intento");               // colocamos titulo a la ventana
        this.setSize(710, 450);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        //this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
        this.getContentPane().setLayout(null);
*/
    }

	private boolean estoyEnMiAeropuerto(IVuelo vuelo, Aeropuerto aerolocal) {
		
		return vuelo.getAeropuertoOrigen().getIdAeropuerto().equals(aerolocal.getIdAeropuerto());
	}
  
    /*
    private void agregarTabla(ConexionAeropuerto conexion) {

    	String[] 	nombreColumna = {"NroVuelo", "Origen", "Destino", "Aerolinea", "Hora Programada"};
    	
    	// acomodar segun tablero llegada o salida
    	Object [][] aux3 = new Object [conexion.getVuelos().size()][nombreColumna.length];
   

    	int i = 0;
    	
		for(IVuelo vuelo : conexion.getVuelos()) {
			

			aux3[i][0] = (vuelo.getIdVuelo().toString());
			aux3[i][3] = (vuelo.getAvion().getAerolinea().toString());
			aux3[i][2] = ( vuelo.getAeropuertoDestino().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
			aux3[i][1] = ( vuelo.getAeropuertoOrigen().getIdAeropuerto() +" - "+ vuelo.getAeropuertoOrigen().getNombre());
			aux3[i][4] = ( vuelo.getHorarioProgramado().getHours() +":"+vuelo.getHorarioProgramado().getMinutes());
			i++;
			
		}
		    	JTable tabla = new JTable(aux3,nombreColumna);
		    	
		    	tabla.setSize(200,200);
		    	tabla.setVisible(true);
		    	tabla.setEnabled(false);
		
		   	
		    	//this.setLayout(new BorderLayout());
		    	this.setLayout(new GridBagLayout());
		    	this.add(tabla.getTableHeader(), BorderLayout.PAGE_START);
		    	this.add(tabla, BorderLayout.CENTER);
		    	
		    	
    	}
    	
    	*/

    	
    
    }


