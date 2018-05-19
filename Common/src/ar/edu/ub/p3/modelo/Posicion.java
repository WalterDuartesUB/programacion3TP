package ar.edu.ub.p3.modelo;

import ar.edu.ub.p3.interfaz.IPosicion;

public class Posicion implements IPosicion{
	
	private double x;
	private double y;
	
	public Posicion(double x, double y) {
		
		this.setX(x);
		this.setY(y);
		
	}
	
	public Posicion( IPosicion posicion ) {
		this( posicion.getX(), posicion.getY() );
	}
	
	@Override
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	@Override
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}