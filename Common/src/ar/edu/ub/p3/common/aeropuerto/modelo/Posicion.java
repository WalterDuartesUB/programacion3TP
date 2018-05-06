package ar.edu.ub.p3.common.aeropuerto.modelo;

import java.io.Serializable;

import ar.edu.ub.p3.common.aeropuerto.modelo.Interface.InterfazPosicionGetterSetter;

public class Posicion implements InterfazPosicionGetterSetter, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1227320847487053787L;
	private double x;
	private double y;
	
	public Posicion(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	public double getX() {
		return x;
	}
	@Override
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	@Override
	public void setY(double y) {
		this.y = y;
	}

}
