package ar.edu.ub.p3.aeropuerto.tablero.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;

import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.EstadoVuelo;

public class VentanaSalida extends JDialog {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//JPanel pane = new JPanel(new GridBagLayout());
	
    public VentanaSalida(ConexionAeropuerto conexion, Aeropuerto aeropuertolocal) {
        super();                  
        iniciarVentana(conexion,aeropuertolocal);     
        setVisible(true);
        //this.setResizable(false);
    	this.setSize(580,400);
		Timer timer = new Timer(1000, this::actualizar);
		timer.start();
    }

    private void iniciarVentana(ConexionAeropuerto conexion, Aeropuerto aeropuertolocal) {
    	
    	
    	setTitle("Prueba Ventana 3");
    	
		JPanel panel = new JPanel(new GridBagLayout());
		this.getContentPane().add(panel);
		
		
		String[] 	nombreColumna = {"Hora Programada","NroVuelo", "Aerolinea", "Destino", "Estima", "Estado"};
		
		// acomodar segun tablero llegada o salida
    	Object [][] vuelos = new Object [conexion.getVuelos().size()][nombreColumna.length];
   

    	int i = 0;
    	
    	ImageIcon icon1 = new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\arg2.png");
    	ImageIcon icon2 = new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\latam2.png");
    	ImageIcon icon3 = new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\andes2.png");
		
    	
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
					

				vuelos[i][3] = ( vuelo.getAeropuertoDestino().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
				vuelos[i][4] = (vuelo.getHorarioDespegue().getHours() + ":" + vuelo.getHorarioDespegue().getMinutes());
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
		
		JLabel jLabelObject = new JLabel();
		jLabelObject.setIcon(new ImageIcon("M:\\Aeropuerto\\programacion3TP\\Aeropuerto\\AeropuertoTableroLlegadas\\img\\salidas.png"));
		
	/*
	 * 		this.setTimerPedirVuelos(new Timer (this.getConfiguracion().getConfiguracionAsInt("tableroTiempoRefresh"), this ::pedirVuelosAlTraficoAereo));
		this.getTimerPedirVuelos().start();
	 */


		String aeropuertoactual = aeropuertolocal.getIdAeropuerto().toString()+"-"+aeropuertolocal.getNombre();
		JLabel aeropuertoactuall = new JLabel(aeropuertoactual);
		
		

		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		
	
		
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

		gbc.fill = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(dibujarHora(), gbc);
		
	
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		panel.add(aeropuertoactuall, gbc);

		this.pack();
		
		this.setVisible(true);
    	
    }
    
	public void actualizar (ActionEvent arg0) {
		this.revalidate();
		this.repaint();
	}

	private Component dibujarHora() {
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		System.out.println(date);
		return dia;
		
	}

	private boolean estoyEnMiAeropuerto(IVuelo vuelo, Aeropuerto aerolocal) {
		
		return vuelo.getAeropuertoOrigen().getIdAeropuerto().equals(aerolocal.getIdAeropuerto());
	}   
    }


