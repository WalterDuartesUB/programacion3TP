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

public class VentanaLlegada extends JFrame {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public VentanaLlegada(ConexionAeropuerto conexion, Aeropuerto aeropuertoLocal) {
        super();                    // usamos el contructor de la clase padre JFrame
        setTitle("Prueba Ventana 3");
        this.add(iniciarVentana(conexion,aeropuertoLocal));        // configuramos la ventana
       // agregarTabla(conexion);
        this.setResizable(false);
        setVisible(true);
        
    }

    private Component iniciarVentana(ConexionAeropuerto conexion, Aeropuerto aeropuertoLocal) {
    	
    	
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);
		
		
		
		//////////////////////////////////////////////////////////
		//Tabla
		String[] 	nombreColumna = {"Hora Programada","NroVuelo", "Aerolinea", "Origen", "Estima", "Estado"};
		
		// acomodar segun tablero llegada o salida
    	Object [][] vuelos = new Object [conexion.getVuelos().size()][nombreColumna.length];
  
    	int i = 0;
    	
    	ImageIcon icon1 = new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\arg2.png");
    	ImageIcon icon2 = new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\latam2.png");
    	ImageIcon icon3 = new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\andes2.png");
		  	
		for(IVuelo vuelo : conexion.getVuelos()) {
			if(estoyEnMiAeropuerto(vuelo,aeropuertoLocal)) {
				vuelos[i][0] = ( vuelo.getHorarioProgramado().getHours() +":"+vuelo.getHorarioProgramado().getMinutes());  // arreglar en algun momento
				vuelos[i][1] = (vuelo.getIdVuelo().toString());
				
				///// HACER ESTO ESCALABLE  solo prueba
				if(vuelo.getAvion().getAerolinea().getNombre().equals("AEROLINEAS ARGENTINAS"))
					vuelos[i][2] = icon1;
				if(vuelo.getAvion().getAerolinea().getNombre().equals("LATAM"))
					vuelos[i][2] = icon2;
				if(vuelo.getAvion().getAerolinea().getNombre().equals("ANDES"))
					vuelos[i][2] = icon3;
					
				vuelos[i][3] = ( vuelo.getAeropuertoOrigen().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
				vuelos[i][4] = (vuelo.getHorarioAterrizajeEstimado().getHours() + ":" + vuelo.getHorarioDespegue().getMinutes());
				vuelos[i][5] = (vuelo.getEstadoVuelo().toString());
				i++;
			}
		}
		
        JTable tabla = new JTable(vuelos,nombreColumna) {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                case 2 : return ImageIcon.class;
                	default: return Object.class;
                }
            }
        };
       
		
		tabla.setRowHeight(50);
		tabla.setEnabled(false);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		
		JScrollPane tableScrollPane = new JScrollPane(tabla);
		tableScrollPane.setPreferredSize(new Dimension(400, 400));
		
		
		
	// Label Imagen	
		JLabel jLabelObject = new JLabel();
		jLabelObject.setIcon(new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\llegadas.png"));
		
		
/////////////////////////////////////////////////////
	// DIA
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		
////////////////////////////////////////////////////
		
	// Aeropuerto Local
		String aeropuertoactual = aeropuertoLocal.getIdAeropuerto().toString()+"-"+aeropuertoLocal.getNombre();
		JLabel aeropuertoactuall = new JLabel(aeropuertoactual);
		
///////////////////////////////////////////////////////		

	//	JPanel detailsPanel = new JPanel();
		//detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
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
		return panel;
		
    }

	private boolean estoyEnMiAeropuerto(IVuelo vuelo, Aeropuerto aeropuertoLocal) {
		return vuelo.getAeropuertoDestino().getIdAeropuerto().equals(aeropuertoLocal.getIdAeropuerto());
	}    
    }


