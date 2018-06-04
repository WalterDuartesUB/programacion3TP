package ar.edu.ub.p3.vista;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class PanelRadar extends JPanel{
	private static final long serialVersionUID = 1L;
	private List<Integer> radiosDeCobertura;
	private Collection<Vuelo> vuelos;
	private int coberturaKm;
	private IAeropuerto aeropuerto; 
	private int angulo;
	private ConexionTraficoAereo conexionTA;
	private Configuracion configuracion;
	
	public PanelRadar( Configuracion configuracion, IAeropuerto aeropuerto, ConexionTraficoAereo conexionTA) {
		this.setConexionTA(conexionTA);
		this.setAeropuerto(aeropuerto);
		this.setVuelos( new LinkedList<Vuelo>() );
		this.setConfiguracion(configuracion);
		
		this.setCoberturaKm( this.getConfiguracion().getConfiguracionAsInt("coberturaRadarEnKilometros") );
		this.setAngulo(0);
		
		this.setRadiosDeCobertura(new LinkedList<Integer>());
		this.getRadiosDeCobertura().add( this.getConfiguracion().getConfiguracionAsInt("radioRadarEnKilometros1")  );
		this.getRadiosDeCobertura().add( this.getConfiguracion().getConfiguracionAsInt("radioRadarEnKilometros2")  );
		this.getRadiosDeCobertura().add( this.getConfiguracion().getConfiguracionAsInt("radioRadarEnKilometros3")  );		
	
		//Creo el timer para dibujar el arco del radar
		new Timer( 15, this::cambiarAnguloDelArcoDelRadar).start();
		
		//Timer para pedir la posicion de los aviones al trafico aereo
		new Timer( 1000, this::pedirVuelosAlTraficoAereo).start();
	  }

	public void cambiarAnguloDelArcoDelRadar(ActionEvent arg0) {
		this.setAngulo(this.getAngulo() + 1);
		this.dibujarRadar();		
	}

	public void pedirVuelosAlTraficoAereo(ActionEvent arg0) {		
		//Pido la info de los vuelos cercanos a mi posicion
		this.setVuelos( this.getConexionTA().obtenerInformacionVuelosCercanos( this.getAeropuerto().getPosicion(), this.getCoberturaKm() ) );
		
		this.dibujarRadar();
	}
	
	  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    
		    Graphics2D g2 = (Graphics2D) g;
		    int width = getWidth();
		    int height = getHeight();
		    int anchoAlto = Integer.min(width, height);
		    this.setBackground(Color.BLACK);
		    
		    this.dibujarGrilla(g2,anchoAlto);
		    
		    this.dibujarRadiosDeCobertura(g2,anchoAlto);
		    
		    this.dibujarEjesDeRadar(g2,anchoAlto);
		    
		    for (IVuelo vuelo : this.getVuelos()){
		    	this.dibujarVuelo(g2,vuelo,anchoAlto);		    
		    }

		    this.dibujarArcoRadar(g2, anchoAlto);
		    
		    	    
	  }

	private void dibujarArcoRadar(Graphics2D g2, int anchoAlto) {
		g2.setColor(Color.green);
		
		AffineTransform old = g2.getTransform();
		GradientPaint gp = new GradientPaint(0,0, new Color( 0,50,0,0), anchoAlto, anchoAlto, new Color(181,230,29).brighter() );
		
		g2.setPaint( gp );
		g2.rotate( Math.toRadians( this.getAngulo() ), 0 + (anchoAlto/2), 0 + (anchoAlto/2));
		g2.fillArc((int)0, (int)0, (int)anchoAlto, (int)anchoAlto, 0, (int)15);
		
		g2.setTransform(old);
	}
	private void dibujarGrilla(Graphics g, int anchoAlto) {
		int x,y;
		g.setColor(Color.RED);
		for (y = 0; y < 10; y++){
			for (x = 0; x< 10; x++){
				g.drawRect((x*(anchoAlto/10)), y*(anchoAlto/10), anchoAlto/10, anchoAlto/10);
			}
		}
		
	}

	private void dibujarVuelo(Graphics g, IVuelo vuelo, int anchoAlto) {
		Posicion posicionAvion = this.obtenerDistanciasAlAeropuerto(vuelo.getAvion().getPosicion());
		double x = posicionAvion.getX();
		double y = posicionAvion.getY();
		//TODO sacar el casteo y comvertir correctamente 
		int xPixel = this.calcularUnidadesDePantalla(anchoAlto, (int)x);
		int yPixel = this.calcularUnidadesDePantalla(anchoAlto, (int)y);
		int yPixelCorregido = this.calcularCoordenadaYEnPantalla(yPixel,anchoAlto);
		int xPixelCorregido = this.calcularCoordenadaXEnPantalla(xPixel,anchoAlto);
		char[] idAvion = vuelo.getAvion().getIdAvion().toCharArray();
 		g.setColor(Color.RED);
		g.fillOval(xPixelCorregido-5, yPixelCorregido-5, 10, 10);
		g.drawChars(idAvion, 0, idAvion.length, xPixelCorregido+10, yPixelCorregido);
	}
	private Posicion obtenerDistanciasAlAeropuerto(IPosicion posicion) {
		return new Posicion(posicion.getX()-this.getAeropuerto().getPosicion().getX(),posicion.getY()-this.getAeropuerto().getPosicion().getY());
	}

	private int calcularCoordenadaXEnPantalla(int xPixel, int anchoAlto) {
		return anchoAlto/2 + xPixel;
	}

	private int calcularCoordenadaYEnPantalla(int yPixel, int anchoAlto) {
		return (anchoAlto/2)-yPixel;
	}

	private void dibujarEjesDeRadar(Graphics g, int anchoAlto) {
		
		g.setColor(Color.GREEN);
	    g.drawLine(0, anchoAlto/2, anchoAlto, anchoAlto/2);
	    g.drawLine(anchoAlto/2, 0, anchoAlto/2, anchoAlto);
	}
	private void dibujarRadiosDeCobertura(Graphics g, int anchoAlto) {
		g.setColor(Color.GREEN);
		for (int radio : this.radiosDeCobertura){
	    	int ancho = calcularUnidadesDePantalla(anchoAlto, radio);
	    	int alto =  calcularUnidadesDePantalla(anchoAlto, radio);
	    	g.drawOval((anchoAlto/2)-ancho, (anchoAlto/2)-alto, ancho*2, alto*2);
	    }
	}
	private int calcularUnidadesDePantalla(int unidadDePantalla, int unidadReal) {
		return (unidadReal * unidadDePantalla/2)/ this.getCoberturaKm();
	}
	private List<Integer> getRadiosDeCobertura() {
		return radiosDeCobertura;
	}
	private void setRadiosDeCobertura(List<Integer> lista) {
		this.radiosDeCobertura = lista;
	}
	private int getCoberturaKm() {
		return coberturaKm;
	}
	private void setCoberturaKm(int coberturaKm) {
		this.coberturaKm = coberturaKm;
	}

	private Collection<Vuelo> getVuelos() {
		return vuelos;
	}

	private void setVuelos(Collection<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	private IAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	private void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	private void dibujarRadar() {
		
		this.validate();
		this.repaint();
		
	}

	private int getAngulo() {
		return angulo;
	}

	private void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	private ConexionTraficoAereo getConexionTA() {
		return conexionTA;
	}

	private void setConexionTA(ConexionTraficoAereo conexionTA) {
		this.conexionTA = conexionTA;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}
}