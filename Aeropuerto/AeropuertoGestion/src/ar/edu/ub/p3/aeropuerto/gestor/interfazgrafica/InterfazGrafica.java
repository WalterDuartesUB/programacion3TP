package ar.edu.ub.p3.aeropuerto.gestor.interfazgrafica;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.aeropuerto.gestor.vista.Gestion_Ventana_Aerolineas;
import ar.edu.ub.p3.aeropuerto.gestor.vista.Gestion_Ventana_Aeropuertos;
import ar.edu.ub.p3.aeropuerto.gestor.vista.Gestion_Ventana_Aviones;
import ar.edu.ub.p3.aeropuerto.gestor.vista.Gestion_Ventana_Vuelos;
import ar.edu.ub.p3.aeropuerto.gestor.vista.Gestion_Ventanas;
import ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea.FichaConListaView;


public class InterfazGrafica {

	//ESTA INTERFAZ GRAFICA TENDRA VARIAS VENTANAS, AL REDEOR DE 6 EN UN FUTURO PARA DIVERSAS ACCIONES
	//POR AHORA SE MANTIENE EN UNA PARA PROBAR LA INTERACCION
	private Gestion_Ventanas			Gestion_Ventanas;
	
	private Gestion_Ventana_Aviones 	GV_Aviones;
	private Gestion_Ventana_Aerolineas 	GV_Aerolineas;
	private Gestion_Ventana_Vuelos 		GV_Vuelos;
	private Gestion_Ventana_Aeropuertos GV_Aeropuertos;
	
	private ConexionAeropuerto conexion;
	
	public InterfazGrafica(ConexionAeropuerto conexion) {
		
		setConexion(conexion);
		generarVentana();
		 
	}
	
	private void generarVentana() {
		
		
		setGV_Aviones   ( new Gestion_Ventana_Aviones	( getConexion() ) );
		setGV_Aerolineas( new Gestion_Ventana_Aerolineas( getConexion() ) );
		setGV_Vuelos	( new Gestion_Ventana_Vuelos	( getConexion() ) );
		setGV_Aeropuertos(new Gestion_Ventana_Aeropuertos(getConexion() ) );
		
		
		
		List<JFrame> ventanas = new LinkedList<JFrame>();
		
		ventanas.add(getGV_Aviones());
		ventanas.add(getGV_Aerolineas());
		ventanas.add(getGV_Aeropuertos());
		ventanas.add(getGV_Vuelos());
		
		
		ventanas.add(new FichaConListaView( conexion ));
		
		setGestion_Ventanas( new Gestion_Ventanas(ventanas) );
		
	}

	

	public ConexionAeropuerto getConexion() {
		return conexion;
	}

	public void setConexion(ConexionAeropuerto conexion) {
		this.conexion = conexion;
	}

	public Gestion_Ventana_Aerolineas getGV_Aerolineas() {
		return GV_Aerolineas;
	}

	public void setGV_Aerolineas(Gestion_Ventana_Aerolineas gV_Aerolineas) {
		GV_Aerolineas = gV_Aerolineas;
	}

	public Gestion_Ventana_Vuelos getGV_Vuelos() {
		return GV_Vuelos;
	}

	public void setGV_Vuelos(Gestion_Ventana_Vuelos gV_Vuelos) {
		GV_Vuelos = gV_Vuelos;
	}

	public Gestion_Ventana_Aeropuertos getGV_Aeropuertos() {
		return GV_Aeropuertos;
	}

	public void setGV_Aeropuertos(Gestion_Ventana_Aeropuertos gV_Aeropuertos) {
		GV_Aeropuertos = gV_Aeropuertos;
	}

	public Gestion_Ventana_Aviones getGV_Aviones() {
		return GV_Aviones;
	}

	public void setGV_Aviones(Gestion_Ventana_Aviones gV_Aviones) {
		GV_Aviones = gV_Aviones;
	}

	public Gestion_Ventanas getGestion_Ventanas() {
		return Gestion_Ventanas;
	}

	public void setGestion_Ventanas(Gestion_Ventanas gestion_Ventanas) {
		Gestion_Ventanas = gestion_Ventanas;
	}
	
	
}
