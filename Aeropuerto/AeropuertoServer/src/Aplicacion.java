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
				
		System.out.println("Enter para pedir la lista de aeropuertos");
		in.nextLine();
		conexionTA.obtenerAeropuertosDisponibles();
		
		System.out.println("Enter para desconectar del server de trafico aereo");
		in.nextLine();
		conexionTA.desconectar();
		
		configuracion.close();
		in.close();
		
	}

}
