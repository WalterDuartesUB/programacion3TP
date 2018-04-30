package ar.edu.ub.p3.aeropuerto.modelo;

public class Avion {
	// TODO Reemplazar por la implementacion / JAR de avion
	
	private String	patente;
	private String  modelo;
	
	public Avion(String patente, String modelo) {
		this.setModelo(modelo);
		this.setPatente(patente);
	}
	public String getNombre() {
		return patente;
	}
	private void setPatente(String nombre) {
		this.patente = nombre;
	}
	public String getModelo() {
		return modelo;
	}
	private void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " " + this.getModelo();
	}
}
