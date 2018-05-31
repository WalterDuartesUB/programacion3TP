import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class Radar extends JPanel{
	private static final long serialVersionUID = 1L;
	private List<Integer> radiosDeCobertura;
	private List<IVuelo> vuelos;
	private int coberturaKm;
	private IAeropuerto aeropuerto; 
	
	public Radar() {
		this.setCoberturaKm(50);
		
		this.setRadiosDeCobertura(new LinkedList<Integer>());
		this.getRadiosDeCobertura().add(10);
		this.getRadiosDeCobertura().add(30);
		this.getRadiosDeCobertura().add(50);
		this.setAeropuerto(new Aeropuerto(null, null,new Posicion(15,15)));
		Aerolinea aerolinea = new Aerolinea(null, null);
		this.setVuelos(new LinkedList<IVuelo>());
		Vuelo vuelo = new Vuelo(null, new Avion(null, aerolinea, new Posicion(0, 0)), this.getAeropuerto(), this.getAeropuerto(), null);
		this.getVuelos().add(vuelo);
	  }
	
	  public void paintComponent(Graphics g) {
		  
	    int width = getWidth();
	    int height = getHeight();
	    
	    this.dibujarRadiosDeCobertura(g, width, height);
	    
	    this.dibujarEjesDeRadar(g, width, height);
	    for (IVuelo vuelo : this.getVuelos()){
	    	this.dibujarVuelo(g,vuelo,width,height);
	    	
	    }
	    
	  }
	private void dibujarVuelo(Graphics g, IVuelo vuelo, int width, int height) {
		Posicion posicionAvion = this.obtenerDistanciasAlAeropuerto(vuelo.getAvion().getPosicion());
		double x = posicionAvion.getX();
		double y = posicionAvion.getY();
		//TODO sacar el casteo y comvertir correctamente 
		int xPixel = this.calcularUnidadesDePantalla(width, (int)x);
		int yPixel = this.calcularUnidadesDePantalla(height, (int)y);
		int yPixelCorregido = this.calcularCoordenadaYEnPantalla(yPixel,height);
		int xPixelCorregido = this.calcularCoordenadaXEnPantalla(xPixel,width);
		
		g.setColor(Color.RED);
		g.fillOval(xPixelCorregido-5, yPixelCorregido-5, 10, 10);
	}
	private Posicion obtenerDistanciasAlAeropuerto(IPosicion posicion) {
		return new Posicion(posicion.getX()-this.getAeropuerto().getPosicion().getX(),posicion.getY()-this.getAeropuerto().getPosicion().getY());
	}

	private int calcularCoordenadaXEnPantalla(int xPixel, int width) {
		return width/2 + xPixel;
	}

	private int calcularCoordenadaYEnPantalla(int yPixel, int height) {
		return (height/2)-yPixel;
	}

	private void dibujarEjesDeRadar(Graphics g, int width, int height) {
		
		g.setColor(Color.black);
	    g.drawLine(0, height/2, width, height/2);
	    g.drawLine(width/2, 0, width/2, height);
	}
	private void dibujarRadiosDeCobertura(Graphics g, int width, int height) {
		g.setColor(Color.black);
		for (int radio : this.radiosDeCobertura){
	    	int ancho = calcularUnidadesDePantalla(width, radio);
	    	int alto =  calcularUnidadesDePantalla(height, radio);
	    	g.drawOval((width/2)-ancho, (height/2)-alto, ancho*2, alto*2);
	    }
	}
	private int calcularUnidadesDePantalla(int unidadDePantalla, int unidadReal) {
		return (unidadReal * unidadDePantalla/2)/ this.getCoberturaKm();
	}
	public List<Integer> getRadiosDeCobertura() {
		return radiosDeCobertura;
	}
	public void setRadiosDeCobertura(List<Integer> lista) {
		this.radiosDeCobertura = lista;
	}
	public int getCoberturaKm() {
		return coberturaKm;
	}
	public void setCoberturaKm(int coberturaKm) {
		this.coberturaKm = coberturaKm;
	}

	public List<IVuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<IVuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public IAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
}
