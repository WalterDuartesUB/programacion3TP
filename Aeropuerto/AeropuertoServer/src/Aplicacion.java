import java.util.Scanner;

import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class Aplicacion {

	public static void main(String[] args) {
		Scanner in = new Scanner( System.in );
		Configuracion configuracion = new Configuracion(args[0]);
		EstadoAeropuerto estadoAeropuerto = new EstadoAeropuerto(configuracion);
		ConexionTraficoAereo conexionTA = new ConexionTraficoAereo(configuracion,estadoAeropuerto);
		
		System.out.println("Enter para conectar al trafico aereo");
		in.nextLine();		
		conexionTA.conectar();
				
		///////////////////////////////////////////////////////////////////////
		//Preparo un menu para poder repetir los mensajes sin reiniciar la app
		
		String inputUsuario = "";
		
		while( inputUsuario.compareTo("Q") != 0 )
		{	
			System.out.println("Menu de opciones\n----------------------------");
			System.out.println("L para pedir la lista de aeropuertos");			
			System.out.println("Q para desconectar del server de trafico aereo y salir de la app");
			inputUsuario = in.nextLine().toUpperCase();
			System.out.println( inputUsuario );
			
			if( inputUsuario.compareTo("L") == 0 )
				conexionTA.obtenerAeropuertosDisponibles();
			else if( inputUsuario.compareTo("Q") == 0 )
				conexionTA.desconectar();
		}
		
		///////////////////////////////////////////////////////////////////////
		//Libero los recursos
		
		configuracion.close();
		in.close();
		
	}

}
