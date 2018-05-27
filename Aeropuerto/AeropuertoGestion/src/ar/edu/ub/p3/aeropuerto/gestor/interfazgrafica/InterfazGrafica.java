package ar.edu.ub.p3.aeropuerto.gestor.interfazgrafica;

import java.awt.EventQueue;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestor.view.Ventana;

public class InterfazGrafica {

	//ESTA INTERFAZ GRAFICA TENDRA VARIAS VENTANAS, AL REDEOR DE 6 EN UN FUTURO PARA DIVERSAS ACCIONES
	//POR AHORA SE MANTIENE EN UNA PARA PROBAR LA INTERACCION
	
	private Ventana ventana;
	private ConexionAeropuerto conexion;
	
	public InterfazGrafica(ConexionAeropuerto conexion) {
		
		setConexion(conexion);
		generarVentana();
		 
	}
	
	private void generarVentana() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVentana( new Ventana( getConexion() ) );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	public Ventana getVentana() {
		return ventana;
	}

	public void setVentana(Ventana ventana) {
		this.ventana = ventana;
	}

	public ConexionAeropuerto getConexion() {
		return conexion;
	}

	public void setConexion(ConexionAeropuerto conexion) {
		this.conexion = conexion;
	}
	
	
}
