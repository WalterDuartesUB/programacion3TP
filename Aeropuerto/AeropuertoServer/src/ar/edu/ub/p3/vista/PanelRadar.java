package ar.edu.ub.p3.vista;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class PanelRadar extends JPanel implements Closeable{
	private static final long serialVersionUID = 1L;
	
	private List<Integer>           radiosDeCobertura;
	private Collection<Vuelo>       vuelosDespegados;
	private int                     coberturaKm;
	private IPosicion               posicionRadar; 
	private int                     angulo;
	private ConexionTraficoAereo    conexionTA;
	private Configuracion           configuracion;
	private Timer                   timerCambioDeAnguloDelArcoDelRadar;
	private Timer                   timerPedidorDeVuelosEnElAire;
	
	
	public PanelRadar( Configuracion configuracion, IPosicion posicionRadar, ConexionTraficoAereo conexionTA) {
		this.setConexionTA(conexionTA);
		this.setPosicionRadar(posicionRadar);
		this.setVuelosDespegados( new LinkedList<Vuelo>() );
		this.setConfiguracion(configuracion);
		
		this.setCoberturaKm( this.getConfiguracion().getConfiguracionAsInt("coberturaRadarEnKilometros") );
		this.setAngulo(0);
		
		this.setRadiosDeCobertura(new LinkedList<Integer>());
		this.getRadiosDeCobertura().add( this.getConfiguracion().getConfiguracionAsInt("radioRadarEnKilometros1")  );
		this.getRadiosDeCobertura().add( this.getConfiguracion().getConfiguracionAsInt("radioRadarEnKilometros2")  );
		this.getRadiosDeCobertura().add( this.getConfiguracion().getConfiguracionAsInt("radioRadarEnKilometros3")  );		
	
		//Creo el timer para dibujar el arco del radar
		this.setTimerCambioDeAnguloDelArcoDelRadar( new Timer( 15, this::cambiarAnguloDelArcoDelRadar));
		this.getTimerCambioDeAnguloDelArcoDelRadar().start();
		
		//Timer para pedir la posicion de los aviones al trafico aereo
		this.setTimerPedidorDeVuelosEnElAire(new Timer( this.getConfiguracion().getConfiguracionAsInt("radarTiempoRefresh"), this::pedirVuelosAlTraficoAereo));
		this.getTimerPedidorDeVuelosEnElAire().start();
		
	  }

	public void cambiarAnguloDelArcoDelRadar(ActionEvent arg0) {
		this.setAngulo(this.getAngulo() + 1);
		this.dibujarRadar();		
	}

	public void pedirVuelosAlTraficoAereo(ActionEvent arg0) {		
		//Pido la info de los vuelos cercanos a mi posicion		
		this.setVuelosDespegados( this.getConexionTA().getEstadoAeropuerto().getVuelosDespegados().values() );
		
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
		    
		    this.dibujarVuelos(g2, anchoAlto, this.getVuelosDespegados(), Color.RED );		
		    this.dibujarVuelos(g2, anchoAlto, this.getVuelosAterrizando(), Color.BLUE );		
	
		    this.dibujarArcoRadar(g2, anchoAlto);
		    
		    	    
	  }

	private void dibujarVuelos(Graphics2D g2, int anchoAlto, Collection<Vuelo> vuelos, Color colorAvion) {
		for (IVuelo vuelo : vuelos){
			this.dibujarVuelo(g2,vuelo,anchoAlto, colorAvion );		    
		}
	}

	private void dibujarArcoRadar(Graphics2D g2, int anchoAlto) {
		g2.setColor(Color.green);
		
		AffineTransform old = g2.getTransform();
		GradientPaint gp = new GradientPaint(0,0, new Color( 0,50,0,0), anchoAlto, anchoAlto, new Color(181,230,29).brighter() );
		
		g2.setPaint( gp );
		g2.rotate( Math.toRadians( this.getAngulo() ), 0 + (anchoAlto/2), 0 + (anchoAlto/2));
		g2.fillArc(0, 0, anchoAlto, anchoAlto, 0, 15);
		
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

	private void dibujarVuelo(Graphics g, IVuelo vuelo, int anchoAlto, Color colorAvion) {
		Posicion posicionAvion = this.obtenerDistanciasAlAeropuerto(vuelo.getAvion().getPosicion());
		int x =new Double(posicionAvion.getX()).intValue();
		int y = new Double(posicionAvion.getY()).intValue();
		int xPixel = this.calcularUnidadesDePantalla(anchoAlto, x);
		int yPixel = this.calcularUnidadesDePantalla(anchoAlto, y);
		int yPixelCorregido = this.calcularCoordenadaYEnPantalla(yPixel,anchoAlto);
		int xPixelCorregido = this.calcularCoordenadaXEnPantalla(xPixel,anchoAlto);
		char[] idAvion = vuelo.getIdVuelo().toCharArray();
 		g.setColor( colorAvion );
		g.fillOval(xPixelCorregido-5, yPixelCorregido-5, 10, 10);
		g.drawChars(idAvion, 0, idAvion.length, xPixelCorregido+10, yPixelCorregido);
	}
	private Posicion obtenerDistanciasAlAeropuerto(IPosicion posicion) {
		return new Posicion(posicion.getX()-this.getPosicionRadar().getX(),posicion.getY()-this.getPosicionRadar().getY());
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

	private Collection<Vuelo> getVuelosDespegados() {
		return vuelosDespegados;
	}
	
	private Collection<Vuelo> getVuelosAterrizando() {
		return this.getConexionTA().getEstadoAeropuerto().getVuelosAterrizando().values();
	}
	
	private void setVuelosDespegados(Collection<Vuelo> vuelos) {
		this.vuelosDespegados = vuelos;
	}

	private IPosicion getPosicionRadar() {
		return posicionRadar;
	}

	private void setPosicionRadar(IPosicion posicionRadar) {
		this.posicionRadar = posicionRadar;
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

	@Override
	public void close() throws IOException {
		this.getTimerCambioDeAnguloDelArcoDelRadar().stop();
		this.getTimerPedidorDeVuelosEnElAire().stop();
	}

	private Timer getTimerCambioDeAnguloDelArcoDelRadar() {
		return timerCambioDeAnguloDelArcoDelRadar;
	}

	private void setTimerCambioDeAnguloDelArcoDelRadar( Timer timerCambioDeAnguloDelArcoDelRadar) {
		this.timerCambioDeAnguloDelArcoDelRadar = timerCambioDeAnguloDelArcoDelRadar;
	}

	private Timer getTimerPedidorDeVuelosEnElAire() {
		return timerPedidorDeVuelosEnElAire;
	}

	private void setTimerPedidorDeVuelosEnElAire( Timer timerPedidorDeVuelosEnElAire) {
		this.timerPedidorDeVuelosEnElAire = timerPedidorDeVuelosEnElAire;
	}
}
