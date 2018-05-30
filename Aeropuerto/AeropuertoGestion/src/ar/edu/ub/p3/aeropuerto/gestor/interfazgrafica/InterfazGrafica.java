package ar.edu.ub.p3.aeropuerto.gestor.interfazgrafica;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestor.vista.IGrafica_ABM_Aviones;


public class InterfazGrafica {

	//ESTA INTERFAZ GRAFICA TENDRA VARIAS VENTANAS, AL REDEOR DE 6 EN UN FUTURO PARA DIVERSAS ACCIONES
	//POR AHORA SE MANTIENE EN UNA PARA PROBAR LA INTERACCION
	
	private IGrafica_ABM_Aviones ventana;
	private ConexionAeropuerto conexion;
	
	public InterfazGrafica(ConexionAeropuerto conexion) {
		
		setConexion(conexion);
		generarVentana();
		 
	}
	
	private void generarVentana() {
		
		
		setVentana( new IGrafica_ABM_Aviones( getConexion() ) );
		
		
	}

	public IGrafica_ABM_Aviones getVentana() {
		return ventana;
	}

	public void setVentana(IGrafica_ABM_Aviones ventana2) {
		this.ventana = ventana2;
	}

	public ConexionAeropuerto getConexion() {
		return conexion;
	}

	public void setConexion(ConexionAeropuerto conexion) {
		this.conexion = conexion;
	}
	
	
}
