package ar.edu.ub.p3.interfaz;

import java.io.Serializable;

public interface IPosicion extends Serializable{
	
	public double getX();
	public double getY();
	
	public IPosicion sumar( IPosicion otraPosicion );
	public double calcularDistancia( IPosicion otraPosicion );
	public double calcularAngulo( IPosicion otraPosicion );
}
