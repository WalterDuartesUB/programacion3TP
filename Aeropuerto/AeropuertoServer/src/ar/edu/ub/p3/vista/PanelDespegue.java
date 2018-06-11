package ar.edu.ub.p3.vista;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;


import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class PanelDespegue extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<String> 		idVuelos;
	private String					miIdAeropuerto;
	private ConexionTraficoAereo 	conexionTA;
	private Configuracion 			configuracion;
	

	public PanelDespegue(Configuracion configuracion, String idAeropuerto, ConexionTraficoAereo conexionTA) {
		this.setConexionTA(conexionTA);
		this.setMiIdAeropuerto(idAeropuerto);
		this.setConfiguracion(configuracion);
		
		this.setVuelos( new LinkedList<String>() );
		

		//Timer para pedir la posicion de los aviones al trafico aereo
		new Timer( 1000, this::pedirVuelosAlTraficoAereo).start();
	}
	
	public void pedirVuelosAlTraficoAereo(ActionEvent arg0) {	
			
		//Preguntar donde saco los vuelos
		//this.setVuelos(this.getConexionTA().obtenerInformacionVuelos(this.getVuelos()));
		this.dibujarTableroDespegue();
	}

	private void dibujarTableroDespegue() {
		this.validate();
		this.repaint();
	}
	
	private void iniciarVentana() {
     	
		JPanel panel = new JPanel(new GridBagLayout());repaint();
		//this.getContentPane().add(panel);
		this.add(panel);
		
		
		String[] 	nombreColumna = {"Hora Programada","NroVuelo", "Aerolinea", "Destino", "Estima", "Estado"};
		
		// acomodar segun tablero llegada o salida
    	Object [][] vuelos = new Object [conexionTA.getVuelosProximoDespegue().size()][nombreColumna.length];
   

    	int i = 0;
    	
    	ImageIcon icon1 = new ImageIcon("C:\\WorkSpaceIntegrador\\programacion3TP\\img\\arg2.png");
    	ImageIcon icon2 = new ImageIcon("C:\\WorkSpaceIntegrador\\programacion3TP\\img\\latam2.png");
    	ImageIcon icon3 = new ImageIcon("C:\\WorkSpaceIntegrador\\programacion3TP\\img\\andes2.png");
		
    	
		for(IVuelo vuelo : conexionTA.getVuelosProximoDespegue()) {
    
			
			if(estoyEnMiAeropuerto(vuelo,miIdAeropuerto)) {

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
		jLabelObject.setIcon(new ImageIcon("C:\\WorkSpaceIntegrador\\programacion3TP\\img\\salidas.png"));
		
	
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		
		JLabel aeropuertoactuall = new JLabel(miIdAeropuerto);
		
		

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

		//this.pack();
		
		
		//this.setVisible(true);
    }

	private boolean estoyEnMiAeropuerto(IVuelo vuelo, String miIdAeropuerto2) {
		return vuelo.getAeropuertoOrigen().getIdAeropuerto().equals(miIdAeropuerto2);
	}

	public Collection<String> getVuelos() {
		return idVuelos;
	}


	private void setVuelos(Collection<String> vuelos) {
		this.idVuelos = vuelos;
	}


	public String getMiIdAeropuerto() {
		return miIdAeropuerto;
	}


	private void setMiIdAeropuerto(String miIdAeropuerto) {
		this.miIdAeropuerto = miIdAeropuerto;
	}


	public ConexionTraficoAereo getConexionTA() {
		return conexionTA;
	}


	public void setConexionTA(ConexionTraficoAereo conexionTA) {
		this.conexionTA = conexionTA;
	}


	public Configuracion getConfiguracion() {
		return configuracion;
	}


	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}



}
