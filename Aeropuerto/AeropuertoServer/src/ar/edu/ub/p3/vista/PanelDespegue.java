package ar.edu.ub.p3.vista;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;


import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class PanelDespegue extends JPanel implements Closeable{


	private static final long serialVersionUID = 1L;
	
	
	private ConexionTraficoAereo 	conexionTA;
	private Configuracion 			configuracion;
	private String					miIdAeropuerto;
	private Collection<Vuelo> 		vuelosProgramadosDespegue;
	private Timer 					timerPedirVuelos;
	


	public PanelDespegue(Configuracion configuracion, String idAeropuerto, ConexionTraficoAereo conexionTA) {
		super();
		this.setConexionTA(conexionTA);
		this.setMiIdAeropuerto(idAeropuerto);
		this.setVuelosProgramadosDespegue(new LinkedList<Vuelo>());
		this.setConfiguracion(configuracion);
		this.Iniciar();
		
		this.setTimerPedirVuelos(new Timer (this.getConfiguracion().getConfiguracionAsInt("tableroTiempoRefresh"), this ::pedirVuelosAlTraficoAereo));
		this.getTimerPedirVuelos().start();
	}
	

	public void pedirVuelosAlTraficoAereo(ActionEvent arg0) {
		this.setVuelosProgramadosDespegue(this.getConexionTA().getEstadoAeropuerto().getVuelosProgramados());
		this.dibujarSalidas();
	}
	
	
	  public void Iniciar() {
	    int width = getWidth();
	    int height = getHeight();
	    int anchoAlto = Integer.min(width, height);
	    this.add(dibujarTabla());
	    System.out.println("hola");
	    
	    
	}
	
	
	private Component dibujarTabla() {
		
		
		String[] 	nombreColumna = {"Hora Programada","NroVuelo", "Aerolinea", "Destino", "Estima", "Estado"};
		Object [][] aux2 = {
				{"pepe","pepe","pepe","pepe","pepe","pepe"},
				{"pepe","pepe","pepe","pepa","pepe","pepe"},
				{"pepe","pepe","pepe","pepe","pepe","pepe"},
				{"pepe","pepe","pepe","pepe","pepe","pepe"},
};
		
		//Object [][] vuelos = new Object [conexionTA.getEstadoAeropuerto().getVuelosProgramados().size()][nombreColumna.length];
		Object [][] vuelos = new Object [this.getVuelosProgramadosDespegue().size()][nombreColumna.length];
		int i = 0 ;
		
		for(IVuelo vuelo : this.getVuelosProgramadosDespegue()) {
		//for(IVuelo vuelo : conexionTA.getEstadoAeropuerto().getVuelosProgramados()) { // cambiar
 

				vuelos[i][0] = ( vuelo.getHorarioProgramado().getHours() +":"+vuelo.getHorarioProgramado().getMinutes());  // arreglar en algun momento
				vuelos[i][1] = (vuelo.getIdVuelo().toString());
				
				/*
				///// HACER ESTO ESCALABLE  solo prueba
				if(vuelo.getAvion().getAerolinea().getNombre().equals("AEROLINEAS ARGENTINAS"))
					vuelos[i][2] = icon1;
				if(vuelo.getAvion().getAerolinea().getNombre().equals("LATAM"))
					vuelos[i][2] = icon2;
				if(vuelo.getAvion().getAerolinea().getNombre().equals("ANDES"))
					vuelos[i][2] = icon3;
					
				 */
				
				vuelos[i][2] = vuelo.getAvion().getAerolinea().getNombre();
				vuelos[i][3] = ( vuelo.getAeropuertoDestino().getIdAeropuerto() + " - "+vuelo.getAeropuertoDestino().getNombre());
				vuelos[i][4] = (vuelo.getHorarioDespegue().getHours() + ":" + vuelo.getHorarioDespegue().getMinutes());
				vuelos[i][5] = (vuelo.getEstadoVuelo().toString());
				i++;
			
		}
		
    	JTable tabla = new JTable(vuelos,nombreColumna);
    	JScrollPane scroll =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	scroll.setBackground(Color.DARK_GRAY);
    	
    	tabla.setAutoscrolls(true);
 
    	tabla.setSize(200,200);
    	
		JScrollPane tableScrollPane = new JScrollPane(tabla);
		tableScrollPane.setPreferredSize(new Dimension(400, 400));

		
    	return tableScrollPane;
		
	}
	private void dibujarSalidas() {
		this.revalidate();
		this.repaint();
		//Iniciar();
		
	}


	public ConexionTraficoAereo getConexionTA() {
		return conexionTA;
	}



	private void setConexionTA(ConexionTraficoAereo conexionTA) {
		this.conexionTA = conexionTA;
	}



	public Configuracion getConfiguracion() {
		return configuracion;
	}



	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}



	public String getMiIdAeropuerto() {
		return miIdAeropuerto;
	}



	private void setMiIdAeropuerto(String miIdAeropuerto) {
		this.miIdAeropuerto = miIdAeropuerto;
	}



	public Collection<Vuelo> getVuelosProgramadosDespegue() {
		return vuelosProgramadosDespegue;
	}



	private void setVuelosProgramadosDespegue(Collection<Vuelo> vuelosProgramadosDespegue) {
		this.vuelosProgramadosDespegue = vuelosProgramadosDespegue;
	}



	public Timer getTimerPedirVuelos() {
		return timerPedirVuelos;
	}



	private void setTimerPedirVuelos(Timer timerPedirVuelos) {
		this.timerPedirVuelos = timerPedirVuelos;
	}



	@Override
	public void close() throws IOException {
		this.getTimerPedirVuelos().stop();
		
	}
	



}
