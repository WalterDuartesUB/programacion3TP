import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class Radar extends JPanel implements IRadar{
	private static final long serialVersionUID = 1L;
	private List<Integer> radiosDeCobertura;
	private List<Vuelo> vuelos;
	private int coberturaKm;
	private IAeropuerto aeropuerto; 
	private int angulo;
	
	public Radar() {
		this.setCoberturaKm(50);
		this.setAngulo(0);
		
		this.setRadiosDeCobertura(new LinkedList<Integer>());
		this.getRadiosDeCobertura().add(10);
		this.getRadiosDeCobertura().add(30);
		this.getRadiosDeCobertura().add(50);
		this.setAeropuerto(new Aeropuerto(null, null,new Posicion(15,15)));
		Aerolinea aerolinea = new Aerolinea(null, null);
		this.setVuelos(new LinkedList<Vuelo>());
		this.getVuelos().add(new Vuelo("Vuelo1", new Avion("Avion1", aerolinea, new Posicion(0, 0)), this.getAeropuerto(), this.getAeropuerto(), null));
		this.getVuelos().add(new Vuelo("Vuelo2", new Avion("Avion2", aerolinea, new Posicion(18, 47)), this.getAeropuerto(), this.getAeropuerto(), null));
		this.getVuelos().add(new Vuelo("Vuelo3", new Avion("Avion3", aerolinea, new Posicion(15, 15)), this.getAeropuerto(), this.getAeropuerto(), null));
		this.getVuelos().add(new Vuelo("Vuelo4", new Avion("Avion4", aerolinea, new Posicion(-10, -25)), this.getAeropuerto(), this.getAeropuerto(), null));
		
		//Creo el thread para mover los aviones de pruebas
		new Thread(new MovedorDeVuelosDePrueba(this,this.getVuelos())).start();
		
		//Creo el timer para dibujar el arco del radar
		new Timer( 15, this::actionPerformed).start();
	  }

	public void actionPerformed(ActionEvent arg0) {
		this.setAngulo(this.getAngulo() + 1);
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

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public IAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	@Override
	public void dibujarRadar() {
		
		this.validate();
		this.repaint();
		
	}

	private int getAngulo() {
		return angulo;
	}

	private void setAngulo(int angulo) {
		this.angulo = angulo;
	}
}
