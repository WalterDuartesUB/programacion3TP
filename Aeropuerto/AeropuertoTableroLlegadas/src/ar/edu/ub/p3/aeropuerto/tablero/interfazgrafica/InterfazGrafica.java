package ar.edu.ub.p3.aeropuerto.tablero.interfazgrafica;

import java.awt.EventQueue;

import ar.edu.ub.p3.aeropuerto.tablero.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.aeropuerto.tablero.view.VentanaLlegada;
import ar.edu.ub.p3.aeropuerto.tablero.view.VentanaSalida;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Posicion;


public class InterfazGrafica {

	//ESTA INTERFAZ GRAFICA TENDRA VARIAS VENTANAS, AL REDEOR DE 6 EN UN FUTURO PARA DIVERSAS ACCIONES
	//POR AHORA SE MANTIENE EN UNA PARA PROBAR LA INTERACCION
	
	//copy gabriel espi
	
	private VentanaLlegada 	ventanaLlegada;
	private VentanaSalida 	ventanaSalida;
	private ConexionAeropuerto conexion;
	Aeropuerto aep = new Aeropuerto("AEP", "Aeroparque", new Posicion (11,11));
	Aeropuerto sla = new Aeropuerto("SLA", "Salta", new Posicion (66,66));
	
	public InterfazGrafica(ConexionAeropuerto conexion) {
		
		setConexion(conexion);
		generarVentana();
		 
	}
	
	private void generarVentana() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVentanaLlegada( new VentanaLlegada( getConexion(),aep ) );
					setVentanaSalida( new VentanaSalida( getConexion(),aep ) );
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	public VentanaLlegada getVentana() {
		return ventanaLlegada;
	}

	public void setVentanaLlegada(VentanaLlegada ventana) {
		this.ventanaLlegada = ventana;
	}

	public ConexionAeropuerto getConexion() {
		return conexion;
	}

	public void setConexion(ConexionAeropuerto conexion) {
		this.conexion = conexion;
	}

	public VentanaSalida getVentanaSalida() {
		return ventanaSalida;
	}

	public void setVentanaSalida(VentanaSalida ventanaSalida) {
		this.ventanaSalida = ventanaSalida;
	}
	
	
}
