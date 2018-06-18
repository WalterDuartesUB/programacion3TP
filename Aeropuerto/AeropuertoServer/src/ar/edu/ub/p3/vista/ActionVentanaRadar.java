package ar.edu.ub.p3.vista;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class ActionVentanaRadar {
	
	public static  void generarVentana(Configuracion configuracion, IAeropuerto aerpuerto, ConexionTraficoAereo conexionTA ) {
		
		new VentanaRadar(configuracion,aerpuerto,conexionTA );;
		

	}
	
}
